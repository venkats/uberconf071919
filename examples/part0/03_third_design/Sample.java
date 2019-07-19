import java.util.*;

interface Remote {
  void up();
}

class TV {
  private int volume = 0;
  
  public int getVolume() { return volume; }
  
  public Remote getRemote() {
    return new Remote() {
      public void up() {
        volume++;
      }
    };
  }
}

public class Sample {  
  public static void main(String[] args) {
    TV tv = new TV();                     
    System.out.println(tv.getVolume());

    Remote remote = tv.getRemote();
    remote.up();
    
    System.out.println(tv.getVolume());
  }
}

//TV is not messing with any extra methods, so GarageDoor, for example,
//will not have increase, up, etc.

//You can have multiple Remotes on the same TV

//Bonus: You can carry a state on the remote itself if you want to

//looks weird
