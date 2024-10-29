import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayEx {

    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = {100, 90, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for(int i = 0; i < iArr1.length; i++) {
            iArr1[i] = i + 1;
        }

        for(int i = 0; i < iArr2.length; i++) {
            iArr2[i] = (int) (Math.random() * 10) + 1;
        }

        for(int i = 0; i < iArr1.length; i++) {
            System.out.print(iArr1[i] + ",");
        }

        System.out.println(Arrays.toString(iArr2));
        System.out.println(Arrays.toString(iArr3));
        System.out.println(Arrays.toString(chArr));
        System.out.println(iArr3);
        System.out.println(chArr);

        String str = "adces";
        String collect = Arrays.stream(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        System.out.println(collect);

        int sum = IntStream.rangeClosed(13, 17)
                .map(i -> {
                    if(isEvenDivisorCount(i)) {
                        return i;
                    }
                    else {
                        return -i;
                    }
                })
                .sum();

        System.out.println(sum);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(1);
        pq.stream().forEach(System.out::println);

        String num = "1234566";
        String num2 = "57";

        System.out.println(0 / 8);

        String strEx = "E=M*C^2";
        System.out.println(strEx.replaceAll("[^a-zA-Z]", ""));

        System.out.println(5 * 100 / 100);

        int[] intArr = new int[]{1, 2, 3, 4};
        Integer[] integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        Arrays.stream(integerArr).forEach(System.out::println);

        Integer[] integerArr2 = new Integer[]{1, 2, 3, 4};
        int[] ints = Arrays.stream(integerArr2).mapToInt(Integer::intValue).toArray();

        int[][] intDoubleArr = new int[][]{
                {2, 3, 4},
                {3, 5, 4},
                {5, 4, 2}
        };

        List<Integer[]> listEx = new ArrayList<>();
        for(int i = 0; i < intDoubleArr.length; i++) {
            listEx.add(Arrays.stream(intDoubleArr[i]).boxed().toArray(Integer[]::new));
        }

        Collections.sort(listEx, (intArr1, intArr2) -> intArr2[0] - intArr1[0]);

        listEx.stream().forEach(intArr1 -> {
            Arrays.stream(intArr1).forEach(i -> System.out.print(i + " "));
        });
    }

    public static boolean isEvenDivisorCount(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count % 2 == 0;
    }

}
