package calculator;

/*
 * Hanchen (Zero) Liu
 * 10/13/2017
 * Calculator.java
 *
 * This class handles all the calculations
 */

import java.util.ArrayList;

/**
 * This class handles all the calculations
 *
 * @author Hanchen (Zero) Liu
 * @version 2.0
 */
public class Calculator
{
    //create some public fields to store information
    public static String operand1 = "";
    public static String operand2 = "";
    public static String operator = "";
    public static ArrayList<String> results = new ArrayList<>();
    public static int resultsIndex;

    /**
     * This method handles normal calculations like addition, subtraction, multiplication, and division
     *
     * @param operand1 the operand before operator
     * @param operand2 the operand after operator
     * @param operator the operator
     * @return the calculation result
     */
    public static String operation(String operand1, String operand2, String operator)
    {
        /*
         * use a switch statement to check the operator, and do the corresponding calculation
         */
        switch (operator)
        {
            case "+": return Double.toString(Double.parseDouble(operand1) + Double.parseDouble(operand2));
            case "-": return Double.toString(Double.parseDouble(operand1) - Double.parseDouble(operand2));
            case "*": return Double.toString(Double.parseDouble(operand1) * Double.parseDouble(operand2));
            case "/": if (Double.parseDouble(operand2) == 0) return "False Value";
                return Double.toString(Double.parseDouble(operand1) / Double.parseDouble(operand2));
        }

        //throws an exception for handling invalid operators
        throw new IllegalArgumentException("Invalid Operator!");
    }

    /**
     * This method handles special calculations like square, square root, sin, cos, and tan
     *
     * @param operand the string before special operator
     * @param specialOperator the special operator
     * @return the calculation result
     */
    public static String specialOperation(String operand, String specialOperator)
    {
        /*
         * use a switch statement to check the operator, and do the corresponding calculation
         */
        switch (specialOperator)
        {
            case "x^2": return Double.toString(Math.pow(Double.parseDouble(operand), 2));
            case "√(x)": return Double.toString(Math.sqrt(Double.parseDouble(operand)));
            case "Sin(x)": return Double.toString(Math.sin(Math.toRadians(Double.parseDouble(operand))));
            case "Cos(x)": return Double.toString(Math.cos(Math.toRadians(Double.parseDouble(operand))));
            case "Tan(x)": return Double.toString(Math.tan(Math.toRadians(Double.parseDouble(operand))));
        }
        //throws an exception for handling invalid operators
        throw new IllegalArgumentException("Invalid Operator!");
    }
}
