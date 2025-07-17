/**
 * Server Operating Costs
 *
 * This is the RentalServer class. It is one of the three types of Servers that will be utilized for this project and extends
 * from the Server abstract class.
 *_____________________________________________________
 * Anoushka Poojary
 * 11/22/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.ServerOperatingCosts;

public class OwnedServer extends Server {
    //Instance variables
    private double maintenanceCost;
    private double failureRate;
    private double baseCost;

    /**
     * This is a constructor for an OwnedServer object to assign values to the name, maintenance, failure, and cost variables
     * @param name
     * @param maintenance
     * @param failure
     * @param cost
     */
    public OwnedServer(String name, double maintenance, double failure, double cost) {
        super(name);
        this.maintenanceCost = maintenance;
        this.failureRate = failure;
        this.baseCost = cost;
    }

    /**
     * This method returns a maintenanceCost in US dollars
     * @return maintenanceCost
     */
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * This method is used to set the maintenance cost in US dollars
     * @param maintenanceCost
     */
    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    /**
     * This method returns the failure rate, which is the chance of failure per year
     * @return failureRate
     */
    public double getFailureRate() {
        return failureRate;
    }

    /**
     * This method sets a failure rate, which is the chance of failure per year
     * @param failure
     */
    public void setFailureRate(double failure) {
        this.failureRate = failure;
    }

    /**
     * This method returns a base cost of a Server
     * @return baseCost
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * This method sets a base cost of a Server
     * @param baseCost
     */
    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    /**
     * This method returns the OwnedServer operating cost by adding the base cost by 1 plus the failure rate and then multiplying
     * that by the years times the maintenance cost.
     * @param years
     * @return operating cost for an OwnedServer
     */
    @Override
    public double getOperatingCost(int years) {
        return  baseCost + (1 + failureRate) * years * maintenanceCost;
    }

    /**
     * This method returns the OwnedServer data in String format.
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,", super.toString(), "N/A", String.format("%.2f,%.2f,%.2f", maintenanceCost, failureRate, baseCost)) + "N/A,N/A";
    }
}
