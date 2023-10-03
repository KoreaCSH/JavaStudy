package ch5_streamEx;

import ch4_domain.Dish;
import ch4_domain.Type;

import java.util.List;
import java.util.stream.Collectors;

public class Slicing {

    public static void main(String[] args) {

        List<Dish> filteredMenu =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() < 320)
                        .collect(Collectors.toList());

        // specialMenu 리스트는 이미 칼로리순으로 정렬되어 있기 때문에 320 칼로리보다 크거나 같은 요리가 나왔을 때 반복 작업을 중단해도 된다.
        // filter 연산은 전체 스트림을 반복하며 각 요소에 Predicate 를 적용하기 때문에, 이때 takeWhile 연산을 활용할 수 있다.
        List<Dish> slicedMenu1 =
                Dish.specialMenu.stream()
                        .takeWhile(dish -> dish.getCalories() < 320)
                        .collect(Collectors.toList());

        System.out.println(slicedMenu1);

        // 반대로, dropWhile 연산은 나머지 요소를 선택할 수 있다.
        // 즉, 처음으로 거짓이 되는 지점까지 발견된 요소를 버린다.
        List<Dish> slicedMenu2 =
                Dish.specialMenu.stream()
                        .dropWhile(dish -> dish.getCalories() < 320)
                        .collect(Collectors.toList());

        System.out.println(slicedMenu2);

        // 최대 n 개의 스트림을 반환하도록 하는 limit() 메서드가 있다.
        List<Dish> slicedMenu3 =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() >= 300)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(slicedMenu3);

        // 처음 n 개의 요소를 제외한 스트림을 반환하는 skip() 메서드가 있다.
        List<Dish> slicedMenu4 =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .skip(2)
                        .collect(Collectors.toList());

        System.out.println(slicedMenu4);

        List<Dish> meatDishes =
                Dish.menu.stream()
                        .filter(dish -> dish.getType() == Type.MEAT)
                        .limit(2)
                        .collect(Collectors.toList());

        System.out.println(meatDishes);

        // 스트림을 활용할 땐 컬렉션의 '정렬' 을 고려하자
    }

}
