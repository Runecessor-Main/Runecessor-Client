package Runecessor;

import java.util.ArrayList;
import java.util.List;

public class XpDropData {

	private int currentXp;

	private int xpAddedPosition;

	private long xpFloatingTime;

	private int[] skillIds;

	public int getCurrentXp() {
		return currentXp;
	}

	public int getXpAddedPosition() {
		return xpAddedPosition;
	}

	public long getXpFloatingTime() {
		return xpFloatingTime;
	}

	public int[] getSkillIds() {
		return skillIds;
	}

	public void setCurrentXp(int value) {
		currentXp = value;
	}

	public void setXpAddedPosition(int value) {
		xpAddedPosition = value;
	}

	public void setXpFloatingTime(long value) {
		xpFloatingTime = value;
	}

	public XpDropData(int currentXp, int xpAddedPosition, long xpFloatingTime, int[] skillIds) {
		this.currentXp = currentXp;
		this.xpAddedPosition = xpAddedPosition;
		this.xpFloatingTime = xpFloatingTime;
		this.xpFloatingTime = xpFloatingTime;
		this.skillIds = skillIds;
	}

	public static List<XpDropData> xpDropDataList = new ArrayList<XpDropData>();
}
