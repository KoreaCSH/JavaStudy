package ch8.list_set_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMethod {

    public static void main(String[] args) {

        Map<String, Integer> ageOfFriends = new HashMap<>();
        ageOfFriends.put("Olivia", 20);
        ageOfFriends.put("Frank", 30);
        ageOfFriends.put("John", 12);
        ageOfFriends.put("James", 35);

        // 기존의 map 반복 작업
        for(Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + "is " + age + " years old");
        }

        // Java8부터 BiConsumer(key, value 를 인수를 가짐) 를 인수로 받는 forEach 메서드 활용 가능
        ageOfFriends.forEach((name, age) -> System.out.println(name + "is " + age + " years old"));


        // 정렬 메서드
        System.out.println("value 로 정렬");
        ageOfFriends
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);


        System.out.println("key 로 정렬");
        ageOfFriends
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);


        // null 을 방지하는 getOrDefault() 메서드
        System.out.println(ageOfFriends.getOrDefault("Dean", 30));


        // 계산 패턴 - key 를 이용해 어떤 계산을 하고 Map 에 추가해야 할 때 - ex) 파일 집합의 각 행을 파싱하여 SHA-256 계산할 때
        // computeIfAbsent 제공된 키에 해당하는 값이 없으면, key 를 이용해 값을 계산하고 맵에 추가한다.
        Map<String, List<String>> friendsToMovies = new HashMap<>();
        String friend = "Raphael";
        /*
        List<String> movies = friendsToMovies.get(friend);
        if(movies == null) {
            movies = new ArrayList<>();
        friendsToMovies.put(friend, movies);
    }
        movies.add("Star Wars");
        */

        friendsToMovies.computeIfAbsent(friend, name -> new ArrayList<>()).add("Star Wars");
        friendsToMovies.computeIfAbsent("John", name -> new ArrayList<>()).add("Inception");

        System.out.println(friendsToMovies);


        // 삭제 패턴
        // 맵에서 특정 key 에 해당하는 항목을 제거하기 위해서는 remove(key, value) 메서드를 활용할 수 있다.
        ageOfFriends.remove("Olivia", 20);
        System.out.println(ageOfFriends);


        // 교체 패턴
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "James bond");
        favouriteMovies.put("James", "Inception");

        favouriteMovies.replaceAll((name, movie) -> movie.toUpperCase());

        System.out.println(favouriteMovies);


        // 서로 다른 두 Map 합치기 - 중복되는 값을 처리하기 위해서는 merge 메서드를 활용한다.
        Map<String, String> family = Map.ofEntries(
                Map.entry("Teo", "Star Wars"),
                Map.entry("Cristina", "James Bond")
        );
        Map<String, String> friends = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"),
                Map.entry("Cristina", "James Bond")
        );

        Map<String, String> everyone = new HashMap<>(family);
        // 중복된 key 없으면 그냥 value 로, 중복된 key 라면 BiFunction 으로 대체
        friends.forEach((k, v) -> everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone);


        // 퀴즈 8-2
        Map<String, Integer> movies = new HashMap<>();
        movies.put("James Bond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        // ConcurrentModificationException 을 방지하며 요소를 삭제할 수 있는 List, Set 의 메서드로 removeIf 가 있다.
        // Map 을 entrySet() 으로 Set 으로 변경한 후 removeIf 를 활용할 수 있다.
        movies.entrySet().removeIf(entry -> entry.getValue() < 10);

        System.out.println(movies);
    }

}
