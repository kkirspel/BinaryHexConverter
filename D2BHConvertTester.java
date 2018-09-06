
/**
 * Write a description of class D2BHConvert here.
 * 
 * Kevin Kirspel
 * @version (a version number or a date)
 */
    import java.util.Scanner;

public class D2BHConvertTester
{
       public static void main(String[] args)
       {
           int value = 0;
           String string; 
           boolean continueProgram = true;
           boolean calculate = true;
           Scanner scan = new Scanner(System.in);
           D2BHConvert converter = new D2BHConvert();
      
            while(continueProgram == true)            
            {
               System.out.print("Enter an integer to be converted to binary and hex: ");
               System.out.println();
               string = scan.next();
               
               if(string.equals("end"))
               {
                   continueProgram = false;
               }
               else
               {
                   try 
                   {
                       value = Integer.parseInt(string);
                   } 
                   catch(Exception e) 
                   {
                       System.out.print("Not an integer");
                       calculate = false;
                   }   
                   
                   if (calculate == true)
                   {
                       System.out.println("Binary: " + converter.decimal2Binary(value));
                       System.out.println("Hex:    " + converter.decimal2Hex(value));
                       System.out.print("(type 'end' to quit)");
                       System.out.println();
                   }
                }
                
               //System.out.println();
               //System.out.print("Enter another number to convert? (y, n) ");
               //System.out.println();
               //answer = scan.next();
               //if(answer.equals("n"))
               //{
               //    continueProgram = false;
               //}
               System.out.println();
             }
        }
    }