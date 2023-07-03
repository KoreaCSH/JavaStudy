package lambda;

import java.util.function.*;
import java.util.*;

public class LambdaEx3 {

    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10; // i의 일의 자리 없애는 로직

        List<Integer> list = new ArrayList<>();
        makeRandomList(list, s);
        System.out.println(list);

        printEvenNum(list, p, c);
        System.out.println();

        List<Integer> newList = doSomething(list, f);
        System.out.println(newList);

    }

    public static <T> void makeRandomList(List<T> list, Supplier<T> s) {
        for(int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }

    public static <T> void printEvenNum(List<T> list, Predicate<T> p, Consumer<T> c) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.print("]");
    }

    public static <T> List<T> doSomething(List<T> list, Function<T, T> f) {
        List<T> newList = new ArrayList<>();
        for(T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }

}
