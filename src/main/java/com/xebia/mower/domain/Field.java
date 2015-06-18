/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sébastien
 */
public class Field {

    private final List<Lawn> lawns;

    private final int width;

    private final int height;

    public Field(int xRightTopCorner, int yRightTopCorner) {
        // Interval [0;
        this.width = xRightTopCorner + 1;
        this.height = yRightTopCorner + 1;
        int capacity = width * height;
        lawns = new ArrayList<Lawn>(capacity);

        int x = 0, y = 0;
        for (int i = 0; i < capacity; i++) {
            lawns.add(new Lawn(this, x, y));

            if (x < width - 1) {
                x++;
            } else {
                y++;
                x = 0;
            }
        }
    }

    public Lawn getLeftLawnOf(Lawn lawn) {
        if (lawn.getX() > 0) {
            return getLawn(lawn.getX() - 1, lawn.getY());
        }
        return null;
    }

    public Lawn getRightLawnOf(Lawn lawn) {
        if (lawn.getX() < width) {
            return getLawn(lawn.getX() + 1, lawn.getY());
        }
        return null;
    }

    public Lawn getBelowLawnOf(Lawn lawn) {
        if (lawn.getY() > 0) {
            return getLawn(lawn.getX(), lawn.getY() - 1);
        }
        return null;
    }

    public Lawn getAboveLawnOf(Lawn lawn) {
        if (lawn.getY() < height) {
            return getLawn(lawn.getX(), lawn.getY() + 1);
        }
        return null;
    }

    public Lawn getLawn(int x, int y) {
        int index = x + y * width;
        return lawns.get(index);
    }
}
