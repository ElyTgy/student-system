import java.util.*;



public class Utility
{
    /**
     * Summary: Constructor for Utility class
     * @params: None
     * @return: None
     */
    public Utility()
    {
        //None
    }

    public static int getNumber(String prompt, String lengthErrorMessage, String formatErrorMessage)
    {
        //Variable declarations 
        boolean runLoop = true;
        int number = 0;
        String input;
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print(prompt);
        
        //ask for user input until a valid number is entered
        while (runLoop){
            try{
                input = inputScanner.nextLine();
                if (input.length() >= 18){throw new ArithmeticException();}
                number = Integer.parseInt(input);
            }catch(ArithmeticException arithmeticException){
                System.out.print(lengthErrorMessage);
                continue;
            }catch(NumberFormatException numberFormatException){
                System.out.print(formatErrorMessage);
                continue;
            }
            runLoop = false;
        }//END of while loop
        
        inputScanner.close();
        return number;
    }//END of getNumber
    
    public static int getPercentage(String prompt)
    {
        //Variable declarations 
        boolean runLoop = true;
        int number = 0;
        String input;
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print(prompt);
        
        //ask for user input until a valid number is entered
        while (runLoop){
            try{
                input = inputScanner.nextLine();
                number = Integer.parseInt(input);
                if(number < 0 || number > 100)
                {
                    System.out.print("Please enter a percentage between 0 and 100: ");
                    continue;
                }
            }catch(NumberFormatException numberFormatException){
                System.out.print("Please enter an integer (round up the percetange if it is has decimals): ");
                continue;
            }
            runLoop = false;
        }//END of while loop
        
        inputScanner.close();
        return number;
    }
    
    //make a mapping count function ex: 1-> first, 2 -> second, ... take in integer return count as string
    public static String getString(String prompt, String lengthErrorMessage)
    {
        //Variable declarations
        String input = "";
        Boolean runLoop = true;
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print(prompt);
        
        
        while (runLoop){
            try{
                input = inputScanner.nextLine();
                if (input.length() >= 18){throw new ArithmeticException();}
            }catch(ArithmeticException arithmeticException){
                System.out.print(lengthErrorMessage);
                continue;
            }
            runLoop = false;
        }//END of while loop     
        
        
        inputScanner.close();
        return input;
    }
    
    //wrapper function for printing printSpace
    public static void printSpace()
    {
        System.out.println("");
    }
    
    public static void clearScreen()
    {
        System.out.flush();
        System.out.print("\f");
    }
}
