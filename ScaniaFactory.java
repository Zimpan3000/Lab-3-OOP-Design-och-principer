public class ScaniaFactory implements CarFactory<Scania> {
    public Scania createCar () {
        return new Scania();
    }
}