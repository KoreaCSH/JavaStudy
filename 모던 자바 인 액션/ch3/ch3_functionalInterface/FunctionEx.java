package ch3_functionalInterface;

import java.util.*;
import java.util.function.Function;

public class FunctionEx {

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
