package ch6.collectorEx;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    // Collectors.toList() 커스텀 하기
    // 수집 연산의 시발점
    @Override
    public Supplier<List<T>> supplier() {
        // 새로운 결과 컨테이너 만들기
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        // 탐색한 항목을 누적한다.
        return List::add;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        // 누적자 객체를 최종 결과로 변환해야 하지만, 누적자 객체가 이미 최종 결과이므로 항등 함수 identity() 를 반환한다.
        return Function.identity();
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        // 스트림의 서로 다른 서브파트를 병렬로 처리할 때 누적자가 해당 결과를 처리하는 방법
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        // 스트림을 병렬로 리듀스할 것인지, 병렬로 리듀스한다면 어떤 최적화를 선택할 것인지에 대한 힌트 제공
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
