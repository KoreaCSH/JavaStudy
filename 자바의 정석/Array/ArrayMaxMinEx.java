import java.util.Arrays;

public class ArrayMaxMinEx {

    public static void main(String[] args) {

        int[] iArr = new int[10];
        for(int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) (Math.random() * 100) + 1;
        }

        System.out.println(Arrays.toString(iArr));

        int max = iArr[0];
        int min = iArr[0];

        for(int i = 0; i < iArr.length; i++) {
            if(max < iArr[i]) {
                max = iArr[i];
            }
            else if(min > iArr[i]) {
                min = iArr[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

}
