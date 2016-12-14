/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations;

/**
 *
 * @author burdabar
 */
public class CalculatorOperationException extends RuntimeException {

    public CalculatorOperationException() {
        super();
    }

    public CalculatorOperationException(String s) {
        super(s);
    }

    public CalculatorOperationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CalculatorOperationException(Throwable throwable) {
        super(throwable);
    }

}
