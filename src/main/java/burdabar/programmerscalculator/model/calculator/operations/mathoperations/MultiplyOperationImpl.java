/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations.mathoperations;

import burdabar.programmerscalculator.model.calculator.CalculatorModel;
import burdabar.programmerscalculator.model.calculator.operations.AbstractCalculatorOperation;

/**
 *
 * @author burdabar
 */
public class MultiplyOperationImpl extends AbstractCalculatorOperation{

    private final long multiplyValue;
    
    public MultiplyOperationImpl (long multiplyValue, CalculatorModel calculatorModel) {
        super(calculatorModel);
        this.multiplyValue = multiplyValue;
    }
    
    @Override
    public void execute() {
        Number calcValue = calculatorModel.getCurrentValue();
        Long currentValue = previousValue = calcValue.longValue();
        Long newValue = currentValue * multiplyValue;
         calculatorModel.setCurrentValue(newValue);
    }
}
