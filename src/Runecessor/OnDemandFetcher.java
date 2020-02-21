package Runecessor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPInputStream;

public final class OnDemandFetcher extends OnDemandFetcherParent implements Runnable {

	private void readData() {
		try {
			int j = inputStream.available();
			if (expectedSize == 0 && j >= 6) {
				waiting = true;
				for (int k = 0; k < 6; k += inputStream.read(ioBuffer, k, 6 - k))
					;
				int l = ioBuffer[0] & 0xff;
				int j1 = ((ioBuffer[1] & 0xff) << 8) + (ioBuffer[2] & 0xff);
				int l1 = ((ioBuffer[3] & 0xff) << 8) + (ioBuffer[4] & 0xff);
				int i2 = ioBuffer[5] & 0xff;
				current = null;
				for (OnDemandData onDemandData = (OnDemandData) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandData) requested.reverseGetNext()) {
					if (onDemandData.dataType == l && onDemandData.ID == j1)
						current = onDemandData;
					if (current != null)
						onDemandData.loopCycle = 0;
				}

				if (current != null) {
					loopCycle = 0;
					if (l1 == 0) {
						SignLink.reporterror("Rej: " + l + "," + j1);
						current.buffer = null;
						if (current.incomplete)
							synchronized (complete) {
								complete.insertHead(current);
							}
						else
							current.unlink();
						current = null;
					}
					else {
						if (current.buffer == null && i2 == 0)
							current.buffer = new byte[l1];
						if (current.buffer == null && i2 != 0)
							throw new IOException("missing start of file");
					}
				}
				completedSize = i2 * 500;
				expectedSize = 500;
				if (expectedSize > l1 - i2 * 500)
					expectedSize = l1 - i2 * 500;
			}
			if (expectedSize > 0 && j >= expectedSize) {
				waiting = true;
				byte abyte0[] = ioBuffer;
				int i1 = 0;
				if (current != null) {
					abyte0 = current.buffer;
					i1 = completedSize;
				}
				for (int k1 = 0; k1 < expectedSize; k1 += inputStream.read(abyte0, k1 + i1, expectedSize - k1))
					;
				if (expectedSize + completedSize >= abyte0.length && current != null) {
					if (clientInstance.decompressors[0] != null)
						if (Config.PRE_EOC) {
							clientInstance.decompressors[current.dataType + 1].put(abyte0.length, java.nio.ByteBuffer.wrap(abyte0), current.ID);
						}
						else {
							clientInstance.decompressors[current.dataType + 1].method234Osrs(abyte0.length, abyte0, current.ID);
						}
					if (!current.incomplete && current.dataType == 3) {
						current.incomplete = true;
						current.dataType = 93;
					}
					if (current.incomplete)
						synchronized (complete) {
							complete.insertHead(current);
						}
					else
						current.unlink();
				}
				expectedSize = 0;
			}
		}
		catch (IOException ioexception) {
			try {
				socket.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			ioexception.printStackTrace();
			socket = null;
			inputStream = null;
			outputStream = null;
			expectedSize = 0;
		}
	}


	public int mapAmount = 0;

	public void start(StreamLoader streamLoader, Client client1) {

		byte[] abyte2 = streamLoader.getDataForName("map_index");
		//byte[] abyte2 = DataToolkit.readFile(ClientConstants.getCacheRevisionLocation()+ "/map_index634.dat");
		Stream stream2 = new Stream(abyte2);
		int j1 = stream2.readUnsignedWord();
		regionIds = new int[j1];
		landscapeIds = new int[j1];
		objectMapIds = new int[j1];
		for (int i2 = 0; i2 < j1; i2++) {
			regionIds[i2] = stream2.readUnsignedWord();
			landscapeIds[i2] = stream2.readUnsignedWord();
			objectMapIds[i2] = stream2. readUnsignedWord();
			mapAmount++;
		}
		abyte2 = streamLoader.getDataForName("midi_index");
		stream2 = new Stream(abyte2);
		j1 = abyte2.length;
		midis = new int[j1];
		for (int k2 = 0; k2 < j1; k2++)
			midis[k2] = stream2.readUnsignedByte();

		clientInstance = client1;
		running = true;
		clientInstance.startRunnable(this, 2);
	}


	public int getNodeCount() {
		synchronized (nodeSubList) {
			return nodeSubList.getNodeCount();
		}
	}

	public void disable() {
		running = false;
	}

	public void requestAllRegions(boolean flag) {
		int j = regionIds.length;
		for (int k = 0; k < j; k++)
			if (flag || mapIndices4[k] != 0) {
				evaluate((byte) 2, 3, objectMapIds[k]);
				evaluate((byte) 2, 3, landscapeIds[k]);
			}

	}

