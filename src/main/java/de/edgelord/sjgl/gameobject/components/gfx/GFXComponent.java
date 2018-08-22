/*
 * Copyright (c) by Malte Dostal
 * Germany, 8.2018
 * All rights reserved
 */

package de.edgelord.sjgl.gameobject.components.gfx;

import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.GameObjectComponent;

/**
 * This abstract <code>GameObjectComponent</code> describes a
 * graphical effect for a <code>GameObject</code>.
 * These <code>GameObjectComponents</code> are disabled by default
 * and need to be enabled using the <code>startGFX()</code> method for
 * the graphical effect to effect the <code>GameObject</code>.
 */
public abstract class GFXComponent extends GameObjectComponent {

    public GFXComponent(GameObject parent, String name) {
        super(parent, name, GFX_COMPONENT);

        disable();
    }

    public void startGFX() {
        enable();
    }

    public void endGFX() {
        disable();
    }
}
