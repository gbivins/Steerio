/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doulos.steerio.examples.explorer;

import java.awt.BorderLayout;
import org.doulos.steerio.examples.nodes.SteerioExamplesNode;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.doulos.steerio.examples.explorer//SteerioExample//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SteerioExampleTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.doulos.steerio.examples.explorer.SteerioExampleTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SteerioExampleAction",
        preferredID = "SteerioExampleTopComponent"
)
@Messages({
    "CTL_SteerioExampleAction=SteerioExample",
    "CTL_SteerioExampleTopComponent=SteerioExample Window",
    "HINT_SteerioExampleTopComponent=This is a SteerioExample window"
})
public final class SteerioExampleTopComponent extends TopComponent implements ExplorerManager.Provider {

    private final ExplorerManager em;

    public SteerioExampleTopComponent() {
        this.em = new ExplorerManager();

        setLayout(new BorderLayout());
        add(new BeanTreeView(), BorderLayout.CENTER);
        Children kids = Children.create(new SteerioExamplesNode(), true);
        AbstractNode rootNode = new AbstractNode(kids);
        em.setRootContext(rootNode);
        associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
        setName(Bundle.CTL_SteerioExampleTopComponent());
        setToolTipText(Bundle.HINT_SteerioExampleTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
}