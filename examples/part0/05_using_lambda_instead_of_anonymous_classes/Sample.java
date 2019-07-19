import java.util.*;

public class Sample {  
  public static void main(String[] args) {
//    Thread th = new Thread(new Runnable() {
//      public void run() {
//        System.out.println("In another thread " + Thread.currentThread());
//      }
//    });

//Any where a functional interface (single abstract method interface)           
//is expected you can send a lambda expression

    Thread th = new Thread(() ->
        System.out.println("In another thread " + Thread.currentThread()));
    
    th.start();
    
    System.out.println("In main " + Thread.currentThread());
  }
}