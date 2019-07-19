import java.util.*;
import java.util.function.*;

public class Sample {  
  public static void process(int n, String msg, Predicate<Integer> predicate) {
    System.out.println(n + " " + msg + ": " + predicate.test(n));
  } 
  
  public static void main(String[] args) {
    Predicate<Integer> isEven = e -> e % 2 == 0;
    Predicate<Integer> isGT5 =  e -> e > 5;
    
    process(5, "is even", isEven);
    process(14, "is even", isEven);

    process(5, "is > 5", isGT5);
    process(14, "is > 5", isGT5);
    
    process(5, "is even and > 5", isEven.and(isGT5));
    process(5, "is even or > 5", isEven.or(isGT5));
    process(14, "is even and > 5", isEven.and(isGT5));
    process(14, "is even or > 5", isEven.or(isGT5)); 
    
    process(5, "is odd", isEven.negate());
  }
}