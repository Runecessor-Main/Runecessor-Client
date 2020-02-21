package Runecessor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;


public class ClientFrame extends Client {

	private static final long serialVersionUID = 747209464164797871L;

	public static JFrame frame;

	public static int xInsetLength, yInsetLength;

	public ClientFrame(String args[], JPanel gamePanel) {
		super(gamePanel, false);
	}

	public ClientFrame(JPanel gamePanel) {
		super(gamePanel, false);
	}

	public void initUI() {
		try {
			Settings.loadSettingsJframe();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame("" + ClientConstants.getServerName() + "");
			frame.setLayout(new BorderLayout());
			setFocusTraversalKeysEnabled(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBackground(Color.black);

		//	getLogo();
			if (fullscreenMode) {
				frame.setUndecorated(true);
			}
			JPanel gamePanel = super.getGamePanel();

			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(763, 501));
			getCursorType();
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			  //Whatever color



			frame.setVisible(true);
			frame.setResizable(false);

			frame.addWindowStateListener(listener);
			ClientFrame.frame.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener() {

				public void ancestorMoved(HierarchyEvent e) {

					clientFrameSaveNeeded = true;
				}

				public void ancestorResized(HierarchyEvent e) {
					if (!Client.loadingGameString().isEmpty()) {
						if (Client.clientWidthSaved != Client.RESIZABLE_WIDTH || Client.clientHeightSaved != Client.RESIZABLE_HEIGHT) {
							if (!Client.isFixedScreenSaved) {
								clientFrameSaveNeeded = true;
							}
						}
					}
					if (Client.maximizable && Client.isFixedScreen()) {
						clientFrameSaveNeeded = true;
					}
				}
			});
			rebuild(false); // To white/yellow/black line bugs on the outside of the client on certain Pcs.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getCursorType() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		switch (isCursor) {

			case 0:
				frame.setCursor(null);
				break;

			case 1:
				Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(ClientConstants.getSpritesLocation() + "cursor/cursor_1.PNG"), new Point(0, 0), "Cursor 1");
				frame.setCursor(cursor);
				break;

			case 2:
				Cursor cursor1 = toolkit.createCustomCursor(toolkit.getImage(ClientConstants.getSpritesLocation() + "cursor/cursor_2.PNG"), new Point(0, 0), "Cursor 2");
				frame.setCursor(cursor1);
				break;

			case 3:
				Cursor cursor2 = toolkit.createCustomCursor(toolkit.getImage(ClientConstants.getSpritesLocation() + "cursor/cursor_3.PNG"), new Point(0, 0), "Cursor 3");
				frame.setCursor(cursor2);
				break;

			case 4:
				Cursor cursor3 = toolkit.createCustomCursor(toolkit.getImage(ClientConstants.getSpritesLocation() + "cursor/cursor_4.PNG"), new Point(0, 0), "Cursor 4");
				frame.setCursor(cursor3);
				break;

			case 5:
				Cursor cursor4 = toolkit.createCustomCursor(toolkit.getImage(ClientConstants.getSpritesLocation() + "cursor/cursor_5.PNG"), new Point(0, 0), "Cursor 5");
				frame.setCursor(cursor4);
				break;
		}

	}

	public URL getCodeBase() {
		try {
			return new URL("http://" + getServerIp() + "/cache");
		}
		catch (Exception e) {
			e.printStackTrace();
			return super.getCodeBase();
		}
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		Utility.print("loadError1: " + s);
	}

	public String getParameter(String key) {
		return "";
	}

	WindowStateListener listener = new WindowAdapter() {
		public void windowStateChanged(WindowEvent evt) {
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

	};

	public void getLogo() {
		frame.setIconImage(new ImageIcon(this.getClass().getResource(
				ClientConstants.getLocalIconImageLocation())).getImage());
	}

	public static void rebuild(boolean logIn) {
		Client.clientIgnoreLocationSave = true;
		// Adding extra numbers to fixed mode because for some odd reason, it gives us a smaller size then what is asked for.
		if (Client.isFixedScreen()) {
			// if os name is windows 7, then use different dimensions
			setPreferredSize();
			frame.setResizable(Client.maximizable);
		}
		else {
			if (Client.fullscreenMode) {
				ClientFrame.frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
			}
			else {
				if (!Client.clientMaximized) {
					frame.setPreferredSize(new Dimension(getClientWidth(), getClientHeight()));
				}
				frame.setResizable(true);
			}
		}
		frame.pack();
		double clientX = Client.isFixedScreen() ? Client.clientFixedLocationX : Client.clientResizedLocationX;
		double clientY = Client.isFixedScreen() ? Client.clientFixedLocationY : Client.clientResizedLocationY;
		if (clientX != -1 && clientY != -1) {
			if (!Client.clientMaximized && !Client.isFixedScreenSaved || Client.isFixedScreen()) {
				if (Client.fullscreenMode) {
					frame.setLocationRelativeTo(null);
				}
				else {
					// First time launching client with no settings saved, new players.
					if (clientX == 0.0 && clientY == 0.0) {
						frame.setLocationRelativeTo(null);
					}
					else {
						//JASON - REMOVED because frame shouldn't reposition after codebase update
						if (ClientLiveConfiguration.LIVE_GAME || Client.isMgt) {
							ClientFrame.frame.setLocation((int) clientX, (int) clientY);
						}
					}
				}
			} else {
				frame.setLocationRelativeTo(null);
			}
		} else {
			frame.setLocationRelativeTo(null);
		}
		Client.clientIgnoreLocationSave = false;
	}

	public static void setPreferredSize() {
		if (Client.maximizable) {
			frame.setPreferredSize(new Dimension(Client.maximizableWidth, Client.maximizableHeight)); // +25 to height on my old laptop.
		}
		else {
			int height = getClientHeight();
			int width = getClientWidth();
			if (!Client.fullscreenMode) {
				height = getClientHeight() + (Client.osName.equals("Windows 7") ? 25 : 29);
				width = getClientWidth() + 6;
			}
			frame.setPreferredSize(new Dimension(width, height)); // +25 to height on my old laptop.
		}
		frame.pack();

	}

}