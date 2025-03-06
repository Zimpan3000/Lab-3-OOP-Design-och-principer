public class FullyOpenState implements truckBedfunctionality{

 public void fullyOpen(Flak flak){
 System.out.println("ÖPPEN DOWNIE!!!!!");
 }

public void fullyClose(Flak flak){
    flak.setState(new FullyClosedState());
}
}
