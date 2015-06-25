/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sébastien
 */
public class XebiaSimulatorConfiguration {

    private int xTopRightCorner;

    private int yTopRightCorner;

    private List<XebiaMowerInstruction> mowerConfigurations;

    public int getXTopRightCorner() {
        return xTopRightCorner;
    }

    public void setXTopRightCorner(int x) {
        this.xTopRightCorner = x;
    }

    public int getYTopRightCorner() {
        return yTopRightCorner;
    }

    public void setYTopRightCorner(int y) {
        this.yTopRightCorner = y;
    }

    public List<XebiaMowerInstruction> getMowerConfigurations() {
        if (mowerConfigurations == null) {
            mowerConfigurations = new ArrayList<XebiaMowerInstruction>();
        }
        return mowerConfigurations;
    }
}
