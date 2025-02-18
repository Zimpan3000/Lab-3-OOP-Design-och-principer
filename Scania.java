import java.awt.*;


public class Scania extends Truck implements loadFunctionality {
    private double angle = 0.0;
    private int maxangle = 70;
    private int minangle = 0;

    public Scania(){
        super(2,0.9,10,Color.MAGENTA, "scania",6);
    }

    
    @Override
    public void raiseAngle(double incrementdegrees) {
       if (getCurrentSpeed() == 0 && angle + incrementdegrees <= maxangle && incrementdegrees > minangle ){
        if (currentSpeed == 0) {
        angle = incrementdegrees+ angle;
        fullyOpen();
        }
    }
    }


    @Override
    public void lowerAngle(double decrementdegrees) {
        if (getCurrentSpeed() == 0 && angle - decrementdegrees >= minangle && decrementdegrees < maxangle ){
            angle = angle - decrementdegrees;
            if (angle <= 0) {
                fullyClose();
            }

        }
    }

    public double getangle(){
        return angle;
    }

   
    public int getmaxangle(){
        return maxangle;
    }

    public int getminangle(){
        return minangle;
    }


  

}