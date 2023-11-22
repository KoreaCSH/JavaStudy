package ch9.design_pattern.observer;

public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")) {
            System.out.println("Yet more news from London... " + tweet);
        }
    }
}
