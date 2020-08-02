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

package de.edgelord.saltyengine.components;

import de.edgelord.saltyengine.core.annotations.DefaultPlacement;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.stereotypes.ComponentContainer;
import de.edgelord.saltyengine.input.Input;
import de.edgelord.saltyengine.transform.TransformRelationMode;
import de.edgelord.saltyengine.utils.TransformRelationUtil;

@DefaultPlacement(method = DefaultPlacement.Method.TRANSFORM_RELATION)
public class MoveWithCursorComponent extends Component {

    private final TransformRelationMode relation;

    public MoveWithCursorComponent(final ComponentContainer parent, final String name, final TransformRelationMode relation) {
        super(parent, name, Components.GAME_COMPONENT);

        this.relation = relation;
    }

    @Override
    public void draw(final SaltyGraphics saltyGraphics) {

    }

    @Override
    public void onFixedTick() {

        TransformRelationUtil.positionRelativeTo(relation, Input.getCursor(), getParent().getTransform());
    }

    @Override
    public void onCollision(final CollisionEvent e) {

    }
}
