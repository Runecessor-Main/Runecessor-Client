package Runecessor;

import java.awt.*;
import java.awt.image.*;

final class GraphicsBufferProducing extends GraphicsBuffer implements ImageProducer, ImageObserver {

	private ColorModel colorModel;

	private ImageConsumer imageConsumer;

	public final synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (imageConsumer == imageconsumer)
			imageConsumer = null;
	}

	public final boolean imageUpdate(Image image, int i, int i_0_, int i_1_, int i_2_, int i_3_) {
		return true;
	}

	final void init(Component component, int w, int h, boolean reset) {
		width = w;
		height = h;
		pixels = new int[h * w + 1];
		depthBuffer = new float[h * w + 1];
		colorModel = new DirectColorModel(32, 16711680, 65280, 255);
		image = component.createImage(this);
		setPixels();
		if (reset)
			startProduction(null);
		component.prepareImage(image, this);
		setPixels();
		component.prepareImage(image, this);
		setPixels();
		component.prepareImage(image, this);
		initDrawingArea();
	}

	public final void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}

	private final synchronized void setPixels() {
		if (imageConsumer != null) {
			imageConsumer.setPixels(0, 0, width, height, colorModel, pixels, 0, width);
			imageConsumer.imageComplete(2);
		}
	}

	public final synchronized void addConsumer(ImageConsumer imageconsumer) {
		imageConsumer = imageconsumer;
		imageconsumer.setDimensions(width, height);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(colorModel);
		imageconsumer.setHints(14);
	}

	public final void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		/* empty */
	}

	final void drawGraphics(int y, Graphics graphics, int x) {
		setPixels();
		graphics.drawImage(image, x, y, this);
	}

	public final synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		if (imageconsumer != imageConsumer)
			return false;
		return true;
	}

	public GraphicsBufferProducing() {
		/* empty */
	}
}