
/**
 * Write a description of class D2B here.
 * 
 * Kevin Kirspel 
 * 10/8/10
 */

public class D2BHConvert
{
    int size;
    
    boolean originalValue = true;
    char hexLetters[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' }; 
    
    ArrayStack convertedStack;
    String convertedString;        

    public String decimal2Hex(int number)
    {
       int value = number;
                   
       if (originalValue)
       {
           convertedString = ""; 
           size = 0;                
           int orderBit = 1;
            
           //determine the size of arrayStack needed
           while (value >= orderBit)
           {
               orderBit = orderBit * 16;
               size++;
           }
           
           //create the stack with the size needed
           convertedStack = new ArrayStack(size);
           
           //ensure this if statement is not reran if this method 
           //is recursively called later
           originalValue = false;
       }
    
       int quotient = 0;
           
       //divide the given integer
       while (value >= 16)
       {
           value = value - 16;
           quotient++;
       }
       
       //if the remainder is less than 10, push it onto the arrayStack
       if (value < 10)
       {
           convertedStack.push(value);
       }
       //otherwise pull the hex-equivalent value from the array of hex values
       //and push that onto the arrayStack instead
       else
       {
           convertedStack.push(hexLetters[value - 10]);
       }
       
       //recursively call this method again if the quotient can be 
       //divided further
       if (quotient > 0)
       {
           decimal2Hex(quotient);
       }
       //otherwise populate the output string with the full converted value
       else
       {
           while(convertedStack.isEmpty() == false)
           {
               convertedString += convertedStack.top();
               convertedStack.pop();
           }  
       }
               
       //reset the method to be used again
       originalValue = true;
       
       return convertedString;
    } 
    
    
    public String decimal2Binary(int number)
    {  
       int value = number;
            
       if(originalValue)
       {
           convertedString = "";  
           size = 0;
           int orderBit = 1;
            
           //determine the size of arrayStack needed
           while (value >= orderBit)
           {
               orderBit = orderBit * 2;
               size++;
           }
           
           //create the stack with the size needed
           convertedStack = new ArrayStack(size);

           //ensure this if statement is not reran if this method 
           //is recursively called later
           originalValue= false;
       }
            
       int quotient = 0;
       
       //divide the given integer
       while (value >= 2)
       {
           value = value - 2;
           quotient++;
       }
       
       //if there is a remainder after the division, push a value of '1' 
       //for this bit, otherwise push '0'
       if (value == 1)
       {
           convertedStack.push("1"); 
       }
       else
       {
           convertedStack.push("0");   
       }
       
       //recursively call this method again if the quotient can be 
       //divided further
       if (quotient != 0)
       {
           decimal2Binary(quotient);
       }
       //otherwise populate the output string with the full converted value
       else
       {
           while(convertedStack.isEmpty() == false)
           {
               convertedString += convertedStack.top();
               convertedStack.pop();
               size--;
           }  
           //if there are remaining bit orders not calculated for, 
           //populate them with '0' values  
           while(size != 0)
           {
               convertedString += 0;
           }
       }
               
       //reset the method to be used again
       originalValue = true;
       
       return convertedString;
    }
        
}
