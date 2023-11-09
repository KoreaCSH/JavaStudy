package ch1.domain;

import ch1.domain.Color;

import java.util.ArrayList;
import java.util.List;

public class Apple {

    private int weight;
    private Color color;

    public Apple() {

    }

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + " " + this.weight;
    }

    public static List<Apple> getApples() {

        List<Apple> apples = new ArrayList<>();

        Apple apple1 = new Apple(100, Color.RED);
        Apple apple2 = new Apple(200, Color.GREEN);
        Apple apple3 = new Apple(150, Color.GREEN);
        Apple apple4 = new Apple(151, Color.RED);
        Apple apple5 = new Apple(120, Color.RED);
        Apple apple6 = new Apple(170, Color.GREEN);

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        apples.add(apple6);

        return apples;
    }

}
