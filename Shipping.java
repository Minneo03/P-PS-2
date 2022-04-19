import java.util.Scanner;
/**
 * Ryan Minneo
 * 02/18/2022
 */
public class Shipping 
{
    public static void main(String[] args) 
    {
        System.out.println("What is the weight of the package? ");
        Scanner in = new Scanner(System.in);
        double weightPackage = in.nextDouble();
        double costOfShipping = weightToCost(weightPackage);
        
        System.out.printf("Cost of Package: $%.2f", costOfShipping);
        System.out.println("");
        
    }
    
    public static double weightToCost(double inWeight)
    {
        double outCost;
        if(inWeight < 1.0)
        {
            outCost = 7.95;
        }
        else if(inWeight < 6.0)
        {
            outCost = 13.52;
        }
        else if(inWeight < 10.0)
        {
            outCost = 22.33;
        }
        else
        {
            outCost = 25.50;
        }
        return outCost;
    }
}
