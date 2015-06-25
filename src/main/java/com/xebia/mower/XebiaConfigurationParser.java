/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Orientation;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author Sébastien
 */
public class XebiaConfigurationParser {

    private final Reader reader;

    private int i = 0;

    public XebiaConfigurationParser(Reader reader) {
        this.reader = reader;
    }

    public XebiaSimulatorConfiguration parse() throws IllegalArgumentException {
        Scanner scanner = new Scanner(reader);
        XebiaSimulatorConfiguration conf = new XebiaSimulatorConfiguration();
        XebiaMowerInstruction lastMowerConf = null;

        while (scanner.hasNextLine()) {
            if (isRightTopCornerDefinition()) {
                conf.setXTopRightCorner(scanner.nextInt());
                conf.setYTopRightCorner(scanner.nextInt());
            } else if (isMowerPosition()) {
                lastMowerConf = new XebiaMowerInstruction();
                lastMowerConf.setXStartPosition(scanner.nextInt());
                lastMowerConf.setYStartPosition(scanner.nextInt());
                lastMowerConf.setOrientation(Orientation.valueOf(scanner.next()));
            } else if (isMowerInstructions()) {
                char[] instructions = scanner.next().toCharArray();
                lastMowerConf.setInstructions(instructions);
                conf.getMowerConfigurations().add(lastMowerConf);
            }
            i++;
        }
        return conf;
    }

    public boolean isRightTopCornerDefinition() {
        return i == 0;
    }

    public boolean isMowerPosition() {
        return !isRightTopCornerDefinition() && i % 2 != 0;
    }

    public boolean isMowerInstructions() {
        return !isRightTopCornerDefinition() && i % 2 == 0;
    }
}
