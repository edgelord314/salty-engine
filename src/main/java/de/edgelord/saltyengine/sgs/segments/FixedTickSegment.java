/*
 * Copyright (c) by Malte Dostal
 * Germany, 8.2018
 * All rights reserved
 */

package de.edgelord.saltyengine.sgs.segments;

import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.sgs.ScriptSegment;

public class FixedTickSegment extends ScriptSegment {
    /**
     * The standard constructor with all necessary parameters
     *
     * @param content the complete content of the segment
     */
    public FixedTickSegment(String content) {
        super(content, Type.onFixedTick);
    }

    @Override
    public void interpret(GameObject parent) {

    }
}