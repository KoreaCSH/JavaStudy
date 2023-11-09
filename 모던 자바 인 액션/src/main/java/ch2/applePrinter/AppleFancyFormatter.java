package ch2.applePrinter;

import ch2.domain.Apple;

public class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return (apple.getWeight() > 150) ? "heavy" : "light";
    }
}
