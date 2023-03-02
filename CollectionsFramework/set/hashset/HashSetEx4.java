package set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetEx4 {

    public static void main(String[] args) {

        Set set = new HashSet();
        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new Person2("John", 20));
        set.add(new Person2("John", 20));

        System.out.println(set);

    }

}

// HashSet의 add 메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해
// 추가하려는 요소의 equals()와 hashCode()를 호출하기 때문에
// 두 메서드를 목적에 맞게 오버라이딩 해야 한다.

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person2) {
            Person2 tmp = (Person2) obj;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return (name + age).hashCode();
//    }

    // 위 코드를 써도 되지만, 아래 코드를 쓰는 것이 좋다.
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}