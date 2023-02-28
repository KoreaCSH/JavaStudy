package list.stackandqueue;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String exp = "";
        System.out.println("java ExpValidCheck");
        System.out.println("수식을 입력하세요: ");

        exp = sc.nextLine();

        Stack stack = new Stack();

        try{
            for(int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);

                if(ch == '(') {
                    stack.push(ch+"");
                } else if(ch == ')') {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                System.out.println("괄호가 일치합니다.");
            } else {
                System.out.println("괄호가 일치하지 않습니다.");
            }

        } catch (EmptyStackException e) {
            System.out.println("괄호가 일치하지 않습니다.");
        }
    }
}
