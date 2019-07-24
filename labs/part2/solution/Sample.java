import java.util.*;
import java.util.stream.*;
import java.util.function.*;

@SuppressWarnings("unchecked")
abstract class Writer {
  private Function<String, String> transformer;
  
  public Writer(Function<String, String>... filters) {
    transformer = Stream.of(filters)
      .reduce(Function.identity(), Function::andThen);
  }
  
  public void write(String input) {
    writeContent(transformer.apply(input));
  }
  
  public abstract void writeContent(String input);
  public abstract String getContents();	
}

@SuppressWarnings("unchecked")
class StringWriter extends Writer {
  public StringWriter(Function<String, String>... filters) {
    super(filters);
  }
  
  private StringBuilder contents = new StringBuilder();

  public void writeContent(String input) {
  	contents.append(input);
	}                        
	
	public String getContents() {
	  return contents.toString();
	}
}

@SuppressWarnings("unchecked")
public class Sample {  
  public static void writeToWriter(Writer writer) {
    writer.write("This is really really stupid!!!");
    System.out.println(writer.getContents());
  }
  
  public static String removeStupid(String input) {
    return input.replace("stupid", "s*****");
  }

  public static void main(String[] args) {
    writeToWriter(new StringWriter());
    
    writeToWriter(new StringWriter(String::toUpperCase));
    writeToWriter(new StringWriter(String::toLowerCase));
    writeToWriter(new StringWriter(Sample::removeStupid));

    writeToWriter(new StringWriter(String::toLowerCase, Sample::removeStupid));
    writeToWriter(new StringWriter(String::toUpperCase, Sample::removeStupid));
  }
}