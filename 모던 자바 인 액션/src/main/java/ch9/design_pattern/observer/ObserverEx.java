package ch9.design_pattern.observer;

public class ObserverEx {

    public static void main(String[] args) {

        // 옵저버 디자인 패턴
        // 어떤 이벤트가 발생했을 때 한 객체(Subject 라 불리는)가 다른 객체 리스트(Observer)에
        // 자동으로 알림을 보내야 하는 상황에서 사용되는 디자인 패턴이다.

        // Subject 객체는 내부에 Observer 리스트를 갖고 있는다.

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        // notifyObservers 메서드 내부에서 모든 Observer 객체에 정보를 전달한다.
        f.notifyObservers("The queen siad her favorite book is Modern Java in Action.");

    }

}
