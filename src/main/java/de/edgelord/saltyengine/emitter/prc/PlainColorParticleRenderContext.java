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

package de.edgelord.saltyengine.emitter.prc;

import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.emitter.Particle;
import de.edgelord.saltyengine.emitter.ParticleRenderContext;

import java.awt.*;

/**
 * A {@link ParticleRenderContext} that renders the {@link Particle}s with one
 * color. That color is to be set in the constructor.
 */
public class PlainColorParticleRenderContext extends ParticleRenderContext {

    public PlainColorParticleRenderContext(final Color color) {
        super(color, color, new BasicStroke(5));
    }

    /**
     * Only calls {@link #applyConfiguration(SaltyGraphics)}.
     *
     * @param graphics the graphics to set up.
     */
    @Override
    public void nextParticleRenderConfig(final SaltyGraphics graphics, final Particle subject) {
        applyConfiguration(graphics);
    }
}
