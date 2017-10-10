package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * Hanchen (Zero) Liu
 * 10/06/2017
 * CalculatorUI.java
 *
 * This class creates an calculator ui
 */

 /**
 * This class creates and calculator ui
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 */

public class CalculatorUI extends Application
{
    //use an array to store number buttons from 1 - 9
    private static final String[] NUMBER_BUTTONS = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3"};

    //use an array to store the operators
    private static final String[] OPERATORS = new String[]{"+", "-", "*", "/"};

    //set the number of columns
    private static final int COLUMN_COUNT = 3;
    //set the number of rows
    private static final int ROW_COUNT = 3;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * @param stage the primary stage for this application,
     *             onto which the application scene can be set.
     *             The primary stage will be embedded in the
     *              browser if the application was launched as an applet.
     *              Applications may create other stages, if needed,
     *              but they will not be primary stages and will not be embedded in the browser
     *
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception
    {
        //set the title for the stage
        stage.setTitle("Calculator");

        //set the scene for the stage
        stage.setScene(createCalculator());

        //show the stage
        stage.show();
    }

    /*
     * This method creates the calculator ui
     */
    private Scene createCalculator()
    {
        //assemble our controls in a grid
        GridPane gridPane = new GridPane();

        //create an output box
        HBox outputBox = new HBox();
        Label output = new Label("0");

        outputBox.getChildren().add(output);

        //add the display box to the grid pane
        gridPane.add(outputBox, 0, 0, 3, 1);

        //set an int to represent the array's index, starts from 0
        int buttonIndex = 0;

        //use a for loop to create number buttons
        for (int i = 1; i <= ROW_COUNT; i++)
        {
            for (int j = 0; j < COLUMN_COUNT; j++)
            {
                gridPane.add(new Button(""+ NUMBER_BUTTONS[buttonIndex]+""), j, i);
                buttonIndex++;
            }
        }

        //use for loop to create operator buttons
        for (int k = 0; k < OPERATORS.length; k++)
        {
            gridPane.add(new Button(""+ OPERATORS[k]+""), COLUMN_COUNT, k + 1);
        }

        //creates the 0 button
        Button button0 = new Button("0");
        gridPane.add(button0, 0, 4);

        //creates the enter button
        Button enterButton = new Button("Enter");
        //set an id to the enter button
        enterButton.setId("enter");
        gridPane.add(enterButton, 1, 4, 2, 1);

        //add styles to the elements using an external stylesheet
        Scene mainScene = new Scene(gridPane, 350, 420);
        mainScene.getStylesheets().add("styles/Styles.css");

        //returns the scene
        return mainScene;
    }
}