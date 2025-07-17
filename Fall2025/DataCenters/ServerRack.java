/**
 * Server Rack
 *
 * This program is designed to create server racks for a data center.
 *_____________________________________________________
 * @author Anoushka Poojary
 * @version 10/23/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.DataCenters;

public class ServerRack {

    //Private variables
    private String brand;
    private int rackID;
    private double operatingCost;
    private OS operatingSystem;
    private Cooling cooling;
    private Ownership ownership;

    /**
     * This is the default constructor for a ServerRack object. It initializes an empty brand, the rack ID and operating
     * costs to 0, and sets the operating system to Windows, cooling type to air, and ownership type to rental.
     */
    public ServerRack() {
        this.brand = "";
        this.rackID = 0;
        this.operatingCost = 0.0;
        this.operatingSystem = OS.WINDOWS;
        this.cooling = Cooling.AIR;
        this.ownership = Ownership.RENTAL;
    }

    /**
     * This is the parameterized constructor for a ServerRack object. It initializes a brand, rack ID, operating cost,
     * operating system, cooling system, and the ownership type based on the parameters.
     * @param aBrand
     * @param aRackID
     * @param anOperatingCost
     * @param anOperatingSystem
     * @param aCooling
     * @param anOwnership
     */
    public ServerRack(String aBrand, int aRackID, double anOperatingCost, OS anOperatingSystem, Cooling aCooling, Ownership anOwnership){
        this.brand = aBrand;
        this.rackID = aRackID;
        this.operatingCost = anOperatingCost;
        this.operatingSystem = anOperatingSystem;
        this.cooling = aCooling;
        this.ownership = anOwnership;

    }

    /**
     * This method returns a brand of a server object.
     * @return the brand of the server
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method sets a brand of a server object.
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This method returns the rack ID of a server
     * @return the rack ID of the server
     */
    public int getRackID() {
        return rackID;
    }

    /**
     * This method sets a rack ID of a server.
     * @param rackID
     */
    public void setRackID(int rackID) {
        this.rackID = rackID;
    }

    /**
     * This method returns an operating cost of a server.
     * @return the operating cost of a server
     */
    public double getOperatingCost() {
        return operatingCost;
    }

    /**
     * This method sets the operating cost of the server.
     * @param operatingCost
     */
    public void setOperatingCost(double operatingCost) {
        this.operatingCost = operatingCost;
    }

    /**
     * This method returns an operating system of either Mac, Windows, or Linux.
     * @return operating system of a server
     */
    public OS getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * This method sets the operating system of the server from the OS enum.
     * @param operatingSystem
     */
    public void setOperatingSystem(OS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * This method returns the cooling type of either air, liquid, heat sink, or hybrid.
     * @return cooling type
     */
    public Cooling getCooling() {
        return cooling;
    }

    /**
     * This method sets a cooling type of the server using the Cooling enum.
     * @param cooling
     */
    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

    /**
     * This method returns an ownership type of either rental, owned, or financed.
     * @return ownership type
     */
    public Ownership getOwnership() {
        return ownership;
    }

    /**
     * This method sets an ownership type of the server using the Ownership enum.
     * @param ownership
     */
    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    /// @Override
    /// This method separates the server object's attributes in a new line
    /// @return the brand, rack ID, operating cost, operating system, cooling method, and ownership type of the server
    public String toString(){
        return String.format("\n\t%s" + "\n\t%d" + "\n\t%.2f" + "\n\t%s" + "\n\t%s" + "\n\t%s" + "\n",
                brand, rackID, operatingCost, operatingSystem, cooling, ownership);
    }
}
