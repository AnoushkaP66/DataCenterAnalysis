/**
 * Operating Costs
 *
 * This project analyzes the operating costs of various data centers based on the failure-rate, hardware, maintenance, power,
 * area, and climate-control.
 *_____________________________________________________
 * @author Anoushka Poojary
 * @version 10/07/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.OperatingCosts;

import java.util.ArrayList;
import java.util.Arrays;

public class OperatingCosts {
    public static void main (String[] args) {
        //Initialize String values
        String operatingCostsMetric = "failure-rate,hardware,maintenance,power,area,climate-control";
        String operatingCostValues = "0.09,4.2,0.22,6.1,30,6.2<>0.08,7.6,0.53,9.5,48.5,8.88<>0.19,0.7,0.35,6.1,47,8.6<>0.23,2.0,0.88,8.71,28,7.49<>0.10,6.6,0.83,10.8,43.6,7.46<>0.22,2.3,0.28,8.8,28,14.29";

        //Initialize String[] metrics = getOperatingMetrics(operatingCostsMetric)
        String[] metrics = getOperatingMetrics(operatingCostsMetric);
        //Initialize double[][] values = getDataCenters (operatingCostValues)
        double[][] values = getDataCenters (operatingCostValues);
        //Output “Data Centers under the annual cost limit are: [" + findAnnualOperationCost(values) + “]”
        System.out.println("Data Centers under the annual cost limit are: " + Arrays.toString(findAnnualOperationCost(values)));
        //Output “The two highest value operating cost metrics for Data Center 1 are: ” + searchHighestMetric (values, metrics, 1)
        System.out.println("The two highest value operating cost metrics for Data Center 1 are: " + OperatingCosts.searchHighestMetric (values, metrics, 1));
        //Output “The Data Center with the highest power is: ” + searchHighesDataCenter(values, metrics, "power)
        System.out.println("The Data Center with the highest power is: " + OperatingCosts.searchHighestDataCenter(values, metrics, "power"));
    }

    /**
     * This method returns the metric names in an array form by dividing the String in between the commas.
     * @param metricNames
     * @return an array of metricNames
     */
    public static String[] getOperatingMetrics (String metricNames) {
        return metricNames.split(",");
    }

    /**
     * This method returns an array of metric values that were previously in String format by dividing the String separated
     * by "<>" symbols and then creating another String array that splits the perevious String array in between commas. The
     * result is then converted from a String to a double, and then stored in a double 2D array, dataCenterValues.
     * @param dataCenterMetrics
     * @return dataCenterValues, the 2D array that stores the metric values
     */
    public static double[][] getDataCenters (String dataCenterMetrics) {
        String[] metrics = dataCenterMetrics.split("<>");
        double[][] dataCenterValues = new double [metrics.length][metrics[0].split(",").length];

        for (int i = 0; i < metrics.length; i++) {
            String[] nums = metrics[i].split(",");
            for (int j = 0; j < nums.length; j++) {
                dataCenterValues[i][j] = Double.parseDouble(nums[j]);
            }
        }
        return dataCenterValues;
    }

    /**
     * This method returns an array of data centers that meet a certain annual operating costs criteria which can only be
     * at most, 18.5. This is done by first creating an ArrayList to easily edit the size of the array. Next, the method
     * will iterate through an array of data centers and initialize the values of the metric names. The formula for operating
     * costs is calculated using those values, and if the cost is less than or equal to 18.5, then that data center number is
     * added to the ArrayList. The loop continues to the next row, and this process starts again until the max length is reached.
     * Finally, the method will convert the ArrayList into a double array and return the array, meetCriteria.
     * @param dataCenters
     * @return meetCriteria, the double array of values that meet the annual operating cost criteria
     */
    public static int[] findAnnualOperationCost(double[][] dataCenters) {
        //Create an ArrayList object so that adding values is easier
        ArrayList<Integer> metrics = new ArrayList<>();

        for (int i = 0; i < dataCenters.length; i++) {
            //Initialize values for metric names
            double failureRate = dataCenters[i][0];
            double hardware = dataCenters[i][1];
            double maintenance = dataCenters[i][2];
            double power = dataCenters[i][3];
            double area = dataCenters[i][4];
            double climateControl = dataCenters[i][5];

            //This is the formula to find the cost of operation
            double operationCost = (1 + failureRate) * (hardware * maintenance + power + (area / climateControl));
            //The data center value is added to the ArrayList if it is less than or equal to 18.5
            if (operationCost <= 18.5) {
                metrics.add(i + 1);
            }
        }

        //Convert from ArrayList to int[]
        int[] meetCriteria = new int[metrics.size()];
        for (int i = 0; i < meetCriteria.length; i++){
            meetCriteria[i] = metrics.get(i);
        }

        return meetCriteria;
    }

    /**
     * This method returns the metric names with the two highest metric values. This is done by initializing two values
     * referencing a metric name and two values storing the numeric values associated with that metric. The values
     * for the two largest values and metric associated with those values are first initialized with index 0 and 1 respectively.
     * If the second-largest value is greater than the first, then those values swap. Then, an iteration of the arrays (both
     * numeric and String) begins. As the loop traverses through the array, values will swap if certain conditions are met.
     * After all the elements are checked, the method will return the two highest metrics.
     * @param dataCenters
     * @param metrics
     * @param dataCenter
     * @return highestMetric1 and highestMetric2 (the two metrics with the highest values)
     */
    public static String searchHighestMetric(double [][] dataCenters, String[] metrics, int dataCenter) {
        //I am fucking sick and tired of typing "dataCenter - 1"
        int rowIndex = dataCenter - 1;

        double highest = dataCenters[rowIndex][0]; String highestMetric1 = metrics[0];
        double highest2 = dataCenters[rowIndex][1]; String highestMetric2 = metrics[1];

        //Swap the highest and second-highest values if the second element is larger than the first
        if (highest2 > highest) {
            double temp = highest; String temp2 = highestMetric1;
            highest = highest2; highestMetric1 = highestMetric2;
            highest2 = temp; highestMetric2 = temp2;
        }

        //Loop through the array starting from the third element
        for (int i = 2; i < dataCenters[rowIndex].length; i++) {
            //Checks if an element in the array is larger than the highest metric value
            if (dataCenters[rowIndex][i] > highest) {
                //The highest metric value becomes the second highest along with the metric associated with it
                highest2 = highest; highestMetric2 = highestMetric1;
                //The new value is given to the highest metric value along with the metric associated with it
                highest = dataCenters[rowIndex][i]; highestMetric1 = metrics[i];
            }
            //Checks if the element in the array is larger than the second-largest metric value but smaller than the first
            else if (dataCenters[rowIndex][i] > highest2 && dataCenters[rowIndex][i] < highest){
                //The second-largest metric value is updated with the new value
                highest2 = dataCenters[rowIndex][i]; highestMetric2 = metrics[i];
            }
        }

        return highestMetric1 + " and " + highestMetric2;
    }

    /**
     * This method returns the highest numeric value of the data center by taking the metric name and searching for the matching
     * index by comparing the String name and the index position. Next, the method will iterate through each row to determine
     * if there is a value larger than the value in the previous row. If the metric value in that row is larger than the
     * value that's set to the highest number, then the value for the highest number changes and the data center, highestDataCenter
     * increases by 1.
     * @param dataCenters
     * @param metrics
     * @param metric
     * @return highestDataCenter
     */
    public static int searchHighestDataCenter(double [][] dataCenters, String[] metrics, String metric) {
        double highestNum = dataCenters[0][0];
        int metricIndex = 0;
        int highestDataCenter = 0;

        for (int i = 0; i < metrics.length; i++) {
            if (metrics[i].equals(metric)) {
                metricIndex = i;
            }
        }

        for (int i = 0; i < dataCenters.length; i++){
            if (dataCenters[i][metricIndex] > highestNum){
                highestNum = dataCenters[i][metricIndex];
                highestDataCenter = i + 1;
            }
        }

        return highestDataCenter;
    }

}
