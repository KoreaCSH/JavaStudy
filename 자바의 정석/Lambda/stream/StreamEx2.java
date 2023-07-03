package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {

    public static void main(String[] args) {

        // 배열은 Arrays.stream(T[]) 혹은 Stream.of(T[]) 로 Stream을 생성할 수 있다.
        // filter() 는 조건에 맞지 않는 요소를 제외한다.
        Stream<String> strstream = Stream.of(new String[] {"a", "d", "A", "z"});
        strstream.filter(s -> !s.equals("A")).sorted().forEach(System.out::print);
        System.out.println();

        // 오토박싱 & 언박싱의 비효율을 줄이기 위해서는 Stream<Integer> 보다 IntStream 을 사용하는 것이 좋다.
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 6, 7, 5});
        intStream.sorted().forEach(System.out::print);
        System.out.println();

        // iterate(), generate() 는 람다식을 매개변수로 받아서, 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.
        // iterate(T seed, UnaryOperator<T> f) 는 seed부터 시작, f에 의해 계산된 값을 다시 seed 값으로 해서 계산을 반복한다.
        // limit() 로 무한 스트림을 유한 스트림으로 만들 수 있다.
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        evenStream.limit(10).forEach((i) -> System.out.print(i + " "));
        System.out.println();

        Stream<String> strstream2 = Stream.of(new String[] {"a", "d", "A", "z", "aa", "gdafs"});
        strstream2.sorted((s1, s2) -> s1.compareTo(s2)).forEach((s) -> System.out.print(s + " "));

    }

}
