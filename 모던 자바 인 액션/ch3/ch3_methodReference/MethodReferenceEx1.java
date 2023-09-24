package ch3_methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface StringToIntProcessor {

    Integer process(String str);

}

public class MethodReferenceEx1 {

    public static void main(String[] args) {

        String str1 = "123";

        Integer num1 = stringToInt(str1, Integer::parseInt);

        System.out.println(num1);
        System.out.println(num1 == 123);

        String str2 = "12345";

        Integer num2 = stringToInt(str2, Integer::parseInt);

        System.out.println(num2);
        System.out.println(num2 == 12345);
    }

    // return 형식을 List<Integer> 로 변경해 보자.
    public static Integer stringToInt(String str, StringToIntProcessor p) {
        return p.process(str);
    }

}
