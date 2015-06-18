/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Orientation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sébastien
 */
public class XebiaSimulatorConfiguration {

    private int xTopRightCorner;

    private int yTopRightCorner;

    private List<XebiaMowerConfiguration> mowerConfigurations;

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

    public List<XebiaMowerConfiguration> getMowerConfigurations() {
        if (mowerConfigurations == null) {
            mowerConfigurations = new ArrayList<XebiaMowerConfiguration>();
        }
        return mowerConfigurations;
    }

    public static class XebiaMowerConfiguration {

        private int xStartPosition;

        private int yStartPosition;

        private Orientation orientation;

        private char[] instructions;

        public XebiaMowerConfiguration(int xStartPosition, int yStartPosition, Orientation orientation, char[] instructions) {
            this.xStartPosition = xStartPosition;
            this.yStartPosition = yStartPosition;
            this.orientation = orientation;
            this.instructions = instructions;
        }

        public XebiaMowerConfiguration() {
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
}
