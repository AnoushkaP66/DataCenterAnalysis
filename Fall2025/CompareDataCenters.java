/**
 * Compare Data Centers
 *
 * This project compares a list of data centers with their costs (in millions of dollars) and the IT load (megawatts)
 * of each. The average, highest values, lowest values, and highest and lowest values of two corporations are all calculated.
 * Finally, the user will input a name of a corporation to see if it is included within the list of other data
 * center corporations.
 *_____________________________________________________
 * Anoushka Poojary
 * The date created
 * CMSC 255
 */

package Projects.CompareDataCenters;

import java.util.Scanner;

public class CompareDataCenters {
    //Main method
    public static void main(String[] args) {
        //Initialize Scanner variable
        Scanner input = new Scanner (System.in);

        //Initialize variable used to store a reference to user input
        String constructionFirm = "";

        //Declare arrays
        String[] corporateNames = {"Turner","Holder","HITT","DPR","Fortis","Mortenson","JE Dunn","Clune"};
        double[] constructionCost = {442.2,584.8,420.7,726.5,574.1,717.0,763.4,527.9};
        double[] ITLoad = {168.4,307.2,21.8,271.0,50.5,117.7,199.6,289.1};
        double[] operatingCost = {19.0,26.4,11.1,24.5,12.7,16.2,20.7,25.5};


        //Calls the methods that return the average of the values
        System.out.printf("The average construction cost in dollars: $%,.2f%s%n" , CompareDataCenters.calcAvg(constructionCost), 'M');
        System.out.printf("The average IT Load in megawatts is: %,.2f%s%n" , CompareDataCenters.calcAvg(ITLoad), "MW");

        //Calls the methods that returns the highest and lowest values
        System.out.printf("The highest construction cost in dollars: $%,.2f%s%n", CompareDataCenters.findHighValue(constructionCost), 'M');
        System.out.printf("The least operating cost in dollars is: $%,.2f%s%n", CompareDataCenters.findLeastValue(operatingCost), 'M');

        //Calls methods that returns the highest two values
        System.out.println("The two construction firms with the highest construction cost are: ");
        String[] largeNames = CompareDataCenters.findHighestTwo(corporateNames, constructionCost);
        for (String names : largeNames) {
            System.out.println(names);
        }

        //Calls methods that returns the lowest two values
        System.out.println("The two construction firms with the lowest IT Load are: ");
        String[] smallNames = CompareDataCenters.findLeastTwo(corporateNames, ITLoad);
        for (String names : smallNames) {
            System.out.println(names);
        }

        //Asks the user to enter a name of a corporation and compare with the array
        System.out.println("Enter a construction firm:");
        constructionFirm = input.nextLine().trim();

        //Compares the user input with the array to see if the two values are equal
        if (CompareDataCenters.findConstructionFirm(corporateNames, constructionFirm)) {
            System.out.println(constructionFirm + " is a construction firm in the array.");
        }
        else {
            System.out.println(constructionFirm + " is not a construction firm in the array.");
        }
    }
    //End of main method

    /**
     * This method calculates the average of numeric values in an array by adding all the values in the array and
     * storing in a sum variable. The sum is then divided by the length of the array used as an argument.
     * @param values
     * @return the average of the numeric values in the array
     */
    public static double calcAvg(double[] values) {
        double sum = 0.0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }


    /**
     * This method traverses through an array of numeric values to find the highest value. The variable highestNum starts
     * with the first element and then uses a for loop to traverse through the array starting at index 1. If a value in
     * the array is higher than the highestNum variable, then highestNum takes that value.
     * @param values
     * @return highestNum which is the highest value in the array
     */
    public static double findHighValue(double[] values) {
        double highestNum = values[0];
        for (int i = 1; i < values.length; i++){
            if (values[i] > highestNum) {
                highestNum = values[i];
            }
        }
        return highestNum;
    }


    /**
     * This method traverses through an array of numeric values to find the lowest value. The variable lowestNum starts
     * with the first element and then uses a for loop to traverse through the array starting at index 1. If a value in
     * the array is lower than the lowestNum variable, then lowestNum takes that value.
     * @param values
     * @return lowestNum which is the lowest value in the array
     */
    public static double findLeastValue(double[] values) {
        double lowestNum = values[0];
        for (int i = 1; i < values.length; i++){
            if (values[i] < lowestNum) {
                lowestNum = values[i];
            }
        }
        return lowestNum;
    }


