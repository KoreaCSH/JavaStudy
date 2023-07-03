package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEx {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        System.out.println(list);

        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);

        Collections.rotate(list, 2);
        System.out.println(list);

        Collections.swap(list, 0, 2);
        System.out.println(list);

        // 저장된 요소의 위치를 임의로 변경
        Collections.shuffle(list);
        System.out.println(list);

        // reverse()와 동일
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        int index = Collections.binarySearch(list, 3);
        System.out.println("index of 3 = " + index);

        System.out.println("max = " + Collections.max(list));
        System.out.println("min = " + Collections.min(list));

        Collections.fill(list, 9);
        System.out.println(list);

        // list 와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        List newList = Collections.nCopies(list.size(), 2);
        System.out.println("newList = " + newList);

        System.out.println(Collections.disjoint(list, newList));

        Collections.copy(list, newList);
        System.out.println("list = " + list);

        Collections.replaceAll(list, 2, 10);
        System.out.println(list);
    }

}
