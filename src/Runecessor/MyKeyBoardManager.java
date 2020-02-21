package Runecessor;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

public class MyKeyBoardManager extends DefaultKeyboardFocusManager {

	private AWTEventListener listener;



	public MyKeyBoardManager(AWTEventListener listener) {

		this.listener = listener;

	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED || e.getID() == KeyEvent.KEY_RELEASED || e.getID() == KeyEvent.KEY_TYPED) {

			listener.eventDispatched(e);

			return true;

		}

		return super.dispatchKeyEvent(e);

	}

}
