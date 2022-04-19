/**
 * Ryan Minneo
 * 03/05/2022
 * 
 * This program will create a table of random numbers from -49 to 49 and the size of the table on both axis will be determined by the user, but neither side can be greater than 10.
 * After creating this table the program will create a masked table where every negative integer including 0 will be set to 0 and every positive integer will be set to 1. 
 * This masked table will then be outputted to a text file "masked.txt" then the next method will take each line from the file and output it into the console.
 */
package project1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Project2
{
    
    /*
      The main method is the method that is running all of the other methods in the order specified.
    */
    public static void main(String[] args) throws FileNotFoundException
    {
        //project 1 variables
        Scanner userInput = new Scanner(System.in); 
        int rows = 0;
        int columns = 0;
        int[][] table;
        int[][] maskedTable;
        
        
        while (rows <= 0 || rows > 10)
        {
            System.out.println("How many rows should this table have (This value has to be greater than 0 and less than or equal to 10): ");
            rows = userInput.nextInt();
        }
        while (columns <= 0 || columns > 10)
        {
            System.out.println("How many columns should this table have (This value has to be greater than 0 and less than or equal to 10): ");
            columns = userInput.nextInt();
        }
        
        table = loadOriginalTable(rows, columns);
        maskedTable = getMask(rows, columns, table);
        outputTables(rows, columns, table);
        
        try
        {
            outputMaskedToFile(columns, rows, maskedTable);
            fileToConsole();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("The masked file couldn't be found.");
        }

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
    Method outputMaskedToFile will take the masked table made in the other method "getMask" and put it onto a new text file named "masked". This method will also put the word "After" before the table so that it will display the table with the header "After"
    @param - rows and columns from the previous methods
    @param - int[][] maskedTable is the masked table that will be put onto the new text file.
    */
    public static void outputMaskedToFile(int columns4, int rows4, int[][] maskedTable) throws FileNotFoundException
    {
        File masked = new File("masked.txt");
        PrintWriter fileOutput = new PrintWriter(masked);
        
        fileOutput.println("After");
        for(int i = 0; i < columns4; i++)
        {
            for(int j = 0; j < rows4; j++)
            {
                fileOutput.printf("%8d", maskedTable[i][j]);
            }
            fileOutput.println("");
        }
        fileOutput.close();
    }
    
    /*
    Method fileToConsole will take the file from the method outputMaskedToFile and read all of it and display it in the console.
    */
    public static void fileToConsole() throws FileNotFoundException
    {
        File masked = new File(".\\masked.txt");
        Scanner maskedScanner = new Scanner(masked);
        
        while(maskedScanner.hasNextLine())
        {
            System.out.println(maskedScanner.nextLine());
        }
        maskedScanner.close();
    }
    

    /*
      Will display both tables marking the original table with a "Before" label
      @param - rows4 and columns4 are the same thing as they were in the previous methods.
      @param - table is the original table created in the "loadOriginalTable"
    */
    public static void outputTables(int rows4, int columns4, int[][] table)
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
        System.out.println("");
    }
}
