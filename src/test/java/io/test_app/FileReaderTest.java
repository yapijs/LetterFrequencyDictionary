package io.test_app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    void shouldGetLinesFromFile() throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        Assertions.assertTrue(fileReader.getTextFromFile().size() > 0);
    }

    @Test
    void shouldFindResourceFile() throws URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI());
        File file = new File(path.toUri());
        Assertions.assertTrue(file.exists());
    }

}
