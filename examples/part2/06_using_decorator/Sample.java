import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.awt.Color;

@SuppressWarnings("unchecked")
class Camera {
  private Function<Color, Color> filter;
  
  public Camera(Function<Color, Color>... filters) {
//    filter = input -> input;
//    
//    for(Function<Color, Color> aFilter: filters) {
//      filter = filter.andThen(aFilter);
//    }

//      filter = Stream.of(filters)
//        .reduce(input -> input, (allFilters, aFilter) -> allFilters.andThen(aFilter));

//      filter = Stream.of(filters)
//        .reduce(Function.identity(), (allFilters, aFilter) -> allFilters.andThen(aFilter));

      filter = Stream.of(filters)
        .reduce(Function.identity(), Function::andThen);
  }
  
  public Color snap(Color input) {
    return filter.apply(input);
  }
}

@SuppressWarnings("unchecked")
public class Sample {
  public static void print(Camera camera) {
    System.out.println(camera.snap(new Color(125, 125, 125)));
  } 
   
  public static void main(String[] args) {
    print(new Camera());
    //print(new Camera(color -> color.brigher()));
    print(new Camera(Color::brighter));
    print(new Camera(Color::darker));

    print(new Camera(Color::brighter, Color::darker));
  }
}