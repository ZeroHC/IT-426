package launchers;

import javafx.application.Application;
import stages_scenes.Storybook;

public class Launcher
{
    public static void main(String[] args)
    {
        //starts our hello world gui
        Application.launch(Storybook.class, args);
    }
}
