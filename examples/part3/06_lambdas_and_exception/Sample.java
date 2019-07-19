import java.util.*;
import java.io.*;

interface ConsumerWithException<T, E extends Exception> {
  void accept(T input) throws E;
}            

class Resource {
  private Resource() { System.out.println("created"); }
  public Resource op1() throws IOException { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }

  public static void use(ConsumerWithException<Resource, IOException> block) throws IOException {
    Resource resource = new Resource();
    try {
      block.accept(resource);
    } finally {
      System.out.println("clean up");
    }
  }
}                                               

public class Sample {  
  public static void main(String[] args) throws IOException {
    Resource.use(resource ->
      resource.op1()
        .op2());
  }
}