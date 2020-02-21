package Runecessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SpriteLoader {

	/**
	 * Loads the sprite data and index files from the cache location. This can
	 * be edited to use an archive such as config or media to load from the
	 * cache.
	 *
	 */
	public static void loadSprites(String indexPath, String dataPath) {
		try {
			ByteBuffer index = new ByteBuffer(FileOperations.ReadFile(indexPath));

			ByteBuffer data = new ByteBuffer(FileOperations.ReadFile(dataPath));

			DataInputStream indexFile = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(index.buffer)));

			DataInputStream dataFile = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(data.buffer)));

			int totalSprites = indexFile.readInt();

			if (cache == null) {
				cache = new SpriteLoader[totalSprites];
				sprites = new Sprite[totalSprites];
			}
			for (int i = 0; i < totalSprites; i++) {
				int id = indexFile.readInt();
				if (cache[id] == null) {
					cache[id] = new SpriteLoader();
				}
				cache[id].readValues(indexFile, dataFile);
				createSprite(cache[id]);
			}
			indexFile.close();
			dataFile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeSprites(String indexPath, String dataPath) {
		try  {
			Files.deleteIfExists(Paths.get(indexPath));
			Files.createFile(Paths.get(indexPath));
			Files.deleteIfExists(Paths.get(dataPath));
			Files.createFile(Paths.get(dataPath));
		} catch (IOException ioe) {
			throw new RuntimeException("Unable to delete and create files.");
		}
		try (DataOutputStream indexFile = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(Paths.get(indexPath).toFile())));
			 DataOutputStream dataFile = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(Paths.get(dataPath).toFile())))) {

			indexFile.writeInt(cache.length);

			for (int i = 0; i < cache.length; i++) {
				if (cache[i] != null) {
					indexFile.writeInt(cache[i].id);
					cache[i].writeValues(indexFile, dataFile);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Reads the information from the index and data files.
	 * 
	 * @param index
	 *            holds the sprite indices
	 * @param data
	 *            holds the sprite data per index
	 * @throws IOException
	 */
	public void readValues(DataInputStream index, DataInputStream data) throws IOException {
		do {
			int opCode = data.readByte();

			if (opCode == 0) {
				break;
			}
			if (opCode == 1) {
				id = data.readShort();
			}
			else if (opCode == 2) {
				name = data.readUTF();
			}
			else if (opCode == 3) {
				drawOffsetX = data.readShort();
			}
			else if (opCode == 4) {
				drawOffsetY = data.readShort();
			}
			else if (opCode == 5) {
				int indexLength = index.readInt();
				byte[] dataread = new byte[indexLength];
				data.readFully(dataread);
				spriteData = dataread;
			}
		}
		while (true);
	}

	public void writeValues(DataOutputStream index, DataOutputStream data) throws IOException {
		data.writeByte(1);
		data.writeShort(id);
		data.writeByte(2);
		data.writeUTF(name);
		data.writeByte(3);
		data.writeShort(drawOffsetX);
		data.writeByte(4);
		data.writeShort(drawOffsetY);
		data.writeByte(5);
		index.writeInt(spriteData.length);
		data.write(spriteData, 0, spriteData.length);
		data.writeByte(0);
	}

	public static void add(SpriteLoader sprite) {
		SpriteLoader[] clone = cache.clone();

		SpriteLoader[] resizedCache = new SpriteLoader[clone.length + 1];

		System.arraycopy(clone, 0, resizedCache, 0, clone.length);

		final int lastIndex = resizedCache.length - 1;

		sprite.id = lastIndex;

		sprite.name = Integer.toString(lastIndex);

		resizedCache[lastIndex] = sprite;

		cache = resizedCache;
	}

	/**
	 * Creates a sprite out of the spriteData.
	 * 
	 * @param sprite
	 * @throws IOException 
	 */
	public static void createSprite(SpriteLoader sprite) throws IOException {
		
		/*	File directory = new File(ClientConstants.getCacheLocation() + "sprites_debug/sprites_dump");
			if (!directory.exists()) {
				directory.mkdir();
			}
			Utility.print("Dumped: " + directory.getAbsolutePath() + System.getProperty("file.separator") + sprite.id + ".png");
			writeFile(new File(directory.getAbsolutePath() + System.getProperty("file.separator") + sprite.id + ".png"), sprite.spriteData);*/
		
		sprites[sprite.id] = new Sprite(sprite.spriteData);
		sprites[sprite.id].anInt1442 = sprite.drawOffsetX;
		sprites[sprite.id].anInt1443 = sprite.drawOffsetY;
	}

	public static void writeFile(File f, byte[] data) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		try {
			raf.write(data);
		}
		finally {
			raf.close();
		}
	}

	public static int findIndex(Sprite sprite) {
		Objects.requireNonNull(sprite, "Sprite cannot be null.");

		if (sprites == null) {
			Utility.print("Sprites is null :/");
			return -1;
		}
		for (int index = 0; index < sprites.length; index++) {
			Sprite existing = sprites[index];

			if (existing == null) {
				continue;
			}
			if (existing == sprite) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Gets the name of a specified sprite index.
	 * 
	 * @param index
	 * @return
	 */
	public static String getName(int index) {
		if (index < 0 || index > cache.length - 1) {
			return "null";
		}
		SpriteLoader loader = cache[index];

		return loader == null ? "null" : loader.name;
	}

	/**
	 * Sets the default values.
	 */
	public SpriteLoader() {
		this(null);
	}

	public SpriteLoader(byte[] spriteData) {
		name = "name";
		id = -1;
		drawOffsetX = 0;
		drawOffsetY = 0;
		this.spriteData = spriteData;
	}

	public static SpriteLoader[] cache;

	public static Sprite[] sprites = null;

	public String name;

	public int id;

	public int drawOffsetX;

	public int drawOffsetY;

	public byte[] spriteData;
}