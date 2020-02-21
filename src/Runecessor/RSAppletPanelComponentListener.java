package Runecessor;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

/**
 * Created by Jason MacKeigan on 2018-05-29 at 1:54 PM
 */
public class RSAppletPanelComponentListener extends ComponentAdapter {

    @Override
    public void componentResized(ComponentEvent e) {
        super.componentResized(e);

        Client instance = Client.instance;

        if (instance == null) {
            return;
        }
        JFrame frame = ClientFrame.frame;

        if (frame == null) {
            return;
        }
//        JPanel panel = Client.instance.getGamePanel();
//
//        Dimension size = new Dimension(e.getComponent().getSize());
//
//        size.width -= frame.getInsets().left + frame.getInsets().right;
//        size.height -= frame.getInsets().top + frame.getInsets().bottom;
//
//        panel.setSize(e.getComponent().getSize());
//        panel.setPreferredSize(e.getComponent().getSize());
//
//        Client.instance.setGraphicsRequiresUpdate(true);
//        Client.clientFrameSaveNeeded = true;
		//        Utility.print("Resized to: " + panel.getSize());
    }
}
