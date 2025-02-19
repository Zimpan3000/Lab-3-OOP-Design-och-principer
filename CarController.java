import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Point;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Workshop<Volvo240> VolvoWorkshop = new Workshop<>(5, new Volvo240(),0., 300.);
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    // ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        
        Scania newsScania = new Scania();
        newsScania.addPositionX(100.0);
        Saab95 newSaab = new Saab95();
        newSaab.addPositionX(200.0);
        Volvo240 newVolvo240 = new Volvo240();
        
        cc.vehicles.add(newSaab);
        cc.vehicles.add(newsScania);
        cc.vehicles.add(newVolvo240);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
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
                if (car instanceof Volvo240 && car.getPositionX() == VolvoWorkshop.Xgetposition() && car.getPositionY() == VolvoWorkshop.Ygetposition()) {
                    
                VolvoWorkshop.fixCar((Volvo240) car); 
                }
                // if x and y of car and car == volvo and == x and y of workshop
                // fixcar
                frame.drawPanel.moveit(x, y, car.getmodelname());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas =  amount / 100.0;
        System.out.println(gas);
        for (Vehicle car : vehicles) {
            car.gas(gas);
            System.out.println(car.getCurrentSpeed());
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            System.out.println("brake 0");
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    
    void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    
    void liftScaniaBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).raiseAngle(10); // Adjust increment as needed
            }
        }
    }
    
    void lowerScaniaBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).lowerAngle(10); // Adjust decrement as needed
            }
        }
    }
    
    void stopAllCars () {
        for (Vehicle car : vehicles) {
            car.stopEngine();
        }

    }

    void startAllCars () {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }

    }
}


