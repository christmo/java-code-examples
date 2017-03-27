package observable.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by soporte on 3/22/17.
 */
public class MainObs {

    public static void main(String[] args) {
        System.out.println("Enter a Text");

        EventSource event = new EventSource();
        event.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("Response1: "+arg);
            }
        });

        event.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("Response2: "+arg);
            }
        });

        new Thread(event).start();
    }

}
