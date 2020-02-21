package Runecessor;

import java.nio.file.Paths;

public enum CachedUUIDEntrySet {
	USER_HOME(new CachedUUIDEntry(Paths.get(System.getProperty("user.home"), "jagex_cll_oldschool_LIVE.dat"), 4096, 1024 * 4, false))
    ;

    private final CachedUUIDEntry entry;

    CachedUUIDEntrySet(CachedUUIDEntry entry) {
        this.entry = entry;
    }

    public CachedUUIDEntry getEntry() {
        return entry;
    }
}