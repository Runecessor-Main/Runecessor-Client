package Runecessor;

final class WaveSound {

	private WaveSound() {
		samples = new SoundSample[10];
	}

	public static void unpack(Stream stream) {
		data = new byte[0x6baa8];
		buffer = new Stream(data);
		SoundSample.init();
		do {
			int j = stream.readUnsignedWord();
			if (j == 65535) {
				return;
			}
			instances[j] = new WaveSound();
			instances[j].loadSamples(stream);
			delays[j] = instances[j].getDelay();

		}
		while (true);
	}

	public static Stream get(int i, int j) {
		if (instances[j] != null) {
			WaveSound sounds = instances[j];
			return sounds.putHeader(i);
		}
		else {
			return null;
		}
	}

	private void loadSamples(Stream stream) {
		for (int i = 0; i < 10; i++) {
			int j = stream.readUnsignedByte();
			if (j != 0) {
				stream.currentOffset--;
				samples[i] = new SoundSample();
				samples[i].load(stream);
			}
		}
		remaining = stream.readUnsignedWord();
		length = stream.readUnsignedWord();
	}

	private int getDelay() {
		int j = 0x98967f;
		for (int k = 0; k < 10; k++) {
			if (samples[k] != null && samples[k].remaining / 20 < j) {
				j = samples[k].remaining / 20;
			}
		}

		if (remaining < length && remaining / 20 < j) {
			j = remaining / 20;
		}
		if (j == 0x98967f || j == 0) {
			return 0;
		}
		for (int l = 0; l < 10; l++) {
			if (samples[l] != null) {
				samples[l].remaining -= j * 20;
			}
		}

		if (remaining < length) {
			remaining -= j * 20;
			length -= j * 20;
		}
		return j;
	}

	private Stream putHeader(int i) {
		int k = method245(i);
		buffer.currentOffset = 0;
		buffer.writeDWord(0x52494646);
		buffer.method403(36 + k);
		buffer.writeDWord(0x57415645);
		buffer.writeDWord(0x666d7420);
		buffer.method403(16);
		buffer.method400(1);
		buffer.method400(1);
		buffer.method403(22050);
		buffer.method403(22050);
		buffer.method400(1);
		buffer.method400(8);
		buffer.writeDWord(0x64617461);
		buffer.method403(k);
		buffer.currentOffset += k;
		return buffer;
	}

	private int method245(int i) {
		int j = 0;
		for (int k = 0; k < 10; k++) {
			if (samples[k] != null && samples[k].position + samples[k].remaining > j) {
				j = samples[k].position + samples[k].remaining;
			}
		}

		if (j == 0) {
			return 0;
		}
		int l = (22050 * j) / 1000;
		int i1 = (22050 * remaining) / 1000;
		int j1 = (22050 * length) / 1000;
		if (i1 < 0 || i1 > l || j1 < 0 || j1 > l || i1 >= j1) {
			i = 0;
		}
		int k1 = l + (j1 - i1) * (i - 1);
		for (int l1 = 44; l1 < k1 + 44; l1++) {
			data[l1] = -128;
		}

		for (int i2 = 0; i2 < 10; i2++) {
			if (samples[i2] != null) {
				int j2 = (samples[i2].position * 22050) / 1000;
				int i3 = (samples[i2].remaining * 22050) / 1000;
				int ai[] = samples[i2].synthesize(j2, samples[i2].position);
				for (int l3 = 0; l3 < j2; l3++) {
					data[l3 + i3 + 44] += (byte) (ai[l3] >> 8);
				}

			}
		}

		if (i > 1) {
			i1 += 44;
			j1 += 44;
			l += 44;
			int k2 = (k1 += 44) - l;
			for (int j3 = l - 1; j3 >= j1; j3--) {
				data[j3 + k2] = data[j3];
			}

			for (int k3 = 1; k3 < i; k3++) {
				int l2 = (j1 - i1) * k3;
				System.arraycopy(data, i1, data, i1 + l2, j1 - i1);

			}

			k1 -= 44;
		}
		return k1;
	}

	private static final WaveSound[] instances = new WaveSound[5000];

	public static final int[] delays = new int[5000];

	private static byte[] data;

	private static Stream buffer;

	private final SoundSample[] samples;

	private int remaining;

	private int length;

}
