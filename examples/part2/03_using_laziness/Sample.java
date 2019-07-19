import java.util.*;
import java.util.function.*;

class Lazy<T> {
  private T instance;      
  Supplier<T> supplier;
  
  public Lazy(Supplier<T> theSupplier) {
    supplier = theSupplier;
  }
  
  public T get() {
    if(instance == null) {
      instance = supplier.get();
      supplier = null;
    }                 
    
    return instance;
  }
}

class Heavy {
  public Heavy() { System.out.println("Heavy created"); }
  public int getValue() { return 1; }
}    

class Holder {
  private Lazy<Heavy> heavy = new Lazy<>(() -> new Heavy());
  
  public Holder() {
    System.out.println("Holder created");
  }
  
  public int getValue() { return heavy.get().getValue(); }
}

public class Sample {  
  public static void main(String[] args) {
    Holder holder = new Holder(); //Heavy object is created lazily
    
    System.out.println("Toss");
    if(Math.random() > 0.5) {
      System.out.println(holder.getValue());
    }                         
    //if you don't use the object you don't paid for it
  }
}