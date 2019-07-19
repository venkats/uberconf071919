import java.util.*;
import java.util.function.*;
    
public class Sample { 
  //lambdas serve as nice strategies
   
  public static int totalValues(List<Integer> values,
    Predicate<Integer> selector) {
//    int result = 0;
//    
//    for(int e : values) {
//      if(selector.test(e)) result += e;
//    }              
//    
//    return result;

    return values.stream()
      .filter(selector)
      .mapToInt(e -> e)
      .sum();
  }
               
  public static boolean isOdd(int n) { return n % 2 != 0; }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    //System.out.println(totalValues(numbers));
    System.out.println(totalValues(numbers, e -> true));
    //turn a normal function into a higher order funtion
    
    System.out.println(totalValues(numbers, e -> e % 2 == 0));
    System.out.println(totalValues(numbers, Sample::isOdd));
  }
}