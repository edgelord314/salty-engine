/*
 * Copyright 2018 Malte Dostal
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

package de.edgelord.saltyengine.ui.elements;

import de.edgelord.saltyengine.core.annotations.DefaultPlacement;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.Vector2f;

@DefaultPlacement(method = DefaultPlacement.Method.TOP_LEFT_CORNER)
public class RoundedTextBox extends TextBox {

    private float arc = 15f;

    public RoundedTextBox(final String text, final float x, final float y, final float width, final float height, final float offsetX, final float offsetY) {
        this(text, new Transform(x, y, width, height), new Vector2f(offsetX, offsetY));
    }

    public RoundedTextBox(final String text, final Transform transform, final Vector2f offset) {
        super(text, transform, offset.getX(), offset.getY());
    }

    @Override
    public void drawBackground(final SaltyGraphics graphics) {
        graphics.drawRoundRect(this, arc);
    }

    public float getArc() {
        return arc;
    }

    public void setArc(final float arc) {
        this.arc = arc;
    }
}
