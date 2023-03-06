package map.hashmap;

import com.sun.jdi.InterfaceType;

import java.util.*;

public class HashMapEx4 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strArr = {"A", "B", "A", "K", "L", "A", "O", "K", "L", "A", "L"};

        for(int i = 0; i < strArr.length; i++) {
            if(map.containsKey(strArr[i])) {
                int tmp = map.get(strArr[i]);
                map.put(strArr[i], tmp + 1);
            }
            else {
                map.put(strArr[i], 1);
            }
        }
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + ": " + printBar((int)e.getValue(), '#') + " " + e.getValue());
        }

    }

    public static String printBar(int num, char ch) {
        char[] chArr = new char[num];
        Arrays.fill(chArr, ch);
        return new String(chArr);
    }

}
