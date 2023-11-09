package ch1.appleFilter;

import ch1.domain.Apple;
import ch1.domain.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * 두 메서드 내부에 중복되는 코드가 많다.
 */
public class AppleFilterV1 {

    public static void main(String[] args) {

        List<Apple> apples = Apple.getApples();

        System.out.println(filterGreenApple(apples));
        System.out.println(filterHeavyApple(apples));
    }

    // 녹색 사과를 선택해서 리스트를 반환
    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 150 이상 사과 선택해서 리스트를 반환
    public static List<Apple> filterHeavyApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

}
