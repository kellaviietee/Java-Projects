package ee.taltech.iti0202.files.input;
import java.io.IOException;
import java.util.List;

public interface InputFilesReader {

    /**
     * Read a text from a file.
     * @param filename path to file.
     * @return Text.
     */
    List<String> readTextFromFile(String filename) throws IOException;
}
