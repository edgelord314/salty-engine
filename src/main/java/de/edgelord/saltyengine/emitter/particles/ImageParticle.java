/*
 * Copyright 2019 Malte Dostal
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

package de.edgelord.saltyengine.emitter.particles;

import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.emitter.EmitterComponent;
import de.edgelord.saltyengine.emitter.Particle;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.graphics.image.SaltyImage;
import de.edgelord.saltyengine.transform.Dimensions;
import de.edgelord.saltyengine.utils.ImageLoader;

/**
 * An abstract <code>Particle</code> which renders {@link #image} obtained from
 * {@link #getImage()}. It is highly recommended to implement that method like
 * this:
 * <pre>
 *     {@code
 *     public BufferedImage getImage() {
 *
 *         return ImageLoader.getOrLoadImage("dirt-particle", "res/images/particles/dirt.png", SaltySystem.defaultImageFactory);
 *     }
 *     }
 * </pre>
 * <p>
 * The default {@link Dimensions} is {@link #DEFAULT_DIMENSIONS}.
 *
 * @see ImageLoader
 * @see ImageLoader#getOrLoadImage(String, String, ImageFactory)
 */
public abstract class ImageParticle extends Particle {

    public static Dimensions DEFAULT_DIMENSIONS = new Dimensions(10f, 10f);

    private final SaltyImage image;

    /**
     * {@inheritDoc}
     */
    public ImageParticle(final Integer waveNumber, final Integer restLifetime, final Float speed, final EmitterComponent parent) {
        super(waveNumber, restLifetime, speed, parent);

        setDimensions(DEFAULT_DIMENSIONS);
        image = getImage();
    }

    /**
     * @return the image to be rendered by this particle
     */
    public abstract SaltyImage getImage();

    @Override
    public void draw(final SaltyGraphics saltyGraphics) {
        saltyGraphics.drawImage(image, this);
    }
}
