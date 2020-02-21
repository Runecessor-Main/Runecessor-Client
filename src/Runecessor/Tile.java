package Runecessor;

public final class Tile extends Node {

    public final StaticObject[] objects;
    final int x;
    final int y;
    final int plane;
    final int[] objectFlags;
    public TileUnderlay underlay;

    public Class40 overlay;

    public WallLoc wall;

    public WallDecoration wallDecoration;

    public GroundDecoration groundDecoration;

    public ItemPile itemPile;
    public Tile aClass30_Sub3_1329;
    int z;
    int objectCount;
    int flags;

    int topPlane;

    boolean aBoolean1322;

    boolean aBoolean1323;

    boolean aBoolean1324;

    int anInt1325;

    int anInt1326;

    int anInt1327;

    int anInt1328;

    public Tile(int i, int j, int k) {
        objects = new StaticObject[5];
        objectFlags = new int[5];
        plane = z = i;
        x = j;
        y = k;
    }
}
