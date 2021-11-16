package hu.solver.reader;

import hu.solver.App;
import hu.solver.reader.DataReader;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordsReader {

    public static final int MIN_LENGTH = App.MIN_LENGTH;
    public static final int MAX_LENGTH = App.MAX_LENGTH;

    private final DataReader dataReader;

    public WordsReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public List<String> getWords(String input) {
        List<String> stringList = dataReader.read(input);
        return stringList.stream()
                .filter(wordLengthIsCorrect())
                .collect(Collectors.toList());
    }

    private Predicate<String> wordLengthIsCorrect() {
        return word -> word.length() >= MIN_LENGTH && word.length() <= MAX_LENGTH;
    }
}
