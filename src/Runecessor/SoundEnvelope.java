package Runecessor;

final class SoundEnvelope {

	public void load1(Stream stream) {
		form = stream.readUnsignedByte();
		anInt538 = stream.readDWord();
		anInt539 = stream.readDWord();
		load2(stream);
	}

	public void load2(Stream stream) {
		segmentCount = stream.readUnsignedByte();
		segmentDuration = new int[segmentCount];
		segmentPeak = new int[segmentCount];
		for (int i = 0; i < segmentCount; i++) {
			segmentDuration[i] = stream.readUnsignedWord();
			segmentPeak[i] = stream.readUnsignedWord();
		}

	}

	void resetValues() {
		checkpoint = 0;
		segmentPosition = 0;
		stepSize = 0;
		amplitude = 0;
		tick = 0;
	}

	int evaluate(int i) {
		if (tick >= checkpoint) {
			amplitude = segmentPeak[segmentPosition++] << 15;
			if (segmentPosition >= segmentCount)
				segmentPosition = segmentCount - 1;
			checkpoint = (int) (((double) segmentDuration[segmentPosition] / 65536D) * (double) i);
			if (checkpoint > tick)
				stepSize = ((segmentPeak[segmentPosition] << 15) - amplitude) / (checkpoint - tick);
		}
		amplitude += stepSize;
		tick++;
		return amplitude - stepSize >> 15;
	}

	public SoundEnvelope() {
	}

	private int segmentCount;

	private int[] segmentDuration;

	private int[] segmentPeak;

	int anInt538;

	int anInt539;

	int form;

	private int checkpoint;

	private int segmentPosition;

	private int stepSize;

	private int amplitude;

	private int tick;

	public static int anInt546;
}
