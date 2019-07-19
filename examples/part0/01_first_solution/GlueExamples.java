import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class GlueExamples {
  public static void example1() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.forEach(e -> System.out.println(e));
  }
  
  public static void example2() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.forEach(System.out::println);    
  }
  
  public static void example3() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.forEach(e -> System.out.println(e * 2));
  }
  
  public static void example4() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.forEach(e -> {
      int count = 0;
      for(int i = 1; i <= e; i++) {
        if(e % i == 0) count++;
      }
      System.out.println(count);
    });
  }
  
  public static long countFactors(int number) {
    // int count = 0;
    // for(int i = 1; i <= number; i++) {
    //   if(number % i == 0) count++;
    // }
    // return count;

    IntPredicate isDivisible = index -> number % index == 0;

    return IntStream.rangeClosed(1, number)
                    .filter(isDivisible)
                    .count();
  }
  
  public static void example5() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.forEach(e -> System.out.println(countFactors(e)));
  }
  
  public static void example6() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    numbers.stream()
            .map(GlueExamples::countFactors)
            .forEach(System.out::println);
  }
  
	public static void main(String[] args) {
	  example1();
	  example2();
	  example3();
	  example4();
	  example5();
	  example6();
  }
}


