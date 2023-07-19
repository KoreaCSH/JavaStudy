package ch2_applePrinter;

import ch2_domain.Apple;

public class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String format(Apple apple) {
        return (apple.getWeight() > 150) ? "heavy" : "light";
    }
}
