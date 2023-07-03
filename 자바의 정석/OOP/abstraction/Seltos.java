package abstraction;

public class Seltos implements Car {

    @Override
    public void start() {
        System.out.println("Seltos의 시동을 겁니다.");
    }

    @Override
    public void moveForward() {
        System.out.println("Seltos가 전진합니다.");
    }

    @Override
    public void moveBackward() {
        System.out.println("Seltos가 후진합니다.");
    }
}
