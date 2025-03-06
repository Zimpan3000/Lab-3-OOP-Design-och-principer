

import java.awt.*;

public class Saab95 extends Car {

   private double turbo = 10;
   private boolean turboOn = false;

    public Saab95(){
        super(4,10,0.5,Color.PINK,"Saab95",3);
    }


    @Override
    public double speedFactor(){
        if(turboOn) this.turbo = 100;
        return getEnginePower() * 0.01 * turbo;
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
}
