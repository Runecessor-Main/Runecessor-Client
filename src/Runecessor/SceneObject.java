package Runecessor;

final class SceneObject extends SceneNode {

	public Model getRotatedModel() {
		int j = -1;
		if (sequence != null) {
			int k = Client.loopCycle - cycle;
			if (k > 100 && sequence.padding > 0)
				k = 100;
			while (k > sequence.getDuration(sequenceFrame)) {
				k -= sequence.getDuration(sequenceFrame);
				sequenceFrame++;
				if (sequenceFrame < sequence.length)
					continue;
				sequenceFrame -= sequence.padding;
				if (sequenceFrame >= 0 && sequenceFrame < sequence.length)
					continue;
				sequence = null;
				break;
			}
			cycle = Client.loopCycle - k;
			if (sequence != null)
				j = sequence.primary[sequenceFrame];
		}
		ObjectDefinition class46;
		if (overrides != null)
			class46 = getOverride();
		else
			class46 = ObjectDefinition.forId(index);
		if (class46 == null) {
			return null;
		}
		else {
			return class46.getAdjustedModel(type, rotation, swZ, seZ, neZ, nwZ, j);
		}
	}

	private ObjectDefinition getOverride() {
		if (Config.PRE_EOC) {
			int i = -1;
			try {
				if (varbit != -1) {
					VarBit varBit = VarBit.cache[varbit];
					int k = varBit.setting;
					int l = varBit.startbit;
					int i1 = varBit.endbit;
					int j1 = Client.BIT_MASK[i1 - l];
					i = clientInstance.variousSettings[k] >> l & j1;
				}
				else if (setting != -1) {
					i = clientInstance.variousSettings[setting];
				}
				if (i < 0 || i >= overrides.length || overrides[i] == -1) {
					return null;
				}
				else {
					return ObjectDefinition.forId(overrides[i]);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			int i = -1;
			if (varbit != -1) {
				try {
					VarBit varBit = VarBit.cache[varbit];
					int k = varBit.setting;
					int l = varBit.startbit;
					int i1 = varBit.endbit;
					int j1 = Client.BIT_MASK[i1 - l];
					i = clientInstance.variousSettings[k] >> l & j1;
				}
				catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else if (setting != -1 && setting < clientInstance.variousSettings.length) {
				i = clientInstance.variousSettings[setting];
			}
			int var;
			if (i >= 0 && i < overrides.length) {
				var = overrides[i];
			}
			else {
				var = overrides[overrides.length - 1];
			}

			return var != -1 ? ObjectDefinition.forId(var) : null;
		}

	}

	public SceneObject(int i, int j, int k, int l, int i1, int j1, int k1, int animation, boolean flag) {
		index = i;
		type = k;
		rotation = j;
		swZ = j1;
		seZ = l;
		neZ = i1;
		nwZ = k1;
		if (animation != -1) {
			sequence = Sequences.anims[animation];
			sequenceFrame = 0;
			cycle = Client.loopCycle;
			if (flag && sequence.padding != -1) {
				sequenceFrame = (int) (Math.random() * (double) sequence.length);
				cycle -= (int) (Math.random() * (double) sequence.getDuration(sequenceFrame));
			}
		}
		ObjectDefinition class46 = ObjectDefinition.forId(index);
		varbit = class46.varbit;
		setting = class46.setting;
		overrides = class46.childrenIDs;
	}

	private int sequenceFrame;

	private final int[] overrides;

	private final int varbit;

	private final int setting;

	private final int swZ;

	private final int seZ;

	private final int neZ;

	private final int nwZ;

	private Sequences sequence;

	private int cycle;

	public static Client clientInstance;

	private final int index;

	private final int type;

	private final int rotation;
}
