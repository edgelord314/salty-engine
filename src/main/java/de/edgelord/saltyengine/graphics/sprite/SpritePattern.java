/*
 * Copyright 2020 Malte Dostal
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.edgelord.saltyengine.graphics.sprite;

import de.edgelord.sanjo.SJClass;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class SpritePattern {

    private final File spritePattern;
    private final HashMap<Integer, Rectangle> pattern = new HashMap<>();

    private Rectangle[][] rectangles;

    public SpritePattern(final File file) {

        spritePattern = file;
    }

    /*
    public void loadPattern() throws Exception {

        final SJClass dataReader = new DataReader(spritePattern);
        List<Integer> currentRectangleData;

        final int sprites;
        int currentIndex = 0;

        final Species spritePattern = dataReader.getMainSpecies();
        final Species pattern = spritePattern.getSubSpecies("pattern");

        sprites = Integer.parseInt(spritePattern.getTagValue("sprites"));

        while (currentIndex != sprites) {

            ++currentIndex;

            currentRectangleData = ValueToListConverter.convertToIntegerList(pattern, "rectangle" + currentIndex, ",");

            this.pattern.put(currentRectangleData.get(4), new Rectangle(currentRectangleData.get(0), currentRectangleData.get(1), currentRectangleData.get(2), currentRectangleData.get(3)));
        }

    }*/

    public Rectangle getRectangle(final int id) {

        return pattern.get(id);
    }
}
