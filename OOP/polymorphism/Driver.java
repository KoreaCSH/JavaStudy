package polymorphism;

import abstraction.Car;
import abstraction.K3;
import abstraction.Seltos;

public class Driver {

    private final Car car = new Seltos();

    void drive() {
        car.start();
        car.moveForward();
        car.moveBackward();
    }

//    private final K3 k3 = new K3();
//    private final Seltos seltos = new Seltos();
//
//    void driveK3() {
//        k3.start();
//        k3.moveForward();
//        k3.moveBackward();
//    }
//
//    void driveSeltos() {
//        seltos.start();
//        seltos.moveForward();
//        seltos.moveBackward();
//    }

}
