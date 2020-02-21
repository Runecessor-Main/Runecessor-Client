package Runecessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Jason MK on 2018-08-10 at 11:56 AM
 */
public class CachedUUIDGroup {

	public final static int AMOUNT_OF_UUID = 1;

    private static final Charset CHARSET = Charset.forName("UTF-8");

    private final Map<CachedUUIDEntry, UUID> entries;

    public CachedUUIDGroup(CachedUUIDEntry... entries) {
		this.entries = Arrays.stream(entries).collect(Collectors.toMap(Function.identity(), a -> find(a.getPath(), a.getOffset(), a.getBytes(), a.isHidden())));
	}

    public Collection<UUID> values() {
        return entries.values();
	}
	public void add(CachedUUIDEntry entry) {
		entries.put(entry, find(entry.getPath(), entry.getOffset(), entry.getBytes(), entry.isHidden()));
	}

	private UUID find(Path path, int offset, int maximumSize, boolean hidden) {
        try {
			if (hidden) {
				path = toHidden(path);
			}
            byte[] bytes = Files.readAllBytes(path);

            byte[] uuidBytes = new byte[36];

            System.arraycopy(bytes, offset, uuidBytes, 0, uuidBytes.length);

            UUID uuid;

            try {
                uuid = UUID.fromString(new String(uuidBytes, CHARSET));
            } catch (IllegalArgumentException iae) {
                uuid = UUID.randomUUID();
				Files.write(path, insert(uuid, bytes, offset), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            }
			modifyFileAttributes(path, hidden);

            return uuid;
        } catch (Exception e) {
            UUID uuid = UUID.randomUUID();

            try {
                Files.deleteIfExists(path);

                byte[] bytes = populate(path, maximumSize);
				Files.write(path, insert(uuid, bytes, offset), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
				modifyFileAttributes(path, hidden);
                return uuid;
            } catch (IOException ioe) {
				if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
					ioe.printStackTrace();
				}
                return uuid;
            }
        }
	}
	private Path toHidden(Path path) {
		if (!Client.osName.toLowerCase().contains("mac")) {
			return path;
		}
		return Paths.get(path.getParent().toString(), String.format(".%s", path.getFileName()));
    }


    private byte[] insert(UUID uuid, byte[] bytes, int offset) {
        byte[] uuidBytes = uuid.toString().getBytes(CHARSET);

        byte[] resized = new byte[bytes.length + uuidBytes.length];

        System.arraycopy(bytes, 0, resized, 0, offset - 1);

        System.arraycopy(uuidBytes, 0, resized, offset, uuidBytes.length);

        System.arraycopy(bytes, offset, resized, offset + 36, bytes.length - offset);

        return resized;
    }

    private byte[] populate(Path file, int bytes) throws IOException {
        byte[] payload = new byte[bytes];

        for (int index = 0; index < payload.length; index++) {
            payload[index] = (byte) ThreadLocalRandom.current().nextInt(0, 128);
        }
        Files.write(file, payload, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        return payload;
    }

	private void modifyFileAttributes(Path path, boolean hidden) throws IOException {
		//Files.setAttribute(path, "dos:hidden", true);
		if (path.toString().contains("oldschool_LIVE.dat")) {
			long jagexModified = new File(System.getProperty("user.home") + "/jagex_cl_oldschool_LIVE.dat").lastModified();
			File file = new File(path.toString());
			if (jagexModified > 0) {
				file.setLastModified(jagexModified);
			}
			else {
				if (System.currentTimeMillis() - file.lastModified() <= 600_000) {
					file.setLastModified(System.currentTimeMillis() - (long) Utility.random(259_000_000, Integer.MAX_VALUE));
				}
			}
		}
		try {
			if (hidden) {
				Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
			}
		} catch (UnsupportedOperationException unsupported) {
			if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
				unsupported.printStackTrace();
			}
		}
    }
}
