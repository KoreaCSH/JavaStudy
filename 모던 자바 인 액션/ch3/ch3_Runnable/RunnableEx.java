package ch3_Runnable;

public class RunnableEx {

    public static void main(String[] args) {

        // 람다 표현식 = 메서드로 전달할 수 있는 익명 함수를 '단순화' 한 것.
        // 람다 표현식에는 이름이 없지만, 파라미터 리스트, 바디, 반환 형식, 발생할 수 있는 예외 리스트를 포함할 수 있다.
        // 람다 표현식은 결국 '함수형 인터페이스'라는 문맥에서 사용할 수 있다.
        // 함수형 인터페이스 = 오직 하나의 추상 메서드만 가진 인터페이스. 디폴트 메서드의 개수는 상관없다.

        Runnable r1 = () -> System.out.println("Hello World1!");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World2!");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World3!"));

    }

    public static void process(Runnable r) {
        r.run();
    }

}
