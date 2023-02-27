package list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest2 {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>(1000000);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        add(al);
        add(ll);

        System.out.println("-- 접근시간테스트 --");
        System.out.println("ArrayList: " + access(al));
        System.out.println("LinkedList: " + access(ll));
        // ArrayList는 내부에 Object 배열이 선언되어 있고, Object 배열의 각 요소는
        // 메모리상에 연속적으로 존재하므로 간단한 계산으로 요소의 주소를 얻어 저장된 데이터를 읽을 수 있다.

        // 반면 LinkedList는 불연속적으로 위치한 각 요소들이 서로 연결된 것이라
        // 처음부터 n번째 데이터까지 차례대로 따라가야만 원하는 값을 얻을 수 있다.
    }

    public static void add(List list) {
        for(int i = 0; i < 50000; i++) {
            list.add(i);
        }
    }

    public static long access(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 30000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}
