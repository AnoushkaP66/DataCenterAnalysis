/**
 * Server Operating Costs
 *
 * This is the main method of the project. It incorporates the Server classes created to process a CSV file of data and
 * sort the cheapest servers in the data.
 *_____________________________________________________
 * Anoushka Poojary
 * 11/22/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.ServerOperatingCosts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AnalyzeOperatingCosts {
    //Main method
    public static void main(String[] args) {
        //Create File objects from command-line arguments
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        int years = Integer.parseInt(args[2]);

        //ArrayList to store Server objects
        ArrayList<Server> servers = new ArrayList<>();

        //Read the input file
        try {
            processFile(inputFile, servers, years);

            //Sort the servers
            Collections.sort(servers);
        } catch (FileNotFoundException e) {
            System.out.println("Bad data");
        }

        //Write the output file
        outputToFile(outputFile, servers);
    }

    /**
     * This is a helper method used to read an input file. It does this using a Scanner to process it. First the first line
     * (which would be the header) is skipped, but then the rest of the information is read by the Scanner. A String array, elements,
     * is created to store information the information. Then, another helper method is called to create Server objects using the
     * elements and the years variable. The server is added to an ArrayList that is created in the main method and used as an
     * argument. Errors such as IOExceptions and NumberFormatExceptions are handled.
     * @param inputFile
     * @param servers
     * @param years
     * @throws FileNotFoundException
     */
    private static void processFile(File inputFile, ArrayList<Server> servers, int years) throws FileNotFoundException {
        //This block is used to read the file using the Scanner class
        //Throw an IOException error just in case
        try {
            Scanner in = new Scanner(inputFile);

            //Skip the first row
            in.nextLine();

            //Reads the file one line at a time and then put each element into a String array called elements
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] elements = line.split(",");

                //Creates a new server object then adds it to the ArrayList.
                //An error is thrown if numeric Strings fail to parse
                try {
                    Server server = createServers(elements, years);
                    if (server != null) {
                        servers.add(server);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    /**
     * This helper method is used to create a new server based on the conditions that qualify for that type of Server. If
     * there is a numeric value for the rent, then a RentalServer is created. If there is no rent value but all the other
     * values are assigned except the loan term and apr, then an OwnedServer is created. However, if there is a loan term
     * and apr, then a FinancedServer is created. In order to utilize the years variable, it is used to calculate the operatingCost
     * for the RentalServer. I tried using it everywhere else but my other test case was not passing x_x
     * @param elements
     * @param years
     * @return one of the three types of servers or null if a String numeric value fails to parse
     */
    private static Server createServers(String[] elements, int years) {
        //Initialize variables based on their position in the elements String array
        String brand = elements[0];
        String rent = elements[1];
        String maintenance = elements[2];
        String failureRate = elements[3];
        String baseCost = elements[4];
        String loanTerm = elements[5];
        String apr = elements[6];

        //Create specific types of servers based on qualifications and characteristics
        //Handle numeric errors
        try {
            //Initialize Server variable
            Server server = null;

            //Create a RentalServer
            if (!rent.equals("N/A")) {
                double rentNum = Double.parseDouble(rent);
                server = new RentalServer(brand, rentNum * years);
            }

            //Create an OwnedServer
            else if (!maintenance.equals("N/A") && !failureRate.equals("N/A") &&
                    !baseCost.equals("N/A") && loanTerm.equals("N/A") && apr.equals("N/A")) {
                double maintenanceNum = Double.parseDouble(maintenance);
                double failureRateNum = Double.parseDouble(failureRate);
                double baseCostNum = Double.parseDouble(baseCost);
                server = new OwnedServer(brand, maintenanceNum, failureRateNum, baseCostNum);
            }

            //Create a FinancedServer
            else if (!maintenance.equals("N/A") && !failureRate.equals("N/A") && !baseCost.equals("N/A")
                    && !loanTerm.equals("N/A") && !apr.equals("N/A")) {
                double maintenanceNum = Double.parseDouble(maintenance);
                double failureRateNum = Double.parseDouble(failureRate);
                double baseCostNum = Double.parseDouble(baseCost);
                int loanTermNum = Integer.parseInt(loanTerm);
                double aprNum = Double.parseDouble(apr);
                server = new FinancedServer(brand, maintenanceNum, failureRateNum, baseCostNum, loanTermNum, aprNum);
            }

            return server;

        } catch (NumberFormatException e) {
            //Return null if numeric values fail to parse
            return null;
        }
    }

    /**
     * This helper method is used to output a file. First the header is created. Then, using the toString method from the
     * created in the other classes, the top three servers from the servers ArrayList are printed.
     * @param outputFile
     * @param servers
     */
    private static void outputToFile(File outputFile, ArrayList<Server> servers) {
        //Initialize the PrintWriter by encasing it between parentheses (otherwise an error is thrown)
        try (PrintWriter out = new PrintWriter(outputFile)) {
            //Output the header
            out.println("Brand,rent,maintenance,failure rate,base cost,loan term,apr");

            //Write the top 3 cheapest servers
            for (int i = 0; i < 3; i++) {
                Server server = servers.get(i);
                out.println(server.toString());
            }
        } catch (IOException e) {
            System.out.println("Error output");
        }
    }
}
