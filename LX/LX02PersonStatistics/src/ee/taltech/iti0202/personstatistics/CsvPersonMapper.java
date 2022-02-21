package ee.taltech.iti0202.personstatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CsvPersonMapper {
    public List<Person> mapToPersons(String path) throws IOException {
        Stream lines = Files.lines(Paths.get(path))
                .map(line -> line.split(","))
                .forEach(arg ->  );
    }
    }
}
