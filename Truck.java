
import java.awt.*;

public abstract class Truck extends Vehicle implements truckBedfunctionality{
    
    private double TruckSpeedFactor = 0.5;
    private boolean TruckBedIsClosed = true;
    
    

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname, int widthOfCar){ 
        super(nrDoors, enginePower, currentSpeed, color, modelname, widthOfCar);
    }

    public void fullyClose(){
        TruckBedIsClosed = true;
    }
    
    public void fullyOpen(){
        if (currentSpeed == 0) { 
         TruckBedIsClosed = false;
        }
    }

	@Override
	protected double speedFactor() {
		return getEnginePower() * 0.01 * TruckSpeedFactor;
	}

    

    public Boolean getTruckBedIsClosed(){
        return TruckBedIsClosed;
    }

    @Override
    public void startEngine(){
        if (getTruckBedIsClosed()){
                currentSpeed = 0.1;
            }
    }
    

    @Override
    public void gas(double amount) {
        if (amount > 0 && amount < 1) {
                if (getTruckBedIsClosed()) {
                    incrementSpeed(amount);
                }
            
        }
    }

    @Override
    public void brake(double amount){
        if (amount > 0 && amount <1){
            if (getTruckBedIsClosed()){
                decrementSpeed(amount);
            }
        }
        
    }
    
    
}    
