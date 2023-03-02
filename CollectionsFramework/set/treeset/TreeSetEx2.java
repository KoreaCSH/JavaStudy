package set.treeset;

import java.util.TreeSet;

public class TreeSetEx2 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZZ");
        set.add("dzzzz");
        set.add("elephant");
        set.add("elevator");

        // subSet의 to는 범위에 포함되지 않는다.
        System.out.println(set);
        System.out.println(set.subSet(from, to));
        System.out.println(set.subSet(from, to + "zzz"));
    }

}
