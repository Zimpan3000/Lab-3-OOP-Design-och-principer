import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Vehicle>{

    private int capacity;
    private T model;
    private List<T> workshopList= new ArrayList<>(capacity);
    private double Xposition;
    private double Yposition;
    public Workshop(int capacity, T model,double Xposition, double Yposition){
        this.capacity = capacity;
        this.model = model;
        this.Xposition = Xposition;
        this.Yposition = Yposition;

    }

    

    public void fixCar(T damagedVehicle){
        if ( workshopList.size() < capacity && !damagedVehicle.getOutOfOrder()){
        damagedVehicle.setOutOfOrderOn();
        workshopList.add(damagedVehicle);
    }
    } 

    public T removeVehicle(T Vehicle) {
        workshopList.remove(Vehicle);
        Vehicle.setOutOfOrderOff();
        return Vehicle;

    }

    public T getmodelname() {
        return this.model;
    }

    public List<T> getWorkshopList() {
        return new ArrayList<>(workshopList); 
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return workshopList.size();
    }

    public double Xgetposition(){
        return Xposition;
    }

    public double Ygetposition(){
        return Yposition;
    }
}