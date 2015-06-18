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
public enum Orientation {

    N,
    E,
    W,
    S;

    public Orientation minus90degrees() {
        return this == N
                ? W
                : this == W
                        ? S
                        : this == S
                                ? E
                                : N;

    }

    public Orientation major90degrees() {
        return this == N
                ? E
                : this == E
                        ? S
                        : this == S
                                ? W
                                : N;

    }
}
