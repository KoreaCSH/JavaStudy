package ch6.collectorEx;

import ch4.domain.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
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


        // 요약 연산 - summingInt()
        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);


        // 요약 연산 - averagingInt()
        double avgCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);


        // 요약 연산 - summarizingInt() - count, sum, min, average, max 등의 모든 정보를 담는다.
        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);


        // 요약연산 - joining() -  스트림의 각 객체의 toString() 메서드를 후출하여 추출한 모든 문자열을 하나의 문자열로 연결해서 반환
        String shortMenu = Dish.menu.stream()
                                .map(Dish::getName)
                                .collect(joining());

        System.out.println(shortMenu);

        String hasDelimiter = Dish.menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));

        System.out.println(hasDelimiter);


        // 범용 리듀싱 요약 연산 - reducing 팩토리 메서드로도 위의 요약 연산들을 수행할 수 있다.
        int totalCaloriesByReducing = Dish.menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));

        System.out.println(totalCaloriesByReducing);


        Optional<Dish> mostCalorieDishByReducing = Dish.menu.stream()
                .collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        System.out.println(mostCalorieDishByReducing.get());


        // 퀴즈 6-1
        String shortMenuByReducing = Dish.menu.stream().collect(reducing("", Dish::getName, (a, b) -> a + b));
        System.out.println(shortMenuByReducing);

        String shotMenuByReducing2 = Dish.menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println(shotMenuByReducing2);
    }

}
