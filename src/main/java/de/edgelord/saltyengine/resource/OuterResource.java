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

package de.edgelord.saltyengine.resource;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.graphics.image.SaltyImage;
import de.edgelord.saltyengine.io.SystemDependentFiles;
import de.edgelord.saltyengine.utils.SaltySystem;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OuterResource implements Resource {

    private final boolean hidden;
    private File sourceDirectory;

    public OuterResource(final boolean hidden) {

        this.hidden = hidden;

        prepareSourceDirectory();

        if (!sourceDirectory.exists()) {
            sourceDirectory.mkdir();
        }
    }

    public void delete() {
        deleteRecursively(sourceDirectory);
    }

    private void deleteRecursively(final File file) {
        final File[] files = file.listFiles();

        if (files != null) {
            for (final File f : files) {
                deleteRecursively(f);
            }
        }
        file.delete();
    }

    @Override
    public SaltyImage getImageResource(final String relativePath) {

        try {
            return SaltySystem.createPreferredImage(getImage(relativePath));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Clip getAudioResource(final String relativePath) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(getFile(relativePath));
        } catch (final UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        return Resource.createClip(audioInputStream);
    }

    @Override
    public File getFileResource(final String relativePath) {
        return getFile(relativePath);
    }

    private void prepareSourceDirectory() {
        if (hidden) {
            sourceDirectory = SystemDependentFiles.getUserFile("." + Game.gameName);
        } else {
            sourceDirectory = SystemDependentFiles.getUserFile(Game.gameName);
        }
    }

    private File getFile(final String relativePath) {
        if (relativePath.startsWith("/")) {
            return new File(sourceDirectory.getAbsolutePath() + relativePath);
        } else {
            return new File(sourceDirectory.getAbsolutePath() + "/" + relativePath);
        }
    }

    public BufferedImage getImage(final String relativePath) throws IOException {
        if (relativePath.startsWith("/")) {
            return ImageIO.read(new File(sourceDirectory.getAbsolutePath() + relativePath));
        } else {
            return ImageIO.read(new File(sourceDirectory.getAbsolutePath() + "/" + relativePath));
        }
    }
}
