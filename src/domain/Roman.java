package domain;

import java.util.Map;

public class Roman {
    private static final Map<Character, Integer> ROMAN_TO_ARABIC = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    private static boolean isValid(String roman) {
        return roman.matches("^[IVXLCDM]+$");
    }

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

    private static boolean ensureCharactersNotRepeat(String[] roman) {
        for (int i = 0; i < roman.length - 1; i++) {
            int next = i + 1 < roman.length ? i + 1 : 0;
            if (roman[i].equals("D") && roman[i].equals(roman[next])) {
                return false;
            }
            if (roman[i].equals("L") && roman[i].equals(roman[next])) {
                return false;
            }
            if (roman[i].equals("V") && roman[i].equals(roman[next])) {
                return false;
            }
        }
        return true;
    }

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
