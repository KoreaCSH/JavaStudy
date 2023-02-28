package list.stackandqueue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {

    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(3);
        pq.offer(5);
        pq.offer(1);
        pq.offer(4);
        pq.offer(2);

        // pq가 내부적으로 가지고 있는 배열의 내용 출력
        System.out.println(pq);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

}
