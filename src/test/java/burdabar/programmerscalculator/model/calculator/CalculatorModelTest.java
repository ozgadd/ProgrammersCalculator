/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author burdabar
 */
public class CalculatorModelTest {
       
    
    @Test
    public void modelShouldCreateWithDefualtValuesWithDefaultConstructor() {
        CalculatorModel calc = new CalculatorModel();

        NumericFormat startFormat = calc.getNumericFormat();
        BytesLengthFormat startLength = calc.getLengthFormat();
        
        assertEquals(NumericFormat.DEC, startFormat);
        assertEquals(BytesLengthFormat.QWORD, startLength);
        assertEquals(0, calc.getCurrentValue().intValue());
    }
    
    @Test
    public void modelShouldContainValuePassedInConstructorAndInitializeWithZerosIfNoNumberPassed() {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.WORD, NumericFormat.DEC);
        
        assertEquals(BytesLengthFormat.WORD, calc.getLengthFormat());
        assertEquals(NumericFormat.DEC, calc.getNumericFormat());
        assertEquals(0, calc.getCurrentValue().intValue());
    }
    
    @Test
    public void modelShouldContainValuePassedInConstructor() {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.DWORD, NumericFormat.HEX, 10);
        
        assertEquals(BytesLengthFormat.DWORD, calc.getLengthFormat());
        assertEquals(NumericFormat.HEX, calc.getNumericFormat());
        assertEquals(10, calc.getCurrentValue().intValue());
    }
    
    @Test
    public void toStringShouldReturnValidHexRepresentationWithByteLength()
    {
        CalculatorModel calc = new CalculatorModel(
                BytesLengthFormat.BYTE, NumericFormat.HEX, Long.MAX_VALUE);
        assertEquals("ff", calc.toString());
    }
    
    @Test
    public void toStringShouldReturnValidHexRepresentationWithWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.WORD, NumericFormat.HEX, Long.MAX_VALUE);
        
        assertEquals("ffff", calc.toString());
    }
    
    @Test
    public void toStringShouldReturnValidHexRepresentationWithDWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.DWORD, NumericFormat.HEX, Long.MAX_VALUE);
        
        assertEquals("ffffffff", calc.toString());
    }
    
    @Test
    public void toStringShouldReturnValidHexRepresentationWithQWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.QWORD, NumericFormat.HEX, Long.MAX_VALUE);
        
        assertEquals("7fffffffffffffff", calc.toString());
    }
    
    @Test
    public void toStringShouldReturnValidBinaryRepresentationWithByteLength()
    {
        CalculatorModel calc = new CalculatorModel(
                BytesLengthFormat.BYTE, NumericFormat.BIN, Long.MAX_VALUE);
        String expected = "‭11111111‬";
        String actual = calc.toString();
        // expected value contain " " so it can't be compared with equals
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidBinaryRepresentationWithWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.WORD, NumericFormat.BIN, Long.MAX_VALUE);
        String expected = "‭1111111111111111‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidBinaryRepresentationWithDWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.DWORD, NumericFormat.BIN, Long.MAX_VALUE);
        String expected = "11111111111111111111111111111111‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidBinaryRepresentationWithQWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.QWORD, NumericFormat.BIN, Long.MAX_VALUE);
        String expected = "‭0111111111111111111111111111111111111111111111111111111111111111‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidDecimalRepresentationWithByteLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.BYTE, NumericFormat.DEC, Long.MAX_VALUE);
        String expected = "255";
        String actual = calc.toString();
        assertEquals(expected, actual);
    }
    
    @Test
    public void toStringShouldReturnValidDecimalRepresentationWithWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.WORD, NumericFormat.DEC, Long.MAX_VALUE);
        String expected = "‭65535‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidDecimalRepresentationWithDWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.DWORD, NumericFormat.DEC, Long.MAX_VALUE);
        String expected = "‭4294967295";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidDecimalRepresentationWithQWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.QWORD, NumericFormat.DEC, Long.MAX_VALUE);
        String expected = "‭9223372036854775807";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidOctalRepresentationWithByteLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.BYTE, NumericFormat.OCT, Long.MAX_VALUE);
        String expected = "‭‭‭‭377‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidOctalRepresentationWithWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.WORD, NumericFormat.OCT, Long.MAX_VALUE);
        String expected = "‭‭‭177777‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidOctalRepresentationWithDWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.DWORD, NumericFormat.OCT, Long.MAX_VALUE);
        String expected = "‭‭37777777777‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    @Test
    public void toStringShouldReturnValidOctalRepresentationWtihQWORDLength()
    {
        CalculatorModel calc = new CalculatorModel(BytesLengthFormat.QWORD, NumericFormat.OCT, Long.MAX_VALUE);
        String expected = "‭1777777777777777777777‬";
        String actual = calc.toString();
        assertTrue(expected.contains(actual));
    }
    
    
    
}
