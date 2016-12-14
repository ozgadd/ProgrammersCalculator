/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations.logic_operation;

import burdabar.programmerscalculator.model.calculator.CalculatorModel;
import burdabar.programmerscalculator.model.calculator.operations.AbstractCalculatorOperation;

/**
 *
 * @author burdabar
 */
public class LogicalOrOperationImpl extends AbstractCalculatorOperation {

    private final long orValue;
    
    public LogicalOrOperationImpl(CalculatorModel calculatorModel, long orValue) {
        super(calculatorModel);
        this.orValue = orValue;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
