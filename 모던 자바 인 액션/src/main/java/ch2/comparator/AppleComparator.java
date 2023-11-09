package ch2.comparator;

import ch2.domain.Apple;

import java.util.Comparator;
import java.util.List;

public class AppleComparator {

    public static void main(String[] args) {
        List<Apple> apples = Apple.getApples();
        System.out.println(apples);

        // 익명클래스 활용
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
        System.out.println(apples);

        // 럄다식 활용
        apples.sort((Apple a1, Apple a2) ->
            a2.getWeight() - a1.getWeight()
        );

        System.out.println(apples);
    }

}
