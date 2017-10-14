package launch;

import javafx.application.Application;
import ui.CalculatorUI;

/*
 * Hanchen (Zero) Liu
 * 10/06/2017
 * Launcher.java
 *
 * This class launches the calculator application
 */

/**
 * This class launches the calculator application
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 */

public class Launcher
{
    /**
     * This is the main method that launches the calculator application
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //launches the calculator application
        Application.launch(CalculatorUI.class, args);
    }
}
