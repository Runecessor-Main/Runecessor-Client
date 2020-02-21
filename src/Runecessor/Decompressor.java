package Runecessor;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

final class Decompressor {


	private static final byte[] bufferOsrs = new byte[520];

	private final RandomAccessFile dataFile;

	private final RandomAccessFile indexFile;

	private final int file;

	private static final int IDX_BLOCK_LEN = 6;

	private static final int HEADER_LEN = 8;

	private static final int EXPANDED_HEADER_LEN = 10;

	private static final int BLOCK_LEN = 512;

	private static final int EXPANDED_BLOCK_LEN = 510;

	private static final int TOTAL_BLOCK_LEN = HEADER_LEN + BLOCK_LEN;

	private static ByteBuffer bufferPreEoc = ByteBuffer.allocateDirect(TOTAL_BLOCK_LEN);

	private final FileChannel index;

	private final FileChannel data;

	private final int maximumSize;

	public Decompressor(RandomAccessFile randomaccessfile, RandomAccessFile randomaccessfile1, int j) {
		file = j;
		if (Config.PRE_EOC) {
			dataFile = randomaccessfile;
			indexFile = randomaccessfile1;
			data = randomaccessfile.getChannel();
			index = randomaccessfile1.getChannel();
			this.maximumSize = Integer.MAX_VALUE;
		}
		else {
			dataFile = randomaccessfile;
			indexFile = randomaccessfile1;
			data = randomaccessfile.getChannel();
			index = randomaccessfile1.getChannel();
			this.maximumSize = Integer.MAX_VALUE;
		}
	}

