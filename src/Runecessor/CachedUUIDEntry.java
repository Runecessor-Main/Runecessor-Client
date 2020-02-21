package Runecessor;

import java.nio.file.Path;

public class CachedUUIDEntry {

    private final Path path;

    private final int offset;

    private final int bytes;

	private final boolean hidden;

	public CachedUUIDEntry(Path path, int offset, int bytes, boolean hidden) {
		this.path = path;
		this.offset = offset;
		this.bytes = bytes;
		this.hidden = hidden;
	}

    public Path getPath() {
        return path;
    }

    public int getOffset() {
        return offset;
    }

    public int getBytes() {
        return bytes;
	}

	public boolean isHidden() {
		return hidden;
    }
}