/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author burdabar
 */
public class CalculatorModel {
   
    @Setter
    @Getter 
    private BytesLengthFormat lengthFormat;
    @Setter
    @Getter
    private NumericFormat numericFormat;
    private Number currentValue;
     
    public CalculatorModel() {
        this(BytesLengthFormat.QWORD, NumericFormat.DEC, 0);
    }
    
    public CalculatorModel(BytesLengthFormat lengthFormat, NumericFormat numericFormat) {
        this(lengthFormat, numericFormat, 0);
    }
    
    public CalculatorModel(BytesLengthFormat lengthFormat, NumericFormat numericFormat, Number currentValue) {
        this.lengthFormat = lengthFormat;
        this.numericFormat = numericFormat;
        this.currentValue = currentValue;
    }
    
    public Number getCurrentValue() {
        long value = currentValue.longValue()
                & lengthFormat.getBitMask();
        return value;
    }
    
    public void setCurrentValue(Number currentValue) {
        this.currentValue = currentValue;
    }
    
    @Override 
    public String toString()
    {
        String stringRepresentation;
        switch(numericFormat)
        {
            case BIN:
                stringRepresentation = getBinaryRepresentation();
                break;
            case HEX:
                stringRepresentation = getHexRepresentation();
                break;
            case OCT:
                stringRepresentation = getOctalRepresentation();
                break;
            case DEC:
            default:
                stringRepresentation = Long.toString(getCurrentValue().longValue());
        }
        return stringRepresentation;
    }
    
   private String getHexRepresentation() {
        long value = getCurrentValue().longValue();
        String hexFormat = Long.toHexString(value);
        return hexFormat;
    }
   
    private String getOctalRepresentation() 
    {
        long value = getCurrentValue().longValue();
        String octalFormat = Long.toOctalString(value);
        return octalFormat;
    }

    private String getBinaryRepresentation() {
        long value = getCurrentValue().longValue();
        String binFormat = Long.toBinaryString(value);
        return binFormat;
    }

    
}
