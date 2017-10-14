package ui;

import calculator.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * Hanchen (Zero) Liu
 * 10/13/2017
 * CalculatorUI.java
 *
 * This class creates an calculator ui
 */

 /**
 * This class creates and calculator ui
 *
 * @author Hanchen (Zero) Liu
 * @version 2.0
 */

public class CalculatorUI extends Application
{
    //use an array to store number buttons from 1 - 9
    private static final String[] NUMBER_BUTTONS = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3"};

    //use an array to store the operators
    private static final String[] OPERATORS = new String[]{"+", "-", "*", "/"};

    //use an array to store the special operators
    private static final String[] SPECIAL_OPERATORS = new String[]{"x^2", "√(x)", "Sin(x)", "Cos(x)", "Tan(x)"};

    //set the number of columns
    private static final int COLUMN_COUNT = 5;
    //set the number of rows
    private static final int ROW_COUNT = 5;

    //create some fields to store information
    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";
    private ArrayList<String> results = new ArrayList<>();
    private int resultsIndex;

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

    //This method creates the calculator ui
    private Scene createCalculator()
    {
        //assemble our controls in a grid
        GridPane gridPane = new GridPane();

        //create an output box
        HBox outputBox = new HBox();
        Label output = new Label("0");

        outputBox.getChildren().add(output);

        //add the display box to the grid pane
        gridPane.add(outputBox, 0, 0, 5, 1);

        createAllButtons(gridPane, output);

        //add styles to the elements using an external stylesheet
        Scene mainScene = new Scene(gridPane, 460, 540);
        mainScene.getStylesheets().add("styles/Styles.css");

        //returns the scene
        return mainScene;
    }

    //this method creates all the buttons
    private void createAllButtons(GridPane gridPane, Label output)
    {
        createFirstRowButtons(gridPane, output);
        createNumberButtons(gridPane, output);
        createOperatorButtons(gridPane, output);
        createLastRowButtons(gridPane, output);
    }

    //this method creates the first row of buttons
    private void createFirstRowButtons(GridPane gridPane, Label output)
    {
        createClearButtons(gridPane, output);
        createShowResultsButton(gridPane, output);
        createPositiveNegativeButton(gridPane, output);
    }

    //this method creates clear buttons
    private void createClearButtons(GridPane gridPane, Label output)
    {
        createAllClearButton(gridPane, output);
        createClearButton(gridPane, output);
    }

