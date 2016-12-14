/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations;

import burdabar.programmerscalculator.model.calculator.CalculatorModel;

/**
 *
 * @author burdabar
 */
public abstract class AbstractCalculatorOperation {
    
    protected final CalculatorModel calculatorModel;
    protected Long previousValue;
    
    public AbstractCalculatorOperation(CalculatorModel calculatorModel) {
        this.calculatorModel = calculatorModel;
    }
    
    
    /***
     * Execute method is used to execute calculator operation
     */
    public abstract void execute() throws CalculatorOperationException;
    
    /***
     * Undo method is used to undo executed operation
     */
    public void undo() {
        if(previousValue != null) {
            calculatorModel.setCurrentValue(previousValue);
        }
    }
    
    
}
