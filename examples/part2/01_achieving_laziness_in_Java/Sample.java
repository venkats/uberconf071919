import java.util.*;
import java.util.function.*;
//Java 8: Supplier, Consumer, Function, Predicate

public class Sample {
  public static int compute(int n) {
    System.out.println("called...");
    return n * 2;
  }              
  
  public static void main(String[] args) {
    int val1 = compute(2);  //eager evauation
    
    System.out.println(val1);
    
    Supplier<Integer> supplier = () -> compute(2); //lazy evaluation
                                      
    //lambda has been evaulated, but it has not been executed
    System.out.println("using supplier"); 
    
    System.out.println(supplier.get());
    
    //Java is mostly eager, but you can get lazy using lambdas
  }
}
