package Runecessor;

/**
 * 474 Drawing Area Refactored by Galkon
 **/

public class DrawingArea474 extends DrawingArea {
	public static void drawHorizontalLineWithOpacity(int lineColor, int lineWidth, int yPos, int opacityLevel, int xPos) {//method340
		if (yPos < topY || yPos >= getBottomY())
			return;
		if (xPos < topX) {
			lineWidth -= topX - xPos;
			xPos = topX;
		}
		if (xPos + lineWidth > getBottomX())
			lineWidth = getBottomX() - xPos;
		int j1 = 256 - opacityLevel;
		int k1 = (lineColor >> 16 & 0xff) * opacityLevel;
		int l1 = (lineColor >> 8 & 0xff) * opacityLevel;
		int i2 = (lineColor & 0xff) * opacityLevel;
		int i3 = xPos + yPos * width;
		for (int j3 = 0; j3 < lineWidth; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
			pixels[i3++] = k3;
		}
	}

	static void drawVerticalLineWithOpacity(int color, int xPos, int opacityLevel, int yPos, int lineHeight) {//method342
		if (xPos < topX || xPos >= getBottomX())
			return;
		if (yPos < topY) {
			lineHeight -= topY - yPos;
			yPos = topY;
		}
		if (yPos + lineHeight > getBottomY())
			lineHeight = getBottomY() - yPos;
		int j1 = 256 - opacityLevel;
		int k1 = (color >> 16 & 0xff) * opacityLevel;
		int l1 = (color >> 8 & 0xff) * opacityLevel;
		int i2 = (color & 0xff) * opacityLevel;
		int i3 = xPos + yPos * width;
		for (int j3 = 0; j3 < lineHeight; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
			pixels[i3] = k3;
			i3 += width;
		}
	}

	public static void drawDiagonalLine(int x, int y, int areaWidth, int areaHeight, int color) {// method577
		areaWidth -= x;
		areaHeight -= y;
		if (areaHeight == 0)
			if (areaWidth >= 0) {
				drawHorizontalLine(x, y, areaWidth + 1, color);
				return;
			}
			else {
				drawHorizontalLine(x + areaWidth, y, -areaWidth + 1, color);
				return;
			}
		if (areaWidth == 0)
			if (areaHeight >= 0) {
				drawVerticalLine(x, y, areaHeight + 1, color);
				return;
			}
			else {
				drawVerticalLine(x, y + areaHeight, -areaHeight + 1, color);
				return;
			}
		if (areaWidth + areaHeight < 0) {
			x += areaWidth;
			areaWidth = -areaWidth;
			y += areaHeight;
			areaHeight = -areaHeight;
		}
		if (areaWidth > areaHeight) {
			y <<= 16;
			y += 32768;
			areaHeight <<= 16;
			int j1 = (int) Math.floor((double) areaHeight / (double) areaWidth + 0.5D);
			areaWidth += x;
			if (x < topX) {
				y += j1 * (topX - x);
				x = topX;
			}
			if (areaWidth >= getBottomX())
				areaWidth = getBottomX() - 1;
			for (; x <= areaWidth; x++) {
				int l1 = y >> 16;
				if (l1 >= topY && l1 < getBottomY())
					pixels[x + l1 * width] = color;
				y += j1;
			}
			return;
		}
		x <<= 16;
		x += 32768;
		areaWidth <<= 16;
		int k1 = (int) Math.floor((double) areaWidth / (double) areaHeight + 0.5D);
		areaHeight += y;
		if (y < topY) {
			x += k1 * (topY - y);
			y = topY;
		}
		if (areaHeight >= getBottomY())
			areaHeight = getBottomY() - 1;
		for (; y <= areaHeight; y++) {
			int i2 = x >> 16;
			if (i2 >= topX && i2 < getBottomX())
				pixels[i2 + y * width] = color;
			x += k1;
		}
	}

	public static void drawFilledPixels(int x, int y, int pixelWidth, int pixelHeight, int color) {// method578
		if (x < topX) {
			pixelWidth -= topX - x;
			x = topX;
		}
		if (y < topY) {
			pixelHeight -= topY - y;
			y = topY;
		}
		if (x + pixelWidth > getBottomX())
			pixelWidth = getBottomX() - x;
		if (y + pixelHeight > getBottomY())
			pixelHeight = getBottomY() - y;
		int j1 = width - pixelWidth;
		int k1 = x + y * width;
		for (int l1 = -pixelHeight; l1 < 0; l1++) {
			for (int i2 = -pixelWidth; i2 < 0; i2++)
				pixels[k1++] = color;
			k1 += j1;
		}
	}

