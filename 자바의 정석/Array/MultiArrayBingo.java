import java.util.Scanner;

public class MultiArrayBingo {

    public static void main(String[] args) {

        final int SIZE = 5;
        int x = 0, y = 0, num = 0;

        int[][] bingo = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                bingo[i][j] = SIZE * i + j + 1;
            }
        }

        //shuffle
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                x = (int)(Math.random() * SIZE);
                y = (int)(Math.random() * SIZE);

                int tmp = bingo[i][j];
                bingo[i][j] = bingo[x][y];
                bingo[x][y] = tmp;
            }
        }

        do{
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    System.out.printf("%3d", bingo[i][j]);
                }
                System.out.println();
            }

            System.out.printf("1에서 %d의 숫자를 입력하세요. (종료:0)", SIZE*SIZE);
            String tmp = scanner.nextLine();
            num = Integer.parseInt(tmp);

            outer:
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(num == bingo[i][j]) {
                        bingo[i][j] = 0;
                        break outer;
                    }
                }
            }

        } while(num != 0);

    }

}
