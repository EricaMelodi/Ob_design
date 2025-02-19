package TheOG;

public interface IHasContainer {

    void loadCars(Vehicle car, int weight);

    void unloadCars();

    void posWhileCarInTransport();

    boolean isNear(Vehicle car);

    boolean isPlatformOpen();

    void closePlatform();

    void openPlatform();

}
