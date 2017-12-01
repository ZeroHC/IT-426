package implementing_observer;

import java.util.HashSet;
import java.util.Set;

public class MyObservable
{
    private Set<MyObserver> observers;

    public MyObservable()
    {
        observers = new HashSet<>();
    }

    public void notifyObservers(Object... arguments)
    {
        for (MyObserver observer : observers)
        {
            observer.update(this);
        }
    }

    public void addObserver(MyObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(MyObserver observer)
    {
        observers.remove(observer);
    }
}
