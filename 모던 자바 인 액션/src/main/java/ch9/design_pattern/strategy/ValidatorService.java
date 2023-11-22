package ch9.design_pattern.strategy;

public class ValidatorService {

    public static void main(String[] args) {

        // 전략 패턴
        // 한 유형의 알고리즘을 보유한 상태에서 런타임에 적절한 알고리즘을 선택하는 기법
        // 인터페이스 존재 이유이며, 변경 사항이 있을 시 많은 코드를 수정할 필요 없이 의존하는 객체만 변경하면 된다.

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean isLower1 = lowerCaseValidator.validate("bbbb");
        boolean isLower2 = lowerCaseValidator.validate("bbbB");
        System.out.println(isLower1);
        System.out.println(isLower2);


        Validator numericValidator = new Validator(new IsNumeric());
        boolean isNumeric = numericValidator.validate("1234");
        boolean isNumeric2 = numericValidator.validate("1234a");
        System.out.println(isNumeric);
        System.out.println(isNumeric2);

    }

}
