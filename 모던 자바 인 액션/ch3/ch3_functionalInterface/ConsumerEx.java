package ch3_functionalInterface;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerEx {

    // 자바가 제공하는 함수형 인터페이스 Consumer
    // Consumer 는 인자 T 를 받고 void 를 return 한다.

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        forEach(numbers, (Integer i) -> System.out.println(i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T t : list) {
            c.accept(t);
        }
    }

}
