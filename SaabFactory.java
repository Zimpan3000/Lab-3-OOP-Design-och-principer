public class SaabFactory implements CarFactory<Saab95> {

@Override
public  Saab95 createCar(){
    return new Saab95();
}    

}
