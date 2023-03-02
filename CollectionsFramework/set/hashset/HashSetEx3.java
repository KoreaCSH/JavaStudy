package set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx3 {

    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("123");
        set.add("123");
        set.add(new Person("John", 24));
        set.add(new Person("John", 24));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
