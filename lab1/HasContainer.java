public interface HasContainer {

    void loadCars(Vehicle car, int weight);

    void unloadCars();

    void posWhileCarInTransport();

    boolean isNear(Vehicle car);

    void platFormIsRaised();

}
