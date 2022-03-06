package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {
    Map<String, String> morseCodes = new HashMap<>();
    Map<String, String> reverseMorseCodes = new HashMap<>();

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
        StringBuilder words = new StringBuilder();
        String[] splitLine = line.split("");
        StringBuilder currentCharacter = new StringBuilder();
        for (String morseCharacter : splitLine) {
            if (morseCharacter.equals(".") || morseCharacter.equals("-")) {
                currentCharacter.append(morseCharacter);
            } else {
                if (!currentCharacter.isEmpty()) {
                    words.append(reverseMorseCodes.get(currentCharacter.toString()));
                    currentCharacter = new StringBuilder();
                }
                if (morseCharacter.equals("\\")) {
                    words.append(" ");
                }
            }
        }
        if (!currentCharacter.isEmpty()) {
            words.append(reverseMorseCodes.get(currentCharacter.toString()));

        }
        return words.toString();
    }
}