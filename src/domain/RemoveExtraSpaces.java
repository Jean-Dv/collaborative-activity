package domain;

/**
 * The RemoveExtraSpaces class provides a method to remove extra spaces from a
 * string.
 */
public class RemoveExtraSpaces {
    /**
     * Removes extra spaces from a string.
     * 
     * @param str The input string.
     * @return The string with extra spaces removed.
     */
    public static String remove(String str) {
        return str.trim().replaceAll("\\s+", " ");
    }
}
