package comparatorAndcomparable;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueComparator {

    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>(
                ((Object o1, Object o2) -> {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;

                    return i1.compareTo(i2) * -1;
                })
        );

        pq.offer(1);
        pq.offer(6);
        pq.offer(7);
        pq.offer(3);
        pq.offer(4);
        pq.offer(5);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println();

        Queue<Integer> pq2 = new PriorityQueue<>(
                ((Object o1, Object o2) -> {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return i2 - i1;
                })
        );

        pq2.offer(5);
        pq2.offer(1);
        pq2.offer(2);
        pq2.offer(7);
        pq2.offer(8);

        while(!pq2.isEmpty()) {
            System.out.println(pq2.poll());
        }

    }

}
