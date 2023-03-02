package encapsulation;

public class Driver {

    private final Car car = new Car();

    public void drive() {
//        car.start();
//        car.moveForward();
//        car.moveBackward();
        car.operate();
    }

}
