package abstraction;

public class K3 implements Car {

    @Override
    public void start() {
        System.out.println("K3의 시동을 겁니다.");
    }

    @Override
    public void moveForward() {
        System.out.println("K3가 전진합니다.");
    }

    @Override
    public void moveBackward() {
        System.out.println("K3가 후진합니다.");
    }

}
