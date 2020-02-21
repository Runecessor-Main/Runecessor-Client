package Runecessor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


/**
 * Created by Jason MacKeigan on 2018-05-25 at 11:33 AM
 */
public class RSAppletPanel extends JPanel implements AncestorListener {

    public RSAppletPanel(String... arguments) {
        setLayout(new BorderLayout());
        setSize(new Dimension(765, 503));
        setPreferredSize(getSize());
        try {
            add(Client.instance = new Client(this, true), BorderLayout.CENTER);
            Client.arguments = arguments;
            Client.getArguments(true); // Must be called before and after
            Client.setClientConfiguration();
            Client.getArguments(false); // Keep here too.
            System.setProperty("java.net.preferIPv4Stack", "true");

            ClientDebugConfiguration.LOCAL_CACHE = Client.ZIP_CLIENT_VERSION ? true : ClientDebugConfiguration.LOCAL_CACHE;
            ClientDebugConfiguration.DOWNLOAD_LATEST_CACHE = Client.ZIP_CLIENT_VERSION ? false : ClientDebugConfiguration.DOWNLOAD_LATEST_CACHE;
            Client.ZIP_CLIENT_VERSION = Client.isLocalCacheClient();

            if (ClientLiveConfiguration.LIVE_GAME) {
                ClientDebugConfiguration.LOCAL_CACHE = false;
            }

            //if (!Client.printToConsole) {
                ErrorStore.setOutputToFile();
            //}

			Utility.print("Applet arguments: " + Arrays.toString(arguments));
            Client.osName = System.getProperty("os.name");
            Game.clientLaunch();
            Settings.loadSettingsJframe();
            addAncestorListener(this);
            addComponentListener(new RSAppletPanelComponentListener());
        } catch (Exception e) {
            throw new RuntimeException("Unable to launch game.");
        }
    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
        if (ClientFrame.frame != null) {
            return;
        }
        Window window = SwingUtilities.getWindowAncestor(event.getAncestor());

        if (window == null) {
            throw new RuntimeException("CRITICAL: Unable to obtain window reference for RSAppletPanel.");
        }

        if (!(window instanceof JFrame)) {
            throw new RuntimeException("CRITICAL: Reference to window is not a JFrame.");
        }
        ClientFrame.frame = (JFrame) window;
        ClientFrame.xInsetLength = ClientFrame.frame.getInsets().left + ClientFrame.frame.getInsets().right;
        ClientFrame.yInsetLength = ClientFrame.frame.getInsets().top + ClientFrame.frame.getInsets().bottom;
        Client.instance.graphics = Client.instance.getGameComponent().getGraphics();
        ClientFrame.frame.addWindowStateListener(new WindowAdapter() {
            public void windowStateChanged(WindowEvent evt) {
				Utility.print("window state changed: " + !Client.loadingGameString().isEmpty());
                if (!Client.loadingGameString().isEmpty()) {
                    int oldState = evt.getOldState();
                    int newState = evt.getNewState();

                    if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0) {
                        Client.clientMaximized = true;
                        Client.clientMaximimzedTime = System.currentTimeMillis();
                        Client.clientFrameSaveNeeded = true;
                        Client.clientMaximizedPreviously = true;
                    }
                    else if ((oldState & Frame.MAXIMIZED_BOTH) != 0 && (newState & Frame.MAXIMIZED_BOTH) == 0) {
                        Client.clientMaximized = false;
                        Client.clientFrameSaveNeeded = true;
                        Client.clientMaximimzedTime = System.currentTimeMillis();
                    }
                }
            }
        });
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {

    }

    @Override
    public void ancestorMoved(AncestorEvent event) {

    }
}
