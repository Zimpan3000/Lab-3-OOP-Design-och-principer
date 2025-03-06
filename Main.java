import java.awt.*;
public class Main {
    
    static ScaniaFactory scaniaFactory = new ScaniaFactory();
    static Volvo240Factory volvo240Factory = new Volvo240Factory();
    static SaabFactory saabFactory = new SaabFactory();
    static Application app;
    static CarController cc;

        public static void main(String[] args) {
           /**
            * Är du en godtycklig kurva i ett konservativt vektorfält för dina kurvor har potential
            * Om vi var två elektroner i en kvantmekanisk superposition, skulle vi ha en 100% sannolikhet att kollapsa i samma sängkonfiguration. 
            */
    
            
        app = new Application();
        app.frame = new DrawPanel(800,560);
        cc = new CarController("CARSIM 1.0", app.frame, app);

        Scania newScania = scaniaFactory.createCar();
        Volvo240 newVolvo240 = volvo240Factory.createCar();
        Saab95 newSaab = saabFactory.createCar();
        newScania.addPositionX(100.0);
        newSaab.addPositionX(200.0);
        
       
        app.vehicles.add(newSaab);
        app.vehicles.add(newScania);
        app.vehicles.add(newVolvo240);
        
        app.frame.setUpCar(newSaab,new Point(300,0));
        app.frame.setUpCar(newScania ,new Point(200,0));
        app.frame.setUpCar(newVolvo240,new Point(100,0));

        app.timer.start();
    }
}
        
        
        
