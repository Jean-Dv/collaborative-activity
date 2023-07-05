package domain;

/**
 * The class Egolatrous provide a method that indicates whether a number is egoless or not. 
 */

public class Egolatrous {
    
    /**
     * Checks if the numerical value entered is an egolatrous number. 
     * @param num The number that will be validated to know if it is an egolatrous number.
     * @return true if the number is an egolatrous number, false if it is not. 
     */
    public static boolean isEgolatrous(int num){

        String numString = String.valueOf(num);
        int power = numString.length();
        int result = 0;
        boolean egolatrous = true;

        for (int i = 0; i < numString.length(); i++) {
            
            int numChar = Character.getNumericValue(numString.charAt(i));
            result = result + (int)Math.pow(numChar, power);

        }
        return result == num ? egolatrous : !egolatrous;
    }
    
}
