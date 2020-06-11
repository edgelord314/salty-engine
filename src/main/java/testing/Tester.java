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

package testing;

import de.edgelord.saltyengine.audio.AudioPlayer;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.GameConfig;
import de.edgelord.saltyengine.core.SceneManager;
import de.edgelord.saltyengine.effect.StaticBackgroundTextbox;
import de.edgelord.saltyengine.factory.AudioFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.utils.CheatCodeListener;
import de.edgelord.saltyengine.utils.ColorUtil;
import de.edgelord.saltyengine.utils.SaltySystem;

import java.awt.*;

public class Tester extends Game {

    private static AudioPlayer audioPlayer;

    private static void initGame() {

        init(GameConfig.config(1200f, 900f, "testing", 1L));

        System.out.println("Welcome to Salty Engine v" + SaltySystem.versionTag);

        Tester.audioPlayer = new AudioPlayer(new AudioFactory(new InnerResource()));

        //Tester.audioPlayer.loadNewAudio("joy_sticky", "res/audio/music/Joy Sticky.wav");
        //Tester.audioPlayer.loadNewAudio("bird_flap", "res/audio/sound/flap.wav");

        //Tester.audioPlayer.loop("joy_sticky");

        //audioPlayer.setClipVolume("joy_sticky", 0.75f);

        getHost().setBackgroundColor(Color.lightGray);

        addCheatCodeListener();
    }

    public static void main(final String[] args) {
        initGame();
        start(60);
        serializeOnExit();

        SceneManager.setCurrentScene(new TestingScene());
        // PointLogger.init("points");
        //RectangleCreator.init();

        //SceneFade fadeIn = new SceneFade("fadeIn", SceneFade.Mode.FADE_IN, Color.BLACK);

        //fadeIn.setDuration(3500);
        //fadeIn.fadeInit();
        // Game.getDefaultGFXController().addGFX(fadeIn);
        // Game.getDefaultGFXController().startAll();
        Game.executeLater(() -> {
            System.out.println("hello there! 7500 fixed ticks since the start!");
            SceneManager.setCurrentScene(new StaticBackgroundTextbox("This is a textbox with a static background!\nThis is a newline\f...and this is on a new page!",
                    new Transform(Game.getHost().getHorizontalCentrePosition(500), 750, 500, 100), SceneManager.getCurrentScene())
                    .withBackgroundColor(ColorUtil.WHITE_SMOKE)
                    .withFont(SaltySystem.defaultFont.deriveFont(20f))
                    .withTextColor(ColorUtil.BLACK)
                    .withTextOffsetY(15));
        }, 7500);
    }

    /**
     * Adds a {@link CheatCodeListener} that listens for "exit".
     */
    private static void addCheatCodeListener() {
        final CheatCodeListener cheater = new CheatCodeListener() {
            @Override
            public boolean handleCheatCode(final String cheatcode) {
                if (cheatcode.equals("exit")) {
                    System.exit(0);
                    return true;
                }

                if (cheatcode.equals("gravity")) {
                    for (final GameObject gameObject : SceneManager.getCurrentScene().getGameObjects()) {
                        gameObject.getPhysics().setGravityEnabled(true);
                    }
                    return true;
                }

                return false;
            }
        };
    }

    public static AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }
}
