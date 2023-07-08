package application;

import javax.swing.JOptionPane;

import domain.Egolatrous;
import domain.Roman;
import domain.CousingFactors;
import domain.DateFormat;
import domain.RemoveExtraSpaces;
import domain.MagicNumbers;

/**
 * The Menu class provides methods for interacting with the user.
 */
public class Menu {

    public static void main(String[] args) {
        showMenu();
    }

    /**
     * Shows the main menu and prompts the user to select an option.
     * 
     */
    public static String showMenu() {
        String menu = "------------- MAIN MENU -------------\n" +
                "       Type the desired option       \n\n" +
                "1. Roman numerals\n" +
                "2. Prime factors\n" +
                "3. Delete spaces\n" +
                "4. Egolatras numbers\n" +
                "5. Magic numbers\n" +
                "6. Dates\n" +
                "7. Exit";
        do {
            try {
                char option = JOptionPane.showInputDialog(menu).charAt(0);
                switch (option) {
                    case '1':
                        roman();
                        break;
                    case '2':
                        cousings();
                        break;
                    case '3':
                        spaces();
                        break;
                    case '4':
                        egolatrous();
                        break;
                    case '5':
                        magic();
                        break;
                    case '6':
                        dates();
                        break;
                    case '7':
                        exit();
                }
            } catch (NullPointerException | StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Enter a correct value");
            }
        } while (true);
    }

    /**
     * Requests a Roman numeral from the user and displays the number in its decimal
     * value.
     */
    public static void roman() {
        do {
            String roman = JOptionPane.showInputDialog("Enter a roman number");
            Integer arabicNumber = null;
            roman = roman.toUpperCase();
            arabicNumber = Roman.convert(roman);
            if (arabicNumber != null) {
                JOptionPane.showMessageDialog(null, arabicNumber);
                break;
            }
            JOptionPane.showMessageDialog(null, "null");

        } while (true);
    }

    /**
     * Prompts the user for a number and displays the prime factors of the number.
     */
    public static void cousings() {
        do {
            String numberString = JOptionPane.showInputDialog("Enter a number");
            try {
                int number = numberString != null ? Integer.valueOf(numberString) : 0;
                String optained = CousingFactors.of(number);
                if (optained != null) {
                    JOptionPane.showMessageDialog(null, optained);
                    break;
                }
                JOptionPane.showMessageDialog(null, "null");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a correct value");
            }
        } while (true);

    }

    /**
     * Prompts the user for a string and returns the string without spaces.
     */
    public static void spaces() {
        do {
            String string = JOptionPane.showInputDialog("Enter a string");
            JOptionPane.showMessageDialog(null, RemoveExtraSpaces.remove(string));

        } while (true);
    }

    /**
     * Prompts the user for a number and checks if the number is egolatrous.
     */
    public static void egolatrous() {
        do {
            String numberString = JOptionPane.showInputDialog("Enter a number");
            try {
                int number = numberString != null ? Integer.valueOf(numberString) : 0;
                JOptionPane.showMessageDialog(null, Egolatrous.isEgolatrous(number));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a correct value");
            }
        } while (true);
    }

    /**
     * Prompts the user for a number and checks if the number is magic.
     */
    public static void magic() {
        do {
            String numberString = JOptionPane.showInputDialog("Enter a number");
            try {
                int number = numberString != null ? Integer.valueOf(numberString) : 0;
                JOptionPane.showMessageDialog(null, MagicNumbers.isMagicNumber(number));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a correct value");
            }
        } while (true);
    }

    /**
     * Receives a date in a specific format and displays a description of the date.
     */
    public static void dates() {
        do {
            String date = JOptionPane.showInputDialog("Enter a date with the format dd/mm/yyyy");
            JOptionPane.showMessageDialog(null, DateFormat.format(date));
            break;
        } while (true);
    }

    /**
     * Close menu.
     */
    public static void exit() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
