package ch6_collectorEx;

import ch4_domain.Dish;
import ch4_domain.Type;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class PartitioningEx {

    public static void main(String[] args) {

        // 분할 함수는 Predicate 를 분류 함수로 사용한다.
        // 그러므로 Map 의 key 형식은 Boolean 이다.
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream()
                                            .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionedMenu);


        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);


        // 물론, 앞서 배웠던 filter() 메서드로도 위의 List 를 얻을 수 있다.
        List<Dish> vegetarianDishesByFilter = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.println(vegetarianDishesByFilter);


        // partitioningBy() 정적 메서드의 장점은 두 번째 매개변수로 Collectors 를 전달할 수 있다는 점이다.
        Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream()
                                                        .collect(partitioningBy(Dish::isVegetarian,
                                                                groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);


        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                Dish.menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get))
                        );

        System.out.println(mostCaloricPartitionedByVegetarian);


        // vegetarian 으로 partitioning 후 500 칼로리 이상인지, 아닌지로 다시 partitioning 하는 예제
        Map<Boolean, Map<Boolean, List<Dish>>> vegetarianDishesByCaloric =
                Dish.menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian,
                                partitioningBy(dish -> dish.getCalories() > 500))
                        );

        System.out.println(vegetarianDishesByCaloric);


        // vegetarian 으로 partitioning 후 각 그룹의 요소 수를 count 하는 예제
        Map<Boolean, Long> vegetarianCount =
                Dish.menu.stream()
                    .collect(partitioningBy(Dish::isVegetarian,
                        counting())
                    );

        System.out.println(vegetarianCount);
    }

}
