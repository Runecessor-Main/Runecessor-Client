package Runecessor;

import java.awt.*;

public abstract class GraphicsBuffer {

	Image image;

	int width;

	int[] pixels;

	int height;

	float[] depthBuffer;

	abstract void init(Component component, int width, int height, boolean reset);

	abstract void drawGraphics(int y, Graphics graphics, int x);

	protected GraphicsBuffer() {
		/* empty */
	}

	final void initDrawingArea() {
		DrawingArea.initDrawingArea(height, width, pixels, depthBuffer);
	}
}