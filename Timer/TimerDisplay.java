
/**
 * The TimerDisplay class implements a digital timer display that shows 
 * minutes and seconds. The range of the timer is counting down to 00:00.
 * The timer display receives "ticks" (via the timeTick method) every second
 * and reacts by decrementing the display. This is done in the usual timer
 * fashion: the minute decrements when the seconds roll over to zero.
 * 
 * @author Ruhuan Liao
 * @version 2021.10.03
 */
public class TimerDisplay
{
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for TimerDisplay objects. This constructor 
     * creates a new Timer set at 00:00.
     */
    public TimerDisplay()
    {
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for TimerDisplay objects. This constructor
     * creates a new Timer set at the time specified by the 
     * parameters.
     */
    public TimerDisplay(int minute, int second)
    {
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        if(second > 59){
            second = second % 60;
            minute++;
        }
        setTime(minute, second);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        seconds.increment();
        if(seconds.getValue() == 00) {  // it just rolled over!
            minutes.increment();
            seconds.setValue(0);
        }
        updateDisplay();
    }
    
    public void timeTickDown()
    {
        seconds.decrement();
        if(seconds.getValue() < 0) {  // it just rolled over!
            minutes.decrement();
            seconds.setValue(59);
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int minute, int second)
    {
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format MM:SS.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = minutes.getDisplayValue() + ":" + 
                        seconds.getDisplayValue();
    }
}
