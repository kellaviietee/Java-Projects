package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {
    private final Map<String, String> morseCodes = new HashMap<>();
    private final Map<String, String> reverseMorseCodes = new HashMap<>();

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
        String[] splitLine = line.trim().split(" ");
        for (String word : splitLine) {
            StringBuilder wordInMorse = new StringBuilder();
            String[] wordLetters = word.split("");
            for (String letter : wordLetters) {
                if (!morseCodes.containsKey(letter.toLowerCase())) {
                    System.out.println(letter);
                }
                wordInMorse.append(morseCodes.get(letter.toLowerCase())).append(" ");
            }
            lineInMorse.append(wordInMorse).append("\t");
        }
        return lineInMorse.toString().trim();
    }

    private String translateLineFromMorse(String line) {
        String[] words = line.split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder sentence = new StringBuilder();
        for (String letter : words) {
            if (letter.startsWith("\t")) {
                sentence.append("\t");
            }
            sentence.append(reverseMorseCodes.get(letter.trim()));
        }
        return sentence.toString();
    }
}