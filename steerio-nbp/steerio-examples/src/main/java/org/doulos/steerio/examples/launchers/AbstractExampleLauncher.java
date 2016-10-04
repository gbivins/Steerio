/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doulos.steerio.examples.launchers;

import com.gameprogblog.engine.Game;
import com.gameprogblog.engine.GameLoop;
import com.gameprogblog.engine.GameLoopVariable;
import com.gameprogblog.engine.GameScreen;
import java.awt.Color;
import java.util.function.BiFunction;
import org.doulos.steerio.examples.IGameLauncher;
import org.magnos.steer.behavior.SteerArriveExample;
import static org.magnos.steer.behavior.SteerBasicExample.DEFAULT_HEIGHT;
import static org.magnos.steer.behavior.SteerBasicExample.DEFAULT_WIDTH;

/**
 *
 * @author root
 */
abstract public class AbstractExampleLauncher implements IGameLauncher {

    final private BiFunction<Integer, Integer, Game> exampleConstructor;
    final private String title;

    protected AbstractExampleLauncher(BiFunction<Integer, Integer, Game> factory, String exampleTitle) {
        exampleConstructor = factory;
        title = exampleTitle;
    }

    @Override
    public GameScreen createGame(int width, int height, boolean antialiasing, Color background) {
        Game game = exampleConstructor.apply(width, height);
        GameLoop loop = new GameLoopVariable(0.1f);
        GameScreen screen = new GameScreen(width, height, true, loop, game);
        screen.setBackground(background);
        return screen;
    }

    @Override
    public String getGameTitle() {
        return title;
    }

}
