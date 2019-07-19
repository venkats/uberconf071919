import java.util.*;
import java.util.function.*;

public class Sample {  
  public static void process(int n, String msg, Function<Integer, Integer> func) {
    System.out.println(n + " " + msg + ": " + func.apply(n));
  } 
  
  public static void main(String[] args) {
    Function<Integer, Integer> inc = e -> e + 1;
    Function<Integer, Integer> doubled = e -> e * 2;
    
    process(5, "incremented", inc); 
    process(5, "doubled", doubled); 
    
    process(5, "incremented and doubled", inc.andThen(doubled));
    process(5, "doubled and incremented", inc.compose(doubled));
  }
}