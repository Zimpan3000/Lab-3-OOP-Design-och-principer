import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class Application implements CarcontrollerMethods {
    private final int delay = 50;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Workshop<Volvo240> VolvoWorkshop = new Workshop<>(3, new Volvo240(),0., 300.);
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    public DrawPanel frame;
   
    static ScaniaFactory scaniaFactory = new ScaniaFactory();
    static Volvo240Factory volvo240Factory = new Volvo240Factory();
    static SaabFactory saabFactory = new SaabFactory();
    static Application App = new Application();


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicles) {
                car.move();
                int x = (int) Math.round(car.getPositionX());
                int y = (int) Math.round(car.getPositionY());
    
                if (y >= 501 || y < 0) {
                    car.turnRight();
                    car.turnRight();
                }
                if (x >= 701 || x < 0) {
                    car.turnRight();
                    car.turnRight();
                }
    
                // Handle Volvo240 in workshop scenario
                if (car instanceof Volvo240 && isCarClose(car) && VolvoWorkshop.getCapacity() > VolvoWorkshop.getCarsinWS()) {
                    car.addPositionX(VolvoWorkshop.Xgetposition());
                    car.addPositionY(VolvoWorkshop.Ygetposition());
                    VolvoWorkshop.fixCar((Volvo240) car);
                }
    
                // Update the car's position on the screen
                frame.moveit(x, y, car);
                frame.repaint();
            }
            // After all cars are moved, repaint the panel to reflect the new positions
            
        }
    }
    

    private Boolean isCarClose(Vehicle car) {
        Double diffX = Math.abs(car.getPositionX() - VolvoWorkshop.Xgetposition());
        Double diffY = Math.abs(car.getPositionY() - VolvoWorkshop.Ygetposition());
        return(10 >= diffX && diffX >= 0 && diffY >= 0 && diffY <= 10);
    }


    @Override
    public void gas(int amount) {
        double gas =  amount / 100.0;
        System.out.println(gas);
        for (Vehicle car : vehicles) {
            car.gas(gas);
            System.out.println(car.getCurrentSpeed());
        }
    }
    @Override
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            System.out.println("brake 0");
            car.brake(brake);
        }
    }
    @Override
   public void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    @Override
    public void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    @Override
    public void liftScaniaBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).raiseAngle(10); // Adjust increment as needed
            }
        }
    }
    @Override
    public void lowerScaniaBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).lowerAngle(10); // Adjust decrement as needed
            }
        }
    }
    @Override
    public void stopAllCars () {
        for (Vehicle car : vehicles) {
            car.stopEngine();
        }

    }
    @Override
    public void startAllCars () {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }

    }

    @Override
    public void turnLeft(){
        for (Vehicle car : vehicles) {
            car.turnLeft();
        }
        
    }

@Override
    public void turnRight() {
        for (Vehicle car : vehicles) {
            car.turnRight();
        }

    }

    @Override
public void addCar() {
    Random random = new Random();
    int randomInt = random.nextInt(3);
    
    if (vehicles.size() < 10)  {
        Vehicle vehicle;
        if (randomInt == 0) {
            vehicle = volvo240Factory.createCar();
        } else if (randomInt == 1) {
            vehicle = saabFactory.createCar();
        } else {
            vehicle = scaniaFactory.createCar();
        }
          
        App.vehicles.add(vehicle);  
        App.frame.setUpCar(vehicle, new Point(100,0));
        
    }
}


    @Override
    public void removeCar() {
        if (!vehicles.isEmpty()) {
            App.frame.removeCar(vehicles.removeLast());
        }
    }
}










