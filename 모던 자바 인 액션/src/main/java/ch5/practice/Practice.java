package ch5.practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Practice {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011 년 트랜잭션을 오름차순으로 정리
        List<Transaction> transactions2011V1 = transactions.stream()
                                                .filter(transaction -> transaction.getYear() == 2011)
                                                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                                                .collect(Collectors.toList());

        System.out.println(transactions2011V1);
        // 1번 수정 - sorted() 내부에 Comparator.comparing() 을 활용하자. comparing 의 매개변수는 Function 이다.
        List<Transaction> transactions2011V2 = transactions.stream()
                                                .filter(transaction -> transaction.getYear() == 2011)
                                                .sorted(comparing(Transaction::getValue))
                                                .collect(Collectors.toList());

        System.out.println(transactions2011V2);


        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열
        List<String> cities = transactions.stream()
                                .map(transaction -> transaction.getTrader().getCity())
                                .distinct()
                                .collect(Collectors.toList());

        System.out.println(cities);


        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
        List<String> tradersCambridge = transactions.stream()
                                            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                            .map(transaction -> transaction.getTrader().getName())
                                            .distinct()
                                            .sorted(String::compareTo)
                                            .collect(Collectors.toList());

        System.out.println(tradersCambridge);
        // 3번 수정 - map 이후 filter, 그리고 comparing 활용
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());


        // 4. 모든 거래자 이름을 알파벳순으로 정렬
        List<String> traders = transactions.stream()
                                    .map(transaction -> transaction.getTrader().getName())
                                    .distinct()
                                    .sorted(String::compareTo)
                                    .collect(Collectors.toList());

        System.out.println(traders);

        // 4번 수정 - List<String> 이 아닌, 하나의 String 변수에 모든 거래자 이름을 정렬할 것.
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted() // 기본 자료형은 기본적인 sorted() 메서드가 존재하는가?
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(traderStr);


        // 5. 밀라노에 거래자가 있는가?
        boolean hasMilanTrader = transactions.stream()
                                    .map(transaction -> transaction.getTrader().getCity())
                                    .anyMatch(city -> city.equals("Milan"));

        System.out.println(hasMilanTrader);


        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력
        int cambridgeTraderValueTotal = transactions.stream()
                                            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                            .map(Transaction::getValue)
                                            .reduce(0, Integer::sum);

        System.out.println(cambridgeTraderValueTotal);
        // 6번 수정 - 트랜잭션값 sum 이 아닌 print
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        // 7. 전체 트랜잭션 중 최댓값은?
        Optional<Integer> valueMax = transactions.stream()
                                        .map(Transaction::getValue)
                                        .reduce(Integer::max);

        System.out.println(valueMax.get());


        // 8 .전체 트랜잭션 중 최솟값은?
        Optional<Integer> valueMin = transactions.stream()
                                        .map(Transaction::getValue)
                                        .reduce(Integer::min);

        System.out.println(valueMin.get());

        // 7, 8번 다른 정답
        // stream 은 최댓값이나 최솟값을 계산하는 데 사용할 키를 지정하는 Comparator 를 인수로 받는 min, max 메서드를 제공한다.
        Optional<Transaction> valueMinByStreamMin = transactions.stream()
                                                        .min(comparing(Transaction::getValue));
    }

}
