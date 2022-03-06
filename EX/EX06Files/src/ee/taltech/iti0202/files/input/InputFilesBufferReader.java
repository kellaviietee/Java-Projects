package ee.taltech.iti0202.files.input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        if (filename == null) {
            IOException e = new IOException();
            throw new FileReaderException("No such file",e);
        }
        List<String> dummyList;
        Path path = Paths.get(filename);
        try {
            dummyList = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return dummyList;
    }
}
