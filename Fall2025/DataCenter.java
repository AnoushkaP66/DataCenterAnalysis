/**
 * Data Centers
 *
 * This program is designed to store server racks in a data center class plus additional information regarding that data
 * center.
 *_____________________________________________________
 * @author Anoushka Poojary
 * @version 10/23/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.DataCenters;

import java.util.ArrayList;

public class DataCenter {

    //Private variables
    private String centerName;
    private int capacity;
    private double budget;
    private ArrayList<ServerRack> rackList;

    /**
     * This is a parameterized constructor for a DataCenter object. It initializes the centerName, capacity, and budget
     * based on the parameters and then creates a new ArrayList object, rackList.
     * @param aCenterName
     * @param aCapacity
     * @param aBudget
     */
    public DataCenter(String aCenterName, int aCapacity, double aBudget) {
        this.centerName = aCenterName;
        this.capacity = aCapacity;
        this.budget = aBudget;
        this.rackList = new ArrayList<>();
    }

    /**
     * This is the default constructor for a DataCenter object. It initializes an empty center name, the capacity and budget
     * to 0, and then creates a new ArrayList, rackList.
     */
    public DataCenter() {
        this.centerName = "";
        this.capacity = 0;
        this.budget = 0.0;
        this.rackList = new ArrayList<>();
    }

    /**
     * This method returns a center name in the data center
     * @return centerName
     */
    public String getCenterName() {
        return centerName;
    }

    /**
     * This method sets the center name of a data center.
     * @param centerName
     */
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    /**
     * This method returns the capacity of the data center
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method sets a capacity of the data center
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * This method returns the budget of a data center
     * @return budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * This method sets the budget of a DataCenter object.
     * @param budget
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * This method adds a ServerRack object to the DataCenter ArrayList, rackList
     * @param rack
     */
    public void addServerRack (ServerRack rack) {
        rackList.add(rack);
    }

    /**
     * This method lets the user know how many ServerRack objects are in the DataCenter object by returning the size of
     * the ArrayList.
     * @return size of rackList
     */
    public int getNumServerRacks() {
        return rackList.size();
    }

    /**
     * This method returns the ArrayList of ServerRack objects that are found within the DataCenter object.
     * @return rackList
     */
    public ArrayList<ServerRack> getServerRacks() {
        return rackList;
    }

    /**
     * This method checks if the total operating costs of the server racks in the rack list meets the budget criteria
     * @return true if the total operating costs is less than or on budget and false if the total is over budget
     */
    public boolean isInBudget() {
        double totalOperatingCosts = 0.0;
        for (ServerRack rack : rackList) {
            totalOperatingCosts += rack.getOperatingCost();
        }
        return totalOperatingCosts <= budget;
    }

    /// @Override
    /// This method outputs the data center information into new lines along with the server rack information by creating
    /// a string of dataCenterInfo and attaching that string with each server rack in the rack list.
    /// @return dataCenterInfo
    public String toString(){
        StringBuilder dataCenterInfo = new StringBuilder(centerName + "\n" + capacity + "\n" + String.format("%.2f", budget)
                + "\n" + "ServerRacks:\n");
        for (ServerRack rack : rackList) {
            dataCenterInfo.append(rack.toString());
        }
        return dataCenterInfo.toString();
    }
}
