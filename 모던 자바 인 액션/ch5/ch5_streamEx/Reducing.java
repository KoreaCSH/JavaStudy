package ch5_streamEx;

import ch4_domain.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    public static void main(String[] args) {

        // 리듀싱 연산 - 모든 스트림 요소를 처리해서 값으로 도출하는 연산
        // reduce 메서드는 두 개의 인자를 갖는다. 초깃값과 두 요소를 조합해서 새로운 값을 만드는 BinaryOperator.
        // ex) 메뉴의 모든 칼로리의 합을 구하시오.
        int kcalSum = Dish.menu.stream()
                .map(dish -> dish.getCalories())
                .reduce(0, Integer::sum);

        System.out.println(kcalSum);

        // 초깃값을 받지 않도록 오버로드된 reduce 도 있다. 단, 해당 메서드는 Optional 객체를 반환한다.
        // 스트림에 아무 요소도 없는 경우 reduce 는 합계를 반환할 수 없으므로 Optional 객체로 감싼 결과를 반환한다.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(sum.get());

        // reduce 연산으로 최댓값, 최솟값도 찾을 수 있다.
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());

        long count = Dish.menu.stream().count();
        System.out.println(count);
        // count 연산을 사용하지 않고, map 과 reduce 연산을 연결하는 기법인 맵 리듀스 패턴으로도 리스트의 요소 개수를 셀 수 있다.

        int countByMapReducePattern = Dish.menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);

        System.out.println(countByMapReducePattern);
    }

}
