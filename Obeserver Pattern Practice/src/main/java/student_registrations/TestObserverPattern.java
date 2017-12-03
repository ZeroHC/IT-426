package student_registrations;

import jdk.internal.org.objectweb.asm.ClassReader;

public class TestObserverPattern
{
    public static void main(String[] args)
    {
        //objects of interest!
        Student josh = new Student("josh");
        Student tina = new Student("tina");

        //have a class "watch" or observe our students
        Registrar grcRegistrar = new Registrar();

        //attach our observers
        josh.addObserver(grcRegistrar);
        tina.addObserver(grcRegistrar);

        //create a second type of observer
        Teacher grcTeacher = new Teacher();

        //attach our observers
        tina.addObserver(grcTeacher);

        tina.registerForClass("IT 426");

        //be careful with your observers/observables
        Classroom room = new Classroom();
        room.addObserver(grcTeacher);

        room.startClass();
    }
}