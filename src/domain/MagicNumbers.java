package domain;
import java.util.Arrays;
public class MagicNumbers {
/* The class provides a method to verify if a number is magic.
 * @param num is the number to verify
 * @return true is the number is 'magic' , false otherwise.
 */

    public static boolean isMagicNumber(int num){
            String numString = String.valueOf(num);
            char[] digits = numString.toCharArray();
            boolean magic;

            Arrays.sort(digits);
            String ascendingString = new String(digits);
            String descendingString = new StringBuilder(ascendingString).reverse().toString();
    
            int ascendingNumber = Integer.parseInt(ascendingString);
            int descendingNumber = Integer.parseInt(descendingString);
    
            int res = descendingNumber - ascendingNumber;
            if(res==num){
                 return true;
                 return magic;
            }
            else{
                magic=false;
            
            return magic;
            }
    
            
    }
    
    
}
