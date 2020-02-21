package Runecessor;

/**
 * 
 * @author Zion
 *
 */
public class FogHandler {

	public static int fogColour = 0x000000;

	public static int fogEndDistance = 3500;

	public static int fogStartDistance = fogEndDistance - 400;

	/**
	 * Adjust the fog end distance according to camera zoom.
	 */
	public static void adjustFogEndDistance() {
		switch (Client.CameraPos2) {
			case 400:
				fogEndDistance = 2680;
				break;
			case 500:
				fogEndDistance = 2800;
				break;
			case 600:
				fogEndDistance = 3000;
				break;
			case 700:
				fogEndDistance = 3050;
				break;
			case 800:
				fogEndDistance = 3070;
				break;
		}
		fogStartDistance = fogEndDistance - 400;
	}

	public static void forceSmoothShadowAndShading() {
		if (!Client.smoothShading) {
			Client.instance.pushMessage("Smooth textures is required and has been turned on.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			Client.smoothShading = true;
			Settings.saveSettings();
		}
		if (!Client.smoothShadow) {
			Client.instance.pushMessage("Smooth shadows is required and has been turned on.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			Client.smoothShadow = true;
			Settings.saveSettings();
		}
	}

	public static void updateFogColour() {
		switch (Client.fog) {
			case "GREENSCREEN":
				FogHandler.fogColour = 0x00ff00;
				break;
			case "SKY":
				FogHandler.fogColour = 0xc8c7ff;
				break;
			case "DAWN":
				FogHandler.fogColour = 0xffd170;
				break;
			case "NIGHT":
				FogHandler.fogColour = 0x1F1F1F;
				break;
			case "DEFAULT":
				FogHandler.fogColour = 0xC8C0A8;
				break;
			case "OFF WHITE":
				FogHandler.fogColour = 0xC8C0A8;
				break;
			case "OFF BLACK":
				FogHandler.fogColour = 0x000000;
				break;
		}
	}


	public static void renderFog(int[] colorBuffer, float[] depthBuffer) {
		if (Client.fog.equals("OFF BLACK") || Client.fog.equals("OFF WHITE")) {
			return;
		}
		float fogLength = fogEndDistance - fogStartDistance;
		for (int index = 0; index < colorBuffer.length; index++) {
			int relative = (int) ((depthBuffer[index]) - fogStartDistance);
			float factor = relative / fogLength;
			factor = Math.min(1f, Math.max(factor, 0f));
			colorBuffer[index] = mix(colorBuffer[index], fogColour, factor);
		}
	}

	public static int mix(int color, int fogColor, float factor) {
		if (factor >= 1f) {
			return fogColor;
		}
		if (factor <= 0f) {
			return color;
		}
		int aR = (color >> 16) & 0xFF;
		int aG = (color >> 8) & 0xFF;
		int aB = (color) & 0xFF;

		int bR = (fogColor >> 16) & 0xFF;
		int bG = (fogColor >> 8) & 0xFF;
		int bB = (fogColor) & 0xFF;

		int dR = bR - aR;
		int dG = bG - aG;
		int dB = bB - aB;

		int nR = (int) (aR + (dR * factor));
		int nG = (int) (aG + (dG * factor));
		int nB = (int) (aB + (dB * factor));
		return (nR << 16) + (nG << 8) + nB;
	}
}