package domain;

import javax.swing.JOptionPane;

/**
 * The Menu class provides methods for interacting with the user.
 */
public class Menu {

    public static void main (String []args){
        showMenu();
    }
    
    /**
     * Shows the main menu and prompts the user to select an option.
     * 
     */
    public static String showMenu (){

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
                
                case '7': exit();
                    
                    
            }

        } while (true);
    
    }

    public static void roman(){
        
        String roman = JOptionPane.showInputDialog("Enter a roman number");

        if (Roman.convert(roman) == null) {
            JOptionPane.showMessageDialog(null, "Null");
        }   
    }

    public static void cousings(){
        
    }

    public static void spaces(){

    }

    public static void egolatrous(){

        String numberString = JOptionPane.showInputDialog("Enter a number");
        int number = 0;
        boolean correct = true;

        while (correct) {
            try {

                number = Integer.valueOf(numberString);
                JOptionPane.showMessageDialog(null, Egolatrous.isEgolatrous(number));
                correct = false;

            } catch (Exception e) {

                e.getMessage();
                JOptionPane.showMessageDialog(null, "Enter a correct value");
                numberString = JOptionPane.showInputDialog("Enter a number");
            } 
        }        

    }

    public static void magic(){

    }

    public static void dates(){

    }

    public static void exit(){
        int option = JOptionPane.showConfirmDialog(null,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
        if( option == JOptionPane.YES_OPTION ){
            System.exit( 0 );
        }
    }


}
