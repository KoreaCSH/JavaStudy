package arrays;

import java.util.Arrays;

public class ArraysStringEx {

    public static void main(String[] args) {
        String[][] str2D = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D2 = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("chArr = " + Arrays.toString(chArr));
        // binarySearch는 반드시 sort 후에 사용해야 한다.
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
        System.out.println("After sorting");
        Arrays.sort(chArr);
        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
    }

}
