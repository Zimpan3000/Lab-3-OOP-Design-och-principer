public class Volvo240Factory implements CarFactory<Volvo240>{

@Override
public Volvo240 createCar(){
    return new Volvo240();
}    

}
