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
public class AddOperationImplTest {
    
    @Mock 
    private CalculatorModel modelMock;
    private ArgumentCaptor<Long> valueCaptor;
    private static final long INITIAL_VALUE = 5L;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(INITIAL_VALUE);
        valueCaptor = ArgumentCaptor
                .forClass(Long.class);
    }
    
    @Test
    public void executeShouldAddValueToCurrentModelValue(){
        long valueToAdd = 5;
        
        AddOperationImpl addOperation = new AddOperationImpl(valueToAdd, modelMock);
        addOperation.execute();
        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(valueCaptor.capture());
        
        long expectedValue = 10L;
        long actualValue = valueCaptor.getValue();
        
        assertEquals(expectedValue, actualValue);
        
    }

    @Test
    public void undoWithoutExecuteShouldDoNothing() {
        long addedValue = 5;
        
        AddOperationImpl addOperation = new AddOperationImpl(addedValue, modelMock);
        addOperation.undo();
        Mockito.verify(modelMock, Mockito.never())
                .setCurrentValue(valueCaptor.capture());
    }
    
    @Test
    public void executeAndUndoShouldKeepValueUnchanged() {
        long addValue = 5;
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(INITIAL_VALUE);
        AddOperationImpl addOperation = new AddOperationImpl(addValue, modelMock);
        addOperation.execute();
        Mockito.verify(modelMock, Mockito.atLeastOnce()).setCurrentValue(valueCaptor.capture());
        assertEquals(10L, valueCaptor.getValue().longValue());
        addOperation.undo();
        Mockito.verify(modelMock, Mockito.atLeastOnce()).setCurrentValue(valueCaptor.capture());
        assertEquals(5L, valueCaptor.getValue().longValue());
    }
    
}
