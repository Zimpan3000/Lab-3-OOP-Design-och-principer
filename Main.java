import java.awt.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        TMF tmfTruck = new TMF(3);
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        Scania   scania = new Scania();

        scania.startEngine();
        scania.gas(0.5);
        System.out.println(scania.getCurrentSpeed());
        scania.stopEngine();
        scania.gas(0.5);
        System.out.println(scania.getCurrentSpeed());
        
        
        // En enkel loop
    }}
        
        
        
