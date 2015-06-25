/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sébastien
 */
public class OrientationTest {

    /**
     * Test of minus90degrees method, of class Orientation.
     */
    @Test
    public void testMinus90degrees() {
        assertEquals(Orientation.W, Orientation.N.minus90degrees());
        assertEquals(Orientation.S, Orientation.W.minus90degrees());
        assertEquals(Orientation.E, Orientation.S.minus90degrees());
        assertEquals(Orientation.N, Orientation.E.minus90degrees());
    }

    /**
     * Test of major90degrees method, of class Orientation.
     */
    @Test
    public void testMajor90degrees() {
        assertEquals(Orientation.E, Orientation.N.major90degrees());
        assertEquals(Orientation.S, Orientation.E.major90degrees());
        assertEquals(Orientation.W, Orientation.S.major90degrees());
        assertEquals(Orientation.N, Orientation.W.major90degrees());
    }

}