	public static void method579() {
		int i = 0;
		int j;
		for (j = width * height - 7; i < j;) {
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
			pixels[i++] = 0;
		}
		for (j += 7; i < j;)
			pixels[i++] = 0;
	}

	public static void drawHorizontalLine(int x, int y, int lineWidth, int color) {// drawHorizontalLine
		if (y < topY || y >= getBottomY())
			return;
		if (x < topX) {
			lineWidth -= topX - x;
			x = topX;
		}
		if (x + lineWidth > getBottomX())
			lineWidth = getBottomX() - x;
		int pixelCount = x + y * width;
		for (int j1 = 0; j1 < lineWidth; j1++)
			pixels[pixelCount + j1] = color;
	}

	public static void drawVerticalLine(int x, int y, int lineHeight, int color) {// drawVerticalLine
		if (x < topX || x >= getBottomX())
			return;
		if (y < topY) {
			lineHeight -= topY - y;
			y = topY;
		}
		if (y + lineHeight > getBottomY())
			lineHeight = getBottomY() - y;
		int pixelCount = x + y * width;
		for (int j1 = 0; j1 < lineHeight; j1++)
			pixels[pixelCount + j1 * width] = color;
	}

	public static void method582() {
		pixels = null;
	}

	public DrawingArea474() {
	}

