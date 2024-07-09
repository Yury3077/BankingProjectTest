package config;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataManager {
    private JsonObject parser;

    public DataManager(String pathToFile) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathToFile));
            parser = (JsonObject) Jsoner.deserialize(reader);
    } catch (IOException | JsonException e) {
            System.out.println(e.getMessage());
        }
    }

    public JsonObject getParser() {
        return parser;
    }
}
