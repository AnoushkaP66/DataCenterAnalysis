/**
 * Data Center Cost Analysis
 *
 * This project takes in a file of data centers, calculates values associated with those data centers, and then outputs
 * a new file of calculations.
 *_____________________________________________________
 * Anoushka Poojary
 * 11/05/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.AnalyzingDataCenters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataCenterCostAnalysis {
    public static void main (String[] args) {
        //Create input and output files
        File inputFile = new File (args[0]);
        File outputFile = new File (args[1]);

        try {
            //Call openFile method to read the data centers and the values
            ArrayList<String> fileData = openFile(inputFile);
            System.out.println("Input file correct");

            //Call createObjects method to create an ArrayList of objects using the file opened
            ArrayList<DataCenter> dataCenters = createObjects(fileData);

            //Calculations
            double meanConstructionCost = findMean(dataCenters, DataCenterAttributes.CONSTRUCTION_COST);
            double highOperatingCost = findHighValue(dataCenters, DataCenterAttributes.IT_LOAD);
            DataCenter meanDataCenter = findMeanDataCenter(dataCenters, DataCenterAttributes.CONSTRUCTION_COST, meanConstructionCost);
            ArrayList<DataCenter> lowestDataCenters = findLowestDataCenters(dataCenters, DataCenterAttributes.CONSTRUCTION_COST, meanConstructionCost);

            //Output
            PrintWriter out = new PrintWriter(outputFile);
            System.out.println("Output file correct");

            outputToFile("The average construction cost of all data centers is: ", meanConstructionCost, out);
            outputToFile("The highest IT load of all data centers is: ", highOperatingCost, out);
            outputToFile("The data center closest to the average construction cost is: ", meanDataCenter, out);
            outputToFile("The data centers below the average value for construction cost are: ", lowestDataCenters, out);

            //Close resource
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Incorrect input filename");
        } catch (IOException e) {
            System.out.println("Incorrect output filename");
        }
    }

    /**
     * This method is used to convert a file to an ArrayList. It is done by adding each line of information into a String
     * ArrayList and then returning the ArrayList.
     * @param inputFile
     * @return data
     * @throws FileNotFoundException
     */
    public static ArrayList<String> openFile (File inputFile) throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();
        Scanner in = new Scanner(inputFile);
        while (in.hasNextLine()) {
            String info = in.nextLine();
            data.add(info);
        }
        in.close();
        return data;
    }

    /**
     * This method is used to create a list of DataCenter objects using an ArrayList of Strings. This is done by creating
     * an array of elements separated by spaces and then assigning those elements to an attribute (all which are in their
     * respective position) and then use those attributes to create a new DataCenter object to store the attribute values.
     * The DataCenter object is then stored into an ArrayList of data centers and that list is returned.
     * @param lines
     * @return dataCenters
     */
    public static ArrayList<DataCenter> createObjects (ArrayList<String> lines) {
        //Create new DataCenter object
        ArrayList<DataCenter> dataCenters = new ArrayList<>();

        //Separate the lines of data
        for (String line : lines) {
            String[] elements = line.split("\t");

            //Set each attribute to an element in the array
            String constructionFirm = elements[0];
            double constructionCost = convertDouble(elements[1]);
            double ITLoad = convertDouble(elements[2]);
            double operatingCost = convertDouble(elements[3]);

            //Use values to create a new DataCenter object and then add the object to a dataCenters list
            DataCenter dataCenter = new DataCenter(constructionFirm, constructionCost, ITLoad, operatingCost);
            dataCenters.add(dataCenter);
        }
        return dataCenters;
    }


    /**
     * This method is used to find the mean value of a specific attribute for all DataCenters.
     * @param dataCenters
     * @param attribute
     * @return average of a DataCenter attribute
     */
    public static double findMean (ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute) {
        double total = 0.0;
        int numAttributes = 0;

        //Iterate through the dataCenters ArrayList
        for (DataCenter dataCenter : dataCenters) {
            double num = getAttribute(dataCenter, attribute);
            /*
            If the attribute value is greater than zero, then add that num to the total and increase the count variable,
            numAttributes.
            */
            if (num >= 0) {
                total += num;
                numAttributes++;
            }
        }
        //Return the average of the DataCenter attribute
        return total / numAttributes;
    }

    /**
     * This method is used to find the maximum value for a specific attribute in the list of data centers. This is done
     * using a helper method to get the attribute value and then checking if that value is greater than the max value.
     * @param dataCenters
     * @param attribute
     * @return maxValue
     */
    public static double findHighValue (ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute) {
        double maxValue = 0.0;
        //Iterate through the ArrayList
        for (DataCenter dataCenter : dataCenters) {
            double num = getAttribute(dataCenter, attribute);

            //If the attribute value is greater than the max value, then the max value is assigned to the new value
            if (num > maxValue) {
                maxValue = num;
            }
        }

        return maxValue;
    }

    /**
     * This method returns the DataCenter object whose value for the given attribute within the ArrayList of
     * DataCenter objects is closest to the mean value of the data for that given attribute. This is done by setting
     * a closestDataCenter variable to null and then initializing a closest difference double variable. The method
     * implements the getAttribute() helper method for a num and then subtracts that num by the mean to get a difference.
     * If the difference is less than the closest difference value, then that difference becomes the new value and the
     * closestDataCenter variable gets the DataCenter object associated with that value.
     * @param dataCenters
     * @param attribute
     * @param meanValue
     * @return closestDataCenter
     */
    public static DataCenter findMeanDataCenter (ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute, double meanValue) {
        //Initialize variables
        DataCenter closestDataCenter = null;
        double closestDifference = Double.MAX_VALUE;

        //Iterates through the dataCenter ArrayList
        for (DataCenter dataCenter : dataCenters) {

            //Gets the attribute and then a difference by subtracting the meanValue parameter from the attribute value
            double num = getAttribute(dataCenter, attribute);
            double difference = Math.abs(num - meanValue);

            //closestDifference is assigned a new value if conditions are met along with a new value for closestDataCenter
            if (difference < closestDifference) {
                closestDifference = difference;
                closestDataCenter = dataCenter;
            }
        }

        return closestDataCenter;
    }

    /**
     * This method returns an ArrayList of data centers which attribute values are less than the value assigned in the
     * arguments.
     * @param dataCenters
     * @param attribute
     * @param value
     * @return lowest
     */
    public static ArrayList<DataCenter> findLowestDataCenters (ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute, double value) {
        ArrayList<DataCenter> lowest = new ArrayList<>();

        //Iterates through the ArrayList of dataCenters
        for (DataCenter dataCenter : dataCenters) {
            /*
            Get the attribute value and if it is less than the argument value, then that data center is added to an
            ArrayList of dataCenters with low values
            */
            double num = getAttribute(dataCenter, attribute);
            if (num < value) {
                lowest.add(dataCenter);
            }
        }
        return lowest;
    }

    /**
     * This method prints an ArrayList of dataCenters
     * @param outputMessage
     * @param dataCenters
     * @param out
     */
    public static void outputToFile (String outputMessage, ArrayList<DataCenter> dataCenters, PrintWriter out){
        out.print(outputMessage);
        for (DataCenter dataCenter : dataCenters) {
            out.print((dataCenter) + " "); //Need to put spaces in between objects
        }
        out.println();
        out.println();
    }

    /**
     * This method prints a DataCenter object
     * @param outputMessage
     * @param dataCenter
     * @param out
     */
    public static void outputToFile (String outputMessage, DataCenter dataCenter, PrintWriter out){
        out.println(outputMessage + dataCenter.toString());
        out.println();
    }

    /**
     * This method prints a double value
     * @param outputMessage
     * @param value
     * @param out
     */
    public static void outputToFile (String outputMessage, double value, PrintWriter out){
        out.println(outputMessage + String.format("%.2f", value));
        out.println();
    }



    /**
     * This is a helper method used to convert from a String value to a double while also handling any exceptions and errors.
     * The method first takes a String value and converts it to a double. If either the method fails to convert or if the
     * converted value is less than 0, then the method simply returns 0.0.
     * @param num
     * @return
     */
    private static double convertDouble (String num) {
        try {
            double parsedNum = Double.parseDouble(num);
            if (parsedNum < 0){
                return 0.0;
            }
            return parsedNum;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * This is the helper method that will be used for the calculations. It returns the value of the attributes of the
     * dataCenter created. However, if none of the other attributes are applied, then the method returns 0.0.
     * @param dataCenter
     * @param attribute
     * @return
     */
    private static double getAttribute (DataCenter dataCenter, DataCenterAttributes attribute) {
        if (attribute.equals(DataCenterAttributes.CONSTRUCTION_COST)) {
            return dataCenter.getConstructionCost();
        }
        else if (attribute.equals(DataCenterAttributes.IT_LOAD)) {
            return dataCenter.getITLoad();
        }
        else if (attribute.equals(DataCenterAttributes.OPERATING_COST)){
            return dataCenter.getOperatingCost();
        }
        else {
            return 0.0;
        }
    }
}
