package map.treemap;

import java.util.*;

public class TreeMapEx {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        String[] strArr = {"A", "B", "A", "K", "L", "A", "O", "K", "L", "A", "L", "A", "O", "O", "L"};

        for(int i = 0; i < strArr.length; i++) {
            if(map.containsKey(strArr[i])) {
                int num = map.get(strArr[i]);
                map.put(strArr[i], num + 1);
            }
            else {
                map.put(strArr[i], 1);
            }
        }

        Iterator it1 = map.entrySet().iterator();
        while(it1.hasNext()) {
            Map.Entry e = (Map.Entry) it1.next();
            System.out.println(e.getKey() + " : " + print((int)e.getValue()) + " " + e.getValue());
        }
        System.out.println();

        Set set = map.entrySet();
        List list = new ArrayList<>(set);
        Collections.sort(list, (Object o1, Object o2) -> {
            if(o1 instanceof Map.Entry && o1 instanceof Map.Entry) {
                Map.Entry e1 = (Map.Entry) o1;
                Map.Entry e2 = (Map.Entry) o2;

                int value1 = (Integer) e1.getValue();
                int value2 = (Integer) e2.getValue();

                return value2 - value1;
            }
            return -1;
        });

        Iterator it2 = list.iterator();
        while(it2.hasNext()) {
            Map.Entry e = (Map.Entry) it2.next();
            System.out.println(e.getKey() + " : " + print((int)e.getValue()) + " " + e.getValue());
        }

    }

    public static String print(int num) {
        char[] chArr = new char[num];
        Arrays.fill(chArr, '#');
        return new String(chArr);
    }

}
