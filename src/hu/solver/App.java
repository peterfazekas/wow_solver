package hu.solver;

import hu.solver.reader.Console;
import hu.solver.reader.FileReader;
import hu.solver.reader.FileWriter;
import hu.solver.reader.WordsReader;
import hu.solver.service.AnagramService;
import hu.solver.service.WordService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 7;

    private final WordService wordService;
    private final Console console;

    private App() {
        var wordsReader = new WordsReader(new FileReader());
        List<String> words = wordsReader.getWords("words.txt");
        var anagramService = new AnagramService(words);
//        var writer = new FileWriter("words.txt");
//        writer.write(words);
        console = new Console(new Scanner(System.in));
        wordService = new WordService(anagramService);
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("Adatok beolvasva!");
        String actual;
        do {
            System.out.print("Kérem adja meg a szót: ");
            actual = console.read();
            System.out.println(wordService.getWords(actual));
        } while (actual.length() > 5);
    }
}
