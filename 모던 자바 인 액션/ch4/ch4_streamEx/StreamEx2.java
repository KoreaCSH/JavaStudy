package ch4_streamEx;

import ch4_domain.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {

    public static void main(String[] args) {

        // 스트림은 기본적으로 lazy 연산이며, 최종 연산을 스트림 파이프라인에서 실행하기 전까지는 아무 연산도 수행하지 않는다.
        // 즉, 중간 연산을 모두 합친 후 합쳐진 중간 연산을 최종 연산으로 한 번에 처리한다.
        // filter 와 map 은 서로 다른 중간 연산이지만 한 과정으로 병합되었다. 이를 '루프 퓨젼'이라 한다.
        List<String> names =
                Dish.menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering: " + dish.getName());
                            return dish.getCalories() > 300;
                        })
                        .map(dish -> {
                            System.out.println("mapping: " + dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(names);

        // 최종 연산에는 collect 뿐만 아니라, count 와 forEach 도 있다.
        long count =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .distinct()
                        .count();

        System.out.println(count);
    }

}
