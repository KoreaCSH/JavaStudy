package ch5_primitiveStreamSpecialization;

import ch4_domain.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamEx {

    public static void main(String[] args) {

        // 스트림 API 는 박싱 비용을 피할 수 있도록 'int 요소에 특화된 IntStream',
        // 'double 요소에 특화된 DoubleStream',
        // 'long' 요소에 특화된 'longStream' 을 제공한다.
        // 각각의 인터페이스는 sum, max, min, average 등의 다양한 유틸리티 메서드를 지원한다.
        // 스트림을 특화 스트림으로 변환할 때는 mapToInt, mapToDouble, mapToLong 세 가지 메서드를 가장 많이 사용한다.

        int caloriesSum = Dish.menu.stream()
                            .mapToInt(Dish::getCalories)
                            // mapToInt 는 Stream<Integer> 가 아닌 IntStream 을 반환한다.
                            .sum();
                            // sum() 은 스트림이 비어있으면 기본값 0 을 반환한다.

        System.out.println(caloriesSum);


        // 객체 스트림으로 복원하기 - boxed() 메서드 사용
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();

        int[] array = new int[]{1, 2, 4};
        Arrays.stream(array)
                .boxed()
                .toArray();

        List<Integer> intListDesc = Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(intListDesc);


        // OptionalInt
        // sum() 에서는 0 이라는 기본값이 있지만, IntStream 에서는 최댓값이 없을 수 있으므로 기본값으로 인해 잘못된 결과가 도출될 수 있다.
        // 그래서 OptionalInt 라는 기본형 Optional 객체를 사용한다.
        OptionalInt caloriesMax = Dish.menu.stream()
                                    .mapToInt(Dish::getCalories)
                                    .max();

        // 이를 통해 값이 없을 때의 기본값을 지정할 수 있다.
        int max = caloriesMax.orElse(1);
        System.out.println(max);


        // 숫자 범위 - range(), rangeClosed() 정적 메서드를 통해 특정 범위의 숫자 Stream 을 얻을 수 있다.
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                    .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());


        // 숫자 스트림을 활용하여 피타고라스 수 다루기
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

}
