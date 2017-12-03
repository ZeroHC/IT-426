package student_registrations;

import java.util.Observable;
import java.util.Observer;

public class Registrar implements Observer
{
    @Override
    public void update(Observable observable, Object args)
    {
        System.out.println("A student registered for a class!");
    }
}