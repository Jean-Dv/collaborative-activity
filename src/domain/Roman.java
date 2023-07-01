package domain;

import java.util.Map;

/**
 * The Roman class provides methods to convert a roman number to an arabic
 * number.
 */
public class Roman {
    /**
     * Mapping of roman characters to their equivalent arabic numbers.
     */
    private static final Map<Character, Integer> ROMAN_TO_ARABIC = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    /**
     * Checks if a given string represents a valid roman numeral.
     * 
     * @param roman The string to be validated as a roman numeral.
     * @return true if the string is a valid roman numeral, false otherwise.
     */
    private static boolean isValid(String roman) {
        return roman.matches("^[IVXLCDM]+$");
    }

    /**
     * Checks if the order of roman characters is valid.
     * 
     * @param romanChars An array of strings representing the roman characters.
     * @return true if the order of characters is valid, false otherwise.
     */
    private static boolean isValidOrder(String[] romanChars) {
        for (int i = 0; i < romanChars.length - 1; i++) {
            int current = ROMAN_TO_ARABIC.get(romanChars[i].charAt(0));
            int next = i + 1 < romanChars.length ? ROMAN_TO_ARABIC.get(romanChars[i + 1].charAt(0)) : 0;
            if (current < next) {
                if (current * 5 != next && current * 10 != next) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ensures that roman characters are not repeated more than 3 times, with
     * characters specified L, D, V.
     * 
     * @param romanChars An array of string representing the roman characters.
     * @return true if the characters are not repeated more than 3 times, false
     *         otherwise.
     */
    private static boolean ensureCharactersNotRepeat(String[] romanChars) {
        for (int i = 0; i < romanChars.length - 1; i++) {
            int next = i + 1 < romanChars.length ? i + 1 : 0;
            if (romanChars[i].equals("D") && romanChars[i].equals(romanChars[next])) {
                return false;
            }
            if (romanChars[i].equals("L") && romanChars[i].equals(romanChars[next])) {
                return false;
            }
            if (romanChars[i].equals("V") && romanChars[i].equals(romanChars[next])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a roman numberal to its equivalent arabic number.
     * 
     * @param roman The roman numeral to be converted.
     * @return The equivalent arabic number, or null if the roman numeral is not
     *         valid.
     */
    public static Integer convert(String roman) {
        String[] romanChars = roman.split("");
        if (!isValid(roman)) {
            return null;
        }
        if (!isValidOrder(romanChars)) {
            return null;
        }
        if (!ensureCharactersNotRepeat(romanChars)) {
            return null;
        }
        Integer arabic = Integer.valueOf(0);
        for (int i = 0; i < romanChars.length; i++) {
            int current = ROMAN_TO_ARABIC.get(romanChars[i].charAt(0));
            int next = i + 1 < romanChars.length ? ROMAN_TO_ARABIC.get(romanChars[i + 1].charAt(0)) : 0;
            if (current < next) {
                arabic += next - current;
                i++;
            } else {
                arabic += current;
            }
        }
        return Integer.valueOf(arabic);
    }
}
