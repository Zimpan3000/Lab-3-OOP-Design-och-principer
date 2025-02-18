import java.awt.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        TMF tmfTruck = new TMF(3);
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3= new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        
        ArrayList<Car> loadList = new ArrayList<>();
       
        
        
        tmfTruck.startEngine();
        tmfTruck.gas(0.9);
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        
        tmfTruck.turnLeft();
        tmfTruck.move();
        loadList.add(volvo1);
        loadList.add(volvo2);
        loadList.add(volvo3);
        
        tmfTruck.stopEngine();
        tmfTruck.fullyOpen();
        // Load cars onto the truck
        tmfTruck.loadCars(loadList);
        tmfTruck.startEngine();
        tmfTruck.gas(0.9);
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        tmfTruck.move();
        System.out.println(tmfTruck.getPositionX());
        System.out.println(tmfTruck.getPositionY());
        System.out.println(volvo1.getPositionX());
        System.out.println(volvo1.getPositionY());
        System.out.println(tmfTruck.unloadCars());

        
        // Load cars onto the truck
        
        System.out.println(tmfTruck.getcarList());
    }
        
        // En enkel loop
       
        
        
}
