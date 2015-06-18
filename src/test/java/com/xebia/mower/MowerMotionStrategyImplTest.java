/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.XebiaSimulatorConfiguration.XebiaMowerConfiguration;
import com.xebia.mower.domain.Field;
import com.xebia.mower.domain.Lawn;
import com.xebia.mower.domain.Mower;
import com.xebia.mower.domain.Orientation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sébastien
 */
public class MowerMotionStrategyImplTest {

    /**
     * Test of move method, of class MowerMotionStrategyImpl.
     */
    @Test
    public void testMove() {
        XebiaMowerConfiguration configuration = new XebiaMowerConfiguration(3, 3, Orientation.N, "GAGAGAGADDADAAA".toCharArray());
        Field field = new Field(configuration.getXStartPosition(), configuration.getYStartPosition());
        Mower mower = new Mower(new Lawn(field, 2, 3), Orientation.N);
        MowerMotionStrategyImpl instance = new MowerMotionStrategyImpl();
        instance.move(configuration, mower);
        
        assertEquals(0, mower.getLawn().getX());
        assertEquals(2, mower.getLawn().getY());
        assertEquals(Orientation.W, mower.getOrientation());
    }

}
