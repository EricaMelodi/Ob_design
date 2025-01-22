public interface Movable {

    int x = 0;
    int up = x + 1;


    default void move(String direction) {
        if (direction == "framåt") {
            // y + 1
        } else if (direction == "bakåt") {
            // y - 1
        } else if (direction == "höger") {
            // x + 1
        } else if (direction == "vänster") {
            // x - 1
        } else {
            System.out.println("Please enter a valid direction.");
        }

    }

    void turnLeft();

    void turnRight();

}