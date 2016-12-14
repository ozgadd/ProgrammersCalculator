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
public class ModuloOperationImplTest {
    
    @Mock
    private CalculatorModel modelMock;
    private ArgumentCaptor<Long> longCaptor;
    private static final long INITIAL_VALUE = 5L;

    private ModuloOperationImpl moduloOperation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(modelMock.getCurrentValue())
                .thenReturn(INITIAL_VALUE);
        longCaptor = ArgumentCaptor
                .forClass(Long.class);
        moduloOperation = new ModuloOperationImpl(INITIAL_VALUE, modelMock);
    }

    @Test
    public void executeShouldModuloValueOfCurrentModelValue() {
        moduloOperation.execute();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        long expectedValue = 0;
        long actualValue = longCaptor.getValue();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void undoShouldDivideMultipliedValueFromModel() {
        moduloOperation.undo();

        Mockito.verify(modelMock, Mockito.never())
                .setCurrentValue(longCaptor.capture());
    }
    
    @Test ( expected = IllegalArgumentException.class)
    public void executeWithZeroShouldThrowException()
    {
        moduloOperation = new ModuloOperationImpl(0, modelMock);
        moduloOperation.execute();
    }

    @Test
    public void executeAndUndoShouldKeepValueUnchanged() {
        moduloOperation.execute();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        long expectedValue = 0;
        long actualValue = longCaptor.getValue();

        assertEquals(expectedValue, actualValue);
        moduloOperation.undo();

        Mockito.verify(modelMock, Mockito.atLeastOnce())
                .setCurrentValue(longCaptor.capture());

        actualValue = longCaptor.getValue();

        assertEquals(INITIAL_VALUE, actualValue);
    }
}
