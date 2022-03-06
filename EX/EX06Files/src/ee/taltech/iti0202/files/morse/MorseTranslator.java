package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {
    static private final Map<String, String> morseCodes = new HashMap<>();
    static private final Map<String, String> reverseMorseCodes = new HashMap<>();

    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            String[] splitLine = line.split(" ");
            morseCodes.put(splitLine[0].toLowerCase(), splitLine[1]);
            reverseMorseCodes.put(splitLine[1], splitLine[0].toLowerCase());
        }
        return morseCodes;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> linesInMorse = new ArrayList<>();
        for (String line : lines) {
            linesInMorse.add(translateLineToMorse(line));
        }
        return linesInMorse;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> dummyList = new ArrayList<>();
        for (String line : lines) {
            dummyList.add(translateLineFromMorse(line));
        }
        return dummyList;
    }

    private String translateLineToMorse(String line) {
        StringBuilder lineInMorse = new StringBuilder();
        String[] splitLine = line.trim().split("");
        for (String character : splitLine) {
            if (character.equals(" ")) {
                lineInMorse.append("\t");
            } else {
                lineInMorse.append(morseCodes.get(character.toLowerCase())).append(" ");
            }
        }
        return lineInMorse.toString();
    }

    private String translateLineFromMorse(String line) {
        String[] splitline = line.split("\s{2,}");
        List<String> wordList = new ArrayList<>();
        for (String morseWord :splitline) {
            StringBuilder actualWord = new StringBuilder();
            String[] morseLetters = morseWord.split("");
            StringBuilder convertedLetter = new StringBuilder();
            for (String letter : morseLetters) {
                if(letter.equals(".") || letter.equals("-")) {
                    convertedLetter.append(letter);
                }
                else {
                    actualWord.append(reverseMorseCodes.get(convertedLetter.toString()));
                    convertedLetter = new StringBuilder();
                }
            }
            if (!convertedLetter.isEmpty()) {
                actualWord.append(reverseMorseCodes.get(convertedLetter.toString()));
            }
            wordList.add(actualWord.toString());
        }
        StringBuilder finalList = new StringBuilder();
        for (String word : wordList) {
            finalList.append(word).append(" ");
        }
        return finalList.toString().trim();
    }
}