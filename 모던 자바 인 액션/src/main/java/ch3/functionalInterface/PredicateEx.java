package ch3.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

    // 자바가 제공하는 함수형 인터페이스 Predicate
    // Predicate 는 인자 T 를 받고 boolean 을 return 한다.

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        List<Integer> even = filter(numbers, (Integer i) -> i % 2  == 0);
        System.out.println(even);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
