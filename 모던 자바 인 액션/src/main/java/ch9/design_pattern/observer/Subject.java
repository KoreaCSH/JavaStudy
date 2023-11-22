package ch9.design_pattern.observer;

public interface Subject {

    void registerObserver(Observer o);

    void notifyObservers(String tweet);

}
