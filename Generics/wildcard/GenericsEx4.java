package wildcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Food {

    private String name;
    private int kcal;

    public Food(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", kcal: " + kcal + "]";
    }

}

class Chicken extends Food {

    public Chicken(String name, int kcal) {
        super(name, kcal);
    }
}

class Pizza extends Food {

    public Pizza(String name, int kcal) {
        super(name, kcal);
    }
}

public class GenericsEx4 {

    public static void main(String[] args) {
        List<Chicken> list = new ArrayList<>();
        list.add(new Chicken("A", 500));
        list.add(new Chicken("B", 700));
        list.add(new Chicken("C", 650));
        list.add(new Chicken("D", 150));

//        Collections.sort(list, new ChickenComparator());
        Collections.sort(list, new FoodComparator());
        System.out.println(list);

        List<Pizza> list2 = new ArrayList<>();
        list2.add(new Pizza("A", 1000));
        list2.add(new Pizza("B", 500));
        list2.add(new Pizza("C", 750));
        list2.add(new Pizza("D", 600));

//        Collections.sort(list2, new PizzaComparator());
        Collections.sort(list2, new FoodComparator());
        System.out.println(list2);

    }

}

class ChickenComparator implements Comparator<Chicken> {
    @Override
    public int compare(Chicken o1, Chicken o2) {
        return o2.getKcal() - o1.getKcal();
    }
}

class PizzaComparator implements Comparator<Pizza> {
    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getKcal() - o2.getKcal();
    }
}

// Collections.sort(List<T> list, Comparator<? super T> c) 이기에 T의 조상 클래스들이 올 수 있다.
// 그러므로 각 클래스의 Comparator 를 만들 필요가 없다.

class FoodComparator implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        return o1.getKcal() - o2.getKcal();
    }
}