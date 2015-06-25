/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Orientation;

/**
 *
 * @author Sébastien
 */
public class XebiaMowerInstruction {

    private int xStartPosition;
    
    private int yStartPosition;
    
    private Orientation orientation;
    
    private char[] instructions;

    public XebiaMowerInstruction(int xStartPosition, int yStartPosition, Orientation orientation, char[] instructions) {
        this.xStartPosition = xStartPosition;
        this.yStartPosition = yStartPosition;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public XebiaMowerInstruction() {
        this(0, 0, Orientation.N, new char[0]);
    }

    public int getXStartPosition() {
        return xStartPosition;
    }

    public void setXStartPosition(int x) {
        this.xStartPosition = x;
    }

    public int getYStartPosition() {
        return yStartPosition;
    }

    public void setYStartPosition(int y) {
        this.yStartPosition = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public char[] getInstructions() {
        return instructions;
    }

    public void setInstructions(char[] instructions) {
        this.instructions = instructions;
    }

}
