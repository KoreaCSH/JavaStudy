package ch9.design_pattern.factory;

public class FactoryMain {

    public static void main(String[] args) {

        Product loan = ProductFactory.createProduct("loan");
        System.out.println(loan);

        Product bond = ProductFactoryV2.createProduct("bond");
        System.out.println(bond);

    }

}
