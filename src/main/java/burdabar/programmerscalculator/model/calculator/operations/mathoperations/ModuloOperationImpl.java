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
public class ModuloOperationImpl extends AbstractCalculatorOperation{

    private final long moduloValue;
    
    public ModuloOperationImpl(long moduloValue, CalculatorModel calculatorModel) {
        super(calculatorModel);
        this.moduloValue = moduloValue;
    }

    @Override
    public void execute() throws CalculatorOperationException {
        Number calcValue =  calculatorModel.getCurrentValue();
        Long currentValue = previousValue = calcValue.longValue();
        if( moduloValue != 0) {
            Long newValue = currentValue % moduloValue;
            calculatorModel.setCurrentValue(newValue);
        } else {
            throw new CalculatorOperationException("You can't modulo by 0!");
        }
    }
    
}
