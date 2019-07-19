import java.util.*;
import java.util.function.*;

class Resource {
  private Resource() { System.out.println("created"); }
  public Resource op1() { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }

  public static void use(Consumer<Resource> block) {
    Resource resource = new Resource();
    try {
      block.accept(resource);
    } finally {
      System.out.println("clean up");
    }
  }
}                                               

public class Sample {  
  public static void main(String[] args) {
    Resource.use(resource ->
      resource.op1()
        .op2());
  }
}