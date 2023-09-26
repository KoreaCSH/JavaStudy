package ch4_streamEx;

import ch4_domain.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {

    public static void main(String[] args) {

        List<String> threeHighCaloricDishNames =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> vegetarianDishNames =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .map(dish -> dish.getName())
                        .collect(Collectors.toList());

        System.out.println(vegetarianDishNames);

        // 컬렉션을 활용한 외부연산 vs 스트림을 활용한 내부연산

        // 1. 외부연산
        List<String> highCaloricDishesCollection = new ArrayList<>();
        for(Dish dish : Dish.menu) {
            if(dish.getCalories() > 300) {
                highCaloricDishesCollection.add(dish.getName());
            }
        }
        System.out.println(highCaloricDishesCollection);

        // 2. 내부연산
        // 작업을 투명하게 병렬로 처리, 더 최적화된 다양한 순서로 처리 가능
        List<String> highCaloricDishesStream =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .collect(Collectors.toList());
        System.out.println(highCaloricDishesStream);
    }

}
