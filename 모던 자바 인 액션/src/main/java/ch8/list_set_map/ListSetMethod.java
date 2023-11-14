package ch8.list_set_map;

import ch4.domain.Dish;
import ch4.domain.Type;

import java.util.*;
import java.util.stream.Collectors;

public class ListSetMethod {

    public static void main(String[] args) {

        List<Dish> dishes = Dish.menu.stream()
                            .collect(Collectors.toList());

        // 아래의 로직은 ConcurrentModificationException 을 일으킨다.
        // for-each 루프는 Iterator 객체를 사용하므로 Iterator 객체와 dishes 객체의 상태가 서로 동기화되지 않기 때문이다.
        // Iterator 객체를 명시적으로 사용하며 해당 객체의 remove() 메서드를 통해 해당 문제를 해결할 수 있지만, 코드가 복잡해진다.
        /*
        for(Dish dish : dishes) {
            if(dish.isVegetarian()) {
                dishes.remove(dish);
            }
        }
        */

        // 이를 해결하기 위해 removeIf 메서드를 사용할 수 있다.
        dishes.removeIf(Dish::isVegetarian);
        System.out.println(dishes);


        // 리스트의 각 요소를 새로운 요소로 바꾸기 위해 map 메서드를 사용할 수도 있겠지만, 기존의 컬렉션에서 요소를 변경하고 싶다면
        // replaceAll 메서드를 활용할 수 있다.
        // replaceAll 의 매개변수는 UnaryOperator 이며, UnaryOperator 는 T 를 받아 T 를 반환하는 함수형 인터페이스이다.
        List<Dish> dishes2 = Dish.menu.stream()
                                .collect(Collectors.toList());

        dishes2.replaceAll(dish -> {
            if(dish.isVegetarian()) {
                dish.setType(Type.VEGETABLE);
            }
            return dish;
        });

        dishes2.stream()
                .forEach(dish -> System.out.println(dish + " : " + dish.getType()));


        // 현재 컬렉션에서 바로 정렬하는 sort() 메서드
        dishes2.sort(Comparator.comparingInt(Dish::getCalories));

        dishes2.stream()
                .forEach(dish -> System.out.println(dish + " : " + dish.getCalories()));

        List<Integer> numbers = Arrays.asList(1, 3, 5, 2, 4, 6);
        numbers.sort(Comparator.reverseOrder());

        System.out.println(numbers);

        // 정리 : List 와 Set 에서 기존 컬렉션을 유지하며 요소에 변화를 주고 싶다면 removeIf, replaceAll, sort 메서드를 활용하자
    }

}
