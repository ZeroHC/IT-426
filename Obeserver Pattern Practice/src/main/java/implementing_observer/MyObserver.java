package implementing_observer;

public interface MyObserver
{
    public void update(MyObservable observable, Object... arguments);
}
