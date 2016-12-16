package burdabar.programmerscalculator.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController implements Initializable {
    
    @FXML
    private Button shiftToRollButton;
    @FXML
    private Button moduloButton;
    @FXML
    private Button clearOperationButton;
    @FXML
    private Button delButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button AButton;
    @FXML
    private Button BButton;
    @FXML
    private Button CButton;
    @FXML
    private Button DButton;
    @FXML
    private Button EButton;
    @FXML
    private Button FButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button equalButton;
    @FXML
    private Button addButton;
    @FXML
    private Button lengthButton;
    @FXML
    private Button leftShiftButton;
    @FXML
    private Button rightShiftButton;
    @FXML
    private Button orButton;
    @FXML
    private Button andButton;
    @FXML
    private Button xorButton;
    @FXML
    private Button notButton;
    @FXML
    private Button hexButton;
    @FXML
    private Button decButton;
    @FXML
    private Button octButton;
    @FXML
    private Button binButton;
    @FXML
    private Label hexField;
    @FXML
    private Label octField;
    @FXML
    private Label decField;
    @FXML
    private Label binField;
    @FXML
    private Label calcField;
    @FXML
    private Button clearButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void zeroButtonCilck(ActionEvent event) {
        calcField.setText("0");
    }

    @FXML
    private void handleDigitAction(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        String oldText = calcField.getText();
        String newText = oldText + digit;
        calcField.setText(newText);
    }

    @FXML
    private void handleAddOperation(ActionEvent event) {
        String currentText = calcField.getText();
        double currentNumber = Double.parseDouble(currentText);
        // Use ADD method from class Calculator.java
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
        // Equal
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        // C Button - Clear display
    }

    @FXML
    private void handleDivideOperation(ActionEvent event) {
        // Divide
    }

    @FXML
    private void handleMultiplyOperation(ActionEvent event) {
        // Multiply
    }

    @FXML
    private void handleMinusOperation(ActionEvent event) {
        // Substract
    }

    @FXML
    private void handleDotAction() {
        // Dot
        String oldText = calcField.getText();
        String newText = oldText;
        if( digit.contains(".") ) {
            // Nothing To Do
        } else {
            newText = oldText + ".";
        }
        calcField.setText(newText);
    }
}
