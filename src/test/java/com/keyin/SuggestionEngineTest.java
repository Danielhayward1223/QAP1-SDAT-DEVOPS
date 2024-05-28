package com.keyin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Map;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine = new SuggestionEngine();
    Path path = Paths.get("src/main/resources/words.txt");

    @Test
    public void loadDictionaryTest() throws Exception {
        suggestionEngine.loadDictionaryData(path);
        Map<String, Integer> wordSuggestionDB = suggestionEngine.getWordSuggestionDB();
        Assertions.assertFalse(wordSuggestionDB.isEmpty(), "Word suggestion file not loaded correctly.");
    }

    @Test
    public void generateSuggestionsTest() throws Exception {
        suggestionEngine.loadDictionaryData(path);
        String testSuggestions = suggestionEngine.generateSuggestions("tesy");
        System.out.println(testSuggestions);
        Assertions.assertNotNull(testSuggestions, "Suggestions have not been generated correctly.");
    }

    @Test
    public void dbTest() {
        SuggestionsDatabase suggestionsDatabase = new SuggestionsDatabase();
        Map<String, Integer> wordMap = suggestionsDatabase.getWordMap();
        Assertions.assertNotNull(wordMap, "Word database is empty.");
    }
}