	public synchronized byte[] decompressOsrs(int i) {
		try {
			seekToOsrs(indexFile, i * 6);
			int l;
			for (int j = 0; j < 6; j += l) {
				l = indexFile.read(bufferOsrs, j, 6 - j);
				if (l == -1)
					return null;
			}
			int i1 = ((bufferOsrs[0] & 0xff) << 16) + ((bufferOsrs[1] & 0xff) << 8) + (bufferOsrs[2] & 0xff);
			int j1 = ((bufferOsrs[3] & 0xff) << 16) + ((bufferOsrs[4] & 0xff) << 8) + (bufferOsrs[5] & 0xff);
			if (j1 <= 0 || (long) j1 > dataFile.length() / 520L)
				return null;
			byte abyte0[] = new byte[i1];
			int k1 = 0;
			for (int l1 = 0; k1 < i1; l1++) {
				if (j1 == 0)
					return null;
				seekToOsrs(dataFile, j1 * 520);
				int k = 0;
				int i2 = i1 - k1;
				if (i2 > 512)
					i2 = 512;
				int j2;
				for (; k < i2 + 8; k += j2) {
					j2 = dataFile.read(bufferOsrs, k, (i2 + 8) - k);
					if (j2 == -1)
						return null;
				}
				int k2 = ((bufferOsrs[0] & 0xff) << 8) + (bufferOsrs[1] & 0xff);
				int l2 = ((bufferOsrs[2] & 0xff) << 8) + (bufferOsrs[3] & 0xff);
				int i3 = ((bufferOsrs[4] & 0xff) << 16) + ((bufferOsrs[5] & 0xff) << 8) + (bufferOsrs[6] & 0xff);
				int j3 = bufferOsrs[7] & 0xff;
				if (k2 != i || l2 != l1 || j3 != file)
					return null;
				if (i3 < 0 || (long) i3 > dataFile.length() / 520L)
					return null;
				for (int k3 = 0; k3 < i2; k3++)
					abyte0[k1++] = bufferOsrs[k3 + 8];

				j1 = i3;
			}

			return abyte0;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public synchronized boolean method234Osrs(int i, byte abyte0[], int j) {
		boolean flag = method235Osrs(true, j, i, abyte0);

		if (!flag)
			flag = method235Osrs(false, j, i, abyte0);
		return flag;
	}

	private synchronized boolean method235Osrs(boolean flag, int j, int k, byte abyte0[]) {
		try {
			int l;
			if (flag) {
				seekToOsrs(indexFile, j * 6);
				int k1;
				for (int i1 = 0; i1 < 6; i1 += k1) {
					k1 = indexFile.read(bufferOsrs, i1, 6 - i1);
					if (k1 == -1)
						return false;
				}
				l = ((bufferOsrs[3] & 0xff) << 16) + ((bufferOsrs[4] & 0xff) << 8) + (bufferOsrs[5] & 0xff);
				if (l <= 0 || (long) l > dataFile.length() / 520L)
					return false;
			}
			else {
				l = (int) ((dataFile.length() + 519L) / 520L);
				if (l == 0)
					l = 1;
			}
			bufferOsrs[0] = (byte) (k >> 16);
			bufferOsrs[1] = (byte) (k >> 8);
			bufferOsrs[2] = (byte) k;
			bufferOsrs[3] = (byte) (l >> 16);
			bufferOsrs[4] = (byte) (l >> 8);
			bufferOsrs[5] = (byte) l;
			seekToOsrs(indexFile, j * 6);
			indexFile.write(bufferOsrs, 0, 6);
			int j1 = 0;
			for (int l1 = 0; j1 < k; l1++) {
				int i2 = 0;
				if (flag) {
					seekToOsrs(dataFile, l * 520);
					int j2;
					int l2;
					for (j2 = 0; j2 < 8; j2 += l2) {
						l2 = dataFile.read(bufferOsrs, j2, 8 - j2);
						if (l2 == -1)
							break;
					}
					if (j2 == 8) {
						int i3 = ((bufferOsrs[0] & 0xff) << 8) + (bufferOsrs[1] & 0xff);
						int j3 = ((bufferOsrs[2] & 0xff) << 8) + (bufferOsrs[3] & 0xff);
						i2 = ((bufferOsrs[4] & 0xff) << 16) + ((bufferOsrs[5] & 0xff) << 8) + (bufferOsrs[6] & 0xff);
						int k3 = bufferOsrs[7] & 0xff;
						if (i3 != j || j3 != l1 || k3 != file)
							return false;
						if (i2 < 0 || (long) i2 > dataFile.length() / 520L)
							return false;
					}
				}
				if (i2 == 0) {
					flag = false;
					i2 = (int) ((dataFile.length() + 519L) / 520L);
					if (i2 == 0)
						i2++;
					if (i2 == l)
						i2++;
				}
				if (k - j1 <= 512)
					i2 = 0;
				bufferOsrs[0] = (byte) (j >> 8);
				bufferOsrs[1] = (byte) j;
				bufferOsrs[2] = (byte) (l1 >> 8);
				bufferOsrs[3] = (byte) l1;
				bufferOsrs[4] = (byte) (i2 >> 16);
				bufferOsrs[5] = (byte) (i2 >> 8);
				bufferOsrs[6] = (byte) i2;
				bufferOsrs[7] = (byte) file;
				seekToOsrs(dataFile, l * 520);
				dataFile.write(bufferOsrs, 0, 8);
				int k2 = k - j1;
				if (k2 > 512)
					k2 = 512;
				dataFile.write(abyte0, j1, k2);
				j1 += k2;
				l = i2;
			}

			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private synchronized void seekToOsrs(RandomAccessFile randomaccessfile, int j) throws IOException {
		try {
			randomaccessfile.seek(j);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ByteBuffer get(int indexFile) {
		try {
			seek(index, indexFile);
			bufferPreEoc.flip();

			int size = getMediumInt(bufferPreEoc);
			int sector = getMediumInt(bufferPreEoc);

			if (size < 0 || size > maximumSize) {
				return null;
			}
			else if (sector <= 0 || sector > data.size() / TOTAL_BLOCK_LEN) {
				return null;
			}

			ByteBuffer decompressed = ByteBuffer.allocate(size);
			int remaining = size;
			int part = 0;
			int sectorLength = indexFile <= 0xffff ? BLOCK_LEN : EXPANDED_BLOCK_LEN;
			int headerLen = indexFile <= 0xffff ? HEADER_LEN : EXPANDED_HEADER_LEN;
			while (remaining > 0) {
				if (sector == 0) {
					return null;
				}

				int sectorSize = remaining > sectorLength ? sectorLength : remaining;
				bufferPreEoc.position(0).limit(sectorSize + headerLen);
				data.read(bufferPreEoc, sector * TOTAL_BLOCK_LEN);
				bufferPreEoc.flip();

				int currentIndex, currentPart, nextSector, currentFile;

				if (indexFile <= 65535) {
					currentIndex = bufferPreEoc.getShort() & 0xffff;
					currentPart = bufferPreEoc.getShort() & 0xffff;
					nextSector = getMediumInt(bufferPreEoc);
					currentFile = bufferPreEoc.get() & 0xff;
				}
				else {
					currentIndex = bufferPreEoc.getInt();
					currentPart = bufferPreEoc.getShort() & 0xffff;
					nextSector = getMediumInt(bufferPreEoc);
					currentFile = bufferPreEoc.get() & 0xff;
				}

				if (indexFile != currentIndex || part != currentPart || file != currentFile) {
					return null;
				}
				else if (nextSector < 0 || nextSector > data.size() / TOTAL_BLOCK_LEN) {
					return null;
				}

				int unread = bufferPreEoc.remaining();
				for (int i = 0; i < unread; i++) {
					decompressed.put(bufferPreEoc.get());
				}

				remaining -= sectorSize;
				sector = nextSector;
				part++;
			}

			decompressed.position(0);
			return decompressed;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean put(int size, ByteBuffer data, int file) {
		if (size < 0 || size > maximumSize) {
			throw new IllegalArgumentException("File too big: " + file + " size: " + size);
		}

		boolean success = put(file, data, size, true);
		if (!success) {
			success = put(file, data, size, false);
		}

		return success;
	}

	private boolean put(int file, ByteBuffer data, int size, boolean exists) {
		try {
			int sector;
			if (exists) {
				seek(index, file);
				bufferPreEoc.flip().position(3);

				sector = getMediumInt(bufferPreEoc);
				if (sector <= 0 || sector > this.data.size() / TOTAL_BLOCK_LEN) {
					return false;
				}
			}
			else {
				sector = (int) (this.data.size() + TOTAL_BLOCK_LEN - 1) / TOTAL_BLOCK_LEN;
				if (sector == 0) {
					sector = 1;
				}
			}

			bufferPreEoc.position(0);
			putMediumInt(bufferPreEoc, size);
			putMediumInt(bufferPreEoc, sector);
			bufferPreEoc.flip();
			index.write(bufferPreEoc, file * IDX_BLOCK_LEN);

			int remaining = size;
			int part = 0;
			int sectorLength = file <= 0xffff ? BLOCK_LEN : EXPANDED_BLOCK_LEN;
			int headerLength = file <= 0xffff ? HEADER_LEN : EXPANDED_HEADER_LEN;
			while (remaining > 0) {
				int nextSector = 0;
				if (exists) {
					bufferPreEoc.position(0).limit(headerLength);
					this.data.read(bufferPreEoc, sector * TOTAL_BLOCK_LEN);
					bufferPreEoc.flip();

					int currentIndex, currentPart, currentFile;
					if (file <= 0xffff) {
						currentIndex = bufferPreEoc.getShort() & 0xffff;
						currentPart = bufferPreEoc.getShort() & 0xffff;
						nextSector = getMediumInt(bufferPreEoc);
						currentFile = bufferPreEoc.get() & 0xff;
					}
					else {
						currentIndex = bufferPreEoc.getInt();
						currentPart = bufferPreEoc.getShort() & 0xffff;
						nextSector = getMediumInt(bufferPreEoc);
						currentFile = bufferPreEoc.get() & 0xff;
					}

					if (file != currentIndex || part != currentPart || this.file != currentFile) {
						return false;
					}
					if (nextSector < 0 || nextSector > this.data.size() / TOTAL_BLOCK_LEN) {
						return false;
					}
				}

				if (nextSector == 0) {
					exists = false;
					nextSector = (int) ((this.data.size() + TOTAL_BLOCK_LEN - 1) / TOTAL_BLOCK_LEN);
					if (nextSector == 0) {
						nextSector = 1;
					}

					if (nextSector == sector) {
						nextSector++;
					}
				}

				if (remaining <= sectorLength) {
					nextSector = 0;
				}

				bufferPreEoc.position(0).limit(TOTAL_BLOCK_LEN);
				if (file <= 0xffff) {
					bufferPreEoc.putShort((short) file);
					bufferPreEoc.putShort((short) part);
					putMediumInt(bufferPreEoc, nextSector);
					bufferPreEoc.put((byte) this.file);
				}
				else {
					bufferPreEoc.putInt(file);
					bufferPreEoc.putShort((short) part);
					putMediumInt(bufferPreEoc, nextSector);
					bufferPreEoc.put((byte) this.file);
				}

				int sectorSize = remaining > sectorLength ? sectorLength : remaining;
				data.limit(data.position() + sectorSize);
				bufferPreEoc.put(data);
				bufferPreEoc.flip();

				this.data.write(bufferPreEoc, sector * TOTAL_BLOCK_LEN);
				remaining -= sectorSize;
				sector = nextSector;
				part++;
			}

			return true;
		}
		catch (IOException ex) {
			return false;
		}
	}

	private synchronized void seek(FileChannel index, int file) throws IOException {
		if (file * IDX_BLOCK_LEN + IDX_BLOCK_LEN > index.size()) {
			return;
		}
		bufferPreEoc.position(0).limit(IDX_BLOCK_LEN);
		index.read(bufferPreEoc, file * IDX_BLOCK_LEN);
	}

	private static int getMediumInt(ByteBuffer buffer) {
		return ((buffer.get() & 0xff) << 16) | ((buffer.get() & 0xff) << 8) | (buffer.get() & 0xff);
	}

	private static void putMediumInt(ByteBuffer buffer, int val) {
		buffer.put((byte) (val >> 16));
		buffer.put((byte) (val >> 8));
		buffer.put((byte) val);
	}

}
