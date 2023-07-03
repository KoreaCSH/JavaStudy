package encapsulation;

public class Car {

    private void start() {
        System.out.println("차의 시동을 겁니다.");
    }

    private void moveForward() {
        System.out.println("차가 전진합니다.");
    }

    private void moveBackward() {
        System.out.println("차가 후진합니다.");
    }

    public void operate() {
        start();
        moveForward();
        moveBackward();
    }

}
