/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burdabar.programmerscalculator.model.calculator;

import lombok.Getter;

/**
 *
 * @author burdabar
 */
@Getter
public enum BytesLengthFormat {
    BYTE(0xFF),
    WORD(0xFFFF),
    DWORD(0xFFFFFFFFL),
    QWORD(0xFFFFFFFFFFFFFFFFL);
    
    private final long bitMask;
    
    private BytesLengthFormat(long bitMask) {
        this.bitMask = bitMask;
    }
}
