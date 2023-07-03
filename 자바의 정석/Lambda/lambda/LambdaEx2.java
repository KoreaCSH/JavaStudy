package lambda;

import java.util.*;
public class LambdaEx2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Consumer functional interface
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Predicate functional interface
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        // UnaryOperator functional interface
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}, "));

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1);
        map2.put(2, 2);
        map2.put(3, 3);
        map2.put(4, 4);
        System.out.println();

        map2.compute(1, (k, v) -> 100);
        System.out.println(map2.get(1));

    }

}
