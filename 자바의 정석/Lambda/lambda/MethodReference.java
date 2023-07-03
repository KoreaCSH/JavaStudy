package lambda;

import java.util.*;
import java.util.function.*;

public class MethodReference {

    public static void main(String[] args) {
        //Function<String, Integer> f = s -> Integer.parseInt(s);
        Function<String, Integer> f = Integer::parseInt;

        System.out.println(f.apply("11"));

        // c = i -> System.out.println(i);
        Consumer<Integer> c = System.out::println;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        for(int i : list) {
            c.accept(i);
        }

    }

}
