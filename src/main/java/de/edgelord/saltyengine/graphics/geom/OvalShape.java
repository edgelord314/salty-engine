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

package de.edgelord.saltyengine.graphics.geom;

import de.edgelord.saltyengine.core.annotations.DefaultPlacement;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.interfaces.TransformedObject;
import de.edgelord.saltyengine.transform.Dimensions;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.Vector2f;

@DefaultPlacement(method = DefaultPlacement.Method.TOP_LEFT_CORNER)
public class OvalShape extends SaltyShape {
    public OvalShape(final Transform transform) {
        super(transform, EnumShape.OVAL);
    }

    public OvalShape(final Vector2f position, final Dimensions dimensions) {
        super(position, dimensions, EnumShape.OVAL);
    }

    public OvalShape(final TransformedObject parent) {
        super(parent, EnumShape.OVAL);
    }

    public OvalShape(final float x, final float y, final float width, final float height) {
        super(x, y, width, height, EnumShape.OVAL);
    }

    @Override
    public void draw(final SaltyGraphics saltyGraphics) {
        if (isFilled()) {
            saltyGraphics.drawOval(this);
        } else {
            saltyGraphics.outlineOval(this);
        }
    }
}
