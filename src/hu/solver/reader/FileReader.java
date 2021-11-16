package hu.solver.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements DataReader{

    @Override
    public List<String> read(String input) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
