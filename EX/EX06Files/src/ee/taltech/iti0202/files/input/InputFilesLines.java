package ee.taltech.iti0202.files.input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputFilesLines implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> dummyList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(dummyList::add);
        } catch (IOException e) {
            throw new FileReaderException("No such File", e);
        }
        return dummyList;
    }
}
