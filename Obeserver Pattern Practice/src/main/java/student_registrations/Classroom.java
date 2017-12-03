package student_registrations;

import java.util.Observable;

public class Classroom extends Observable
{
    public void startClass()
    {
        //start up the class

        //let others know that our class has started!
        this.setChanged();
        this.notifyObservers("Class has started!");
    }
}