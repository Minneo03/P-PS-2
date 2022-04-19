/*
 * Ryan Minneo
 * 04/15/2022
 */
import java.util.*;
package calculator;
public class Calculator 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String operator;
        double num1;
        double num2;
        double result;
        
        System.out.println("Would you like to add or subtract? Enter \"+\" or \"-\"");
        operator = input.next();
        System.out.println("What is the first number of the operation: ");
        num1 = input.nextDouble();
        System.out.println("What is the second number of the operation: ");
        num2 = input.nextDouble();
        
        if (operator.equals("+"))
        {
            result = Add(num1, num2);
            Display(operator, num1, num2, result);
        }
        else if (operator.equals("-"))
        {
            result = Subtract(num1, num2);
            Display(operator, num1, num2, result);
        }
        else
        {
            System.out.println("Please input the proper values.");
        }
        
    }
    
    public static double Add(double leftNum, double rightNum)
    {
        double resulting;
        
        resulting = leftNum + rightNum;
        return resulting;
    }
    
    public static double Subtract(double leftNum, double rightNum)
    {
        double resulting;
        
        resulting = leftNum - rightNum;
        return resulting;
    }
    
    public static void Display(String operation, double leftNum, double rightNum, double resultingNum)
    {
        System.out.printf("%.2f %s %.2f = %.2f", leftNum, operation, rightNum, resultingNum);
        System.out.println("");
    }
}
