package ch5.streamEx;

import ch4.domain.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {

        // 1. filter() 와 Predicate 를 활용한 필터링
        List<Dish> vegetarianMenu =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        System.out.println(vegetarianMenu);


        // 2. distinct() 메서드를 활용한 필터링
        // 해당 메서드는 스트림에서 만든 객체의 hashCode, equals 로 결정된다.
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

}
