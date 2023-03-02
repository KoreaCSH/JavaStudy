package set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "2", "3", "3", "4", "4", "5", "32", "1043"};
        Set set = new HashSet();

        for(int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }

        System.out.println(set);
    }

}
