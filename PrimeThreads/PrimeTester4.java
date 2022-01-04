import java.lang.*;
/**
 * 4 thread PrimeTester processing the time and the count of total primes 
 * of each of the threads, then add all of the threads together to get the total primes
 *
 * @author Ruhuan Liao
 * @version 1.0
 */
public class PrimeTester4
{
    public static final int MAX = 100000000;

    public static void main(String[] args) throws InterruptedException {
        PrimeThread pThread = new PrimeThread(3,MAX/4); 
        PrimeThread pThread2 = new PrimeThread(MAX/4+1,2*MAX/4);
        PrimeThread pThread3 = new PrimeThread(2*MAX/4+1,3*MAX/4);
        PrimeThread pThread4 = new PrimeThread(3*MAX/4+1,MAX);
    
    
        long initialN = System.nanoTime();
        
        pThread.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();
        
        pThread.join();
        pThread2.join();
        pThread3.join();
        pThread4.join();

        long endN = System.nanoTime();
        long nTime = endN - initialN;
        String Seconds = getSeconds(nTime);
    
        System.out.println("----------------My 4-Thread Output------------------");
        
        System.out.println("Thread " + pThread.getName() + "PrimeCount = " + pThread.getPCount());
        System.out.printf("#Seconds used = %s%n%n", pThread.getSTime());
        System.out.println(" ");
        
        System.out.println("Thread " + pThread2.getName() + "PrimeCount = " + pThread2.getPCount());
        System.out.printf("#Seconds used = %s%n%n", pThread2.getSTime());
        System.out.println(" ");
        
        System.out.println("Thread " + pThread3 + "PrimeCount = " + pThread3.getPCount());
        System.out.printf("#Seconds used = %s%n%n", pThread3.getSTime());
        System.out.println(" ");
        
        System.out.println("Thread " + pThread4 + "PrimeCount = " + pThread4.getPCount());
        System.out.printf("#Seconds used = %s%n%n", pThread4.getSTime());
        System.out.println(" ");
        
        int totalPrimes = pThread.getPCount() + pThread2.getPCount() + pThread3.getPCount() + pThread4.getPCount(); 
        int totalRange = pThread.getRangeSize() + pThread2.getRangeSize() + pThread3.getRangeSize() + pThread4.getRangeSize();
        
        System.out.printf("Main # Secods Used = %s%n ", Seconds);
        System.out.println("Total Primes " + totalPrimes);
        System.out.println("Total Range " + totalRange);
        
        System.out.println("----------------My 4-Thread Output------------------");
    }
    
    public static String getSeconds(long nTime){
        return String.format("%6.3f", nTime/1000000000.0);
    }
}
