package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private TextField textField;

    @FXML
    protected void onEqual() {
        String input = textField.getText();
            if(input != null && input.length() > 0){
                String[] splitInput = input.split("\\+|\\-|\\*|\\/");
                if(splitInput.length == 2){
                    String operator = input.replaceAll("[^\\+\\-\\*\\/]", "");
                    double num1 = Double.parseDouble(splitInput[0]);
                    double num2 = Double.parseDouble(splitInput[1]);
                    double result = 0;
                    switch(operator){
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                }
            }
    }

    @FXML
    protected void onClear() {
        textField.setText("");
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        textField.setText(textField.getText() + buttonText);
    }

}