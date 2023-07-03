package set.hashset;

import java.util.*;

public class HashSetEx3 {

    public static void main(String[] args) {
        Set set = new HashSet();

        List list = new ArrayList();
        Collections.addAll(list, 2, 2, 2, 2, 2, 3);

        set.addAll(list);
        System.out.println(set.containsAll(list));

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
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
