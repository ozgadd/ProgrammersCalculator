/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator.operations.mathoperations;

import burdabar.programmerscalculator.model.calculator.CalculatorModel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author burdabar
 */
public class SubstractOperationImplTest {
    
    @Mock
    private CalculatorModel modelMock;
    private ArgumentCaptor<Long> longCaptor;
    private SubstractOperationImpl substractOperation;
    private static final int START_VALUE = 5;
    private static final int SUBSTRACT_VALUE = 5;
    
    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(START_VALUE);

        longCaptor = ArgumentCaptor.forClass(Long.class);
        substractOperation = new SubstractOperationImpl(SUBSTRACT_VALUE, modelMock);
    }    
    
    @Test
    public void executeShouldSubstractValueFromCurrentValue()
    {
        substractOperation.execute();
        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());
        
        long expectedValue = 0;
        long actualValue = longCaptor.getValue();
        
        assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void undoWithoutExecuteShouldDoNothing()
    {
        substractOperation.undo();
        Mockito.verify(modelMock, Mockito.never())
                .setCurrentValue(longCaptor.capture());
    }
    
    @Test
    public void callExecuteAndUndoShouldKeepStartValue()
    {
        substractOperation.execute();
        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());
        
        long expectedValue = 0;
        long actualValue = longCaptor.getValue();
        
        assertEquals(expectedValue, actualValue);
        
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(actualValue);
        
        substractOperation.undo();
        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());
        
        actualValue = longCaptor.getValue();
        
        assertEquals(START_VALUE, actualValue);
        
    }
    
}
