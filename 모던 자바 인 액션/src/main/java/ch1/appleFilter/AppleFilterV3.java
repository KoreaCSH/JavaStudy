package ch1.appleFilter;

import ch1.domain.Apple;
import ch1.domain.Color;

import java.util.*;
import java.util.function.Predicate;

public class AppleFilterV3 {

    public static void main(String[] args) {

        List<Apple> apples = Apple.getApples();

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numbers = Arrays.asList(array);

        System.out.println(filter(apples, apple -> {
            return Color.GREEN.equals(apple.getColor()) && apple.getWeight() > 150;
        }));

        System.out.println(filter(numbers, i -> i % 2 == 0));

    }

    // 라이브러리 메서드 사용
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {

        List<T> result = new ArrayList<>();

        for(T e : inventory) {
            if(p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

}
