/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Orientation;
import com.xebia.mower.XebiaSimulatorConfiguration.XebiaMowerConfiguration;
import java.io.Reader;
import java.io.StringReader;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
/**
 *
 * @author Sébastien
 */
@RunWith(MockitoJUnitRunner.class)
public class XebiaConfigurationParserTest {

    /**
     * Test of parse method, of class XebiaConfigurationParser.
     */
    @Test
    public void testParseOK() {
        String input = "5 5\n"
                + "1 2 N\n"
                + "GAGAGAGAA\n"
                + "3 3 E\n"
                + "AADAADADDA";

        Reader reader = new StringReader(input);
        XebiaConfigurationParser parser = new XebiaConfigurationParser(reader);

        XebiaSimulatorConfiguration conf = parser.parse();
        assertEquals(5, conf.getXTopRightCorner());
        assertEquals(5, conf.getYTopRightCorner());
        assertEquals(2, conf.getMowerConfigurations().size());

        XebiaMowerConfiguration mower1 = conf.getMowerConfigurations().get(0);
        assertEquals(1, mower1.getXStartPosition());
        assertEquals(2, mower1.getYStartPosition());

        assertEquals(Orientation.N, mower1.getOrientation());
        assertEquals("GAGAGAGAA", String.valueOf(mower1.getInstructions()));

        XebiaMowerConfiguration mower2 = conf.getMowerConfigurations().get(1);
        assertEquals(3, mower2.getXStartPosition());
        assertEquals(3, mower2.getYStartPosition());
        assertEquals(Orientation.E, mower2.getOrientation());
        assertEquals("AADAADADDA", String.valueOf(mower2.getInstructions()));

    }

    /**
     * Test of parse method, of class XebiaConfigurationParser.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParseFailDueToBadOrientation() {
        String input = "5 5\n"
                + "1 2 B\n"
                + "GAGAGAGAA\n";

        Reader reader = new StringReader(input);
        XebiaConfigurationParser parser = new XebiaConfigurationParser(reader);
        XebiaSimulatorConfiguration conf = parser.parse();
        assertNull(conf);
    }
    
        /**
     * Test of parse method, of class XebiaConfigurationParser.
     */
    @Test(expected = NoSuchElementException.class)
    public void testParseFailDueToMissingLine() {
        String input = "5 5\n"
                + "1 2 E\n";

        Reader reader = new StringReader(input);
        XebiaConfigurationParser parser = new XebiaConfigurationParser(reader);
        XebiaSimulatorConfiguration conf = parser.parse();
        assertNull(conf);
    }
}
