package io.test_app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.collection.IsMapContaining;


public class DictionaryAppTest {

    @Test
    void shouldCountCharacters() {
        List<String> listOfText = Arrays.asList("This is  ", "my input!* 7a");
        Map<Character, Integer> resultMap = DictionaryApp.getCharacterMap(listOfText);
        Map<Character, Integer> testResult = new HashMap<>();
        testResult.put('a', 1);
        testResult.put('i', 3);
        testResult.put('t', 2);
        testResult.put('s', 2);
        testResult.put('h', 1);
        testResult.put('m', 1);
        testResult.put('p', 1);
        testResult.put('u', 1);
        testResult.put('n', 1);
        testResult.put('y', 1);

        assertThat(resultMap, is(testResult));
        assertThat(resultMap.size(), is(10));
        assertThat(resultMap, not(IsMapContaining.hasKey('A')));
    }
}
