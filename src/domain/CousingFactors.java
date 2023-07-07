package domain;

import static java.lang.Math.sqrt;

import java.util.Stack;

public class CousingFactors {
    private static int cantFactors = 0;

    private static String[] reverse(Stack<String> a, int n) {
        String[] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a.get(i);
            j = j - 1;
        }
        return b;
    }

    private static boolean ensureNumberIsPositiveAndMajorOne(int number) {
        return number > 1;
    }

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

    private static int nextFactor(int number) {
        do {
            number++;
        } while (!isCousing(number));
        return number;
    }

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
