package ch2.applePrinter;

import ch2.domain.Apple;

public class AppleWeightFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}
