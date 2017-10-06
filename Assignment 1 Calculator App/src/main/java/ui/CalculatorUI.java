package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorUI extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Calculator");
        stage.setScene(createCalculator());
        stage.show();
    }

    private Scene createCalculator()
    {
        //assemble our controls in a grid
        GridPane gridPane = new GridPane();

//        //set spacing around elements
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.setPadding(new Insets(10));

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

        return mainScene;
    }
}
