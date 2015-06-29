/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower.domain;

import com.xebia.mower.IMowerMotionStrategy;
import com.xebia.mower.MowerMotionStrategyImpl;
import com.xebia.mower.XebiaMowerInstruction;
import javax.inject.Inject;

/**
 *
 * @author Sébastien
 */
public class Mower {

    private Lawn lawn;

    private Orientation orientation;

    private IMowerMotionStrategy motionStrategy;

    public Mower(Lawn lawn, Orientation orientation, IMowerMotionStrategy motionStrategy) {
        this.lawn = lawn;
        this.orientation = orientation;
        this.motionStrategy = motionStrategy;
    }

    /**
     * Use constructor Mower(Lawn lawn, Orientation orientation,
     * IMowerMotionStrategy motionStrategy) instead.
     */
    @Deprecated
    public Mower(Lawn lawn, Orientation orientation) {
        this(lawn, orientation, new MowerMotionStrategyImpl());
    }

    @Inject
    public Mower(IMowerMotionStrategy motionStrategy) {
        this(null, Orientation.N, motionStrategy);
    }

    public Mower goLeft() {
        Lawn leftLawn = getField().getLeftLawnOf(lawn);
        if (leftLawn != null) {
            setLawn(leftLawn);
        }
        return this;
    }

    public Mower goRight() {
        Lawn rightLawn = getField().getRightLawnOf(lawn);
        if (rightLawn != null) {
            setLawn(rightLawn);
        }
        return this;
    }

    public Mower goUp() {
        Lawn upLawn = getField().getAboveLawnOf(lawn);
        if (upLawn != null) {
            setLawn(upLawn);
        }
        return this;
    }

    public Mower goDown() {
        Lawn downLawn = getField().getBelowLawnOf(lawn);
        if (downLawn != null) {
            setLawn(downLawn);
        }
        return this;
    }

    public Mower goStraight() {
        if (Orientation.N == orientation) {
            goUp();
        } else if (Orientation.E == orientation) {
            goRight();
        } else if (Orientation.W == orientation) {
            goLeft();
        } else if (Orientation.S == orientation) {
            goDown();
        }
        return this;
    }

    public Mower rotateLeft() {
        orientation = orientation.minus90degrees();
        return this;
    }

    public Mower rotateRight() {
        orientation = orientation.major90degrees();
        return this;
    }

    public Mower move(XebiaMowerInstruction instruction) {
        motionStrategy.move(this, instruction);
        return this;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public Mower setLawn(Lawn lawn) {
        this.lawn = lawn;
        return this;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Mower setOrientation(Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    private Field getField() {
        return lawn.getField();
    }
}
