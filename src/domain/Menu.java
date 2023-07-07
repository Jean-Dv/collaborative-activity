package domain;

import javax.swing.JOptionPane;

/**
 * The Menu class provides methods for interacting with the user.
 */
public class Menu {
    
    /**
     * Shows the main menu and prompts the user to select an option.
     * 
     */
    public static String showMenu (){

        String menu = "------------- MAIN MENU -------------/n/n" + 
                "-------- Type the desired option --------" +
                "1. Roman numerals" +
                "2. Prime factors" +
                "3. Delete spaces" +
                "4. Egolatras numbers" +
                "5. Magic numbers" +
                "6. Dates" +
                "7. Exit";      
        
        do {
            char option = JOptionPane.showInputDialog(menu).charAt(0);

            switch (option) {
                case '1': roman();
                    
                    break;
            
                case '2': cousings();
                    
                    break;
                
                case '3': spaces();
                    
                    break;

                case '4': egolatrous();
                    
                    break;
                
                case '5': magic();
                    
                    break;
                
                case '6': dates();
                    
                    break;
                
                case '7':
                    
                    
            }

        } while (true);
    
    }

    public static void roman(){

        String roman = JOptionPane.showInputDialog("Enter the Roman numeral");

    }

    public static void cousings(){

        String numberString = JOptionPane.showInputDialog("Enter a number");

        try {
            int number = Integer.valueOf(numberString);
        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Enter a correct value");
        }        

        //JOptionPane.showMessageDialog(null, );

    }

    public static void spaces(){

    }

    public static void egolatrous(){

        String numberString = JOptionPane.showInputDialog("Enter a number");
        int number = 0;
        try {
            number = Integer.valueOf(numberString);
        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Enter a correct value");
        }        

        JOptionPane.showMessageDialog(null, Egolatrous.isEgolatrous(number));

    }

    public static void magic(){

    }

    public static void dates(){

    }



    /** 
    public static String validateRoman(){
        char option = 0;
        //option = Character.valueOf(JOptionPane.showInputDialog(showMenu()).charAt(0));

        String roman = "";

        return roman;
    }
    */


}
