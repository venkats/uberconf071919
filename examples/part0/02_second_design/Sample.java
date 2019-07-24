interface Remote {
  void up();
}

class TV implements Remote {
  private int volume = 0;
  
  public int getVolume() { return volume; }

  public void up() {
    volume++;
  }  
}

public class Sample {  
  public static void main(String[] args) {
    TV tv = new TV();                     
    System.out.println(tv.getVolume());

    Remote remote = tv;
    remote.up();
    
    System.out.println(tv.getVolume());
  }
}

//The appliance conforms to the Remote interface. Simplifies the design a bit, but introduces quite a few concerns.

//We can't have multiple Remotes for the same appliance.
//The appliance's public method participate in Remote function, we can't have a private implementation for improved efficiency where needed.
//Tight coupling if Remote and appliances.