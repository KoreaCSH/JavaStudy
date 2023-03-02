package set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx5 {

    public static void main(String[] args) {
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        Set setHab = new HashSet();
        Set setGyo = new HashSet();
        Set setCha = new HashSet();

        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");

        set2.add("4");
        set2.add("5");
        set2.add("6");
        set2.add("7");
        set2.add("8");

        Iterator it1 = set1.iterator();
        Iterator it2 = set2.iterator();
        while (it1.hasNext()) {
            setHab.add(it1.next());
        }
        while (it2.hasNext()) {
            setHab.add(it2.next());
        }
        System.out.println("합칩합: " + setHab);

        it2 = set2.iterator();
        while(it2.hasNext()) {
            Object tmp = it2.next();
            if(set1.contains(tmp)) {
                setGyo.add(tmp);
            }
        }
        System.out.println("교집합: " + setGyo);

        it1 = set1.iterator();
        while(it1.hasNext()) {
            Object tmp = it1.next();
            if(!set2.contains(tmp)) {
                setCha.add(tmp);
            }
        }
        System.out.println("차집합:" + setCha);

    }

}
