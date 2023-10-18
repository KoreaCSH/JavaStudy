package ch6_collectorEx;

import ch4_domain.Dish;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsEx {

    public static void main(String[] args) {

        // Collectors 가 제공하는 여러 정적 메서드
        long dishCount = Dish.menu.stream().collect(counting());
        System.out.println(dishCount);


        // 물론 앞에서 배웠듯이 count() 결과 연산을 사용할 수 있다.
        long howManyDishes = Dish.menu.stream().count();
        System.out.println(howManyDishes);


        // Collectors.maxBy(Comparator), Collectors.minBy(Comparator)
        Optional<Dish> mostCalorieDish = Dish.menu.stream()
                                            .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(mostCalorieDish.get());


        // 앞에서 배웠듯이 reduce 를 활용한 max
        Optional<Integer> mostCalorie = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::max);

        System.out.println(mostCalorie.get());

    }

}
