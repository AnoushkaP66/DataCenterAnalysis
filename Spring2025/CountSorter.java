/***
 * @author Anoushka Poojary
 * CMSC 256 - CMSC 256 - Intro to Data Structures Section 901
 * Project 3 - Code
 * @version 2/21/2025
 * This project demonstrates a counting sort algorithm, which is done by finding the highest value in an array, creating an
 * array to store the amount of times a number appears in the array, and then sorting the original array based on the amount of
 * times that number appears in the count array. The program handles exceptions for empty arrays or if there is a negative value
 * present in the array.
 */
package cmsc256;

public class CountSorter {
    public static void main (String[] args) {
        int[] anArray = {4, 2, 1, 3, 4, 1, 2, 1, 0, 4};

        //Test the hasAllPositiveElements method
        boolean positiveElements = hasAllPositiveElements(anArray);
        System.out.println(positiveElements);

        //Test the findMax method
        int max = findMax(anArray);
        System.out.println(max);

        //Test the getCounters method
        int[] counters = getCounters(anArray);
        for (int nums : counters) {
            System.out.print(nums + " ");
        }
        System.out.println();

        //Sorting the array
        int[] sortedArray = countingSort(anArray);
        for (int nums : sortedArray) {
            System.out.print(nums + " ");
        }
    }

    /**
     * This method checks to see if an array has only positive integers.
     * @param anArray
     * @return true if all elements in the array are positive or false if the method finds a value that is negative
     * @throws IllegalArgumentException when the array is null
     */
    public static boolean hasAllPositiveElements(final int[] anArray) {
        if (anArray == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        //Iterates through the all elements in the array using an enhanced for loop
        //Returns false if a negative element is found
        //Returns true if all elements are positive
        for (int i : anArray) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method returns the highest number in the array.
     * @param array the original array
     * @return max value in array
     */
    public static int findMax(final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        // returns the maximum value in the parameter array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * This method returns an array containing the count for each value in the parameter array.
     * @param anArray the original array
     * @return counterArray the new array containing the count for each element in the original array
     * @throws IllegalArgumentException when the array is either empty/null or there is a negative integer in the array
     */
    public static int[] getCounters(final int[] anArray) {
        //Exception 1 thrown - empty array
        if (anArray == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        //Exception 2 thrown - has a negative integer
        else if (!hasAllPositiveElements(anArray)){
            throw new IllegalArgumentException("Positive elements only!");
        }
        //If exceptions aren't thrown, the following conditions are run.
        else {
            //The new array is initialized by the array's maximum number plus one because Java indexing starts at 0
            int[] countArray = new int[findMax(anArray) + 1];
            //The code iterates through all elements of the array and increments the count for each value that appears in
            //the count array
            for (int value : anArray) {
                countArray[value]++;
            }
            return countArray;
        }
    }

    /**
     * This method returns a sorted array based on the values of the parameter counter array. It does this by adding all
     * elements, using that total to create a new sorted array, and then inserting all elements in order from the counter
     * array to the new sorted array.
     * @param countArray the array of counters
     * @return sortArray the original array that was sorted because of the countArray
     */
    public static int[] convertCountersToSortedArray(final int[] countArray) {
        //Initialize numValues
        int totalValue = 0;
        //The total value of all elements in the counter array is calculated using a for loop
        for (int i = 0; i < countArray.length; i++) {
            totalValue += countArray[i];
        }

        //New sortedArray is created with the same capacity as the total calculated earlier
        int[] sortedArray = new int[totalValue];
        //Initialize an index value for traversal purposes
        int index = 0;

        //Nested for loop for sorting the values
        //This is done by iterating through the counter array by adding each value of i to the sorted array
        //by the number of times it appears in the counter array
        for (int i = 0; i < countArray.length; i++) {
            for(int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }

    /**
     * This method calls the other methods to sort the parameter array
     * @param anArray the original array
     * @return sorted array
     * @throws IllegalArgumentException if array is empty or if there is a negative integer in the array
     */
    public static int[] countingSort(final int[] anArray) {
        if (anArray == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if(!hasAllPositiveElements(anArray)) {
            throw new IllegalArgumentException("Positive elements only!");
        }
        int[] counters = getCounters(anArray);
        return convertCountersToSortedArray(counters);
    }


}
