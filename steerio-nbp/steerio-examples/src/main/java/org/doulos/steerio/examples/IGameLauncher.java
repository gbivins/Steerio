/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doulos.steerio.examples;

import com.gameprogblog.engine.GameScreen;
import java.awt.Color;

/**
 *
 * @author TheGBiv
 */
public interface IGameLauncher {

    public GameScreen createGame(int width, int height, boolean antialiasing, Color background);

    public String getGameTitle();

    default public String getCategory() {
        return "Default";
    }
}
