package Homework6;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
   	
    	/* here I am going to use a recursion. I am going to count the number if ways
    	 * by first calculating the number of combinations when there are no quarters at all
    	 * which is going to be calculated in calculateNoQuater, which is basically
    	 * calculates the combination of dimes, nickels and pennies. Then I am going to
    	 * calculate when there is only one quarter by passing the rest to calculateNoQuater 
    	 * and so on till I reach max of the quarters.
    	 */
    	int k=cents/25;
    	int total = 0;
    	for (int i=0;i<=k;i++)
    	{
    		total = total + calculateNoQuarter(cents-25*i);
    	}
    	return total;	    			
    }
    
    public static int calculateNoQuarter(int cents)
  	 {
  		/*here I am pretty much calculating the combinations of the dimes, nickels and
  		 * pennies by going though number of the dimes and passing it to the 
  		 * calculateNoDimes, which is pretty much calculating combinations of the 
  		 * nickels and pennies. 
  		 */
  	    int k=cents/10;
  	    int total = 0;
  	    for (int i=0;i<=k;i++)
  	    {
  	    	total = total + calculateNoDimes(cents-10*i);
  	    }
  	    return total;	    			
  	 }
    
  	 public static int calculateNoDimes(int cents)
  	 {
  		/*here is almost the same story much calculating the combinations of the dimes,
  		 * nickels and pennies by going though number of the nickels by adding one
  		 * because number of the combinations with just pennies is one.
   		 */
  	    int k=cents/5;
  	    int total = 0;
  	    for (int i=0;i<=k;i++)
  	    {
  	    	total = total + 1;
  	    }
  	    return total;	    			
  	 }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) 
    {
    	  try
    	  {    
              //creating a file
    		  PrintWriter text = new PrintWriter("src/Homework6/CoinCombinations.txt");    
              
    		  //I am going to use an ArrayList since, we going need to access specific elements
    		  //and arrays are the best for that.
    		  ArrayList<Integer> list = new ArrayList<Integer>(4);
    		  list.add(0);
    		  list.add(0);
    		  list.add(0);
    		  list.add(0);
    		  
    		  /*Here it is pretty much does the same thing as in previous method but 
    		   * without recursion. I just go thought all the possible values of the
    		   * number of quarters from 0 to max, for each combinations of quarters
    		   * I go through the possible number of dimes, then for each dime number
    		   * I go through possible number of nickels and then I for each number of 
    		   * nickels there is only one combination of pennies, since they all have to
    		   * be there.
    		   */
    		  int k1=cents/25;
    		  for (int i1=0;i1<=k1;i1++)
    		  {
    			 //setting current number of quarters
    			 list.set(0, i1);
    			 //we have to subtract because these cents are already in the quarters
    			 int k2=(cents-25*i1)/10;
    			 for (int i2=0;i2<=k2;i2++)
    			 {
    				 //setting current number of dimes
    				 list.set(1, i2);
    				 //we have to subtract both quarters and dimes
    				 int k3=(cents-25*i1-10*i2)/5;
    				 for (int i3=0;i3<=k3;i3++)
    				 {
    					//setting current number of nickels and the rest are pennies
    					 list.set(2, i3);
    					 list.set(3, cents-25*i1-10*i2-5*i3);
    					 
    					 //printing the information to the file
    					 text.println("["+list.get(0)+","+list.get(1)+
    							 ","+list.get(2)+","+list.get(3)+"]");
    				 }
    			 }
    		  }
    		  //closing the file
              text.close();
              
              System.out.println("success...");    
          }
    	  catch(Exception e)
    	  {
    		  System.out.println(e);
    	  }
    }

} // End of class ChangeCalculator
