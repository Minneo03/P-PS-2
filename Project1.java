/**
 * Ryan Minneo
 * 02/10/2022
 */
package project1;
import java.util.Scanner;


public class Project1
{
    
    /*
      The main method is the method that is running all of the other methods in the order specified.
    */
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in); 
        int rows;
        int columns;
        System.out.println("How many rows should this table have (This value has to be less than or equal to 10): ");
        rows = userInput.nextInt();
        if(rows > 10)
        {
            rows = 10;
        }
        System.out.println("How many columns should this table have (This value has to be less than or equal to 10): ");
        columns = userInput.nextInt();
        if(columns > 10)
        {
            columns = 10;
        }
        
        int[][] table = loadOriginalTable(rows, columns);
        int[][] maskedTable = getMask(rows, columns, table);
        outputTables(rows, columns, table, maskedTable);


    }

    /*
      This method will create a 2D array where the size is specified through the parameters and then set every index of the array to a random integer through the randomInt() method.
      @param - int rows2 determines the amount of rows the table that is being created through this method will have.
      @param - int columns2 is the same as rows2 but for the columns of the array rather than the rows.
      return - returns the table that is created in this method. This table is filled with ints.
    */
    public static int[][] loadOriginalTable(int rows2, int columns2)
    {
        int[][] originalTable = new int[columns2][rows2];
        int i;
        int j = 0;
        
        for(i = 0; i < columns2; i++)
        {
            for(j = 0; j < rows2; j++)
            {
                originalTable[i][j] = randomInt();
            }
        }
        return originalTable;
    }

    /*
      Generates a random number from -49 to 49
      return - returns the int generated in the method.
    */
    public static int randomInt()
    {
        return ((int)Math.floor(Math.random()*(49-(-48))+(-49)));
    }

    /*
      Method getMask will create a new table based on the original table where every positive integer is replaced with an int "1" and every negative integer including 0 is replaced with an int "0"
      @param - rows and columns for the new table, which will be the same as the "loadOriginalTable" method
      @param - int[][] originalTable2 is the original table
      return - returns the int[][] maskedTable
    */
    public static int[][] getMask(int rows3, int columns3, int[][] originalTable2)
    {
        int[][] originalMaskedTable = new int[columns3][rows3];
        
        for(int i = 0; i < columns3; i++)
        {
            for(int j = 0; j < rows3; j++)
            {
                if(originalTable2[i][j] > 0)
                {
                    originalMaskedTable[i][j] = 1;
                }
                else
                {
                    originalMaskedTable[i][j] = 0;
                }   
            }
        }
        return originalMaskedTable;
    }

    /*
      Will display both tables marking the original table with a "Before" label and the maskedTable with the label "After"
      @param - rows4 and columns4 are the same thing as they were in the previous methods.
      @param - table is the original table created in the "loadOriginalTable"
      @param - maskedTable is the table created in the "getMask" method.
    */
    public static void outputTables(int rows4, int columns4, int[][] table, int[][] maskedTable)
    {
        System.out.println("Before");
        for(int i = 0; i < columns4; i++)
        {
            for(int j = 0; j < rows4; j++)
            {
                System.out.printf("%8d", table[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("After");
        for(int i = 0; i < columns4; i++)
        {
            for(int j = 0; j < rows4; j++)
            {
                System.out.printf("%8d", maskedTable[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("");
    }
}
