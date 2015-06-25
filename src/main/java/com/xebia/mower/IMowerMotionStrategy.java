/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Mower;

/**
 *
 * @author Sébastien
 */
public interface IMowerMotionStrategy {

    public void move(Mower mower, XebiaMowerInstruction configuration);
}
