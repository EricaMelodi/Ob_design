package TheOG;

public interface ICollision {

    default boolean collision(Garage<?> g) {
        return false;
    }

}