	public int getVersionCount(int j) {
		return versions[j].length;
	}

	private void closeRequest(OnDemandData onDemandData) {
		try {
			if (socket == null) {
				long l = System.currentTimeMillis();
				if (l - openSocketTime < 4000L)
					return;
				openSocketTime = l;
				socket = clientInstance.openSocket(WebsiteRead.port + Client.portOff);
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				outputStream.write(15);
				for (int j = 0; j < 8; j++)
					inputStream.read();

				loopCycle = 0;
			}
			ioBuffer[0] = (byte) onDemandData.dataType;
			ioBuffer[1] = (byte) (onDemandData.ID >> 8);
			ioBuffer[2] = (byte) onDemandData.ID;
			if (onDemandData.incomplete) {
				ioBuffer[3] = 2;
			}
			else if (!Client.isLoggedIn()) {
				ioBuffer[3] = 1;
			}
			else {
				ioBuffer[3] = 0;
			}
			outputStream.write(ioBuffer, 0, 4);
			writeLoopCycle = 0;
			fails = -10000;
			return;
		}
		catch (IOException ioexception) {
			ioexception.printStackTrace();
		}
		try {
			socket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		socket = null;
		inputStream = null;
		outputStream = null;
		expectedSize = 0;
		fails++;
	}

	public int getAnimCount() {
		return 29192;
	}

	public int getModelCount() {
		return 29191;
	}

	public void sendImmediately(int i, int file) {
		synchronized (nodeSubList) {
			for (OnDemandData onDemandData = (OnDemandData) nodeSubList.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandData) nodeSubList.reverseGetNext())
				if (onDemandData.dataType == i && onDemandData.ID == file)
					return;

			OnDemandData onDemandData_1 = new OnDemandData();
			onDemandData_1.dataType = i;
			onDemandData_1.ID = file;
			onDemandData_1.incomplete = true;
			synchronized (wanted) {
				wanted.insertHead(onDemandData_1);
			}
			nodeSubList.insertHead(onDemandData_1);
		}
	}

	public int getModelIndex(int i) {
		return modelIndices[i] & 0xff;
	}

