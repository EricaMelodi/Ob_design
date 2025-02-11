import java.util.ArrayList;

public class Container<T> {

    private ArrayList<T> data = new ArrayList<>();
    private int maxAmount;

    public Container (int getMaxAmount) {
        this.maxAmount = maxAmount;
    }


}
