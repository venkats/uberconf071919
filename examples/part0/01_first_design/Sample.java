//Different appliances like TV, Fan,... may be controlled using a universal remote.
//Design such a remote so it can work with different appliances.

class Remote {
  private Controllable controllable;
  
  public Remote(Controllable controllable) {
    this.controllable = controllable;
  }
  
  public void up() {
    controllable.increase();
  }
}

interface Controllable {
  void increase();
}                                

class TV implements Controllable {
  private int volume = 0;
  
  public int getVolume() { return volume; }

  public void increase() {
    volume++;
  }  
}

public class Sample {  
  public static void main(String[] args) {
    TV tv = new TV();                     
    System.out.println(tv.getVolume());

    Remote remote = new Remote(tv);
    remote.up();
    
    System.out.println(tv.getVolume());
  }
}

//The Remote may be used with different Controllables.
//We may have more than one Remote for an appliances.

//The appliances have to conform to the Controllables interface.
//If we bring in a Garage door, it now needs an increase method which does not fit well.