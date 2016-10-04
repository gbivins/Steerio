/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doulos.steerio.examples.launchers;

import org.doulos.steerio.examples.IGameLauncher;
import org.magnos.steer.behavior.SteerAwayExample;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author TheGBiv
 */
@ServiceProvider(service = IGameLauncher.class)
public class SteerAwayExampleLauncher extends AbstractExampleLauncher {

    public SteerAwayExampleLauncher() {
        super(SteerAwayExample::new, "SteerAwayExample");
    }

}
