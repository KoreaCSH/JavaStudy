package ch5_createStream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {

        // Stream.of() 메서드를 통해서 스트림을 생성할 수 있다.
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);


        // Stream.empty() 메서드를 통해서 스트림을 비울 수 있다.
        Stream<String> emptyStream = Stream.empty();


        // Arrays.stream 메서드를 통해서 배열로 스트림을 만들 수 있다.
        int[] numbers = new int[] {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum(); // 기본형 int 로 이루어진 배열은 IntStream 으로 변환한다.
        System.out.println(sum);


        // 무한 스트림 만들기 1 - 생산된 값을 연속적으로 계산하는 Stream.iterate()
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);


        // 퀴즈 5-4
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(20)
                .forEach(ints -> System.out.println("(" + ints[0] + ", " + ints[1] + ")"));


        // 일반적인 피보나치 수열
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(20)
                .map(ints -> ints[0])
                .forEach(System.out::println);


        // iterate() 에 Predicate 적용 - 두 번째 인수로 Predicate 를 받아 언제까지 작업을 수행할 것인지 정할 수 있다.
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);


        // 쇼트서킷을 지원하는 takeWhile() 을 통해서도 작업을 중단할 수 있다.
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 50)
                .forEach(System.out::println);


        // Stream.generate() 는 Supplier 를 인수로 받아 새로운 값을 생성한다.
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

}
