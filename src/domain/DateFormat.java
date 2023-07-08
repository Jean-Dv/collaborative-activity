package domain;

import java.util.HashMap;

/**
 * The DateFormat class provides methods to convert a date from the format
 */
public class DateFormat {
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    /**
     * A mapping of month numbers to their corresponding names in Spanish.
     */
    private static final HashMap<Integer, String> MONTHS = new HashMap<>();

    static {
        MONTHS.put(1, "Enero");
        MONTHS.put(2, "Febrero");
        MONTHS.put(3, "Marzo");
        MONTHS.put(4, "Abril");
        MONTHS.put(5, "Mayo");
        MONTHS.put(6, "Junio");
        MONTHS.put(7, "Julio");
        MONTHS.put(8, "Agosto");
        MONTHS.put(9, "Septiembre");
        MONTHS.put(10, "Octubre");
        MONTHS.put(11, "Noviembre");
        MONTHS.put(12, "Diciembre");
    }

    /**
     * Checks if a given date string is valid in the format DD/MM/YYYY.
     * 
     * @param date The date string to be validated
     * @return true if the date string is valid, false otherwise.
     */
    private static boolean isValid(String date) {
        return date.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
    }

    /**
     * Checks if a given day is valid for specific month.
     * 
     * @param day   The day to be validated
     * @param month The month for which the day need to be validated
     * @return true if the day is valid, false otherwise.
     */
    private static boolean isValidDay(int day, int month) {
        if (month == FEBRUARY) {
            return day > 0 && day <= 28;
        }
        if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) {
            return day > 0 && day <= 30;
        }
        return day > 0 && day <= 31;
    }

    /**
     * Checks if a given month is valid.
     *
     * @param month The month to be validated.
     * @return true if the month is valid, false otherwise.
     */
    private static boolean isValidMonth(int month) {
        return month > 0 && month <= 12;
    }

    /**
     * Retrieves the name of a moth for a given month number.
     * 
     * @param month The month number.
     * @return The name of the month.
     */
    private static String getMonth(int month) {
        return MONTHS.get(month);
    }

    /**
     * Formats a date string in the format DD/MM/YYYY to the format DD de MONTH de
     * YYYY.
     * 
     * @param date The date string to be formatted.
     * @return The formatted date string, or null if the input date is not valid.
     */
    public static String format(String date) {
        if (isValid(date) == false) {
            return null;
        }
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (isValidDay(day, month) == false) {
            return null;
        }

        if (isValidMonth(month) == false) {
            return null;
        }

        return String.format("%d de %s de %d", day, getMonth(month), year);
    }
}
