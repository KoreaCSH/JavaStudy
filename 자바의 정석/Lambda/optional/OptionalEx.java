package optional;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {
        // Optional.of(null) 은 NullPointerException 을, ofNullable(null) 은 null 을 반환한다.
        Optional<String> optStr = Optional.ofNullable("abcde");

        // Optional 객체도 Stream 처럼 filter(), map(), flatMap() 사용 가능하다.
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr: " + optStr.get());
        System.out.println("optInt: " + optInt.get());

        int result = Optional.of("123").filter(s -> s.length() > 0).map(Integer::parseInt).get();
        System.out.println("result: " + result);

        int result2 = Optional.of("").filter(s -> s.length() > 0).map(Integer::parseInt).orElse(-1);
        System.out.println("result2: " + result2);

        Optional.of("456").map(Integer::parseInt).ifPresent(x -> System.out.println("result3: " + x));

        Optional<String> opt = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.empty();
        System.out.println("opt: " + opt);
        System.out.println("opt2: " + opt2);
        System.out.println("opt.equals(opt2)?: " + opt.equals(opt2));

    }

}
