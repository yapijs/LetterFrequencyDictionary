package io.test_app;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Map;

public class FileWriter {
    private final String FILE_NAME = "output.txt";
    private Path path;

    public FileWriter() throws URISyntaxException {
        //this.path = Paths.get(getClass().getClassLoader().getResource(FILE_NAME).toURI());
        this.path = Paths.get("src/main/resources", FILE_NAME);
    }

    public void writeDataToFile(Map<Character, Integer> data) throws IOException {
        Files.write(path, ("Letter : number of occurrences\n").getBytes());
        data.forEach( (key, value) -> {
            try {
                Files.write(path, (key + " : " + value + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
