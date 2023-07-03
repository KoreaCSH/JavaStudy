package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysEx {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {
                {11, 12 ,13},
                {21, 22, 23}
        };

        System.out.println(Arrays.toString(arr));
        //toString은 1차원 배열에만 사용할 수 있으므로 다차원 배열에는 deepToString()을 사용해야 한다.
        //deepToString()은 배열의 모든 요소를 재귀적으로 접근해서 문자열을 구성하므로 3차원 이상의 배열에도 동작한다.
        System.out.println(Arrays.deepToString(arr2D));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        // 범위 넘어가면 0으로 채운다.
        int[] arr4 = Arrays.copyOf(arr, 7);
        int[] arr5 = Arrays.copyOfRange(arr, 3, 5);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("arr6: " + Arrays.toString(arr6));

        // 컬렉션 프레임워크에는 참조형 데이터 타입이 들어가므로, int[] 배열이 아닌 Integer[] 배열을 넣어야 한다.
        // 또한, 단순히 Arrays.asList()로 list를 초기화하면 정적 배열이 되어 size를 변경할 수 없다.
        // 동적 배열을 만들기 위해서는 아래와 같이 선언 및 초기화를 해 준다.
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println("list: " + list);

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 10);
        System.out.println("arr7: " + Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)(Math.random() * 6) + 1);
        System.out.println("arr7: " + Arrays.toString(arr7));

        for(int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph) + i);
        }

    }
}
