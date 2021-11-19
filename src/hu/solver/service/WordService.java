package hu.solver.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordService {

    private final AnagramService anagramService;

    public WordService(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    public List<String> getWords(String actual) {
        return getKeys(actual).stream()
                .map(anagramService::getWords)
                .filter(hasValue())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<String> getKeys(String actual) {
        List<String> keys = new ArrayList<>();
        keys.addAll(get3Letters(actual));
        keys.addAll(get4Letters(actual));
        if (actual.length() > 5) {
            keys.addAll(get5Letters(actual));
        }
        if (actual.length() > 6) {
            keys.addAll(get6Letters(actual));
        }
        keys.add(actual);
        return keys;
    }

    private Set<String> get3Letters(String actual) {
        Set<String> words = new HashSet<>();
        for (int l1 = 0; l1 < actual.length() - 2; l1++) {
            for (int l2 = l1 + 1; l2 < actual.length() - 1; l2++) {
                for (int l3 = l2 + 1; l3 < actual.length(); l3++) {
                    String word = String.valueOf(
                            new char[]{actual.charAt(l1), actual.charAt(l2), actual.charAt(l3)});
                    words.add(word);
                }
            }
        }
        return words;
    }

    private Set<String> get4Letters(String actual) {
        Set<String> words = new HashSet<>();
        for (int l1 = 0; l1 < actual.length() - 3; l1++) {
            for (int l2 = l1 + 1; l2 < actual.length() - 2; l2++) {
                for (int l3 = l2 + 1; l3 < actual.length() - 1; l3++) {
                    for (int l4 = l3 + 1; l4 < actual.length(); l4++) {
                        String word = String.valueOf(
                                new char[]{actual.charAt(l1), actual.charAt(l2),
                                        actual.charAt(l3), actual.charAt(l4)});
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    private Set<String> get5Letters(String actual) {
        Set<String> words = new HashSet<>();
        for (int l1 = 0; l1 < actual.length() - 4; l1++) {
            for (int l2 = l1 + 1; l2 < actual.length() - 3; l2++) {
                for (int l3 = l2 + 1; l3 < actual.length() - 2; l3++) {
                    for (int l4 = l3 + 1; l4 < actual.length() - 1; l4++) {
                        for (int l5 = l4 + 1; l5 < actual.length(); l5++) {
                            String word = String.valueOf(
                                    new char[]{actual.charAt(l1), actual.charAt(l2),
                                            actual.charAt(l3), actual.charAt(l4), actual.charAt(l5)});
                            words.add(word);
                        }
                    }
                }
            }
        }
        return words;
    }

    private Set<String> get6Letters(String actual) {
        Set<String> words = new HashSet<>();
        for (int l1 = 0; l1 < actual.length() - 5; l1++) {
            for (int l2 = l1 + 1; l2 < actual.length() - 4; l2++) {
                for (int l3 = l2 + 1; l3 < actual.length() - 3; l3++) {
                    for (int l4 = l3 + 1; l4 < actual.length() - 2; l4++) {
                        for (int l5 = l4 + 1; l5 < actual.length() - 1; l5++) {
                            for (int l6 = l5 + 1; l6 < actual.length(); l6++) {
                                String word = String.valueOf(
                                        new char[]{actual.charAt(l1), actual.charAt(l2), actual.charAt(l3),
                                                actual.charAt(l4), actual.charAt(l5), actual.charAt(l6)});
                                words.add(word);
                            }
                        }
                    }
                }
            }
        }
        return words;
    }

    private Predicate<String> hasValue() {
        return i -> !i.isEmpty();
    }
}
