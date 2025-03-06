
import java.awt.*;

public abstract class Truck extends Vehicle {
    
    private double TruckSpeedFactor = 10;
    private Flak flak = new Flak();
    

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname, int widthOfCar){ 
        super(nrDoors, enginePower, currentSpeed, color, modelname, widthOfCar);
    }
    
    public void fullyClose(){
        flak.close();
    }
    
    public void fullyOpen(){
        if (currentSpeed == 0) { 
         flak.open();
        }
    }

	@Override
	protected double speedFactor() {
		return getEnginePower() * 0.01 * TruckSpeedFactor;
	}

    

    public Boolean getTruckBedIsClosed(){
        return flak.getState();
    }

    @Override
    public void startEngine(){
        if (getTruckBedIsClosed()){
                currentSpeed = 0.1;
            }
    }
    

    @Override
    public void gas(double amount) {
        if (amount > 0 && amount <= 1) {
                if (getTruckBedIsClosed()) {
                    incrementSpeed(amount);
                }
            
        }
    }

    @Override
    public void brake(double amount){
        if (amount > 0 && amount <= 1){
            if (getTruckBedIsClosed()){
                decrementSpeed(amount);
            }
        }
        
    }
    
    
}    
