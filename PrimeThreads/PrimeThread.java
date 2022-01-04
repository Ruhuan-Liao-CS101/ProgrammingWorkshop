import java.util.Random;
/**
 * PrimeThread class 
 *
 * @author Ruhuan Liao
 * @version 1.0
 */

public class PrimeThread extends Thread
{
    // instance variables - replace the example below with your own
    private int lo;
    private int hi;
    private long nanoTime;
    private int pCount;

    /**
     * Constructor for objects of class Thread
     */
    
    public PrimeThread(int lo, int hi)
    {
        if(lo % 2==0)lo++;
        this.lo=lo;
        this.hi=hi;
    }
    
    public boolean isPrime(int n) 
    {
        if (n % 2 == 0) return false;
        int limit = (int)Math.ceil(Math.sqrt((double)n));
        for (int divisor = 3; divisor <= limit; divisor +=2) 
            if (lo % divisor == 0)
                return false;     
        return true; 
    }
    
    public void run()
    {
        long initial = System.nanoTime();
        for (int n = lo; n <= hi; n += 2){ 
            if (isPrime(n))
            {
                pCount ++;
            };
        }
        long end = System.nanoTime();
        
        nanoTime = initial - end;
    }
    
    public int getPCount() 
    { 
        return pCount; 
    } 
    
    public long getNTime() 
    { 
        return nanoTime; 
    }
    
    public String getSTime() 
    {
        double seconds = nanoTime/1000000000.0;
        return "" + seconds; 
    }
    
    public int getRangeSize() 
    { 
        return hi-lo+1; 
    }
}    
    
