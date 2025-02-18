
import java.awt.*;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
public class TMF extends Truck{

    private int maxsize;
    private Deque<Car> carlist = new ArrayDeque<>(maxsize);
    private int widthOfLorry= 4;
   

    public TMF(int maxsize){
        super(2, 0.8, 0,Color.CYAN ,"TMF",4);
        this.maxsize = maxsize;
    }

    
    public void loadCars(List<Car> loadList){
        if (loadList.size() + carlist.size() <= maxsize){
            
            for (int i = 0 ; i < loadList.size(); i++ ){
               
                if (loadList.get(i).getwidthOfCar() <= widthOfLorry && (this instanceof Truck)&& isCarClose(loadList.get(i)) && getCurrentSpeed()==0 && getTruckBedIsClosed()==false) {
                    if (!loadList.get(i).getOutOfOrder()) {
                        carlist.addFirst(loadList.get(i));
                        loadList.get(i).setOutOfOrderOn();
                    }
                }
            }
        }
    }

    private Boolean isCarClose(Car car) {
        Double diffX = Math.abs(car.getPositionX() - getPositionX());
        Double diffY = Math.abs(car.getPositionY() - getPositionY());
        return(10 >= diffX && diffX > 0 && diffY > 0 && diffY <= 10);
    }
    
    public Car unloadCars() {
        carlist.peek().setOutOfOrderOff();
        return carlist.removeFirst();
        
    }
    @Override
    public void move() {
        super.move();
        for (Car car : carlist) {
            car.addPositionX(getPositionX());
            car.addPositionY(getPositionY());
            }
    }

    public int getmaxsize(){
        return maxsize;
    }

    public Deque<Car> getcarList(){
        return carlist;
    }

    public int widthOfLorry(){
        return widthOfLorry;
    }
}

