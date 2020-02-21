package Runecessor;//Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
//Decompiler options: packimports(3)

public final class TileUnderlay {

	public TileUnderlay(int i, int j, int k, int l, int i1, int j1, boolean flag, boolean tex) {
		isFlatShaded = true;
		swHSL = i;
		neHSL = j;
		nwHSL = k;
		seHSL = l;
		texture = i1;
		//5728914
		rgb = j1;
		isFlatShaded = flag;
		textured = tex;
	}

	public final int swHSL;

	public final int neHSL;

	public final int nwHSL;

	public final int seHSL;

	public final int texture;

	public boolean isFlatShaded;

	public final int rgb;

	public final boolean textured;
}
