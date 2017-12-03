package launcher;

import javafx.application.Application;
import view.TodoView;

/**
 * This class launches the application
 *
 * @author Hanchen Liu
 * @version 1.0
 */
public class TodoLauncher
{
    /**
     * This is the main program.
     *
     * @param args This parameter passes in arguments to be executed by main.
     */
    public static void main(String[] args)
        {
            Application.launch(TodoView.class, args);
        }
}