    /**
     * This method returns the names of companies with the two highest values. This is done by initializing two values
     * referencing a name of a company and two values storing the numeric values associated with that company. The values
     * for the two largest numbers and name associated with those values are first initialized with index 0 and 1 respectively.
     * If the second-largest number is greater than the first, then those values swap. Then, an iteration of the arrays (both
     * numeric and String) begins. As the loop traverses through the array, values will swap if certain conditions are met.
     * After all the elements are checked, the method will return the names of the corporations.
     * @param names
     * @param values
     * @return String[] {largeName1, largeName2}
     */
    public static String[] findHighestTwo(String[] names, double[] values) {
        //Initialize values for largest value and company associated with that value at index 0
        double largeNum1 = values[0];
        String largeName1 = names[0];
        //Initialize values for 2nd largest value and company associated with that value at index 1
        double largeNum2 = values[1];
        String largeName2 = names[1];

        //Checks the first two elements of the array and swap them if the second element is smaller the first element
        if (largeNum2 > largeNum1) {
            //Swap algorithm for both the numeric and String values
            double temp = largeNum1;
            String temp2 = largeName1;

            largeNum1 = largeNum2;
            largeName1 = largeName2;

            largeNum2 = temp;
            largeName2 = temp2;
        }
        //Traverse through the array starting at index 2
        for (int i = 2; i < values.length; i++) {
            //Checks if an element in the array is larger than the largest number
            if (values[i] > largeNum1) {
                //The largest number becomes the second largest along with the name associated with it
                largeNum2 = largeNum1;
                largeName2 = largeName1;
                //The new value is given to the largest number along with the name associated with it
                largeNum1 = values[i];
                largeName1 = names[i];
            }
            //Checks if the element in the array is larger than the second-largest number but smaller than the first
            else if (values [i] > largeNum2 && values[i] < largeNum1) {
                //The second-largest number is updated with the new value
                largeNum2 = values[i];
                largeName2 = names[i];
            }
        }
        return new String[] {largeName1, largeName2};
    }


    /**
     * This method returns the names of companies with the two smallest values. This is done by initializing two values
     * referencing a name of a company and two values storing the numeric values associated with that company. The values
     * for the two smallest numbers and name associated with those values are first initialized with index 0 and 1 respectively.
     * If the second-lowest number is greater than the first, then those values swap. Then, an iteration of the arrays (both
     * numeric and String) begins. As the loop traverses through the array, values will swap if certain conditions are met.
     * After all the elements are checked, the method will return the names of the corporations.
     * @param names
     * @param values
     * @return String[] {smallName1, smallName2}
     */
    public static String[] findLeastTwo(String[] names, double[] values) {
        //Initialize values for smallest value and company associated with that value at index 0
        double smallNum1 = values[0];
        String smallName1 = names[0];
        //Initialize values for 2nd smallest value and company associated with that value at index 1
        double smallNum2 = values[1];
        String smallName2 = names[1];

        //Checks the first two elements of the array and swap them if the second element is smaller the first element
        if (smallNum2 < smallNum1) {
            //Swap algorithm for both the numeric and String values
            double temp = smallNum1;
            String temp2 = smallName1;

            smallNum1 = smallNum2;
            smallName1 = smallName2;

            smallNum2 = temp;
            smallName2 = temp2;
        }
        //Traverse through the array starting at index 2
        for (int i = 2; i < values.length; i++) {
            //Checks if an element in the array is smaller than the smallest number
            if (values[i] < smallNum1) {
                //The smallest number becomes the second smallest along with the name associated with it
                smallNum2 = smallNum1;
                smallName2 = smallName1;
                //The new value is given to the smallest number along with the name associated with it
                smallNum1 = values[i];
                smallName1 = names[i];
            }
            //The second-smallest number is updated with the new value
            else if (values [i] < smallNum2 && values[i] > smallNum1) {
                //The second-smallest number is updated with the new value
                smallNum2 = values[i];
                smallName2 = names[i];
            }
        }
        return new String[] {smallName1, smallName2};
    }


    /**
     * This method finds if the user input (constructionFirm) is in the array of corporation names by traversing through
     * the array and finding a matching String value.
     * @param names
     * @param constructionFirm
     * @return true if user input and the name of the construction firm in the array match
     */
    public static boolean findConstructionFirm(String[] names, String constructionFirm) {
        for (int i = 0; i < names.length; i++) {
            if (constructionFirm.equals(names[i])) {
                return true;
            }
        }
        return false;
    }
}