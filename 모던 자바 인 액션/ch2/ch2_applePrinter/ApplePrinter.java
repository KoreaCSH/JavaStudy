package ch2_applePrinter;

import ch2_domain.Apple;

import java.util.List;

public class ApplePrinter {

    public static void main(String[] args) {
        List<Apple> apples = Apple.getApples();

        prettyPrintApple(apples, new AppleWeightFormatter());

        System.out.println();

        prettyPrintApple(apples, new AppleFancyFormatter());

        System.out.println();
        
        prettyPrintApple(apples, apple -> "color : " + apple.getColor());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple : inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
    }

}
