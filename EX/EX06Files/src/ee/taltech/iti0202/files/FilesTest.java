package ee.taltech.iti0202.files;


import ee.taltech.iti0202.files.input.FileReaderException;
import ee.taltech.iti0202.files.input.InputFilesBufferReader;
import ee.taltech.iti0202.files.input.InputFilesScanner;
import ee.taltech.iti0202.files.input.InputFilesLines;
import ee.taltech.iti0202.files.input.InputFilesReader;
import ee.taltech.iti0202.files.morse.MorseTranslator;
import ee.taltech.iti0202.files.output.OutputFilesWriter;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilesTest {

    /**
     * Test BufferReader ability to read a text as well as the exception it should throw.
     */
    @Test
    public void testBufferReader() throws IOException {
        InputFilesReader bufferReader = new InputFilesBufferReader();
        List<String> text = bufferReader.readTextFromFile("input.txt");
        List<String> testText = new ArrayList<>();
        testText.add("lorem ipsum dolor sit amet, consectetur adipiscing elit,");
        assertEquals(testText, text);
        FileReaderException thrown = assertThrows(FileReaderException.class,
                () -> bufferReader.readTextFromFile("notInput.txt"));
        assertTrue(thrown.getMessage().contains("No such file"));
    }

    /**
     * Test FilesLine ability to read a text as well as the exception it should throw.
     */
    @Test
    public void testFilesLines() throws IOException {
        InputFilesReader filesLines = new InputFilesLines();
        List<String> text = filesLines.readTextFromFile("input.txt");
        List<String> testText = new ArrayList<>();
        testText.add("lorem ipsum dolor sit amet, consectetur adipiscing elit,");
        assertEquals(testText, text);
        FileReaderException thrown = assertThrows(FileReaderException.class,
                () -> filesLines.readTextFromFile("notInput.txt"));
        assertTrue(thrown.getMessage().contains("No such file"));
    }

    /**
     * Test FileScanner ability to read a text as well as the exception it should throw.
     */
    @Test
    public void testFilesScanner() throws IOException {
        InputFilesReader filesScanner = new InputFilesScanner();
        List<String> text = filesScanner.readTextFromFile("input.txt");
        List<String> testText = new ArrayList<>();
        testText.add("lorem ipsum dolor sit amet, consectetur adipiscing elit,");
        assertEquals(testText, text);
        FileReaderException thrown = assertThrows(FileReaderException.class,
                () -> filesScanner.readTextFromFile("notInput.txt"));
        assertTrue(thrown.getMessage().contains("No such file"));
    }

    /**
     * Test File writer.
     */
    @Test
    public void testOutputWriter() throws IOException {
        List<String> testText = new ArrayList<>();
        testText.add("lorem ipsum dolor sit amet, consectetur adipiscing elit,");
        OutputFilesWriter writer = new OutputFilesWriter();
        writer.writeLinesToFile(testText, "test.txt");
        InputFilesReader reader = new InputFilesScanner();
        List<String> outputText = reader.readTextFromFile("test.txt");
        assertEquals(testText, outputText);
    }

    /**
     * Test Morse translator morse abilities.
     */
    @Test
    public void testMorseTranslatorToMorse() throws IOException {
        List<String> letters = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "??", "??", "??", "x", "y", "z", "0", "1", "2",
                "3", "4", "5", "6", "7", "8", "9", "&", "'", "@", ")", "(", ":", ",", "=", "!", ".", "-", "+", "?",
                "/"));
        MorseTranslator translator = new MorseTranslator();
        InputFilesScanner reader = new InputFilesScanner();
        List<String> morseCodes = reader.readTextFromFile("morse.txt");
        assertTrue(translator.addMorseCodes(morseCodes).keySet().containsAll(letters));
        List<String> testMorse = reader.readTextFromFile("morseInput.txt");
        List<String> actualMorse = translator.translateLinesToMorse(reader.readTextFromFile("input.txt"));
        assertEquals(testMorse, actualMorse);
    }

    /**
     * Test Morse translator regular text abilities.
     */
    @Test
    public void testMorseTranslatorFromMorse() throws IOException {
        MorseTranslator translator = new MorseTranslator();
        InputFilesScanner reader = new InputFilesScanner();
        List<String> morseCodes = reader.readTextFromFile("morse.txt");
        translator.addMorseCodes(morseCodes);
        List<String> testText = reader.readTextFromFile("input.txt");
        List<String> actualText = translator.translateLinesFromMorse(reader.readTextFromFile("morseInput.txt"));
        assertEquals(testText, actualText);
    }
}
