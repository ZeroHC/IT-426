package student_registrations;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer
{
    public void sayHiToStudent(String... names)
    {

    }

    @Override
    public void update(Observable observable, Object arguments)
    {
        if (observable instanceof Student)
        {
            Object [] parts = (Object[])arguments;
            Student student = (Student)observable;

            System.out.println(student.getName()
                    + " signed up for " + parts[0].toString()
                    + " at " + parts[1].toString());
        }

        else if (observable instanceof Classroom)
        {
            System.out.println(arguments.toString());
        }
    }
}
