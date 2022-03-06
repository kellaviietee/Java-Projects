package ee.taltech.iti0202.files.input;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> allLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                allLines.add(scanner.nextLine() + "\n");
            }
        } catch (IOException e) {
            throw new FileReaderException("No such File", e);
        }
        return allLines;
    }
}