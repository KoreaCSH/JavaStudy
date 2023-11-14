package ch7.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    // 이 값 이하의 서브태스크는 더 이상 분할할 수 없다. (기준값)
    private static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    // 메인 태스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 해당 태스크에서 더할 배열의 길이
        int length = end - start;

        // 기준값보다 같거나 작으믈 순차적으로 결과 계산
        if(length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        // 다른 스레드로 새로 생성한 서브태스크 비동기로 실행
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        // 두 번째 서브태스크를 동기 실행
        Long rightResult = rightTask.compute();
        // 첫 번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다린다.
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for(int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

}
