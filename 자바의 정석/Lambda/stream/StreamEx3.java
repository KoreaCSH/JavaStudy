package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student implements Comparable<Student> {

    private String name;
    private int ban;
    private int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
public class StreamEx3 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("김", 1, 100));
        list.add(new Student("이", 1, 200));
        list.add(new Student("박", 2, 250));
        list.add(new Student("최", 1, 400));
        list.add(new Student("성", 2, 90));
        list.add(new Student("오", 1, 120));
        list.add(new Student("광", 2, 130));

        // thenComparing 은 comparing 메서드 뒤에 추가한다.
        list.stream().sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        IntStream studentScoreStream = list.stream().mapToInt(Student::getTotalScore);
        int allTotalScore = studentScoreStream.sum();
        System.out.println(allTotalScore);
    }

}
