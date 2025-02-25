import java.awt.*;

public abstract class Vehicle {


    private int nrDoors; 
    private double enginePower; 
    public double currentSpeed; 
    private Color color; 
    private String modelName;
    private int widthOfVehicle; 

    //private HashMap<String, Double> dictionary = new HashMap<>();
   // private Point direction = new Point(0,1);
    PositionManager positionManager = new PositionManager();
    private Boolean outOfOrder = false; // if car is on transport or in workshop

    public  Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname, int widthOfVehicle){
        this.nrDoors = nrDoors; 
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelname;
        this.widthOfVehicle = widthOfVehicle;

        positionManager.addPositionX(0.0);
        positionManager.addPositionY(0.0);
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

    
    public void move() {
        if (!outOfOrder) {
            positionManager.move(getCurrentSpeed());
        } else {
            System.out.println("handbreak is on");
        }

    }

    public void turnLeft() {
         positionManager.turnLeft();
    }
    
    
    public void turnRight() {
        positionManager.turnRight();
    }

    public Double getPositionX () {
        return positionManager.getPositionX();
    }

    public Double getPositionY () {
        return positionManager.getPositionY();
    }

     public void addPositionX (Double x) {
        positionManager.addPositionX(x);
    }
    
    public void addPositionY (Double y) {
        positionManager.addPositionY(y);
    }
}    

    

    
    
   
