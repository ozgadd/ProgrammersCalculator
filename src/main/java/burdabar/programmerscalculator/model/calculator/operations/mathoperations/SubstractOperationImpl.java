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
public class SubstractOperationImpl extends AbstractCalculatorOperation {

    
    private final long valueToSubstract;
    
    public SubstractOperationImpl(long valueToSubstract, CalculatorModel calculatorModel) {
        super(calculatorModel);
        this.valueToSubstract = valueToSubstract;
    }
    
    @Override
    public void execute() {
        Number calcValue = calculatorModel.getCurrentValue();
        Long currentValue = previousValue = calcValue.longValue();
        Long newValue = currentValue - valueToSubstract;
        calculatorModel.setCurrentValue(newValue);
    }
}
