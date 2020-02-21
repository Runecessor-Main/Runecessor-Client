package Runecessor;

import java.nio.ByteBuffer;

public class FloorDefinition {


	public static FloorDefinition[] overlays;

	public static FloorDefinition[] underlays;

	public int texture;

	public int rgb;

	public boolean occlude;

	public int anotherRgb;

	public int hue;

	public int saturation;

	public int lumiance;

	public int anotherHue;

	public int anotherSaturation;

	public int anotherLuminance;

	public int blendHue;

	public int blendHueMultiplier;

	public int hslToRgb;
	public int texture1;

	private FloorDefinition() {
		texture = -1;
		occlude = true;
	}


	public static void unpackConfig634(StreamLoader streamLoader) {
		Stream stream = new Stream(DataToolkit.readFile(ClientConstants.getMainCacheLocation() + "/718_cache/flo.dat"));
		int cacheSize = stream.readUnsignedWord();
		if(underlays == null)
			underlays = new FloorDefinition[cacheSize];
		for(int j = 0; j < cacheSize; j++) {
			try {
				if(underlays[j] == null)
					underlays[j] = new FloorDefinition();
				underlays[j].readValues(stream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("530 Underlay Floors amount: "+cacheSize);
	}

	private void readValues(Stream stream) {
		do {
			int opcode = stream.readUnsignedByte();
			switch(opcode) {
				case 1:
					rgb = stream.read3Bytes();
					method262(rgb, true);
					break;
				case 2:
					texture1 = stream.readUnsignedByte();
					break;
				case 3:
					break;
				case 5:
					occlude = false;
					break;
				case 6:
					stream.readString();
					break;
				case 7:
					int j = hue;
					int k = saturation;
					int l = lumiance;
					int i1 = anotherHue;
					int j1 = stream.read3Bytes();
					hslToRgb = j1;
					method262(j1, true);
					hue = j;
					saturation = k;
					lumiance = l;
					anotherHue = i1;
					blendHueMultiplier = i1;
					break;
				case 0:
					return;
				default:
					System.out.println("Error unrecognised config code: " + opcode);
					break;
			}
		} while(true);
	}

	private void method262(int color, boolean flag) {
		double d = (double)(color >> 16 & 0xff) / 256D;
		double d1 = (double)(color >> 8 & 0xff) / 256D;
		double d2 = (double)(color & 0xff) / 256D;
		double d3 = d;
		if(d1 < d3)
			d3 = d1;
		if(d2 < d3)
			d3 = d2;
		double d4 = d;
		if(d1 > d4)
			d4 = d1;
		if(d2 > d4)
			d4 = d2;
		double d5 = 0.0D;
		double d6 = 0.0D;
		double d7 = (d3 + d4) / 2D;
		if(d3 != d4)
		{
			if(d7 < 0.5D)
				d6 = (d4 - d3) / (d4 + d3);
			if(d7 >= 0.5D)
				d6 = (d4 - d3) / (2D - d4 - d3);
			if(d == d4)
				d5 = (d1 - d2) / (d4 - d3);
			else
			if(d1 == d4)
				d5 = 2D + (d2 - d) / (d4 - d3);
			else
			if(d2 == d4)
				d5 = 4D + (d - d1) / (d4 - d3);
		}
		d5 /= 6D;
		hue = (int)(d5 * 256D);
		saturation = (int)(d6 * 256D);
		lumiance = (int)(d7 * 256D);
		if(saturation < 0)
			saturation = 0;
		else
		if(saturation > 255)
			saturation = 255;
		if(lumiance < 0)
			lumiance = 0;
		else
		if(lumiance > 255)
			lumiance = 255;
		if(d7 > 0.5D)
			blendHueMultiplier = (int)((1.0D - d7) * d6 * 512D);
		else
			blendHueMultiplier = (int)(d7 * d6 * 512D);
		if(blendHueMultiplier < 1)
			blendHueMultiplier = 1;
		anotherHue = (int)(d5 * (double) blendHueMultiplier);
		int hOffset = hue;
		int sOffset = saturation;
		int lOffset = lumiance;
		hslToRgb = method263(hOffset, sOffset, lOffset);
	}

	private int method263(int i, int j, int k) {
		if(k > 179)
			j /= 2;
		if(k > 192)
			j /= 2;
		if(k > 217)
			j /= 2;
		if(k > 243)
			j /= 2;
		return (i / 4 << 10) + (j / 32 << 7) + k / 2;
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		ByteBuffer buffer = ByteBuffer.wrap(streamLoader.getDataForName("flo.dat"));
		int underlayAmount = buffer.getShort();
		underlays = new FloorDefinition[underlayAmount];
		for (int i = 0; i < underlayAmount; i++) {
			if (underlays[i] == null) {
				underlays[i] = new FloorDefinition();
			}
			underlays[i].readValuesUnderlay(buffer);
			underlays[i].generateHsl();
		}
		int overlayAmount = buffer.getShort();
		if (ClientDebugConfiguration.DEBUG_MODE) {
		Utility.print(String.format("Loaded %d underlays", underlayAmount));
		Utility.print(String.format("Loaded %d overlays", overlayAmount));
		}

		overlays = new FloorDefinition[overlayAmount];
		for (int i = 0; i < overlayAmount; i++) {
			if (overlays[i] == null) {
				overlays[i] = new FloorDefinition();
			}
			overlays[i].readValuesOverlay(buffer);
			overlays[i].generateHsl();
		}
	}

	private void generateHsl() {
		if (anotherRgb != -1) {
			rgbToHsl(anotherRgb);
			anotherHue = hue;
			anotherSaturation = saturation;
			anotherLuminance = lumiance;
		}
		rgbToHsl(rgb);
	}

	private void readValuesUnderlay(ByteBuffer buffer) {
		for (;;) {
			int opcode = buffer.get();
			if (opcode == 0) {
				break;
			}
			else if (opcode == 1) {
				rgb = ((buffer.get() & 0xff) << 16) + ((buffer.get() & 0xff) << 8) + (buffer.get() & 0xff);
				if (Client.groundSnow) {
					//Heavy snow (Nearly every brown/green area turns white
					if (this.rgb == 0x35720A || this.rgb == 0x58680B || this.rgb == 0x78680B || this.rgb == 0x6CAC10 || this.rgb == 0x819531 || this.rgb == 0x38562F || this.rgb == 0x276D27 || this.rgb == 0x396215

							|| this.rgb == 0x33501E || this.rgb == 0x64BB75 ||
							//start of browns
							this.rgb == 0x3D2B0B || this.rgb == 0xAC9058 || this.rgb == 0xD9BB93 || this.rgb == 0xB09058 || //
							this.rgb == 0x302020 || this.rgb == 0x604040 || this.rgb == 0x906830 || this.rgb == 0x33501E || //
							this.rgb == 0x64BB75 || this.rgb == 0x604040 || this.rgb == 0x807048 || this.rgb == 0x544828 || //
							this.rgb == 0xB09058 || this.rgb == 0x78680B || this.rgb == 0x858210 || //
							//this.rgb == 0x644E1E || this.rgb == 0x654D0B || this.rgb == 0x664411 || this.rgb == 0x644E1E || //
							this.rgb == 0x654D0B || this.rgb == 0x4B3E14 || this.rgb == 0x5C543C || this.rgb == 0x946B03 || this.rgb == 0xC08048) {
						this.rgb = 0xEdEdEd;
					}

					//Medium snow (Leaves brown colours, only covers greens
					if (this.rgb == 0x35720A || this.rgb == 0x58680B || this.rgb == 0x6CAC10 || this.rgb == 0x38562F || this.rgb == 0x276D27 || this.rgb == 0x396215 || this.rgb == 0x33501E || this.rgb == 0x64BB75) {
						this.rgb = 0xd9d9d9;
					}

					//White edge, patchy frost everywhere else, tried to replicate osrs areas such as varrock and lum.
					if (this.rgb == 0x644E1E || this.rgb == 0x35720A || this.rgb == 0x50680B || this.rgb == 0x78680B || this.rgb == 0x6CAC10 || this.rgb == 0x819531) {
						this.rgb = 0xd9d9d9;
					}

					// Other dark spots in the wilderness.
					if (this.rgb == 0x7A7880 || this.rgb == 0x383830 || this.rgb == 0x282820 || this.rgb == 0x282018 || this.rgb == 0x504840 || this.rgb == 0x484038 || this.rgb == 0x383828 || this.rgb == 0x003838 || this.rgb == 0x303525 || this.rgb == 0x282848 || this.rgb == 0x183018 || this.rgb == 0x4D4D4D || this.rgb == 0x2E2E2E || this.rgb == 0x3D2B0B || this.rgb == 0x030303 || this.rgb == 0x464034 || this.rgb == 0x4B3E14 || this.rgb == 0x2F2B1F || this.rgb == 0x111E1A || this.rgb == 0x333333 || this.rgb == 0x2B2E2D || this.rgb == 0x300000 || this.rgb == 0x3C2823 || this.rgb == 0x404040 || this.rgb == 0x383838 || this.rgb == 0x303030 || this.rgb == 0x282828 || this.rgb == 0x202020 || this.rgb == 0x181818

					) {
						this.rgb = 0xd9d9d9;
					}
					//colours to leave:
					//this.rgb == 0x38562F
				}
				if (Client.lightSnow) {
					//White edge, patchy frost everywhere else, tried to replicate osrs areas such as varrock and lum.
					if (this.rgb == 0x644E1E || this.rgb == 0x35720A || this.rgb == 0x50680B || this.rgb == 0x78680B || this.rgb == 0x6CAC10 || this.rgb == 0x819531) {
						this.rgb = 0xd9d9d9;
					}
				}
			}
			else {
				Utility.print("Error unrecognised underlay code: " + opcode);
			}
		}
	}

	private void readValuesOverlay(ByteBuffer buffer) {
		for (;;) {
			int opcode = buffer.get();
			if (opcode == 0) {
				break;
			}
			else if (opcode == 1) {
				rgb = ((buffer.get() & 0xff) << 16) + ((buffer.get() & 0xff) << 8) + (buffer.get() & 0xff);
			}
			else if (opcode == 2) {
				texture = buffer.get() & 0xff;
				if (Client.movingWater) {
					if (texture == 1) {
						texture = 24;
					}
				}
			}
			else if (opcode == 5) {
				occlude = false;
			}
			else if (opcode == 7) {
				anotherRgb = ((buffer.get() & 0xff) << 16) + ((buffer.get() & 0xff) << 8) + (buffer.get() & 0xff);
			}
			else {
				Utility.print("Error unrecognised overlay code: " + opcode);
			}
		}
	}

	private void rgbToHsl(int rgb) {
		double r = (rgb >> 16 & 0xff) / 256.0;
		double g = (rgb >> 8 & 0xff) / 256.0;
		double b = (rgb & 0xff) / 256.0;
		double min = r;
		if (g < min) {
			min = g;
		}
		if (b < min) {
			min = b;
		}
		double max = r;
		if (g > max) {
			max = g;
		}
		if (b > max) {
			max = b;
		}
		double h = 0.0;
		double s = 0.0;
		double l = (min + max) / 2.0;
		if (min != max) {
			if (l < 0.5) {
				s = (max - min) / (max + min);
			}
			if (l >= 0.5) {
				s = (max - min) / (2.0 - max - min);
			}
			if (r == max) {
				h = (g - b) / (max - min);
			}
			else if (g == max) {
				h = 2.0 + (b - r) / (max - min);
			}
			else if (b == max) {
				h = 4.0 + (r - g) / (max - min);
			}
		}
		h /= 6.0;
		hue = (int) (h * 256.0);
		saturation = (int) (s * 256.0);
		lumiance = (int) (l * 256.0);
		if (saturation < 0) {
			saturation = 0;
		}
		else if (saturation > 255) {
			saturation = 255;
		}
		if (lumiance < 0) {
			lumiance = 0;
		}
		else if (lumiance > 255) {
			lumiance = 255;
		}
		if (l > 0.5) {
			blendHueMultiplier = (int) ((1.0 - l) * s * 512.0);
		}
		else {
			blendHueMultiplier = (int) (l * s * 512.0);
		}
		if (blendHueMultiplier < 1) {
			blendHueMultiplier = 1;
		}
		blendHue = (int) (h * blendHueMultiplier);
		hslToRgb = hslToRgb(hue, saturation, lumiance);
	}

	private final static int hslToRgb(int h, int s, int l) {
		if (l > 179) {
			s /= 2;
		}
		if (l > 192) {
			s /= 2;
		}
		if (l > 217) {
			s /= 2;
		}
		if (l > 243) {
			s /= 2;
		}
		return (h / 4 << 10) + (s / 32 << 7) + l / 2;
	}
}