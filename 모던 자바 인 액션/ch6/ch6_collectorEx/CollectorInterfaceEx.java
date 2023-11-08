package ch6_collectorEx;

import ch4_domain.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class CollectorInterfaceEx {

    public static void main(String[] args) {

        // 커스텀 Collector 객체 사용 예제
        List<Dish> vegetarianDishes = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(new ToListCollector<>());

        System.out.println(vegetarianDishes);


        // 커스텀 Collector 를 구현해서 소수, 비소수 분할 예제 성능 개선하기
        Map<Boolean, List<Integer>> primesMap = partitionPrimesWithCustomCollector(30);
        System.out.println(primesMap);
        
        
        // 기존 Collector 활용
        Map<Boolean, List<Integer>> primesMap2 = partitionPrimes(30);
        System.out.println(primesMap2);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(i -> isPrime(i)));
    }

    static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

}
