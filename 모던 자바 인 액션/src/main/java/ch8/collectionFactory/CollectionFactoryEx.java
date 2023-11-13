package ch8.collectionFactory;

import java.util.*;

public class CollectionFactoryEx {

    public static void main(String[] args) {
        /*
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");
        */

        // asList() 팩토리 메서드를 통해 코드를 간단하게 만들 수 있다.
        // 단, 고정 크기의 리스트를 만들어내기에 요소를 갱신할 순 있지만, 새 요소를 추가하거나 기존 요소를 삭제할 순 없다.
        // List<String> friends = Arrays.asList("Raphael", "Olivia", "Thibaut");

        // List.of() 팩토리 메서드를 사용할 수도 있다.
        // 단, 매개변수가 10개가 넘어간다면 추가 배열을 할당해서 리스트로 감싸기 때문에 나중에 가비지 컬렉션을 하는 비용을 지불해야 한다.
        // 그러므로, 요소를 추가하지 않고, 값을 변경하지 않는 리스트를 생성할 때에는 팩토리 메서드를 활용하자.
        List<String> strings = List.of("A", "B", "C");
        System.out.println(strings);

        // UnsupportedOperationException 발생
        // strings.set(0, "D");
        // strings.add("D");

        // Set.of() 와 Map.of() 로도 Set, Map 을 생성할 수 있다.
        Set<String> stringsSet = Set.of("A", "B", "C");
        System.out.println(stringsSet);

        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        System.out.println(ageOfFriends);

        // UnsupportedOperationException 발생
        // ageOfFriends.put("Raphael", 30);

        // 10 개 이상의 키와 값 쌍을 가진 맵을 만들 때에는 Map.ofEntries 팩토리 메서드를 이용하는 것이 좋다.
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(Map.entry("Raphael", 30),
                Map.entry("Olivia", 25),
                Map.entry("Thibaut", 26));

        System.out.println(ageOfFriends2);
    }

}
