package part04;

import java.util.HashMap;
import java.util.Set;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely. If you
 * decide to complete it, you can use the MorseCodeTest class to test your
 * implementation. You can also create complete the MorseApp class, which uses
 * this class to translate between morse code and text.
 *
 * Based on Wikipedia, "Morse code is a method used in telecommunication to
 * encode text characters as standardized sequences of two different signal
 * durations, called dots and dashes, or dits and dahs"
 * (https://en.wikipedia.org/wiki/Morse_code).
 *
 * In this class, the morse code is represented as a string of dots (.) and
 * dashes (-). Characters are separated by a single space and words are
 * separated by three spaces.
 *
 * Your task is to implement the methods morseToText and textToMorse, which
 * translate between "normal" text and morse code. In the textToMorse method,
 * the input text can contain any characters, including special characters. You
 * only need to implement translation for the upper and lower case letters a-z
 * and the numbers 0-9.
 *
 * The mapping between characters and morse code can be found online, and is not
 * included in this assignment. You can use a Map to store the morse codes and
 * their corresponding characters.
 */
public class MorseCode {

    private static HashMap<String, String> newMap = new HashMap<>();
    private static HashMap<String, String> map2 = new HashMap<>();
    static {
        newMap.put("A", ".-");
        newMap.put("B", "-...");
        newMap.put("C", "-.-.");
        newMap.put("D", "-..");
        newMap.put("E", ".");
        newMap.put("F", "..-.");
        newMap.put("G", "--.");
        newMap.put("H", "....");
        newMap.put("I", "..");
        newMap.put("J", ".---");
        newMap.put("K", "-.-");
        newMap.put("L", ".-..");
        newMap.put("M", "--");
        newMap.put("N", "-.");
        newMap.put("O", "---");
        newMap.put("P", ".--.");
        newMap.put("Q", "--.-");
        newMap.put("R", ".-.");
        newMap.put("S", "...");
        newMap.put("T", "-");
        newMap.put("U", "..-");
        newMap.put("V", "...-");
        newMap.put("W", ".--");
        newMap.put("X", "-..-");
        newMap.put("Y", "-.--");
        newMap.put("Z", "--..");
        newMap.put("0", "-----");
        newMap.put("1", ".----");
        newMap.put("2", "..---");
        newMap.put("3", "...--");
        newMap.put("4", "....-");
        newMap.put("5", ".....");
        newMap.put("6", "-....");
        newMap.put("7", "--...");
        newMap.put("8", "---..");
        newMap.put("9", "----.");

        Set<String> keys = newMap.keySet();
        for (String key : keys) {
            map2.put(newMap.get(key), key);
        }
    }

    /**
     * Translates a string of morse code to text. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces. Characters a-z and 0-9 are supported.
     *
     * For example, ".... . .-.. .-.. --- .-- --- .-. .-.. -.." translates to
     * "hello world".
     *
     * @param morse the morse code to translate
     * @return the translated text (in lower case)
     */
    public String morseToText(String morse) {
        String[] words = morse.split("   ");
        String answer = "";
        for (String word : words) {
            String[] codes = word.split(" ");
            if (answer.length() > 0) {
                answer += " ";
            }
            for (String code : codes) {
                answer += map2.get(code);
            }
        }
        return answer.toLowerCase();
    }

    /**
     * Translates a string of text to morse code. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces.
     *
     * Upper and lower case letters a-z and numbers 0-9 are supported. Other
     * characters are ignored.
     *
     * For example, "Hello World" translates to
     * ".... . .-.. .-.. --- .-- --- .-. .-.. -..".
     *
     * @param text the text to translate
     * @return the translated morse code as a single string
     */
    public String textToMorse(String text) {
        String[] words = text.split(" ");
        String answer = "";
        for (String word : words) {
            String[] characters = word.split("");
            if (answer.length() > 0) {
                answer += "  ";
            }
            for (String character : characters) {
                if (newMap.get(character.toUpperCase()) != null) {
                    answer += newMap.get(character.toUpperCase()) + " ";
                }
            }
        }
        return answer.trim();
    }
}