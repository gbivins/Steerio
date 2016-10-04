/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doulos.steerio.examples.nodes;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Set;
import javax.swing.Action;
import org.doulos.steerio.examples.IGameLauncher;
import org.doulos.steerio.examples.explorer.GameEditorTopComponent;
import org.openide.actions.OpenAction;
import org.openide.cookies.OpenCookie;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author root
 */
public class SteerioExamplesNode extends ChildFactory<IGameLauncher> {

    @Override
    protected boolean createKeys(List<IGameLauncher> list) {
        list.addAll(Lookup.getDefault().lookupAll(IGameLauncher.class));
        return true;
    }

    @Override
    protected Node createNodeForKey(IGameLauncher key) {
        BeanNode node = null;
        try {
            node = new GameLauncherNode(key);
            node.setDisplayName(key.getGameTitle());
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        return node;
    }

    class GameLauncherNode extends BeanNode {

        public GameLauncherNode(IGameLauncher bean) throws IntrospectionException {
            this(bean, new InstanceContent());
        }

        private GameLauncherNode(final IGameLauncher launcher, InstanceContent ic) throws IntrospectionException {
            super(launcher, Children.LEAF, new AbstractLookup(ic));
            ic.add(new OpenCookie() {
                @Override
                public void open() {
                    TopComponent tc = findTopComponent(launcher);
                    if (tc == null) {
                    tc = new GameEditorTopComponent(launcher);
                        tc.open();
                    }
                    tc.requestActive();
                }
            });
            setDisplayName(launcher.getGameTitle());
        }

        private TopComponent findTopComponent(IGameLauncher person) {
            Set<TopComponent> openTopComponents = WindowManager.getDefault()
                    .getRegistry().getOpened();
            for (TopComponent tc : openTopComponents) {
                if (tc.getLookup().lookup(IGameLauncher.class) == person) {
                    return tc;
                }
            }
            return null;
        }

        @Override
        public Action[] getActions(boolean context) {
            return new Action[]{SystemAction.get(OpenAction.class)};
        }

    }

}
