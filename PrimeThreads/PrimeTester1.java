import java.lang.*;
/**
 * Single thread PrimeTester processing the time and the count of total primes 
 * of the without using muti-threads.
 *
 * @author Ruhuan Liao
 * @version 1.0
 */
public class PrimeTester1
{
    public static final int MAX = 100000000;

    public static void main(String[] args) throws InterruptedException {
        PrimeThread pThread = new PrimeThread(1,MAX); 
    
        long initialN = System.nanoTime();
        
        pThread.start();
        pThread.join();
        
        long endN = System.nanoTime();
        long nTime = endN - initialN;
        String Seconds = getSeconds(nTime);
    
        System.out.println("----------------My Single Thread Output------------------");
        
        System.out.println("Thread " + pThread.getName() + "PrimeCount = " + pThread.getPCount());
        System.out.printf("#Seconds used = ", pThread.getSTime());
        System.out.println(" ");
        
        int totalPrimes = pThread.getPCount();
        int totalRange = pThread.getRangeSize();
        
        System.out.printf("Main # Secods Used = ", Seconds);
        System.out.println("Total Primes " + totalPrimes);
        System.out.println("Total Range " + totalRange);
        System.out.println("----------------My Single Thread Output------------------");
    }
    
    public static String getSeconds(long nTime){
        return String.format("%6.3f", nTime/1000000000.0);
    }

}