	public void run() {
		try {
			while (running) {
				onDemandCycle++;
				int i = 20;
				if (anInt1332 == 0 && clientInstance.decompressors[0] != null) {
					i = 50;
				}
				try {
					Thread.sleep(i);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				waiting = true;
				for (int j = 0; j < 100; j++) {
					if (!waiting) {
						break;
					}
					waiting = false;
					checkReceived();
					handleFailed();
					if (uncompletedCount == 0 && j >= 5) {
						break;
					}
					handlePassive();
					if (inputStream != null) {
						readData();
					}
				}

				boolean flag = false;
				for (OnDemandData onDemandData = (OnDemandData) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandData) requested.reverseGetNext()) {
					if (onDemandData.incomplete) {
						flag = true;
						onDemandData.loopCycle++;
						if (onDemandData.loopCycle > 50) {
							onDemandData.loopCycle = 0;
							closeRequest(onDemandData);
						}
						Utility.print("Error: model is incomplete or missing  [ type = " + onDemandData.dataType + "]  [id = " + onDemandData.ID + "]");
					}
				}

				if (!flag) {
					for (OnDemandData onDemandData_1 = (OnDemandData) requested.reverseGetFirst(); onDemandData_1 != null; onDemandData_1 = (OnDemandData) requested.reverseGetNext()) {
						flag = true;
						onDemandData_1.loopCycle++;
						if (onDemandData_1.loopCycle > 50) {
							onDemandData_1.loopCycle = 0;
							closeRequest(onDemandData_1);
						}
					}

				}
				if (flag) {
					loopCycle++;
					if (loopCycle > 750) {
						try {
							socket.close();
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						socket = null;
						inputStream = null;
						outputStream = null;
						expectedSize = 0;
					}
				}
				else {
					loopCycle = 0;
					statusString = "";
				}
				if (Client.isLoggedIn() && socket != null && outputStream != null && (anInt1332 > 0 || clientInstance.decompressors[0] == null)) {
					writeLoopCycle++;
					if (writeLoopCycle > 500) {
						writeLoopCycle = 0;
						ioBuffer[0] = 0;
						ioBuffer[1] = 0;
						ioBuffer[2] = 0;
						ioBuffer[3] = 10;
						try {
							outputStream.write(ioBuffer, 0, 4);
						}
						catch (IOException e) {
							e.printStackTrace();
							loopCycle = 5000;
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			SignLink.reporterror("od_ex " + e.getMessage());
		}
	}

	public void sendPassively(int i, int j) {
		if (clientInstance.decompressors[0] == null)
			return;
		if (anInt1332 == 0)
			return;
		OnDemandData onDemandData = new OnDemandData();
		onDemandData.dataType = j;
		onDemandData.ID = i;
		onDemandData.incomplete = false;
		synchronized (passive) {
			passive.insertHead(onDemandData);
		}
	}

	@SuppressWarnings("unused")
	public OnDemandData getNextNode() {
		OnDemandData onDemandData;
		synchronized (complete) {
			onDemandData = (OnDemandData) complete.popHead();
		}
		if (onDemandData == null) {
			return null;
		}
		synchronized (nodeSubList) {
			onDemandData.unlinkSub();
		}
		if (onDemandData.buffer == null) {
			Utility.print("NULL GZIPINPUTSTREAM1.");
			return onDemandData;
		}
		int i = 0;
		try {
			GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(onDemandData.buffer));
			if (gzipinputstream == null) {
				Utility.print("NULL GZIPINPUTSTREAM2.");
				return onDemandData;
			}
			do {
				if (i == gzipInputBuffer.length) {
					Utility.print("NULL GZIPINPUTSTREAM3.");
					throw new RuntimeException("buffer overflow!");
				}
				if (gzipinputstream == null) {
					Utility.print("NULL GZIPINPUTSTREAM4.");
					return onDemandData;
				}
				if (gzipInputBuffer == null) {
					Utility.print("NULL GZIPINPUTSTREAM5.");
					return onDemandData;
				}
				int k = gzipinputstream.read(gzipInputBuffer, i, gzipInputBuffer.length - i); // This line is the error.
				if (k == -1)
					break;
				i += k;
			}
			while (true);
		}
		catch (IOException e) {
			Utility.print("Failed to unzip model [" + onDemandData.ID + "] type = " + onDemandData.dataType);
			e.printStackTrace();
			return null;
		}
		onDemandData.buffer = new byte[i];
		System.arraycopy(gzipInputBuffer, 0, onDemandData.buffer, 0, i);

		return onDemandData;
	}

	public int getRegionUID(int i, int k, int l) {
		int i1 = (l << 8) + k;
		int map1;
		int map2;
		for (int j1 = 0; j1 < regionIds.length; j1++) {
			if (regionIds[j1] == i1) {
				//Utility.print("regionIds[" + j1 + "] = " + regionIds[j1] + ";");
				if (i == 0) {
					//Utility.print("landscapeIds[" + j1 + "] = " + landscapeIds[j1] + ";");
					map1 = landscapeIds[j1] > 3535 ? -1 : landscapeIds[j1];
					return map1;
				}
				else {
					//Utility.print("objectMapIds[" + j1 + "] = " + objectMapIds[j1] + ";");
					map2 = objectMapIds[j1] > 3535 ? -1 : objectMapIds[j1];
					return map2;
				}
			}
		}
		return -1;
	}

	public void requestModel(int i) {
		sendImmediately(0, i);
	}

	public void evaluate(byte byte0, int i, int j) {
		if (clientInstance.decompressors[0] == null)
			return;
		if (versions[i][j] == 0)
			return;
		if (Config.PRE_EOC) {
			clientInstance.decompressors[i + 1].get(j);
		}
		else {
			clientInstance.decompressors[i + 1].decompressOsrs(j);
		}
		fileStatus[i][j] = byte0;
		if (byte0 > anInt1332)
			anInt1332 = byte0;
		totalFiles++;
	}

	public boolean regionIsLoaded(int i) {
		for (int k = 0; k < regionIds.length; k++)
			if (objectMapIds[k] == i)
				return true;
		return false;
	}

	private void handleFailed() {
		uncompletedCount = 0;
		completedCount = 0;
		for (OnDemandData onDemandData = (OnDemandData) requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandData) requested.reverseGetNext()) {
			if (onDemandData.incomplete) {
				uncompletedCount++;
				Utility.print("Error: model is incomplete or missing  [ type = " + onDemandData.dataType + "]  [id = " + onDemandData.ID + "]");
			}
			else {
				completedCount++;
			}
		}

		while (uncompletedCount < 10) {
			try {
				OnDemandData onDemandData_1 = (OnDemandData) requests.popHead();
				if (onDemandData_1 == null) {
					break;
				}
				Utility.print("Error missing file: " + onDemandData_1.ID + ", index " + onDemandData_1.dataType);
				if (fileStatus[onDemandData_1.dataType][onDemandData_1.ID] != 0) {
					filesLoaded++;
				}
				fileStatus[onDemandData_1.dataType][onDemandData_1.ID] = 0;
				requested.insertHead(onDemandData_1);
				uncompletedCount++;
				closeRequest(onDemandData_1);
				waiting = true;
				Utility.print("Error: file is missing1  [ type = " + onDemandData_1.dataType + "]  [id = " + onDemandData_1.ID + "]");
			}
			catch (Exception e) {
				e.printStackTrace();
				Utility.print("Error special 1: " + e.getMessage());
			}
		}
	}

	public void clearPassive() {
		synchronized (passive) {
			passive.removeAll();
		}
	}

	private void checkReceived() {
		OnDemandData onDemandData;
		synchronized (wanted) {
			onDemandData = (OnDemandData) wanted.popHead();
		}
		while (onDemandData != null) {
			waiting = true;
			byte abyte0[] = null;
			if (clientInstance.decompressors[0] != null) {
				if (Config.PRE_EOC) {
					try {
						abyte0 = clientInstance.decompressors[onDemandData.dataType + 1].get(onDemandData.ID).array();
					} catch(NullPointerException e) {
						System.out.println("Missing model: "+onDemandData.ID);
					}
				}else {
					abyte0 = clientInstance.decompressors[onDemandData.dataType + 1].decompressOsrs(onDemandData.ID);
				}
			}
			synchronized (wanted) {
				if (abyte0 == null) {
					requests.insertHead(onDemandData);
				}
				else {
					onDemandData.buffer = abyte0;
					synchronized (complete) {
						complete.insertHead(onDemandData);
					}
				}
				onDemandData = (OnDemandData) wanted.popHead();
			}
		}
	}

	private void handlePassive() {
		while (uncompletedCount == 0 && completedCount < 10) {
			if (anInt1332 == 0)
				break;
			OnDemandData onDemandData;
			synchronized (passive) {
				onDemandData = (OnDemandData) passive.popHead();
			}
			while (onDemandData != null) {
				if (fileStatus[onDemandData.dataType][onDemandData.ID] != 0) {
					fileStatus[onDemandData.dataType][onDemandData.ID] = 0;
					requested.insertHead(onDemandData);
					closeRequest(onDemandData);
					waiting = true;
					if (filesLoaded < totalFiles)
						filesLoaded++;
					statusString = "Loading extra files - " + (filesLoaded * 100) / totalFiles + "%";
					completedCount++;
					if (completedCount == 10)
						return;
				}
				synchronized (passive) {
					onDemandData = (OnDemandData) passive.popHead();
				}
			}
			for (int j = 0; j < 4; j++) {
				byte abyte0[] = fileStatus[j];
				int k = abyte0.length;
				for (int l = 0; l < k; l++)
					if (abyte0[l] == anInt1332) {
						abyte0[l] = 0;
						OnDemandData onDemandData_1 = new OnDemandData();
						onDemandData_1.dataType = j;
						onDemandData_1.ID = l;
						onDemandData_1.incomplete = false;
						requested.insertHead(onDemandData_1);
						closeRequest(onDemandData_1);
						waiting = true;
						if (filesLoaded < totalFiles)
							filesLoaded++;
						statusString = "Loading extra files - " + (filesLoaded * 100) / totalFiles + "%";
						completedCount++;
						if (completedCount == 10)
							return;
					}

			}

			anInt1332--;
		}
	}

	public boolean midiIsLoaded(int i) {
		return midis[i] == 1;
	}

	public OnDemandFetcher() {
		requested = new NodeList();
		statusString = "";
		ioBuffer = new byte[500];
		fileStatus = new byte[4][];
		passive = new NodeList();
		running = true;
		waiting = false;
		complete = new NodeList();
		if (Config.PRE_EOC) {
			gzipInputBuffer = new byte[9999999];
		}
		else {
			gzipInputBuffer = new byte[0x71868];
		}
		nodeSubList = new NodeSubList();
		versions = new int[4][];
		requests = new NodeList();
		wanted = new NodeList();
	}

	private int totalFiles;

	private final NodeList requested;

	private int anInt1332;

	public String statusString;

	private int writeLoopCycle;

	private long openSocketTime;

	private int[] objectMapIds;

	private final byte[] ioBuffer;

	public int onDemandCycle;

	private final byte[][] fileStatus;

	private Client clientInstance;

	private final NodeList passive;

	private int completedSize;

	private int expectedSize;

	private int[] midis;

	public int fails;

	private int[] landscapeIds;

	private int filesLoaded;

	private boolean running;

	private OutputStream outputStream;

	private int[] mapIndices4;

	private boolean waiting;

	private final NodeList complete;

	private final byte[] gzipInputBuffer;

	private final NodeSubList nodeSubList;

	private InputStream inputStream;

	private Socket socket;

	private final int[][] versions;

	private int uncompletedCount;

	private int completedCount;

	private final NodeList requests;

	private OnDemandData current;

	private final NodeList wanted;

	private int[] regionIds;

	private byte[] modelIndices;

	private int loopCycle;
}