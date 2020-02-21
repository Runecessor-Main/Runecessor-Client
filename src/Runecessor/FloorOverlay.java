package Runecessor;

public class FloorOverlay {

        public static FloorOverlay[] cache;
        public int ground_texture_overlay = -1;
        public int ground_color_overlay;
        public boolean occlude_overlay;
        public int ground_hue_overlay;
        public int ground_sat_overlay;
        public int ground_lum_overlay;
        public int weighted_hue;
        public int chroma_overlay;
        public int hsl_blended_overlay;
        public int alpha;
        public int detailed_texture;
        public int detailed_color;

        public static void unpackConfig(StreamLoader archiveIndex) {
            ByteBuffer data = new ByteBuffer(DataToolkit.readFile(ClientConstants.getMainCacheLocation() + "/718_cache/flo2.dat"));
            int cacheSize = data.readUnsignedWord();
            cache = new FloorOverlay[cacheSize];
            for (int index = 0; index < cacheSize ; index++) {
                if (cache[index] == null)
                    cache[index] = new FloorOverlay();
                cache[index].readValues(data);
            }
        }

        private void readValues(ByteBuffer data) {
            for(;;) {
                int opcode = data.readUnsignedByte();
                if (opcode == 0)
                    break;
                else if (opcode == 1) {
                    ground_color_overlay = ((data.readUnsignedByte() & 0xff) << 16) + ((data.readUnsignedByte() & 0xff) << 8) + (data.readUnsignedByte() & 0xff);
                    rgbhsl(ground_color_overlay);
                } else if (opcode == 2) {
                    ground_texture_overlay = data.readUnsignedByte() & 0xff;
                } else if (opcode == 3) {
                    ground_texture_overlay = data.readUnsignedWord() & 0xffff;
                    if (ground_texture_overlay == 65535) {
                        ground_texture_overlay = -1;
                    }
                } else if (opcode == 4) {
                    ;
                } else if (opcode == 5) {
                    occlude_overlay = false;
                } else if (opcode == 6) {
                    ;
                } else if (opcode == 7) {
                    detailed_color = ((data.readUnsignedByte() & 0xff) << 16) + ((data.readUnsignedByte() & 0xff) << 8) + (data.readUnsignedByte() & 0xff);
                } else if (opcode == 8) {
                    ;
                } else if (opcode == 9) {
                    detailed_texture = data.readUnsignedWord() & 0xffff;
                } else if (opcode == 10) {
                    ;
                } else if (opcode == 11) {
                    detailed_texture = data.readUnsignedByte() & 0xff;
                } else if (opcode == 12) {
                    ;
                } else if (opcode == 13) {
                    detailed_color = ((data.readUnsignedByte() & 0xff) << 16) + ((data.readUnsignedByte() & 0xff) << 8) + (data.readUnsignedByte() & 0xff);
                } else if (opcode == 14) {
                    detailed_texture = data.readUnsignedByte() & 0xff;
                } else if (opcode == 15) {
                    detailed_texture = data.readUnsignedWord() & 0xffff;
                    if (detailed_texture == 65535) {
                        detailed_texture = -1;
                    }
                } else if (opcode == 16) {
                    alpha = data.readUnsignedByte() & 0xff;
                } else {
                    System.err.println("[opcode: "+opcode+"] floor overlay value missing!");
                }
            }
        }

        private void rgbhsl(int color) {
            double red = (double) (color >> 16 & 0xff) / 255.0;
            double green = (double) (color >> 8 & 0xff) / 255.0;
            double blue = (double) (color & 0xff) / 255.0;
            double min = red;
            if (green < min)
                min = green;
            if (blue < min)
                min = blue;
            double max = red;
            if (green > max)
                max = green;
            if (blue > max)
                max = blue;
            double hue = 0.0;
            double saturation = 0.0;
            double luminance = (min + max) / 2.0;
            if (min != max) {
                if (luminance < 0.5)
                    saturation = (max - min) / (max + min);
                if (luminance >= 0.5)
                    saturation = (max - min) / (2.0 - max - min);
                if (red == max)
                    hue = (green - blue) / (max - min);
                else if (green == max)
                    hue = 2.0 + (blue - red) / (max - min);
                else if (blue == max)
                    hue = 4.0 + (red - green) / (max - min);
            }
            hue /= 6.0;
            ground_hue_overlay = (int) (hue * 255.0);
            ground_sat_overlay = (int) (saturation * 255.0);
            ground_lum_overlay = (int) (luminance * 255.0);
            int hue_overlay = ground_hue_overlay;
            int sat_overlay = ground_sat_overlay;
            int lum_overlay = ground_lum_overlay;
            if (sat_overlay < 0)
                sat_overlay = 0;
            else if (sat_overlay > 255)
                sat_overlay = 255;
            if (lum_overlay < 0)
                lum_overlay = 0;
            else if (lum_overlay > 255)
                lum_overlay = 255;
            if (luminance > 0.5)
                chroma_overlay = (int) ((1.0 - luminance) * saturation * 512.0);
            else
                chroma_overlay = (int) (luminance * saturation * 512.0);
            if (chroma_overlay < 1)
                chroma_overlay = 1;
            weighted_hue = (int) (hue * (double) chroma_overlay);
            int hue_offset = hue_overlay;
            int sat_offset = sat_overlay;
            int lum_offset = lum_overlay;
    /*        if(Config.randomize) {
                hue_offset = (hue_overlay + (int) (Ma`th.random() * 16.0) - 8);
                if (hue_offset < 0)
                    hue_offset = 0;
                else if (hue_offset > 255)
                    hue_offset = 255;
                sat_offset = (sat_overlay + (int) (Math.random() * 48.0) - 24);
                if (sat_offset < 0)
                    sat_offset = 0;
                else if (sat_offset > 255)
                    sat_offset = 255;
                lum_offset = (lum_overlay + (int) (Math.random() * 48.0) - 24);
                if (lum_offset < 0)
                    lum_offset = 0;
                else if (lum_offset > 255)
                    lum_offset = 255;
            }*/
            hsl_blended_overlay = encode(hue_offset, sat_offset, lum_offset);
        }

        private final int encode(int hue, int saturation, int luminance) {
            if (luminance > 179)
                saturation /= 2;
            if (luminance > 192)
                saturation /= 2;
            if (luminance > 217)
                saturation /= 2;
            if (luminance > 243)
                saturation /= 2;
            int color = (hue / 4 << 10) + (saturation / 32 << 7) + luminance / 2;
            return color;
        }



}
