package ch5.streamEx;

import ch4.domain.Dish;

public class Matching {

    public static void main(String[] args) {

        // 스트림 API 에는 특정 속성이 데이터 집합에 있는지 여부를 검색하는 검색과 매칭 관련 메서드가 있다.
        // 1. Predicate 가 적어도 한 요소와 일치하는 지 확인하는 anyMatch()
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // 2. Predicate 가 모든 요소와 일치하는 지 검사하는 allMatch() 메서드
        if(Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("All menu is lower than 1000kcal");
        }

        // 3. allMatch() 와 반대 연산을 실시하는 noneMatch()
        if(Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("All menu is lower than 1000kcal");
        }

    }

}
