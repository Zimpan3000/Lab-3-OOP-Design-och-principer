import java.util.HashMap;
import java.awt.*;

public class PositionManager implements Moveable  {
     private HashMap<String, Double> dictionary = new HashMap<>();
     private Point direction = new Point(0,1);
     
     public void setdirection(Point point){
        direction = point;
        
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
    public int getDirectionX () {
        return direction.x;
    }

    public int getDirectionY () {
        return direction.y;
    }

    public void turnLeft() {
        switch (getDirectionY()) {
            case 1:
                direction = new Point(-1,0);
                break;
    
            case 0:
                if (getDirectionX()  == -1) {
                     direction = new Point(0,-1);
                     break;
                    
                } else if (getDirectionX()  == 1) {
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

    public void turnRight() {
        switch (getDirectionY()) {
            case 1:
                direction = new Point(1,0);
                break;
    
            case 0:
                if (getDirectionX() == -1) {
                     direction = new Point(0,1);
                     break;
                    
                } else if (getDirectionX()  == 1) {
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
    @Override
    public void move(double speed) {
        double x = speed * getDirectionX();
        double y = speed * getDirectionY();
        addPositionX(getPositionX() + x);
        addPositionY(getPositionY() + y);
        }
}
