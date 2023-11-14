package parallel;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ParallelStreamBenchmark {

    // 자바7 이후 버전부터 _는 숫자 리터럴의 어디에도 등장할 수 있으며, 이를 통해 숫자를 끊어 읽을 수 있게 되어 가독성이 향상된다.
    private static final long N = 10_000_000L;

    // Score : 3.195
    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for(long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    // Score : 73.409
    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }

    // Score : 195.046
    @Benchmark
    public long parallelSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    // 스트림 및 병렬이 더 느린 이유는
    // 1. 반복 결과로 박싱된 객체가 만들어지므로 숫자를 더하려면 언박싱을 해야 한다.
    // 2. 반복 작업은 병렬로 수행할 수 있는 독립 단위로 나누기가 어렵다.
    // 즉, 병렬 프로그래밍을 오용하면 오히려 전체 프로그램의 성능이 더 나빠질 수도 있다.


    // 병렬에 더 특화된 메서드 사용
    // 병렬 연산을 하기 위해서는 연산에 사용될 데이터들이 청크 단위로 나누어져야 한다.
    // rangeClosed() 는 청크로 분할할 수 있는 숫자 범위 생산 + 기본형 long 을 직접 사용하므로 박싱과 언박싱 오버헤드가 사라진다는 장점이 있다.

    // Score : 3.139
    @Benchmark
    public long rangedSum() {
        return LongStream.rangeClosed(1, N)
                .reduce(0L, Long::sum);
    }

    // Score : 0.635
    @Benchmark
    public long parallelRangedSum() {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

//    @Benchmark
//    public long recursiveTaskSum() {
//        return ForkJoinSumCalculator.forkJoinSum(N);
//    }

    @TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }

}
