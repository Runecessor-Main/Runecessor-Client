package Runecessor;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class RSApplet extends Applet implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener, FocusListener, WindowListener, ComponentListener {

	private static final long serialVersionUID = 5272673907779894690L;

	public final void initClientFrame(int i, int j) {
		myWidth = j;
		myHeight = i;
		graphics = getGameComponent().getGraphics();
		fullGameScreen = Client.constructGraphicsBuffer(myWidth, myHeight, getGameComponent());
		startRunnable(this, 1);
	}

	@Override
	public void init() {
		Client.instance.setGraphicsRequiresUpdate(true);
		initClientFrame(503, 765);
	}

	public void run() {
		getGameComponent().addMouseListener(this);
		getGameComponent().addMouseMotionListener(this);
		getGameComponent().addKeyListener(this);
		getGameComponent().addFocusListener(this);
		getGameComponent().addMouseWheelListener(this);
		if (gameFrame != null) {
			gameFrame.addWindowListener(this);
		}
		Load.startUp();
		int i = 0;
		int j = 256;
		int k = 1;
		int i1 = 0;
		int j1 = 0;
		for (int k1 = 0; k1 < 10; k1++) {
			aLongArray7[k1] = System.currentTimeMillis();
		}

		while (anInt4 >= 0) {
			if (anInt4 > 0) {
				anInt4--;
				if (anInt4 == 0) {
					exit();
					return;
				}
			}
			int i2 = j;
			int j2 = k;
			j = 300;
			k = 1;
			long l1 = System.currentTimeMillis();
			if (aLongArray7[i] == 0L) {
				j = i2;
				k = j2;
			}
			else if (l1 > aLongArray7[i]) {
				j = (int) ((long) (2560 * delayTime) / (l1 - aLongArray7[i]));
			}
			if (j < 25) {
				j = 25;
			}
			if (j > 256) {
				j = 256;
				k = (int) ((long) delayTime - (l1 - aLongArray7[i]) / 10L);
			}
			if (k > delayTime) {
				k = delayTime;
			}
			aLongArray7[i] = l1;
			i = (i + 1) % 10;
			if (k > 1) {
				for (int k2 = 0; k2 < 10; k2++) {
					if (aLongArray7[k2] != 0L) {
						aLongArray7[k2] += k;
					}
				}

			}
			if (k < minDelay) {
				k = minDelay;
			}
			try {
				Thread.sleep(k);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				j1++;
			}
			for (; i1 < 256; i1 += j) {
				setClickMode3(clickMode1);
				saveClickX = clickX;
				saveClickY = clickY;
				Client.clickPositionUpdateRequired = false;
				aLong29 = clickTime;
				clickMode1 = 0;
				processGameLoop();
				readIndex = writeIndex;
			}

			i1 &= 0xff;
			if (delayTime > 0) {
				fps = (1000 * j) / (delayTime * 256);
			}
			processDrawing();
			if (shouldDebug) {
				Utility.print("ntime:" + l1);
				for (int l2 = 0; l2 < 10; l2++) {
					int i3 = ((i - l2 - 1) + 20) % 10;
					Utility.print("otim" + i3 + ":" + aLongArray7[i3]);
				}
				Utility.print("fps:" + fps + " ratio:" + j + " count:" + i1);
				Utility.print("del:" + k + " deltime:" + delayTime + " mindel:" + minDelay);
				Utility.print("intex:" + j1 + " opos:" + i);
				shouldDebug = false;
				j1 = 0;
			}
		}
		if (anInt4 == -1) {
			exit();
		}
	}

	private void exit() {
		anInt4 = -2;
		cleanUpForQuit();
		if (gameFrame != null) {
			try {
				Thread.sleep(1000L);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.exit(0);
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public final void method4(int i) {
		delayTime = 1000 / i;
	}

	public final void start() {
		if (anInt4 >= 0) {
			anInt4 = 0;
		}
	}

	public final void stop() {
		if (anInt4 >= 0)
			anInt4 = 4000 / delayTime;
	}

	public final void destroy() {
		anInt4 = -1;
		try {
			Thread.sleep(5000L);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (anInt4 == -1)
			exit();
	}

	public final void update(Graphics g) {
		if (graphics == null) {
			graphics = g;
		}
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void paint(Graphics g) {
		if (graphics == null) {
			graphics = g;
		}
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public boolean mouseWheelDown;

	public final void mousePressed(MouseEvent mouseevent) {
		int x = mouseevent.getX();
		int y = mouseevent.getY();
		if (gameFrame != null) {
			x -= 4; //4
			y -= 22; //22
		}
		idleTime = 0;
		clickX = x;
		clickY = y;
		clickTime = System.currentTimeMillis();
		int type = mouseevent.getButton();
		if (type == 2) {
			mouseWheelDown = true;
			mouseWheelX = x;
			mouseWheelY = y;
			return;
		}
		boolean mouseDown = mouseevent.isMetaDown();
		if (Client.mouseRightClickFix) {
			mouseDown = (mouseevent.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK);
		}
		if (mouseDown) {
			clickMode1 = 2;
			clickMode2 = 2;
		}
		else {
			clickMode1 = 1;
			clickMode2 = 1;
			Client.clickPositionUpdateRequired = true;
		}
	}

	public final void mouseReleased(MouseEvent mouseevent) {
		idleTime = 0;
		clickMode2 = 0;
		Client.hasClicked = false;
		mouseWheelDown = false;
	}

	public final void mouseClicked(MouseEvent mouseevent) {
	}

	public final void mouseEntered(MouseEvent mouseevent) {
	}

	public final void mouseExited(MouseEvent mouseevent) {
		idleTime = 0;
		mouseX = -1;
		mouseY = -1;
	}

	public int mouseWheelX;

	public int mouseWheelY;

	public final void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (gameFrame != null) {
			Insets insets = gameFrame.getInsets();
			x -= insets.left;//4
			y -= insets.top;//22
		}
		if (mouseWheelDown) {
			y = mouseWheelX - e.getX();
			int k = mouseWheelY - e.getY();
			mouseWheelDragged(y, -k);
			mouseWheelX = e.getX();
			mouseWheelY = e.getY();
			return;
		}
		idleTime = 0;
		mouseX = x;
		mouseY = y;
		//clickType = DRAG;
	}


	public void mouseWheelDragged(int param1, int param2) {

	}

	public void mouseWheelMoved(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		handleInterfaceScrolling(event);
		//TODO #FULLSCREEN ADJUST interfaces chat box scrolling via mouse scroll
		int yPosOffset = Client.isFixedScreen() ? 0 : Client.getClientHeight() - Client.getFullscreenModeChatAreaY(541);
		if (mouseX > 0 && mouseX < 512 && mouseY > 338 + yPosOffset && mouseY < 478 + yPosOffset) {
			int scrollPos = Client.chatScrollAmount;
			scrollPos -= rotation * 30;
			if (scrollPos < 0) {
				scrollPos = 0;
			}
			if (scrollPos > Client.chatScrollHeight - 110) {
				scrollPos = Client.chatScrollHeight - 110;
			}
			if (Client.chatScrollAmount != scrollPos) {
				Client.chatScrollAmount = scrollPos;
				Client.setUpdateChatAreaPending(true);
			}
		}

		if (Client.getInterfaceDisplayed() <= 0) {
			// TODO #FULLSCREEN ADJUST, mouse scrolling zoom.
			if (Client.isFixedScreen()) {
				if (Client.instance.mouseX > 0 && Client.instance.mouseX < 516 && Client.instance.mouseY > 0 && Client.instance.mouseY < 338) {

				}
				else {
					return;
				}
			}
			else {
				if (Client.instance.isNotTileClickingArea()) {
					return;
				}
			}
			if (Client.mouseScroll) {
				if (rotation == -1) {
					if (Client.CameraPos2 > (Client.isFixedScreen() ? (ClientDebugConfiguration.DEBUG_MODE ? -300 : 0) : 160)) {
						Client.CameraPos2 -= 40;
						Settings.saveSettings();
					}
				}
				else {
					if (Client.CameraPos2 <= 1075) {
						Client.CameraPos2 += 40;
						Settings.saveSettings();
					}
				}
			}
		}
	}

	public void handleInterfaceScrolling(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		int positionX = 0;
		int positionY = 0;
		int width = 0;
		int height = 0;
		int offsetX = 0;
		int offsetY = 0;
		int childID = 0;
		int tabInterfaceID = Client.tabInterfaceId[Client.getTabId()];

		//TODO #FULLSCREEN ADJUST interface scrolling on inventory tab.
		int mouseX1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(759));
		int mouseY1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(545));
		if (tabInterfaceID != -1) {
			RSInterface tab = RSInterface.interfaceCache[tabInterfaceID];
			if (tab != null) {
				offsetX = 765 - 218;
				offsetY = 503 - 298;
				for (int index = 0; index < tab.children.length; index++) {
					if (RSInterface.interfaceCache[tab.children[index]].scrollMax > 0) {
						childID = index;
						positionX = tab.childX[index];
						positionY = tab.childY[index];
						positionX += mouseX1;
						positionY += mouseY1;
						width = RSInterface.interfaceCache[tab.children[index]].width;
						height = RSInterface.interfaceCache[tab.children[index]].height;
						break;
					}
				}
				if (mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
					RSInterface.interfaceCache[tab.children[childID]].scrollPosition += rotation * 30;
					Client.setTabAreaAltered(true);
				}
			}
		}

		//TODO #FULLSCREEN ADJUST interface scrolling on 3d screen.
		if (Client.getInterfaceDisplayed() != -1) {

			int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
			int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
			RSInterface rsi = RSInterface.interfaceCache[Client.getInterfaceDisplayed()];
			offsetX = 4;
			offsetY = 4;
			if (rsi == null) {
				return;
			}
			for (int index = 0; index < rsi.children.length; index++) {
				if (RSInterface.interfaceCache[rsi.children[index]].scrollMax > 0) {
					childID = index;
					positionX = rsi.childX[index] + x1;
					positionY = rsi.childY[index] + y1;
					width = RSInterface.interfaceCache[rsi.children[index]].width;
					height = RSInterface.interfaceCache[rsi.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
				RSInterface.interfaceCache[rsi.children[childID]].scrollPosition += rotation * 30;
			}

			// Support for 2 use-able scroll bars on same interface, but the width must be both different for it to recognise a second scrollbar.
			int positionX1 = 0;
			for (int index = 0; index < rsi.children.length; index++) {
				if (RSInterface.interfaceCache[rsi.children[index]].scrollMax > 0 && width != RSInterface.interfaceCache[rsi.children[index]].width) {
					childID = index;
					positionX1 = rsi.childX[index] + x1;
					positionY = rsi.childY[index] + y1;
					width = RSInterface.interfaceCache[rsi.children[index]].width;
					height = RSInterface.interfaceCache[rsi.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX1 && mouseY > offsetY + positionY && mouseX < offsetX + positionX1 + width && mouseY < offsetY + positionY + height) {
				RSInterface.interfaceCache[rsi.children[childID]].scrollPosition += rotation * 30;
			}
		}
	}

	public final void mouseMoved(MouseEvent mouseevent) {
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if (gameFrame != null) {
			i -= 4;
			j -= 22;
		}
		idleTime = 0;
		mouseX = i;
		mouseY = j;
	}

	/**
	 * Invoked when the component's size changes.
	 *
	 * @param e
	 */
	@Override
	public void componentResized(ComponentEvent e) {

	}

	/**
	 * Invoked when the component's position changes.
	 *
	 * @param e
	 */
	@Override
	public void componentMoved(ComponentEvent e) {

	}

	/**
	 * Invoked when the component has been made visible.
	 *
	 * @param e
	 */
	@Override
	public void componentShown(ComponentEvent e) {

	}

	/**
	 * Invoked when the component has been made invisible.
	 *
	 * @param e
	 */
	@Override
	public void componentHidden(ComponentEvent e) {

	}

	public static enum HotKeyData {
		F1(KeyEvent.VK_F1),
		F2(KeyEvent.VK_F2),
		F3(KeyEvent.VK_F3),
		F4(KeyEvent.VK_F4),
		F5(KeyEvent.VK_F5),
		F6(KeyEvent.VK_F6),
		F7(KeyEvent.VK_F7),
		F8(KeyEvent.VK_F8),
		F9(KeyEvent.VK_F9),
		F10(KeyEvent.VK_F10),
		F11(KeyEvent.VK_F11),
		F12(KeyEvent.VK_F12),
		ESC(KeyEvent.VK_ESCAPE);

		private int hotKeyId;


		private HotKeyData(int hotKeyId) {
			this.hotKeyId = hotKeyId;
		}

		public int getHotKeyId() {
			return hotKeyId;
		}
	}

	public final void keyPressed(KeyEvent keyevent) {
		idleTime = 0;
		int keyPressed = keyevent.getKeyCode();
		int j = keyevent.getKeyChar();
		if (keyevent.isShiftDown()) {
			Client.shiftIsDown = true;
		}
		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			Utility.print("keyPressed: " + keyPressed);
		}
		if (Client.combatTabFKey == keyPressed) {
			Client.setTabId(0, false); // Combat interface
		}
		else if (Client.equipmentTabFKey == keyPressed) {
			Client.setTabId(4, false); // Equipment
		}
		else if (Client.inventoryTabFKey == keyPressed) {
			Client.setTabId(3, false); // Inventory
		}
		else if (Client.magicTabFKey == keyPressed) {
			Client.setTabId(6, false); // Magic
		}
		else if (Client.prayerTabFKey == keyPressed) {
			Client.setTabId(5, false); // Prayer
		}
		else if (Client.screenshotFKey == keyPressed) {
			new Thread(new Screenshot("", "" + ClientConstants.getServerName().toLowerCase() + "_screenshots")).start();
		}


		// Escape key
		else if (keyPressed == 27) {
			Client.closeAllInterfaces();
			Client.instance.clearTopInterfaces();
		}
		if (j < 30)
			j = 0;
		if (keyPressed == 37)
			j = 1;
		if (keyPressed == 39)
			j = 2;
		if (keyPressed == 38)
			j = 3;
		if (keyPressed == 40)
			j = 4;
		if (keyPressed == 17)
			j = 5;
		if (keyPressed == 8)
			j = 8;
		if (keyPressed == 127)
			j = 8;
		if (keyPressed == 9)
			j = 9;
		if (keyPressed == 10)
			j = 10;
		if (keyPressed >= 112 && keyPressed <= 123)
			j = (1008 + keyPressed) - 112;
		if (keyPressed == 36)
			j = 1000;
		if (keyPressed == 35)
			j = 1001;
		if (keyPressed == 33)
			j = 1002;
		if (keyPressed == 34)
			j = 1003;
		if (j > 0 && j < 128)
			keyArray[j] = 1;
		if (j > 4) {
			charQueue[writeIndex] = j;
			writeIndex = writeIndex + 1 & 0x7f;
		}
	}

	public final void keyReleased(KeyEvent keyevent) {
		idleTime = 0;
		int i = keyevent.getKeyCode();
		char c = keyevent.getKeyChar();
		if (c < '\036')
			c = '\0';
		if (i == 37)
			c = '\001';
		if (i == 39)
			c = '\002';
		if (i == 38)
			c = '\003';
		if (i == 40)
			c = '\004';
		if (i == 17)
			c = '\005';
		if (i == 8)
			c = '\b';
		if (i == 127)
			c = '\b';
		if (i == 9)
			c = '\t';
		if (i == 10)
			c = '\n';
		if (c > 0 && c < '\200')
			keyArray[c] = 0;

		if (i == KeyEvent.VK_SHIFT) {
			Client.shiftIsDown = false;
		}
	}

	public final void keyTyped(KeyEvent keyevent) {
	}

	public final int readChar(int dummy) {
		while (dummy >= 0) {
			for (int j = 1; j > 0; j++)
				;
		}
		int k = -1;
		if (writeIndex != readIndex) {
			k = charQueue[readIndex];
			readIndex = readIndex + 1 & 0x7f;
		}
		return k;
	}

	public final void focusGained(FocusEvent focusevent) {
		awtFocus = true;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void focusLost(FocusEvent focusevent) {
		awtFocus = false;
		for (int i = 0; i < 128; i++)
		{
			keyArray[i] = 0;
		}
		Client.shiftIsDown = false;
	}

	public final void windowActivated(WindowEvent windowevent) {
	}

	public final void windowClosed(WindowEvent windowevent) {
	}

	public final void windowClosing(WindowEvent windowevent) {
		destroy();
	}

	public final void windowDeactivated(WindowEvent windowevent) {
	}

	public final void windowDeiconified(WindowEvent windowevent) {
	}

	public final void windowIconified(WindowEvent windowevent) {
	}

	public final void windowOpened(WindowEvent windowevent) {
	}

	public void startUp() {
	}

	public void processGameLoop() {
	}

	public void cleanUpForQuit() {
	}

	public void processDrawing() {
	}

	public void raiseWelcomeScreen() {
	}

	public Component getGameComponent() {
		if (gameFrame != null)
			return gameFrame;
		else
			return this;
	}

	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}

	public void drawLoadingText(int i, String s) {
		while (graphics == null) {
			graphics = getGameComponent().getGraphics();
			try {
				getGameComponent().repaint();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000L);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		Font font = new Font("Arial", 1, 13);
		Font font1 = new Font("Arial", 0, 13);
		getGameComponent().getFontMetrics(font1);
		if (shouldClearScreen && Load.finishedLoading) {
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, myWidth, myHeight);
			Client.showSelectDataImages = true;
		}
		graphics.setColor(Color.black);
		graphics.fillRect(0, 479, 765, 53); // The black rectangle.
		graphics.setColor(Client.loadingBarColour);
		graphics.fillRect(0, 479, i * 3, myHeight);
		graphics.setColor(Color.black);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		int length = s.length() * 3;
		if (s.contains("...")) {
			length -= 5;
		}
		graphics.drawString(s, 374 - length, 495);
	}

	public RSApplet() {
		delayTime = 20;
		minDelay = 1;
		aLongArray7 = new long[10];
		shouldDebug = false;
		shouldClearScreen = true;
		awtFocus = true;
		keyArray = new int[128];
		charQueue = new int[128];
	}

	public int getClickMode3() {
		return clickMode3;
	}

	public void setClickMode3(int clickMode3) {
		this.clickMode3 = clickMode3;
	}

	private int anInt4;

	private int delayTime;

	int minDelay;

	private final long[] aLongArray7;

	public int fps;

	boolean shouldDebug;

	public int myWidth;

	public int myHeight;

	public Graphics graphics;

	public GraphicsBuffer fullGameScreen;

	public JFrame gameFrame;

	public static boolean shouldClearScreen;

	public boolean awtFocus;

	public int idleTime;

	public int clickMode2;

	public int mouseX;

	public int mouseY;

	private int clickMode1;

	public static int clickX;

	public static int clickY;

	private long clickTime;

	private int clickMode3;

	public int saveClickX;

	public int saveClickY;

	public long aLong29;

	public final int[] keyArray;

	private final int[] charQueue;

	private int readIndex;

	private int writeIndex;

	public static int anInt34;
}