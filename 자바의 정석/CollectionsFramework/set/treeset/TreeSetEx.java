package set.treeset;

import java.util.Set;
import java.util.TreeSet;

// TreeSet 은 내부적으로 레드 - 블랙트리로 구현되어 있다.
// 중복 데이터 허용 X, 저장 순서 유지 X, 하지만 내부적으로 '정렬' 한다.

public class TreeSetEx {

    public static void main(String[] args) {

        TreeSet set = new TreeSet();

        for(int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }

        // HashSet과 달리 저장할 때 이미 정렬하기 때문에
        // 읽어올 때 List로 변환한 후 Collections.sort() 를 할 필요가 없다.
        System.out.println(set);
        System.out.println(set.subSet(10, 40));

    }

}
