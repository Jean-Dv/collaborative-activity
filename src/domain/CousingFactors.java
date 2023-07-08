package domain;

import static java.lang.Math.sqrt;

import java.util.Stack;

/* The CousingFactors class provides a method that find thes factors
 */

public class CousingFactors {
    private static int cantFactors = 0;

    /*
     * Reverses the order of items in a stack and saves them in an array.
     */
    // a is the items to invert
    // n is the quantify of items
    // return b tha is an array that contains the elements of the stack in reverse
    // order.
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
     * The function ensureNumberIsPositiveAndMajorOneCheck check if a number is
     * positive and greater than 1.
     * Return true if the numebr is postive and major one, or else flasd if the
     * number doesn't meet the conditions
     */

    private static boolean ensureNumberIsPositiveAndMajorOne(int number) {
        return number > 1;
    }

    /*
     * The isCousing function checks whether a given number is a prime number.
     * The hasDivisors variable as false to indicate that no divisors have been
     * found yet.
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
    // The function nextFactor find the next cousing number major to the given
    // number
    // Returns the next cousing number major to the given number

    private static int nextFactor(int number) {
        do {
            number++;
        } while (!isCousing(number));
        return number;
    }

    /*
     * The funtion writeFactor generates the string representation of a cousing
     * factor, including the factors of one.
     * Return the string representation of cousing factor
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
     * The function factorize descompose a number into its cousing factors and
     * returns
     * them in an array.
     * return an array containing the cousing factors of the number in the form of
     * strings.
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
     * The method of gets the representation of the cousing factors of a number as a
     * string.
     * number is The number from the cousing factors will be obtained.
     * Return a string representing the cousing factors of the number separated by
     * the '*' character.
     * If the number is invalid, null is returned.
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