	public static void drawGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor) {// method583
		int k1 = 0;
		int l1 = 0x10000 / gradientHeight;
		if (x < topX) {
			gradientWidth -= topX - x;
			x = topX;
		}
		if (y < topY) {
			k1 += (topY - y) * l1;
			gradientHeight -= topY - y;
			y = topY;
		}
		if (x + gradientWidth > getBottomX())
			gradientWidth = getBottomX() - x;
		if (y + gradientHeight > getBottomY())
			gradientHeight = getBottomY() - y;
		int i2 = width - gradientWidth;
		int j2 = x + y * width;
		for (int k2 = -gradientHeight; k2 < 0; k2++) {
			int l2 = 0x10000 - k1 >> 8;
			int i3 = k1 >> 8;
			int j3 = ((startColor & 0xff00ff) * l2 + (endColor & 0xff00ff) * i3 & 0xff00ff00) + ((startColor & 0xff00) * l2 + (endColor & 0xff00) * i3 & 0xff0000) >>> 8;
			for (int k3 = -gradientWidth; k3 < 0; k3++)
				pixels[j2++] = j3;
			j2 += i2;
			k1 += l1;
		}
	}

	public static void drawAlphaGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor, int alpha) {
		int k1 = 0;
		int l1 = 0x10000 / gradientHeight;
		if (x < topX) {
			gradientWidth -= topX - x;
			x = topX;
		}
		if (y < topY) {
			k1 += (topY - y) * l1;
			gradientHeight -= topY - y;
			y = topY;
		}
		if (x + gradientWidth > getBottomX())
			gradientWidth = getBottomX() - x;
		if (y + gradientHeight > getBottomY())
			gradientHeight = getBottomY() - y;
		int i2 = width - gradientWidth;
		int result_alpha = 256 - alpha;
		int total_pixels = x + y * width;
		for (int k2 = -gradientHeight; k2 < 0; k2++) {
			int gradient1 = 0x10000 - k1 >> 8;
			int gradient2 = k1 >> 8;
			int gradient_color = ((startColor & 0xff00ff) * gradient1 + (endColor & 0xff00ff) * gradient2 & 0xff00ff00) + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00) * gradient2 & 0xff0000) >>> 8;
			int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
			for (int k3 = -gradientWidth; k3 < 0; k3++) {
				int pixel_pixels = pixels[total_pixels];
				pixel_pixels = ((pixel_pixels & 0xff00ff) * result_alpha >> 8 & 0xff00ff) + ((pixel_pixels & 0xff00) * result_alpha >> 8 & 0xff00);
				pixels[total_pixels++] = color + pixel_pixels;
			}
			total_pixels += i2;
			k1 += l1;
		}
	}

	public static void drawAlphaHorizontalLine(int x, int y, int lineWidth, int color, int alpha) {// drawAlphaHorizontalLine
		if (y < topY || y >= getBottomY())
			return;
		if (x < topX) {
			lineWidth -= topX - x;
			x = topX;
		}
		if (x + lineWidth > getBottomX())
			lineWidth = getBottomX() - x;
		int j1 = 256 - alpha;
		int k1 = (color >> 16 & 0xff) * alpha;
		int l1 = (color >> 8 & 0xff) * alpha;
		int i2 = (color & 0xff) * alpha;
		int i3 = x + y * width;
		for (int j3 = 0; j3 < lineWidth; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
			pixels[i3++] = k3;
		}
	}

	public static void drawAlphaVerticalLine(int x, int y, int lineHeight, int color, int alpha) {// drawAlphaVerticalLine
		if (x < topX || x >= getBottomX())
			return;
		if (y < topY) {
			lineHeight -= topY - y;
			y = topY;
		}
		if (y + lineHeight > getBottomY())
			lineHeight = getBottomY() - y;
		int j1 = 256 - alpha;
		int k1 = (color >> 16 & 0xff) * alpha;
		int l1 = (color >> 8 & 0xff) * alpha;
		int i2 = (color & 0xff) * alpha;
		int i3 = x + y * width;
		for (int j3 = 0; j3 < lineHeight; j3++) {
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
			pixels[i3] = k3;
			i3 += width;
		}
	}

	public static void drawAlphaFilledPixels(int xPos, int yPos, int pixelWidth, int pixelHeight, int color, int alpha) {// method586
		if (xPos < topX) {
			pixelWidth -= topX - xPos;
			xPos = topX;
		}
		if (yPos < topY) {
			pixelHeight -= topY - yPos;
			yPos = topY;
		}
		if (xPos + pixelWidth > getBottomX())
			pixelWidth = getBottomX() - xPos;
		if (yPos + pixelHeight > getBottomY())
			pixelHeight = getBottomY() - yPos;
		color = ((color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((color & 0xff00) * alpha >> 8 & 0xff00);
		int k1 = 256 - alpha;
		int l1 = width - pixelWidth;
		int i2 = xPos + yPos * width;
		for (int j2 = 0; j2 < pixelHeight; j2++) {
			for (int k2 = -pixelWidth; k2 < 0; k2++) {
				int l2 = pixels[i2];
				l2 = ((l2 & 0xff00ff) * k1 >> 8 & 0xff00ff) + ((l2 & 0xff00) * k1 >> 8 & 0xff00);
				pixels[i2++] = color + l2;
			}
			i2 += l1;
		}
	}

	public static void drawRoundedRectangle(int x, int y, int width, int height, int color, int alpha, boolean filled, boolean shadowed) {
		if (shadowed)
			drawRoundedRectangle(x + 1, y + 1, width, height, 0, alpha, filled, false);
		if (alpha == -1) {
			if (filled) {
				drawHorizontalLine(y + 1, color, width - 4, x + 2);// method339
				drawHorizontalLine(y + height - 2, color, width - 4, x + 2);// method339
				drawPixels(height - 4, y + 2, x + 1, color, width - 2);// method336
			}
			drawHorizontalLine(y, color, width - 4, x + 2);// method339
			drawHorizontalLine(y + height - 1, color, width - 4, x + 2);// method339
			drawVerticalLineNew(y + 2, color, height - 4, x);// method341
			drawVerticalLineNew(y + 2, color, height - 4, x + width - 1);// method341
			drawPixels(1, y + 1, x + 1, color, 1);// method336
			drawPixels(1, y + 1, x + width - 2, color, 1);// method336
			drawPixels(1, y + height - 2, x + width - 2, color, 1);// method336
			drawPixels(1, y + height - 2, x + 1, color, 1);// method336
		}
		else if (alpha != -1) {
			if (filled) {
				drawHorizontalLineNew(color, width - 4, y + 1, alpha, x + 2);// method340
				drawHorizontalLineNew(color, width - 4, y + height - 2, alpha, x + 2);// method340
				method335(color, y + 2, width - 2, height - 4, alpha, x + 1);// method335
			}
			drawHorizontalLineNew(color, width - 4, y, alpha, x + 2);// method340
			drawHorizontalLineNew(color, width - 4, y + height - 1, alpha, x + 2);// method340
			drawVerticleLineNew(color, x, alpha, y + 2, height - 4);// method342
			drawVerticleLineNew(color, x + width - 1, alpha, y + 2, height - 4);// method342
			method335(color, y + 1, 1, 1, alpha, x + 1);// method335
			method335(color, y + 1, 1, 1, alpha, x + width - 2);// method335
			method335(color, y + height - 2, 1, 1, alpha, x + 1);// method335
			method335(color, y + height - 2, 1, 1, alpha, x + width - 2);// method335
		}
	}
}
