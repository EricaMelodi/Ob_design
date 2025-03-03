package TheOG;

public class VehicleFactory {
    public Vehicle createVehicle(String modelName) {

        switch (modelName) {
            case "Volvo240":
                return new Volvo240();
            case "Saab95":
                return new Saab95();
            case "Scania":
                return new Scania();
            default:
                throw new IllegalArgumentException("Unknown vehicle model: " + modelName);
        }
    }
}

