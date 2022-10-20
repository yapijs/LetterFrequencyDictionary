package io.test_app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private final String FILE_NAME = "input.txt";
    private final Path path;

    public FileReader() throws URISyntaxException {
        this.path = Paths.get(getClass().getClassLoader()
                .getResource(FILE_NAME).toURI());
    }

    public List<String> getTextFromFile() throws IOException {
        return new ArrayList<>(Files.readAllLines(path));
    }
}
