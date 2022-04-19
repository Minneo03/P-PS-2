/*
Ryan Minneo
04/01/2022

This program will create a menu for the user to either add, delete, search, return length, or display the an ArrayList. This menu will continue looping around, allowing the user to infinetely add to the list, or any of the other options I stated above. Before the option is provided, the entire menu will be displayed automatically. The code itself will use a switch statement to determine which operation the user wants to use on the ArrayList. The user will also be given the option to exit the program whenever the menu is displayed.
*/

import java.util.*;
 

//package project3;

public class Project3 {

    static boolean exit = false;
    /**
     * The main method is the method that is running all of the other methods in the order specified. It will use a while loop continue doing operations on the ArrayList until the user specifies. This method will utilize a switch statement to determine which operation the user wants to complete.
     * @param - exit - uses this boolean to exit the program when the user specifies.
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String command = "";
        
        while (exit == false)
        {
            System.out.println("Would you like to Add, Delete, Search, Retrieve, GetLength, or Display the list? Or would you like to Exit the program?");
            try 
            {
                command = input.next();
            }
            catch (InputMismatchException exception)
            {   
                System.out.println("Please type in one of the commands listed. (InputMismatchException)");
            }
            
            switch (command.toLowerCase())
            {
                case ("add"):
                    Add(names);
                    break;
                case ("delete"):
                    Delete(names);
                    break;
                case ("search"):
                    Search(names);
                    break;
                case ("retrieve"):
                    Retrieve(names);
                    break;
                case ("getlength"):
                    GetLength(names);
                    break;
                case ("display"):
                    Display(names);
                    break;
                case ("exit"):
                    Exit();
                    break;
                default:
                    System.out.println("Please type in one of the commands listed.");
                    break;
            }
        }
    }
    
    /*
    This method will add an element to the arraylist either to the end of the arraylist or at an index specified by the user.
    @param - nameList - pulls the main arrayList so that this method can add to that list.
    */
    public static void Add(ArrayList nameList)
    {
        Scanner input = new Scanner(System.in);
        int choice;
        String name;
        
        System.out.println("Would you like to (1) add at the end of the list or (2) at a certain index?");
        try 
        {
            choice = input.nextInt();
            switch (choice)
            {
                case (1):
                    System.out.println("Enter the name you would like to add at the end of the list. ");
                    name = input.next();
                    nameList.add(name);
                    System.out.println(name + " has been added to the end of the ArrayList.");
                    break;
                case (2):
                    System.out.println("What index would you like to add an element at? ");
                    choice = input.nextInt();
                    if (choice > nameList.size()-1)
                    {
                        System.out.println("Index " + choice + " is out of bounds for this ArrayList.");
                        break;
                    }
                    else
                    {
                        System.out.println("Enter the name you would like to add at index " + choice + ". ");
                        name = input.next();
                        nameList.add(choice, name);
                        System.out.println(name + " has been added to the ArrayList at index " + choice + ".");
                        break;
                    }
                default:
                    System.out.println("Please enter \"1\" or \"2\" when choosing here.");
            }
        }
        catch (InputMismatchException exception)
        {   
            System.out.println("Please type in one of the commands listed. (InputMismatchException)");
        }
    }
    
    /*
    This method will delete an element in the ArrayList either by allowing the user to input the element itself to find and delete it, or allowing the user to input an index of the element that the user wants to delete.
    @param - nameList - the main ArrayList of the project.
    */
    public static void Delete(ArrayList nameList)
    {
        Scanner input = new Scanner(System.in);
        String element;
        int choice;
        int index;
        boolean found = false;
        
        try
        {
            System.out.println("Would you like to (1) delete an object by name or (2) delete at a certain index?");
            choice = input.nextInt();
            if (choice == 1)
            {
                System.out.println("What is the name of the object you are trying to delete? ");
                element = input.next();
                for (int i = 0; i < nameList.size(); i++)
                {
                    if (element.equals((nameList.get(i)).toString()))
                    {
                        nameList.remove(i);
                        System.out.println(element + " has been deleted from the ArrayList.");
                        found = true;
                    }
                }
                if (found == false)
                {
                    System.out.println("Element " + element + " could not be found in this ArrayList.");
                }
            }
            else if (choice == 2)
            {
                System.out.println("What is the index of the object you want to delete?");
                index = input.nextInt();
                if (index > nameList.size()-1)
                {
                    System.out.println("Index " + index + " is out of bounds for this ArrayList.");
                }
                else
                {
                    element = (nameList.get(index)).toString();
                    nameList.remove(index);
                    System.out.println("The element " + element + " has been removed from the ArrayList.");
                }
            }
            else
            {
                System.out.println("Please enter \"1\" or \"2\" when choosing here.");
            }
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Please type in one of the commands listed. (InputMismatchException)");
        }
        
    }
    
    /*
    The search method will find the index of an element that the user inputs.
    @param - nameList - the main ArrayList of this program.
    */
    public static void Search(ArrayList nameList)
    {
        Scanner input = new Scanner(System.in);
        String element;
        boolean found = false;
        
        try 
        {
            System.out.println("What is the element that you are trying to find? ");
            element = input.next();
            for (int i = 0; i < nameList.size(); i++)
            {
                if (element.equals((nameList.get(i)).toString()))
                {
                    System.out.println(element + " is at index " + i + " in the ArrayList.");
                    found = true;
                }
            }
            if (found == false)
            {
                System.out.println("Element " + element + " could not be found in this ArrayList.");
            }
        }
        catch (InputMismatchException exception) 
        {
            System.out.println("Please type in one of the commands listed. (InputMismatchException)");
        }
    }
    
    /*
    The retrieve method will find what the element is at a certain index in the ArrayList, where the user inputs the index.
    @param - nameList - the main ArrayList of the program.
    */
    public static void Retrieve(ArrayList nameList)
    {
        Scanner input = new Scanner(System.in);
        int index;
        String element;
        
        try 
        {
            System.out.println("What index are you trying to retreive?");
            index = input.nextInt();
            if (index > nameList.size()-1)
            {
                System.out.println("The index " + index + " is out of bounds.");
            }
            else
            {
                element = (nameList.get(index)).toString();
                System.out.println("The name at index " + index + " is " + element + ".");
            }
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Please type in one of the commands listed. (InputMismatchException)");
        }
        
    }
    
    /*
    The getlength method will display the length of the list to the user.
    @param - nameList - the main ArrayList of the program.
    */
    public static void GetLength(ArrayList nameList)
    {
        System.out.println("The size of the array is " + nameList.size() + ".");
    }
    
    /*
    The display method will simply print out the ArrayList nameList
    @param - nameList - the main ArrayList of the program.
    */
    public static void Display(ArrayList nameList)
    {
        System.out.println(nameList);
    }
    
    /*
    The exit method will allow the user to quit the program and end the while loop in the main method by changing the static variable exit to true.
    @param - exit - static variable that determines whether to continue the while loop in the main method or not. The only time this variable will be true is when the user decides to exit the program.
    */
    public static void Exit()
    {
        exit = true;
    }
}
