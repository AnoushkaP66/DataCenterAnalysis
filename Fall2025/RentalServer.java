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

public class RentalServer extends Server {
    //Instance variables
    private double annualRent;

    /**
     * This is a constructor for a RentalServer object. It assigns a name using the super constructor (Server class) and
     * also adds an annualRent value.
     * @param name
     * @param rent
     */
    public RentalServer(String name, double rent) {
        super(name);
        this.annualRent = rent;
    }

    /**
     * This method returns an annual rent.
     * @return annualRent
     */
    public double getAnnualRent() {
        return annualRent;
    }

    /**
     * This method sets an annual rent value.
     * @param annualRent
     */
    public void setAnnualRent(double annualRent) {
        this.annualRent = annualRent;
    }

    /**
     * This method returns the operating cost of a Rental Server by multiplying the years and annualRent.
     * @param years
     * @return
     */
    @Override
    public double getOperatingCost(int years) {
        return annualRent * years;
    }

    /**
     * This method returns the RentalServer data in String format.
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s,%s", super.toString(), String.format("%.2f,", annualRent)) + "N/A,N/A,N/A,N/A,N/A";
    }

}
