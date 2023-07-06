package ru.vasadm.minitable.services;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static double evaluate(String expression) {
        double result = 0;
        String operation = "";
        List<Character> openBrackets = new ArrayList<>();
        List<Character> closeBrackets = new ArrayList<>();
        StringBuilder innerInput =new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char inputChar = expression.charAt(i);
            if(openBrackets.isEmpty()){
                if (Character.isDigit(inputChar)) {

                    if (operation.equals("") && result == 0) {
                        result = Character.digit(inputChar, Character.MAX_RADIX);
                        continue;
                    } else if (!operation.equals("")) {
                        result = calculateWithOperation(operation, Character.digit(inputChar, Character.MAX_RADIX), result);
                        continue;
                    }
                }
                // if the input is operation then we must set the operation in order
                // to be taken into consideration again ..
                if (inputChar == '+' || inputChar == '-' || inputChar == '*' || inputChar == '/') {
                    operation = Character.toString(inputChar);
                    continue;
                }
            }
            if (inputChar == '(') {
                // set operation to be empty in order to calculate the
                // operations inside the brackets ..
                openBrackets.add(inputChar);
                continue;
            }
            if(inputChar ==')'){
                closeBrackets.add(inputChar);
                if(openBrackets.size() == closeBrackets.size()){
                    openBrackets.remove((Character)'(');
                    closeBrackets.remove((Character)')');
                    double evalResult =  evaluate(innerInput.toString());
                    result = calculateWithOperation(operation,evalResult,result);
                    innerInput.setLength(0);
                }
                if(openBrackets.size()> closeBrackets.size()){
                    continue;
                }
                //break;
            }
            else{
                innerInput.append(inputChar);
            }
        }
        return result;
    }

    private static double calculateWithOperation(String operation, double inputChar, double output) {
        switch (operation) {
            case "+":
                output = output + inputChar;
                break;

            case "-":
                output = output - inputChar;
                break;

            case "*":
                output = output * inputChar;
                break;

            case "/":
                output = output / inputChar;
                break;

            default:
                break;
        }
        return output;
    }
}