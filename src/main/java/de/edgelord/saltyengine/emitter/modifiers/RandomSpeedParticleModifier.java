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

package de.edgelord.saltyengine.emitter.modifiers;

import de.edgelord.saltyengine.emitter.Particle;
import de.edgelord.saltyengine.emitter.ParticleModifier;
import de.edgelord.saltyengine.utils.GeneralUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of {@link ParticleModifier}
 * that applies a random speed to each {@link
 * Particle}. The random speed is between {@link
 * #minSpeed} and {@link #maxSpeed} and gets, due
 * to integer precision, multiplied by {@link
 * #factor}.
 * <p>
 * If {@link #newSpeedEachTick} is true, all
 * Particle will get a new random speed, if it is
 * <code>false</code>, each particle will only
 * get
 * a random speed once.
 */
public class RandomSpeedParticleModifier implements ParticleModifier {

    /**
     * If this is <code>true</code>, each {@link
     * Particle} gets a new random speed every
     * fixed tick, if it is
     * <code>false</code>, every {@link Particle}
     * will only get a random speed once.
     */
    private final boolean newSpeedEachTick;
    /**
     * The internally used list to store particles
     * that were already served.
     */
    private final List<Particle> alreadySet = new LinkedList<>();
    /**
     * The minimum speed that is randomly
     * generated.
     */
    private int minSpeed;
    /**
     * The maximum speed that is randomly
     * generated.
     */
    private int maxSpeed;
    /**
     * The factory by which the randomly generated
     * speed is multiplied.
     */
    private float factor;

    /**
     * the constructor.
     *
     * @param minSpeed         the minimum speed
     * @param maxSpeed         the maximum speed
     * @param factor           the factory by
     *                         which each randomly
     *                         generated speed is
     *                         multiplied
     * @param newSpeedEachTick whether or not to
     *                         generate a random
     *                         speed for a {@link
     *                         Particle} all over
     *                         again.
     */
    public RandomSpeedParticleModifier(final int minSpeed, final int maxSpeed, final float factor, final boolean newSpeedEachTick) {
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.factor = factor;
        this.newSpeedEachTick = newSpeedEachTick;
    }

    @Override
    public void modifyParticle(final Particle particle) {

        if (newSpeedEachTick) {
            particle.setSpeed(GeneralUtil.randomInt(minSpeed, maxSpeed) * factor);
        } else {
            if (!alreadySet.contains(particle)) {
                particle.setSpeed(GeneralUtil.randomInt(minSpeed, maxSpeed) * factor);
            }
        }
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(final int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(final int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(final float factor) {
        this.factor = factor;
    }
}
