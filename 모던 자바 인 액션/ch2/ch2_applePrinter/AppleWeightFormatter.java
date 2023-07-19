package ch2_applePrinter;

import ch2_domain.Apple;

public class AppleWeightFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}
