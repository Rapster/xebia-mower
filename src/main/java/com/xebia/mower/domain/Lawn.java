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
public class Lawn {

    private final Field field;

    private final int x;

    private final int y;

    public Lawn(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Field getField() {
        return field;
    }

}
