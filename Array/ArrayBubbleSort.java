import java.util.Arrays;

public class ArrayBubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] = (int)(Math.random() * 10) + 1);
        }
        System.out.println();

        for(int i = 0; i < arr.length-1; i++) {
            boolean changed = false;

            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    changed = true;
                }
            }

            // 불필요한 반복을 줄일 수 있다.
            if(!changed) break;
            System.out.println(Arrays.toString(arr));

        }

    }

}
