package ch7_parallelStream;

import java.util.stream.Stream;

public class ParallelStreamEx {

    public static void main(String[] args) {

        // 스트림 인터페이스를 활용하면 아주 간단하게 요소를 병렬로 처리할 수 있다.
        // 컬렉션에 parallelStream 을 호출하면 '병렬 스트림'이 생성된다.
        // 병렬 스트림이란 각각의 스레드에서 처리할 수 있도록 스트림 요소를 청크로 분할한 스트림이다.
        // 따라서 병렬 스트림을 이용하면 모든 멀티코어 프로세서가 각각의 청크를 처리하도록 할당할 수 있다.

        // 일반적인 순차 스트림 활용 함수
        Long sequentialSum = sequentialSum(10);
        System.out.println(sequentialSum);

        Long iterativeSum = iterativeSum(10);
        System.out.println(iterativeSum);

        Long parallelSum = parallelSum(10);
        System.out.println(parallelSum);

    }

    // 일반적인 반복문
    public static Long iterativeSum(long n) {
        long result = 0;
        for(long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // 일반적인 순차 스트림 작업
    public static Long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                        .limit(n)
                        .reduce(0L, Long::sum);
    }

    // 병렬 스트림 활용
    public static Long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
