package wildcard;

import java.util.ArrayList;

class Fruit2 {
    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple2 extends Fruit2 {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Banana extends Fruit2 {
    @Override
    public String toString() {
        return "wildcard.Banana";
    }
}

class Juice {
    private String name;

    Juice(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit2> fruitBox) {
        StringBuilder sb = new StringBuilder();
        for(Fruit2 f : fruitBox.getList()) {
            sb.append(f).append(" ");
        }
        sb.append("wildcard.Juice");
        return new Juice(sb.toString());
    }
}

public class GenericsEx3 {

    public static void main(String[] args) {
        FruitBox<Fruit2> fruitBox1 = new FruitBox<>();
        fruitBox1.add(new Apple2());
        fruitBox1.add(new Banana());

        Juice juice1 = Juicer.makeJuice(fruitBox1);
        System.out.println(juice1);

        FruitBox<Apple2> fruitBox2 = new FruitBox<>();
        fruitBox2.add(new Apple2());
        fruitBox2.add(new Apple2());

        Juice juice2 = Juicer.makeJuice(fruitBox2);
        System.out.println(juice2);
    }

}

class FruitBox<T extends Fruit2> extends Box2<T> {

}

class Box2<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void add(T e) {
        list.add(e);
    }

    public T get(int i) {
        return list.get(i);
    }

    public ArrayList<T> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
