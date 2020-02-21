package Runecessor.resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason MacKeigan on 2018-05-28 at 10:32 AM
 */
public class LocalResourceLoader {

    private final Path directory;

    private final Map<String, LocalResource> resources = new HashMap<>();

    public LocalResourceLoader(Path directory) {
        this.directory = directory;
    }

    public void load() throws IOException {
        if (!Files.exists(directory)) {
            return;
        }
        Files.find(directory, Integer.MAX_VALUE, (file, attributes) -> file.toFile().isFile()).forEach(file -> {
            File resource = file.toFile();

            resources.putIfAbsent(resource.getName(), new LocalResource(resource));
        });
    }

    public LocalResource get(String name) {
        return resources.get(name);
    }

}
