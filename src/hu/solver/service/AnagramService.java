package hu.solver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramService {

    private static final Locale LOCALE_HU = new Locale("hu", "HU");

    private final Map<String, List<String>> wordsMap;

    public AnagramService(List<String> wordList) {
        wordsMap = initWordsMap(wordList);
    }

    public String getWords(String key) {

        String anagram = getAnagram(key);
        List<String> elements = wordsMap.get(anagram);
        return elements != null ? String.join(", ", elements) : "";
    }

    private Map<String, List<String>> initWordsMap(List<String> wordList) {
        Map<String, List<String>> wordsMap = new HashMap<>();
        wordList.forEach(word -> {
            String key = getAnagram(word);
            List<String> words = wordsMap.containsKey(key) ? wordsMap.get(key) : new ArrayList<>();
            words.add(word);
            wordsMap.put(key, words);
        });
        return wordsMap;
    }

    public String getAnagram(String text) {
        var upperCaseText = text.toUpperCase(LOCALE_HU);
        return upperCaseText.chars()
                .sorted()
                .mapToObj(i -> Character.toString((char) i))
                .collect(Collectors.joining());
    }
}
