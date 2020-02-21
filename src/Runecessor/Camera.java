package Runecessor;

/**
 * Camera constants/settings.
 *
 * @author Lava, created on 07-01-2016.
 */
public class Camera {

    public static int getCameraSpeed(String axis) {
        for (CameraData data : CameraData.values()) {
            if (Client.cameraSpeed.equals(data.toString())) {
                return axis.equals("X") ? data.getX() : data.getY();
            }
        }
        return 0;
    }


    public static enum CameraData {
        SUPER_SLOW(8, 8),
        SLOW(24, 12),
        MEDIUM(28, 15),
        FAST(32, 18),
        VERY_FAST(36, 21),
        EXTREMELY_FAST(40, 24);

        private int x;

        private int y;


        private CameraData(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
