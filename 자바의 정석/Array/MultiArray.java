public class MultiArray {

    public static void main(String[] args) {
        int[][] arr = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40}
        };

        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                sum1 += arr[i][j];
            }
        }

        System.out.println(sum1);

        for(int[] tmp : arr) {
            for(int i : tmp) {
                sum2 += i;
            }
        }

        System.out.println(sum2);
    }

}
