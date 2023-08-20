package ch3_functionalInterface;

import java.util.*;
import java.util.function.Function;

public class FunctionEx {

    // 자바가 제공하는 함수형 인터페이스 Function
    // Function 은 인자 T 객체를 받고 R 객체를 return 한다.
    public static void main(String[] args) {

        List<Integer> lengthOfString = map(
                Arrays.asList("modern", "java", "in", "action"),
                (String s) -> s.length()
        );

        System.out.println(lengthOfString);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

}
