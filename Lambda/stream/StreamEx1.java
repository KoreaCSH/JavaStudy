package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx1 {

    public static void main(String[] args) {
        String[] strArr = {"aaa", "ddd", "ccc"};
        List<String> strList = Arrays.asList(strArr);

//        Arrays.sort(strArr);
//        Collections.sort(strList);
//
//        System.out.println(Arrays.toString(strArr));
//        System.out.println(strList);

        Stream<String> strStream1 = Arrays.stream(strArr);
        Stream<String> strStream2 = strList.stream();

        strStream1.sorted().forEach(System.out::println);
//        strStream2.sorted().forEach(System.out::println);

        // Stream 은 데이터 소스를 변경하지 않으며, Iterator 처럼 일회용이다.
        List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
        System.out.println(sortedList);

    }

}
