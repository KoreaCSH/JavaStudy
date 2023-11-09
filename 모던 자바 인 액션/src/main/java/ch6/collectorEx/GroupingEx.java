package ch6.collectorEx;

import java.util.*;

import ch4.domain.Dish;
import ch4.domain.Type;
import ch6.domain.CaloricLevel;

import static java.util.Comparator.*;
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
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("greasy", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("salmon", Arrays.asList("delicious", "fresh"));

        Map<Type, Set<String>> dishNamesByType = Dish.menu.stream()
                                                    .collect(groupingBy(Dish::getType,
                                                            flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));

        System.out.println(dishNamesByType);


        // 다수준 그룹화
        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream()
                                                                                .collect(groupingBy(Dish::getType,
                                                                                        groupingBy(dish -> {
                                                                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                                                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                                                                            else return CaloricLevel.FAT;
                                                                                        })));

        System.out.println(dishesByTypeCaloricLevel);


        // 서브그룹으로 데이터 수집 - 단순한 그룹화 뿐만 아니라 Collectors.counting() 등의 정적 메서드를 넘겨서 그룹의 데이터를 계산할 수도 있다.
        Map<Type, Long> typesCount =
                Dish.menu.stream()
                        .collect(groupingBy(Dish::getType, counting()));

        System.out.println(typesCount);


        Map<Type, Optional<Dish>> mostCaloricByType =
                Dish.menu.stream()
                        .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        System.out.println(mostCaloricByType);


        // groupingBy 는 존재하지 않는 요리의 키를 Map 에 추가하지 않기 때문에 위의 maxBy 예제처럼 Optional 래퍼를 사용할 필요가 없다.
        // 이 때 collectingAndThen 정적 메서드를 활용할 수 있다.
        Map<Type, Dish> mostCaloricByType2 =
                Dish.menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get
                                )));

        System.out.println(mostCaloricByType2);


        // groupingBy 의 두 번째 매개변수로 다른 Collectors 정적 메서드를 전달하는 에제
        Map<Type, Integer> totalCaloriesByType = Dish.menu.stream()
                                                    .collect(groupingBy(Dish::getType,
                                                            summingInt(Dish::getCalories)));

        System.out.println(totalCaloriesByType);


        Map<Type, Set<CaloricLevel>> caloricLevelByType =
                Dish.menu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }, toCollection(HashSet::new) )));

        System.out.println(caloricLevelByType);
    }

}
