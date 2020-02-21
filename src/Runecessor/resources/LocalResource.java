package Runecessor.resources;

import java.io.File;


public class LocalResource {

    private final File file;

    public LocalResource(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
