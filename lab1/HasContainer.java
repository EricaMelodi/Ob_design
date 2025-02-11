public interface HasContainer {

    public void loadCars(Vehicle car, int weight);

    public void unloadCars();

    public void posWhileCarInTransport();

    public  boolean isNear(Vehicle car);
}
