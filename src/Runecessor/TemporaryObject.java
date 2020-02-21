package Runecessor;

final class TemporaryObject extends Node {

	TemporaryObject() {
		cycle = -1;
	}

	public int objectId;

	public int rotation;

	public int instancedHeight;

	public int type;

	public int cycle;

	public int plane;

	/**
	 * It means the object will appear on all instances on the same height.
	 */
	public boolean global;

	public int classType;

	public int x;

	public int y;

	public int locIndex;

	public int locRotation;

	public int locType;

	public int spawnCycle;

	private boolean custom = false;

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}
}
