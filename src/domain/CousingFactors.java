package domain;

import static java.lang.Math.sqrt;

import java.util.Stack;

/*
 * The CousingFactors class provides a method that find thes factors
 */
public class CousingFactors {
    private static int cantFactors = 0;

    /*
     * Reverses the order of items in a stack and saves them in an array.
     * 
     * @param a is the items to invert
     * @param n is the quantify of item.
     * @return An array that contains the elements of the stack in reverse
     * order.
     */
    private static String[] reverse(Stack<String> a, int n) {
        String[] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a.get(i);
            j = j - 1;
        }
        return b;
    }

    /*
     * The function check if a number is positive and greater than 1.
     * 
     * @param number The number to validate. 
     * @return true if the number is positive and major one, false otherwise.
     */
    private static boolean ensureNumberIsPositiveAndMajorOne(int number) {
        return number > 1;
    }

    /*
     * The function checks whether a given number is a prime number.
     * The hasDivisors varialbe as false to indicate that no divisors have been
     * found yet.
     * 
     * @param number The number to check.
     * @return true if the number is prime, false otherwise.
     */
    private static boolean isCousing(int number) {
        boolean hasDivisors = false;
        int i = 2;
        while (i <= sqrt(number) && !hasDivisors) {
            if (number % i == 0) {
                hasDivisors = true;
            }
            i++;
        }
        return !hasDivisors;
    }

    /*
     * The function find the next cousing factor major to the given number
     * 
     * @param number is the inicial number
     * @return the next cousing number major to the given number
     */

    private static int nextFactor(int number) {
        do {
            number++;
        } while (!isCousing(number));
        return number;
    }

    /*
     * The function generates the string representation of a cousing
     * 
     * @param factor is the cousing factor
     * @return the string representation of cousing factor
     */
    private static String writeFactor(int factor) {
        String factorString = "";
        if (cantFactors > 0) {
            if (cantFactors == 1) {
                factorString += String.format("%d^1", factor);
            } else {
                factorString += String.format("%d^%d", factor, cantFactors);
            }
            cantFactors = 0;
        }
        return factorString;
    }

    /*
     * The function descompose a number into its cousing factors and return then in
     * array.
     * 
     * @param number is the number to descompose
     * @return an array containing the cousing factors of number in form of strings
     */

    private static String[] factorize(int number) {
        Stack<String> factorString = new Stack<String>();
        int factor = 2;
        do {
            if (number % factor == 0) {
                cantFactors++;
                number /= factor;
            } else {
                factorString.push(writeFactor(factor));
                factor = nextFactor(factor);
            }
        } while (number > 1);
        factorString.push(writeFactor(factor));
        String[] returnedArrayWithFactors = reverse(factorString, factorString.size());
        return returnedArrayWithFactors;
    }

    /*
     * The function gets the representation of the cousing factors of a numeber as a
     * string
     * 
     * @param number is the number of the cousing factor will be obtained.
     * @return a string representing the cousing factors of the number separed by
     * the '*' character. If the number is invalid, null is returned
     */
    public static String of(int number) {
        if (!ensureNumberIsPositiveAndMajorOne(number)) {
            return null;
        }
        String factorizedNumber = "";
        String[] factors = factorize(number);
        for (int i = 0; i < factors.length; i++) {
            if (factors[i] != null && factors[i] != "") {
                if (i == 0) {
                    factorizedNumber += factors[i];
                } else {
                    factorizedNumber += String.format("*%s", factors[i]);
                }
            }
        }
        return factorizedNumber;
    }
}
