package map.hashmap;

import com.sun.source.tree.LiteralTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {

    static Map<String, HashMap<String, String>> map = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "James", "010-1234-5678");
        addPhoneNo("친구", "PKH", "010-1234-5679");
        addPhoneNo("친구", "abc", "010-3456-5678");
        addPhoneNo("친구", "abcd", "010-7890-5678");
        addPhoneNo("학교", "korea", "010-9876-5678");
        addPhoneNo("학교", "yonsei", "010-1904-5678");
        addPhoneNo("amiga", "010-0000-5678");
        printList();
    }

    static void addPhoneNo(String groupName, String name, String No) {
        addGroup(groupName);
        HashMap group = map.get(groupName);
        group.put(No, name);
    }

    static void addPhoneNo(String name, String No) {
        addPhoneNo("기타", name, No);
    }

    static void addGroup(String groupName) {
        if(!map.containsKey(groupName))
            map.put(groupName, new HashMap<>());
    }

    static void printList() {
        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            Set subSet = ((HashMap) e.getValue()).entrySet();
            Iterator subIt = subSet.iterator();

            System.out.println("* " + e.getKey() + "[" + subSet.size() + "]");

            while(subIt.hasNext()) {
                Map.Entry subE = (Map.Entry) subIt.next();
                System.out.println(subE.getValue() + " " + subE.getKey());
            }
        }
    }

}
