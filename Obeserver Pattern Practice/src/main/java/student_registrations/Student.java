package student_registrations;

import java.util.Observable;

public class Student extends Observable
{
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    //do something of interest...
    public void registerForClass(String className)
    {
        //register for the classes with the college
        //assume a few steps occur here

        //let my observers know that something of note
        //happened
        this.setChanged();
        this.notifyObservers();
    }

    public String getName()
    {
        return name;
    }
}
