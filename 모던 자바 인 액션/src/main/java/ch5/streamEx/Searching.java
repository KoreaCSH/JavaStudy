package ch5.streamEx;

import ch4.domain.Dish;

import java.util.*;

public class Searching {

    public static void main(String[] args) {

        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        System.out.println(dish.get().getName());

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish1 -> System.out.println(dish1.getName()));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = numbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        System.out.println(firstSquareDivisibleByThree.get());

        // findFirst() 와 findAny() 의 차이는?
        // 병렬 실행에서는 첫 번째 요소를 찾기 어렵기 때문에 요소의 반환 순서가 상관없다면 병렬 스트림에서는 findAny 를 사용하자.
        // 반환 순서가 중요하다면 findFirst() 를 사용하자.
    }

}
