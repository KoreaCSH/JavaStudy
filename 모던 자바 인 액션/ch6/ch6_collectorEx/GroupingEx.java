package ch6_collectorEx;

import java.util.*;

import ch4_domain.Dish;
import ch4_domain.Type;
import ch6_domain.CaloricLevel;

import static java.util.stream.Collectors.*;

public class GroupingEx {

    public static void main(String[] args) {

        // Collectors.groupingBy(Function) 으로 stream 을 그룹화할 수 있다.
        Map<Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);


        // 메서드 참조로 분류할 수 없는 경우
        Map<CaloricLevel, List<Dish>> dishesByCalorie = Dish.menu.stream()
                                                            .collect(groupingBy(dish -> {
                                                                if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                                                else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                                                else return CaloricLevel.FAT;
                                                            }));

        System.out.println(dishesByCalorie);


        // 각 그룹의 요소를 조작하는 연산
        // ex) 500 칼로리가 넘는 요리만 필터하는 경우 - filter 메서드 사용 -> FISH 에는 500 칼로리가 넘는 요리가 없기에 map 에 아예 추가되지 않는다.
        Map<Type, List<Dish>> caloricDishesByType = Dish.menu.stream()
                                                        .filter(dish -> dish.getCalories() >= 500)
                                                        .collect(groupingBy(Dish::getType));

        System.out.println(caloricDishesByType);


        // filter() 메서드가 아닌, collect() 메서드 내부에서 filtering() 정적 메서드를 사용하자.
        Map<Type, List<Dish>> caloricDishesByType2 = Dish.menu.stream()
                                                        .collect(groupingBy(Dish::getType,
                                                                filtering(dish -> dish.getCalories() >= 500, toList())));

        System.out.println(caloricDishesByType2);


        // collect() 메서드 내부에서 mapping() 정적 메서드 사용
        Map<Type, List<String>> dishNameByType = Dish.menu.stream()
                                                    .collect(groupingBy(Dish::getType,
                                                            mapping(Dish::getName, toList())));

        System.out.println(dishNameByType);


        // flatMapping() 예제
    }

}
