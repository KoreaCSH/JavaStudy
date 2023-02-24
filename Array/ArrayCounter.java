import java.util.Arrays;

public class ArrayCounter {

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] counter = new int[10];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10);
            System.out.print(arr[i]);
        }
        System.out.println();

        for(int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(i + "의 개수: " + counter[i]);
        }

    }

}
