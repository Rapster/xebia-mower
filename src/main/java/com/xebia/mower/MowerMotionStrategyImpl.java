/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Mower;
import com.xebia.mower.XebiaSimulatorConfiguration.XebiaMowerConfiguration;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sébastien
 */
public class MowerMotionStrategyImpl implements IMowerMotionStrategy {

    @Override
    public void move(XebiaMowerConfiguration configuration, Mower mower) {
        System.out.println(MessageFormat.format("Mower starts moving from ({0}, {1})  in direction of {2}.",
                mower.getLawn().getX(), mower.getLawn().getY(), mower.getOrientation()));

        for (char instruction : configuration.getInstructions()) {
            switch (instruction) {
                case 'G':
                    mower.rotateLeft();
                    break;
                case 'D':
                    mower.rotateRight();
                    break;
                case 'A':
                    mower.goStraight();
                    break;
                    default:
                         Logger.getLogger(MowerMotionStrategyImpl.class.getName()).log(Level.WARNING, "Unknown instruction: {0}", instruction);
            }
        }

        System.out.println(MessageFormat.format("Mower stopped moving at ({0}, {1}) in direction of {2}.",
                mower.getLawn().getX(), mower.getLawn().getY(), mower.getOrientation()));
    }
}