    /*
     * this method creates an all clear button which will not only reset the output text,
     * but also clears all the operands, operator, and the history results
     */
    private void createAllClearButton(GridPane gridPane, Label output)
    {
        Button allClearButton = new Button("CE");
        allClearButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                output.setText("0");
                operand1 = "";
                operand2 = "";
                operator = "";
                results.clear();
            }
        });

        gridPane.add(allClearButton, 0, 1);
    }

    //this method creates a clear button that resets the output text
    private void createClearButton(GridPane gridPane, Label output)
    {
        Button clearButton = new Button("C");
        clearButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                output.setText("0");
            }
        });

        gridPane.add(clearButton, 1, 1);
    }

    /*
     * this method creates a show stored result button that will show one
     * previous result every time the button is clicked
     */
    private void createShowResultsButton(GridPane gridPane, Label output)
    {
        Button showStoredResultButton = new Button("ANS");

        //set a index that is used to go through the results list
        if (!results.isEmpty()) resultsIndex = results.size()-1;
        else resultsIndex = 0;
        showStoredResultButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (results.isEmpty())
                {
                    output.setText("0");
                }

                /*
                 * when all the previous results are gone through,
                 * loop back to the last/latest result
                 */
                else
                {
                    output.setText(results.get(resultsIndex));
                    if (resultsIndex > 0)
                    {
                        resultsIndex--;
                    }
                    else resultsIndex = results.size() - 1;
                }
            }
        });

        gridPane.add(showStoredResultButton, 2, 1);
    }

    //this method creates a positive/negative button that will change the sign of the present number
    private void createPositiveNegativeButton(GridPane gridPane, Label output)
    {
        Button positiveNegativeButton = new Button("+/-");
        positiveNegativeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (output.getText().startsWith("-")) output.setText(output.getText().replace("-", ""));
                else output.setText("-" + output.getText());
            }
        });

        gridPane.add(positiveNegativeButton, 3, 1);
    }

    //this method creates all the number buttons from 1-9
    private void createNumberButtons(GridPane gridPane, Label output)
    {
        //set an int to represent the array's index, starts from 0
        int buttonIndex = 0;

        //use a for loop to create number buttons
        for (int i = 2; i <= ROW_COUNT-1; i++)
        {
            for (int j = 0; j < COLUMN_COUNT-2; j++)
            {
                final Button tempButton = new Button(""+ NUMBER_BUTTONS[buttonIndex]+"");
                tempButton.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        if (output.getText().equals("0") || output.getText().equals("-0")
                                || (!results.isEmpty() && results.contains(output.getText()))
                                || output.getText().equals("False Value"))
                        {
                            output.setText(tempButton.getText());
                        }

                        else output.setText(output.getText() + tempButton.getText());
                    }
                });

                gridPane.add(tempButton, j, i);
                buttonIndex++;
            }
        }
    }

    //this method creates all the operators
    private void createOperatorButtons(GridPane gridPane, Label output)
    {
        createNormalOperatorButtons(gridPane, output);
        createSpecialOperatorButtons(gridPane, output);
    }

    //this method creates the normal operator buttons
    private void createNormalOperatorButtons(GridPane gridPane, Label output)
    {
        //use for loop to create operator buttons
        for (int k = 0; k < OPERATORS.length; k++)
        {
            final Button tempButton = new Button(""+ OPERATORS[k]+"");

            tempButton.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    if (output.getText().equals("False Value")) output.setText("False Value");
                    else
                    {
                        operand1 = output.getText();
                        operator = tempButton.getText();
                        output.setText("0");
                    }
                }
            });

            gridPane.add(tempButton, COLUMN_COUNT-2, k + 2);
        }
    }

    //this method creates special operator buttons
    private void createSpecialOperatorButtons(GridPane gridPane, Label output)
    {
        //use for loop to create special operator buttons
        for (int l = 0; l < SPECIAL_OPERATORS.length; l++)
        {
            final Button tempButton = new Button(""+ SPECIAL_OPERATORS[l]+"");

            tempButton.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    if (output.getText().equals("False Value")) output.setText("False Value");
                    else
                    {
                        //add the result to the result list
                        results.add(Calculator.specialOperation(output.getText(), tempButton.getText()).replaceAll("\\.?0*$", ""));
                        output.setText(results.get(results.size()-1));
                    }
                }
            });

            tempButton.setId("specialOperator");
            gridPane.add(tempButton, COLUMN_COUNT-1, l + 1);
        }
    }

    //this method creates the last row of buttons
    private void createLastRowButtons(GridPane gridPane, Label output)
    {
        createButtonZero(gridPane, output);
        createDecimalButton(gridPane, output);
        createEqualButton(gridPane, output);
    }

    //this method creates the 0 button
    private void createButtonZero(GridPane gridPane, Label output)
    {
        Button button0 = new Button("0");
        button0.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (output.getText().equals("0") || output.getText().equals("False Value")) output.setText(button0.getText());
                else output.setText(output.getText() + button0.getText());
            }
        });
        gridPane.add(button0, 0, 5);
    }

    //this method creates an decimal button
    private void createDecimalButton(GridPane gridPane, Label output)
    {
        Button decimalButton = new Button(".");

        decimalButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (!output.getText().contains(".") && !output.getText().equals("False Value"))
                {
                    output.setText(output.getText() + decimalButton.getText());
                }
                else output.setText(output.getText());
            }
        });

        gridPane.add(decimalButton, 1, 5);
    }

    //this method creates the equal button
    private void createEqualButton(GridPane gridPane, Label output)
    {
        Button equalButton = new Button("=");

        equalButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (operator.isEmpty()) output.setText(output.getText());
                else
                {
                    operand2 = output.getText();
                    results.add(Calculator.operation(operand1, operand2, operator).replaceAll("\\.?0*$", ""));
                    output.setText(results.get(results.size() - 1));
                    operator = "";
                }
            }
        });

        gridPane.add(equalButton, 2, 5);
    }
}