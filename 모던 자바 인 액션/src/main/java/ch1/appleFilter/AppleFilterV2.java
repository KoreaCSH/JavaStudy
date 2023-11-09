package ch1.appleFilter;

import ch1.domain.Apple;
import ch1.domain.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 코드 중복을 방지하기 위해 인수로 값을 받아 true 나 false 를 반환하는 'Predicate' 를 활용하자
 */
public class AppleFilterV2 {

    public static void main(String[] args) {

        List<Apple> apples = Apple.getApples();

        System.out.println(filterApples(apples, apple -> isGreenApple(apple)));

        // 메소드 참조(method reference)는 람다 표현식이 단 하나의 메소드만을 호출하는 경우에 해당 람다 표현식에서 불필요한 매개변수를 제거하고 사용할 수 있도록 해줍니다.
        System.out.println(filterApples(apples, AppleFilterV2::isHeavyApple));
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

}
