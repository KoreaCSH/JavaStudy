package comparatorAndcomparable;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "bear", "tiger"};
        Arrays.sort(strArr);
        System.out.println("strArr = " + Arrays.toString(strArr));

        // String은 대소문자를 구분하지 않고 비교하는 Comparator를 상수의 형태로 제공
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("strArr = " + Arrays.toString(strArr));

        Integer[] arr = {1, 2, 3, 4, 5};
        Arrays.sort(arr, new Descending());
        System.out.println("arr = " + Arrays.toString(arr));

    }

}

class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}
