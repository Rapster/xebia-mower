/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xebia.mower.guice.MotionStrategyModule;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

/**
 *
 * @author Sébastien
 */
public class XebiaMowerSimulatorTest {

    /**
     * Test of run method, of class XebiaMowerSimulator.
     */
    @Test
    public void testRun() {
        String input = "5 5\n"
                + "1 2 N\n"
                + "GAGAGAGAA\n"
                + "3 3 E\n"
                + "AADAADADDA";

        Reader reader = new StringReader(input);
        XebiaConfigurationParser parser = new XebiaConfigurationParser(reader);
        XebiaSimulatorConfiguration conf = parser.parse();
        Injector injector = Guice.createInjector(new MotionStrategyModule());
        XebiaMowerSimulator simulator = injector.getInstance(XebiaMowerSimulator.class);
        simulator.run(conf);
    }

}
