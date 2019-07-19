import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3);
    
    Iterator iterator = list.iterator();
    Iterator iterator2 = list.iterator();
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }                                   
    
    //Iterator interface, but you may iterate over a List, Set, etc.

    System.out.println(iterator);
    System.out.println(iterator2);
  }
}