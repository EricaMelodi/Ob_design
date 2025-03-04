package TheOG;
import java.util.Arrays;
import java.util.List;

public class VehicleFactory {
    private final List<String> availableModels = Arrays.asList("Volvo240", "Saab95", "Scania");

    public Vehicle createVehicle(String modelName) {
        if (!availableModels.contains(modelName)) {
            throw new IllegalArgumentException("Unknown vehicle model: " + modelName);
        }

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

    public List<String> getAvailableModels() {
        return availableModels;
    }
}
