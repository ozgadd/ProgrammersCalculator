/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import burdabar.programmerscalculator.model.calculator.operations.AbstractCalculatorOperation;
import burdabar.programmerscalculator.model.calculator.operations.CalculatorOperationException;
import burdabar.programmerscalculator.model.calculator.operations.mathoperations.AddOperationImpl;
import burdabar.programmerscalculator.model.calculator.operations.mathoperations.DivideOperationImpl;
import burdabar.programmerscalculator.model.calculator.operations.mathoperations.ModuloOperationImpl;
import burdabar.programmerscalculator.model.calculator.operations.mathoperations.MultiplyOperationImpl;
import burdabar.programmerscalculator.model.calculator.operations.mathoperations.SubstractOperationImpl;
import lombok.Getter;

/**
 *
 * @author burdabar
 */
public class Calculator {

    private final CalculatorModel model;
    private final Deque<AbstractCalculatorOperation> executedOperations;
    private final Deque<AbstractCalculatorOperation> undoOperations;
    @Getter
    private String displayString;

    public Calculator(CalculatorModel model) {
        this.model = model;
        executedOperations = new ArrayDeque<>();
        undoOperations = new ArrayDeque<>();
        setDisplayStringToModelValue();
    }

    private void setDisplayStringToModelValue() {
        displayString = model.getCurrentValue().toString();
    }

    public void add(long value) {
        AbstractCalculatorOperation addOperation = new AddOperationImpl(value, model);
        addOperation.execute();
        executedOperations.add(addOperation);
        setDisplayStringToModelValue();
    }

    public void substract(long value) {
        AbstractCalculatorOperation substractOperation = new SubstractOperationImpl(value, model);
        substractOperation.execute();
        executedOperations.add(substractOperation);
        setDisplayStringToModelValue();
    }

    public void divide(long value) {
        try {
            AbstractCalculatorOperation divideOperation = new DivideOperationImpl(value, model);
            divideOperation.execute();
            executedOperations.add(divideOperation);
            setDisplayStringToModelValue();
        } catch (CalculatorOperationException ex) {
            displayString = ex.getMessage();
        }
    }

    public void multiply(long value) {
        AbstractCalculatorOperation multiplyOperation = new MultiplyOperationImpl(value, model);
        multiplyOperation.execute();
        executedOperations.add(multiplyOperation);
        setDisplayStringToModelValue();
    }

    public void modulo(long value) {
        try {
            AbstractCalculatorOperation moduloOperation = new ModuloOperationImpl(value, model);
            moduloOperation.execute();
            executedOperations.add(moduloOperation);
            setDisplayStringToModelValue();
        } catch (CalculatorOperationException ex) {
            displayString = ex.getMessage();
        }
    }

    public void undo() {
        if (!executedOperations.isEmpty()) {
            AbstractCalculatorOperation lastOperation = executedOperations.pop();
            lastOperation.undo();
            undoOperations.add(lastOperation);
            setDisplayStringToModelValue();
        }
    }

    public void redo() {
        if (!undoOperations.isEmpty()) {
            AbstractCalculatorOperation operationToRedo = undoOperations.pop();
            operationToRedo.execute();
            executedOperations.add(operationToRedo);
            setDisplayStringToModelValue();
        }
    }

    public void changeNumericFormat(NumericFormat numericFormat) {
        model.setNumericFormat(numericFormat);
        setDisplayStringToModelValue();
    }

    public void changeBytesLengthFormat(BytesLengthFormat bytesLengthFormat) {
        model.setLengthFormat(bytesLengthFormat);
        setDisplayStringToModelValue();
    }   
    
}
