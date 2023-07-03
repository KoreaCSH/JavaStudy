package lambda;

import java.util.function.*;
public class LambdaEx4 {

    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g);
        System.out.println(h.apply("10"));

        Function<Integer, Integer> h2 = f.compose(g);
        System.out.println(h2.apply(10));

        Function<String, String> f2 = x -> x; // 항등함수. f(x) = x
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        System.out.println(Predicate.isEqual(str1).test(str2));
    }

}
