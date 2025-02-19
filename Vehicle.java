import java.awt.*;
import java.util.HashMap;

public abstract class Vehicle implements Moveable {


    private int nrDoors; 
    private double enginePower; 
    public double currentSpeed; 
    private Color color; 
    private String modelName;
    private int widthOfVehicle; 

    private HashMap<String, Double> dictionary = new HashMap<>();
    private Point direction = new Point(0,1);

    private Boolean outOfOrder = false; // if car is on transport or in workshop

    public  Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname, int widthOfVehicle){
        this.nrDoors = nrDoors; 
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelname;
        this.widthOfVehicle = widthOfVehicle;

        dictionary.put("x", 0.0);
        dictionary.put("y", 0.0);
    }

    public int getwidthOfCar(){
        return widthOfVehicle;
    }

    public int getNrDoors(){
        return nrDoors; 
    }
    
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        double returnSpeed = currentSpeed;
        if (returnSpeed > enginePower) {
            returnSpeed = enginePower;
        } else if (returnSpeed < 0) {
            returnSpeed = 0;
        }
        return returnSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    this.color = clr;
    }

    public String getmodelname(){
        return modelName;
    }

    public void startFixingVehicle(){

    }

    public void setOutOfOrderOn () {
        stopEngine();
        outOfOrder = true;
    }

    public void setOutOfOrderOff () {
        startEngine();
        outOfOrder = false;
    }

    public Boolean getOutOfOrder () {
        return outOfOrder;

    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    protected abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    
    public void gas(double amount) {
        if (amount > 0 && amount <= 1) {
         incrementSpeed(amount);
        }
    }


    public void brake(double amount) {
        if (amount > 0 && amount <= 1) {
            decrementSpeed(amount);
            }
        
    }

    @Override
    public void move() {
        if (!outOfOrder) {
        double speed = getCurrentSpeed();
        double x = speed * direction.x;
        double y = speed * direction.y;
        dictionary.put("x", dictionary.get("x") + x);
        dictionary.put("y", dictionary.get("y") + y);
        } else {
            System.out.println("handbreak is on");
        }

    }

    @Override 
    public void turnLeft() {
        switch (direction.y) {
            case 1:
                direction = new Point(-1,0);
                break;
    
            case 0:
                if (direction.x == -1) {
                     direction = new Point(0,-1);
                     break;
                    
                } else if (direction.x == 1) {
                    direction = new Point(0,1);
                    break;
                }
            case -1:
                direction = new Point(1,0);
                break;
                
             default:
                break;

        }
    }

    @Override
    public void turnRight() {
        switch (direction.y) {
            case 1:
                direction = new Point(1,0);
                break;
    
            case 0:
                if (direction.x == -1) {
                     direction = new Point(0,1);
                     break;
                    
                } else if (direction.x == 1) {
                    direction = new Point(0,-1);
                    break;
                }
            case -1:
                direction = new Point(-1,0);
                break;
                
             default:
                break;

        }
    }

    public Double getPositionX () {
        return dictionary.get("x");
    }

    public Double getPositionY () {
        return dictionary.get("y");
    }

     public void addPositionX (Double x) {
        dictionary.put("x", x);
    }
    
    public void addPositionY (Double y) {
        dictionary.put("y", y);
    }
    public Point getDirection () {
        return direction;
    }
    
    
}    

    

    
    
   
