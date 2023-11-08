package ch6_collectorEx;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

// Collector<T, A, R> 에서 T 는 스트림 요소의 형식,
// A 는 중간 결과를 누적하는 객체의 형식
// R 는 collect 연산의 최종 결과 형식을 의미한다.

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            // 즉, 현재까지 얻은 acc.get(true) 소수 리스트로 소수임을 판별하는 것.
            acc.get(isPrime(acc.get(true), candidate)).add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream().takeWhile(i -> i <= candidateRoot)
                               // noneMatch(Predicate) 는 주어진 Predicate 와 일치하는 요소가 없는 지 확인한다. 그리고 해당 메서드는 쇼트서킷 기법.
                              .noneMatch(i -> candidate % i == 0);
    }

}
