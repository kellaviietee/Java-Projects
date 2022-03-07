package ee.taltech.iti0202.files.morse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {
    private final Map<String, String> morseCodes = new HashMap<>();
    private final Map<String, String> reverseMorseCodes = new HashMap<>();

    /**
     * Add morse code decipher to the class.
     *
     * @param lines Lines of morse codes.
     * @return Morse code deciphering algorithm.
     */
    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            String[] splitLine = line.split(" ");
            morseCodes.put(splitLine[0].toLowerCase(), splitLine[1]);
            reverseMorseCodes.put(splitLine[1], splitLine[0].toLowerCase());
        }
        return morseCodes;
    }

    /**
     * Translate regular text into a Morse code.
     *
     * @param lines Normal text to be converted.
     * @return text converted to Morse.
     */
    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> linesInMorse = new ArrayList<>();
        for (String line : lines) {
            linesInMorse.add(translateLineToMorse(line));
        }
        return linesInMorse;
    }

    /**
     * Translates a Morse code to normal text
     *
     * @param lines all the lines to be translated.
     * @return normal text.
     */
    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> dummyList = new ArrayList<>();
        for (String line : lines) {
            dummyList.add(translateLineFromMorse(line));
        }
        return dummyList;
    }

    private String translateLineToMorse(String line) {
        StringBuilder lineInMorse = new StringBuilder();
        String[] splitLine = line.trim().split(" ");
        for (String sentence : splitLine) {
            String[] words = sentence.split(" ");
            for (String word : words) {
                StringBuilder morseWord = new StringBuilder();
                String[] letters = word.split("");
                for (int i = 0; i < letters.length; i++) {
                    morseWord.append(morseCodes.get(letters[i]));
                    if (i < letters.length - 1) {
                        morseWord.append(" ");
                    }
                }
                morseWord.append("\t");
                lineInMorse.append(morseWord);
            }
        }
        return lineInMorse.toString().trim();
    }

    private String translateLineFromMorse(String line) {
        String[] words = line.split("\s{2,}");
        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (reverseMorseCodes.containsKey(letter.toLowerCase())) {
                    sentence.append(reverseMorseCodes.get(letter.toLowerCase()));
                }
            }
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }
}
