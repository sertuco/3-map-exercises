package part04;

import java.util.Scanner;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely.
 *
 * See the MorseCode class for more information.
 */
public class MorseApp {

    public static void main(String... args) {
        MorseCode morseCode = new MorseCode();
        Scanner lukija = new Scanner(System.in);
        System.out.print("For text to morse input 1, for morse to text input 2, to stop input 0: ");
        String number = lukija.nextLine();
        while (!number.equals("0")) {
            if (number.equals("1")) {
                System.out.print("\nInput text for translation: ");
                String text = lukija.nextLine();
                System.out.println("Translation: " + morseCode.textToMorse(text) + "\n");
            } else if (number.equals("2")) {
                System.out.print("\nInput morse for translation: ");
                String morse = lukija.nextLine();
                System.out.println("Translation: " + morseCode.morseToText(morse) + "\n");
            } else {
                System.out.print("\nInvalid input.\n");
            }
            System.out.print("For text to morse input 1, for morse to text input 2, to stop input 0: ");
            number = lukija.nextLine();
        }
        lukija.close();
    }
}