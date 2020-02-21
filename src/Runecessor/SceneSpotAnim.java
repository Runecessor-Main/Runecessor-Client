package Runecessor;

final class SceneSpotAnim extends SceneNode {

	private int nextFrame;

	public SceneSpotAnim(int i, int j, int l, int i1, int j1, int k1, int l1) {
		isFinished = false;
		spotanim = SpotAnim.cache[i1];
		plane = i;
		x = l1;
		y = k1;
		z = j1;
		endCycle = j + l;
		isFinished = false;
	}

	public Model getRotatedModel() {
		Model model = spotanim.getModel();
		if (model == null)
			return null;

		int j = spotanim.animationSequence.primary[frame];
		int nextFrame1 = spotanim.animationSequence.primary[nextFrame];
		int cycle1 = spotanim.animationSequence.duration[frame];
		Model model_1 = new Model(true, Frames.isNegativeZero(j), false, model);
		if (!isFinished) {
			model_1.method469();
			model_1.method470(j, nextFrame1, cycle1, cycle);
			model_1.anIntArrayArray1658 = null;
			model_1.anIntArrayArray1657 = null;
		}
		if (spotanim.scale != 128 || spotanim.height != 128)
			model_1.scaleModel(spotanim.scale, spotanim.scale, spotanim.height);
		if (spotanim.rotation != 0) {
			if (spotanim.rotation == 90)
				model_1.method473();
			if (spotanim.rotation == 180) {
				model_1.method473();
				model_1.method473();
			}
			if (spotanim.rotation == 270) {
				model_1.method473();
				model_1.method473();
				model_1.method473();
			}
		}
		model_1.method479(64 + spotanim.ambient, 850 + spotanim.contrast, -30, -50, -30, true);
		return model_1;
	}

	public void update(int i) {
		for (cycle += i; cycle > spotanim.animationSequence.getDuration(frame);) {
			cycle -= spotanim.animationSequence.getDuration(frame) + 1;
			frame++;
			if (frame >= spotanim.animationSequence.length && (frame < 0 || frame >= spotanim.animationSequence.length)) {
				frame = 0;
				isFinished = true;
			}
		}

	}

	public final int plane;

	public final int x;

	public final int y;

	public final int z;

	public final int endCycle;

	public boolean isFinished;

	private final SpotAnim spotanim;

	private int frame;

	private int cycle;
}
