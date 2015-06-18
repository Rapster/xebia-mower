/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower.domain;

/**
 *
 * @author Sébastien
 */
public class Mower {

    private Lawn lawn;

    private Orientation orientation;

    public Mower(Lawn lawn, Orientation orientation) {
        this.lawn = lawn;
        this.orientation = orientation;
    }

    public void goLeft() {
        Lawn leftLawn = getField().getLeftLawnOf(lawn);
        if (leftLawn != null) {
            setLawn(leftLawn);
        }
    }

    public void goRight() {
        Lawn rightLawn = getField().getRightLawnOf(lawn);
        if (rightLawn != null) {
            setLawn(rightLawn);
        }
    }

    public void goUp() {
        Lawn upLawn = getField().getAboveLawnOf(lawn);
        if (upLawn != null) {
            setLawn(upLawn);
        }
    }

    public void goDown() {
        Lawn downLawn = getField().getBelowLawnOf(lawn);
        if (downLawn != null) {
            setLawn(downLawn);
        }
    }

    public void goStraight() {
        if (Orientation.N == orientation) {
            goUp();
        } else if (Orientation.E == orientation) {
            goRight();
        } else if (Orientation.W == orientation) {
            goLeft();
        } else if (Orientation.S == orientation) {
            goDown();
        }
    }

    public void rotateLeft() {
        orientation = orientation.minus90degrees();
    }

    public void rotateRight() {
        orientation = orientation.major90degrees();
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    private Field getField() {
        return lawn.getField();
    }
}
