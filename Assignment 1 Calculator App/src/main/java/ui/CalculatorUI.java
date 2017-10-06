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

        //initialize all the buttons
        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button buttonAdd = new Button("+");
        Button buttonSubtract = new Button("-");
        Button buttonMultiply = new Button("*");
        Button buttonDivide = new Button("/");
        Button buttonEnter = new Button("Enter");

        //set an id for the enter button
        buttonEnter.setId("enter");

        //add first row of buttons to the grid pane
        gridPane.add(button7, 0, 1);
        gridPane.add(button8, 1, 1);
        gridPane.add(button9, 2, 1);
        gridPane.add(buttonAdd, 3, 1);

        //add second row of buttons to the grid pane
        gridPane.add(button4, 0, 2);
        gridPane.add(button5, 1, 2);
        gridPane.add(button6, 2, 2);
        gridPane.add(buttonSubtract, 3, 2);

        //add third row of buttons to the grid pane
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.add(button3, 2, 3);
        gridPane.add(buttonMultiply, 3, 3);

        //add last row of buttons to the grid pane
        gridPane.add(button0, 0, 4);
        gridPane.add(buttonEnter, 1, 4, 2, 1);
        gridPane.add(buttonDivide, 3, 4);

        //add styles to the elements using an external stylesheet
        Scene mainScene = new Scene(gridPane, 210, 250);
        mainScene.getStylesheets().add("Styles.css");

        //returns the scene
        return mainScene;
    }
}
