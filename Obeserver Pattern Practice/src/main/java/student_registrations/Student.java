package student_registrations;

import java.time.LocalDateTime;
import java.util.Observable;

public class Student extends Observable
{
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    //do something of interest...
    public void registerForClass(String className)
    {
        //register for classes with the college...
        //assume a few steps occur here...

        //let my observers know that something of note
        //happened
        this.setChanged();
        this.notifyObservers(new Object[] {className, LocalDateTime.now()});
    }
}