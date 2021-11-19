package hu.solver;

import hu.solver.reader.Console;
import hu.solver.reader.FileReader;
import hu.solver.reader.WordsReader;
import hu.solver.service.AnagramService;
import hu.solver.service.WordService;

import java.util.Scanner;

public class App {

    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 7;

    private final WordService wordService;
    private final Console console;

    private App() {
        var wordsReader = new WordsReader(new FileReader());
        var anagramService = new AnagramService(wordsReader.getWords("hungarian_words.txt"));
        console = new Console(new Scanner(System.in));
        wordService = new WordService(anagramService);
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("Adatok beolvasva!");
        System.out.println("Kérem adja meg a szót: ");
        String actual = console.read();
        System.out.println(wordService.getWords(actual));
    }
}
