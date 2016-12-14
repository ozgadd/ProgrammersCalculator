/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations.mathoperations;

import burdabar.programmerscalculator.model.calculator.CalculatorModel;
import burdabar.programmerscalculator.model.calculator.operations.AbstractCalculatorOperation;
import burdabar.programmerscalculator.model.calculator.operations.CalculatorOperationException;

/**
 *
 * @author burdabar
 */
public class DivideOperationImpl extends AbstractCalculatorOperation {

    private final long divideValue;

    public DivideOperationImpl(long divideValue, CalculatorModel calcModel) {
        super(calcModel);
        this.divideValue = divideValue;
    }

    @Override
    public void execute() throws CalculatorOperationException {
        Number calcValue =  calculatorModel.getCurrentValue();
        Long currentValue = previousValue = calcValue.longValue();
        if( divideValue != 0) {
            Long newValue = currentValue / divideValue;
            calculatorModel.setCurrentValue(newValue);
        } else {
            throw new CalculatorOperationException("You can't divide by 0!");
        }
    }

}
