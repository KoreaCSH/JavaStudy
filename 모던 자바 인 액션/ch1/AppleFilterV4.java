import java.util.List;
import java.util.stream.Collectors;

/**
 * 스트림을 활용한 사과 객체 필터링
 * 스트림은 주로 컬렉션을 필터링, 추출, 그룹화할 때 사용된다.
 * */
public class AppleFilterV4 {

    public static void main(String[] args) {

        List<Apple> apples = Apple.getApples();

        // 순차 처리 방식의 스트림 활용
        List<Apple> heavyApplesV1 = apples.stream()
                                    .filter((Apple a) -> a.getWeight() > 150)
                                    .collect(Collectors.toList());

        System.out.println(heavyApplesV1);

        // 병렬 처리 방식의 스트림 활용
        List<Apple> heavyApplesV2 = apples.parallelStream()
                                    .filter((Apple a) -> a.getWeight() > 150)
                                    .collect(Collectors.toList());

        System.out.println(heavyApplesV2);

        // 함수는 일급값이다 =
        // 함수는 일반적인 값과 마찬가지로 변수에 할당, 매개변수로 전달 및 다른 함수의 반환값으로 사용할 수 있음을 의미.
    }

}
