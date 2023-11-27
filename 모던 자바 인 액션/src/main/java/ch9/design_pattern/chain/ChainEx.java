package ch9.design_pattern.chain;

public class ChainEx {

    public static void main(String[] args) {

        // 의무 체인 패턴
        // 한 객체가 어떤 작업을 처리한 다음에 다른 객체로 결과를 전달하고,
        // 다른 객체도 해야 할 작업을 처리한 다음에 또 다른 객체로 전달하는 패턴

        // 일반적으로 다음으로 처리할 객체 정보를 유지하는 '필드'를 포함하는 작업 처리 추상 클래스로 의무 체인 패턴을 구성한다.

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really good?!");

        System.out.println(result);
    }

}
