
import java.util.Scanner; 


public class Atm   
{   
    static Scanner input = new Scanner(System.in);
	public static final void main(final String... atm) 
	{   
       try 
       {
            System.out.println(" \n\t\t " + " Welcome to Virtual ATM "); 

            Menu option = new Menu();
            option.login();
       } 
       catch(final Exception am)
       { 
            System.err.println("\tATM is Temporary Out Of Service");
       } 
       finally
       { 
            input.close();
            System.out.println("\n\t Something Went Wrong\n\n");
       }        
    }
 

   
    public static void dot() throws InterruptedException
    {
        for (int dot = 1; dot <= 3 ; dot++)
        {
            System.out.print(".");
            Thread.sleep(450);
        }
    }

   
    public static void delay() throws InterruptedException
    {
        for (int delay = 0; delay <= 3 ; delay++)
        {
            Thread.sleep(140);
        }
    }

    public static void exitMessage()
    {
       System.out.println("\nThank you for using this ATM, Have a Nice day !!");
      
    }
    public static void invalid() 
    {
       System.err.println("Invalid !!  Select Appropriative Selection ");
    }  
}

