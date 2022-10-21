package io.test_app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryApp {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader();
            Map<Character, Integer> mappedCharacters = getCharacterMap(fileReader.getTextFromFile());
            FileWriter fileWriter = new FileWriter();
            fileWriter.writeDataToFile(mappedCharacters);
        } catch (URISyntaxException | IOException e) {
            e.getMessage();
        }

    }

    static Map<Character, Integer> getCharacterMap(List<String> listOfInputRows) {
        Map<Character, Integer> allCharacters = new HashMap<>();
        for (String rawRow: listOfInputRows) {
            String row = rawRow.replaceAll("[^a-zA-Z]", "").toLowerCase();
            for (int i = 0; i < row.length(); i++) {
                allCharacters.merge(row.charAt(i), 1, Integer::sum);
            }
        }
        return allCharacters;
    }
}
