package hu.solver.reader;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.next();
    }
}
