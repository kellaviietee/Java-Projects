package ee.taltech.iti0202.files.input;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String>dummyList = new ArrayList<>();
        try (Scanner scanner = new Scanner(filename)) {
            while (scanner.hasNextLine()) {
                dummyList.add(scanner.nextLine());
            }
        }
        return dummyList;
    }
}