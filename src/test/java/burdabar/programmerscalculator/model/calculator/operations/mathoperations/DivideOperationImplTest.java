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
public class DivideOperationImplTest {
    
    @Mock
    private CalculatorModel modelMock;
    private ArgumentCaptor<Long> longCaptor;
    private static final long INITIAL_VALUE = 5L;

    private DivideOperationImpl divideOperation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(INITIAL_VALUE);
        longCaptor = ArgumentCaptor
                .forClass(Long.class);
        divideOperation = new DivideOperationImpl(INITIAL_VALUE, modelMock);
    }

    @Test
    public void executeShouldMultiplyValueOfCurrentModelValue() {
        divideOperation.execute();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        long expectedValue = 1;
        long actualValue = longCaptor.getValue();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void undoShouldDivideMultipliedValueFromModel() {
        divideOperation.undo();

        Mockito.verify(modelMock, Mockito.never())
                .setCurrentValue(longCaptor.capture());
    }
    
    @Test ( expected = IllegalArgumentException.class)
    public void executeWithZeroShouldThrowException()
    {
        divideOperation = new DivideOperationImpl(0, modelMock);
        divideOperation.execute();
    }

    @Test
    public void executeAndUndoShouldKeepValueUnchanged() {
        divideOperation.execute();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        long expectedValue = 1;
        long actualValue = longCaptor.getValue();

        assertEquals(expectedValue, actualValue);
        divideOperation.undo();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        actualValue = longCaptor.getValue();

        assertEquals(INITIAL_VALUE, actualValue);
    }
    
}
