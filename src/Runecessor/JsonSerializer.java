package Runecessor;

import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer<T> {

    private final Class<T> type;

    public JsonSerializer(Class<T> type) {
        this.type = type;
    }

    public T deserialize(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, type);

    }

    public String serialize(T object) {
        final Gson gson = new Gson();
        return gson.toJson(object);
    }

    public T read(File location) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            final Gson gson = new Gson();
            return gson.fromJson(reader, type);
        }
    }

    public void write(File location, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(location))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
