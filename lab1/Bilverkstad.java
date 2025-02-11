import java.util.ArrayList;


//generic type
//

public class Bilverkstad <Vehicle extends Car> {
     private int MAX_CARS;
     private ArrayList<Vehicle> carsInGarage;


    public Bilverkstad (int MAX_CARS){
        this.MAX_CARS = MAX_CARS;
        this.carsInGarage = new ArrayList<>();
    }


    public void takeInCar(Vehicle car){
       if (carsInGarage.size() < MAX_CARS){
           carsInGarage.add(car);
       } else {
           throw new IllegalArgumentException("Garage is full");
       }

    }

    public void takeOutCar(Vehicle car) {
        if (carsInGarage.contains(car)) {
            carsInGarage.remove(car);
        } else {
            throw new IllegalArgumentException("Car is not in the garage!");
        }
    }

    // Test: Kommentera bort nere för att se om det fungerar!

    public static void main(String[] args) {

        Bilverkstad<Volvo240> volvoVerkstad = new Bilverkstad<>(5);

        Volvo240 Volvo = new Volvo240();
        Volvo240 Volvo240 = new Volvo240();

        Saab95 Saab95 = new Saab95();
     // volvoVerkstad.takeInCar(Saab95);
        volvoVerkstad.takeInCar(Volvo240);
        volvoVerkstad.takeInCar(Volvo240);
        volvoVerkstad.takeInCar(Volvo240);
     }



}


