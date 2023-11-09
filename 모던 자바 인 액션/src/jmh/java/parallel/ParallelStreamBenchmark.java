package parallel;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ParallelStreamBenchmark {

    // 자바7 이후 버전부터 _는 숫자 리터럴의 어디에도 등장할 수 있으며, 이를 통해 숫자를 끊어 읽을 수 있게 되어 가독성이 향상된다.
    private static final long N = 10_000_000L;

    // Score : 3.195
    @Benchmark
    public Long iterativeSum() {
        long result = 0;
        for(long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    // Score : 73.409
    @Benchmark
    public Long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }

    // Score : 195.046
    @Benchmark
    public Long parallelSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }

}
