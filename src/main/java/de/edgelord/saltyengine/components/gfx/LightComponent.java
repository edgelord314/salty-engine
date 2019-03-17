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

package de.edgelord.saltyengine.components.gfx;

import de.edgelord.saltyengine.core.annotations.DefaultPlacement;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.stereotypes.ComponentContainer;
import de.edgelord.saltyengine.effect.light.Light;
import de.edgelord.saltyengine.effect.light.LightSystem;
import de.edgelord.saltyengine.effect.light.PointLight;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.TransformRelationMode;
import de.edgelord.saltyengine.utils.TransformRelationUtil;

/**
 * This {@link de.edgelord.saltyengine.core.Component} makes a {@link Light} follow its parent using the rule
 * described in {@link #relationToParent} and {@link TransformRelationUtil}.
 * The light and the mode can be set in one of the constructors, if not the defaults are:
 * {@code TransformRelationMode.CENTRE}
 * and
 * {@code new PointLight(parent.getTransform())}
 */
@DefaultPlacement(method = DefaultPlacement.Method.TRANSFORM_RELATION)
public class LightComponent extends GFXComponent {

    private TransformRelationMode relationToParent;
    private Light light;

    public LightComponent(ComponentContainer parent, String name, TransformRelationMode relationToParent, Light light) {
        super(parent, name);

        this.light = light;
        this.relationToParent = relationToParent;

        addToLightSystem();
    }

    public LightComponent(ComponentContainer parent, String name, Light light) {
        this(parent, name, TransformRelationMode.CENTRE, light);
    }

    public LightComponent(ComponentContainer parent, String name, TransformRelationMode relationToParent) {
        this(parent, name, relationToParent, new PointLight(parent.getTransform()));
    }

    public LightComponent(ComponentContainer parent, String name) {
        this(parent, name, TransformRelationMode.CENTRE, new PointLight((Transform) parent.getTransform().clone()));
    }

    @Override
    public void draw(SaltyGraphics saltyGraphics) {
    }

    @Override
    public void onFixedTick() {
        TransformRelationUtil.positionRelativeTo(relationToParent, getParent().getTransform(), light.getTransform());
    }

    private void addToLightSystem() {
        LightSystem currentLightSystem = SceneManager.getCurrentScene().getLightSystem();

        if (currentLightSystem == null) {
            throw new NullPointerException("Can't add a LightComponent when the current scene has no LightSystem! Set one by using Scene#setLightSystem!");
        }

        currentLightSystem.addLight(light);
    }

    public TransformRelationMode getRelationToParent() {
        return relationToParent;
    }

    public void setRelationToParent(TransformRelationMode relationToParent) {
        this.relationToParent = relationToParent;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }
}
