/**
 * A heater that has a minium and maximum temperature, and can be manipulate to be cooler or warmer by the amount in increment.
 * @author (Ruhuan Liao)
 * @version (9/19/2021)
 */
public class Heater
{
    // instance variables - replace the example below with your own   
    private double temperature;
    private double warmer;
    private double cooler;
    private double min;
    private double max;
    private double increment;
    
    /**
     * Constructor for objects of class Heater
     */
    public Heater(double minimum, double maximum)
    {
        // initialise instance variables
        temperature = 15.0;
        min = minimum;
        max = maximum;
        increment = 5.0;
    }

    /**
     * An example of a method - warmer and cooler
     *
     * @param  y  a sample parameter for a method
     * @return    temperature
     */
    public void warmer(){
        if (temperature <= max){
            temperature += increment;
        }
        else {
            temperature -= increment;
        }
    }

    public void cooler(){
        if (temperature >= min){
            temperature += increment;
        }
        else {
            temperature -= increment;
        }
    }
    
    public void setIncrement(double inc){
         if (inc >= 0){
            increment = inc;
            }
        }
        
            public double getTemperature(){
        return temperature;
    }
}
    
    
    
