import java.util.*;

class Heavy {
  public Heavy() { System.out.println("Heavy created"); }
  public int getValue() { return 1; }
}    

class Holder {
  private Heavy heavy = new Heavy();
  
  public Holder() {
    System.out.println("Holder created");
  }
  
  public int getValue() { return heavy.getValue(); }
}

public class Sample {  
  public static void main(String[] args) {
    Holder holder = new Holder(); //Heavy object is created eagerly
    
    System.out.println("Toss");
    if(Math.random() > 0.5) {
      System.out.println(holder.getValue());
    }                         
    //even if you don't use the object you paid for it
  }
}