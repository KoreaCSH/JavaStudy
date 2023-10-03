package ch5_streamEx;

import ch4_domain.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                                        .map(String::length)
                                        .collect(Collectors.toList());

        System.out.println(wordLengths);

        // 다른 map(Function) 메서드를 서로 연결할 수 있다.
        List<Integer> dishNameLengths = Dish.menu.stream()
                                            .map(Dish::getName)
                                            .map(String::length)
                                            .collect(Collectors.toList());

        System.out.println(dishNameLengths);

        // 스트림 평면화 - flatMap() 메서드 활용
        // words.stream().map(word -> word.split("")).map(Arrays::stream) .. 으로 하면
        // 두 번째 map 연산의 결과가 Stream<String> 이기 때문에 List<Stream<String>> 으로 만들어지면서 문제가 해결되지 않음.
        // flatMap 을 활용하면 배열의 각 요소를 스트림이 아니라 스트림의 콘텐츠로 매핑한다.
        List<String> words2 = Arrays.asList("Hello", "World");
        List<String> uniqueCharacters =
                words2.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        // 예제 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println(squares);

        // 예제 2
        List<Integer> numbers2 = Arrays.asList(1, 2, 3);
        List<Integer> numbers3 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers2.stream()
                                .flatMap(num -> numbers3.stream()
                                        .map(num2 -> new int[]{num, num2}))
                                .collect(Collectors.toList());

                pairs.stream().forEach(ints -> System.out.println(ints[0] + ", " + ints[1]));
        System.out.println();

        // 예제 3
        List<int[]> pairs2 = numbers2.stream()
                .flatMap(num -> numbers3.stream()
                        .filter(num2 -> (num + num2) % 3 == 0)
                        .map(num2 -> new int[]{num, num2}))
                .collect(Collectors.toList());

        pairs2.stream().forEach(ints -> System.out.println(ints[0] + ", " + ints[1]));
    }

}
