import java.util.*;
import java.util.function.*;

public class Sample {                                     
  public static String fastCompute(int value) {
    return "fast algorithm to compute " + value;
  }

  public static String preciseCompute(int value) {
    return "precision algorithm to compute " + value;
  }

  public static String doWork(Function<Integer, String> algorithm) {
    return "doWork with " + algorithm.apply(42);
  }
  
  public static void main(String[] args) {
    //we may use either of the algorithms for computation.
    
    if(Math.random() > 0.5) {
      System.out.println(doWork(Sample::fastCompute));
    } else {
      System.out.println(doWork(Sample::preciseCompute));
    }
  }
}