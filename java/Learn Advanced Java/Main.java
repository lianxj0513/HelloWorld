import java.math.BigInteger;
import java.time.Clock;
import java.util.concurrent.ForkJoinPool;

public class Main {
  public static void main(String[] args) {
    Clock clock = Clock.systemDefaultZone();
    long start, stop;
    MakeBigIntArray test = new MakeBigIntArray(5000);
    
    // Check the number of available processors
    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println(nThreads);
    
    RecursiveFactorial rSum = new RecursiveFactorial(test.getList());
    ForkJoinPool pool = new ForkJoinPool(nThreads);
    
    start = clock.millis();
    pool.invoke(rSum);
    stop = clock.millis();
    
    BigInteger result = rSum.result;
    System.out.println("Time in ms: " + (stop - start));
    System.out.println("Pooled Result: " + result);
    
    BigInteger sum = new BigInteger("1");
    start = clock.millis();
    for (int i = 0; i < test.getList().length; i++) {
        sum = sum.multiply(test.getList()[i]);
    }
    stop = clock.millis();
    System.out.println("Time in ms: " + (stop - start));
    System.out.println("Serial Result: " + sum);
  }
}