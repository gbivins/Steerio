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
import org.doulos.steerio.examples.IGameLauncher;
import org.magnos.steer.behavior.SteerArriveExample;
import static org.magnos.steer.behavior.SteerBasicExample.DEFAULT_HEIGHT;
import static org.magnos.steer.behavior.SteerBasicExample.DEFAULT_WIDTH;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author TheGBiv
 */
@ServiceProvider(service = IGameLauncher.class)
public class SteerArriveExampleLauncher extends AbstractExampleLauncher {

    public SteerArriveExampleLauncher() {
        super(SteerArriveExample::new, "SteerArriveExample");
    }
}
