package io.test_app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryApp {
    public static void main(String[] args) throws URISyntaxException, IOException {
//        try {
//            FileReader fileReader = new FileReader();
//        } catch (URISyntaxException e) {
//            System.out.println(e.getMessage());
//        } catch (NullPointerException e) {
//            System.out.println("Input file not found!");
//        }

        FileReader fileReader = new FileReader();
        System.out.println(getCharacterMap(fileReader.getTextFromFile()));



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
