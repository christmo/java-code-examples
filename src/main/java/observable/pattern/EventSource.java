package observable.pattern;

import java.util.Observable;
import java.util.Scanner;

/**
 * Created by soporte on 3/22/17.
 */
public class EventSource extends Observable implements Runnable {
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}
