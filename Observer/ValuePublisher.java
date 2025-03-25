
import java.util.ArrayList;
import java.util.List;

public class ValuePublisher {
    private final List<NumericBaseObserver> observers = new ArrayList<>();

    public void updateState(int state) {
        for (NumericBaseObserver observer : observers) {
            observer.updateState(state);
        }
    }

    public void subscribe(NumericBaseObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(NumericBaseObserver observer) {
        observers.remove(observer);
    }
}