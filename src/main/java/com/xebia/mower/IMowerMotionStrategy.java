/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Mower;
import com.xebia.mower.XebiaSimulatorConfiguration.XebiaMowerConfiguration;

/**
 *
 * @author Sébastien
 */
public interface IMowerMotionStrategy {

    public void move(XebiaMowerConfiguration configuration, Mower mower);
}
