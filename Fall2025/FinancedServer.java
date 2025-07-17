/**
 * Server Operating Costs
 *
 * This is the Financed Server class. It is one of the three types of Servers and extends from the OwnedServer.
 *_____________________________________________________
 * Anoushka Poojary
 * 11/22/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.ServerOperatingCosts;

public class FinancedServer extends OwnedServer {
    //Instance variables
    private int loanTerm;
    private double apr;

    /**
     * This is a constructor for a FinancedServer object which uses its superclass, OwnedServer, to assign values to the name,
     * maintenance, failure, and cost variables in addition to assigning a loanTerm and apr value
     * @param name
     * @param maintenance
     * @param failure
     * @param cost
     * @param term
     * @param rate
     */
    public FinancedServer(String name, double maintenance, double failure, double cost, int term, double rate) {
        super(name, maintenance, failure, cost);
        this.loanTerm = term;
        this.apr = rate;
    }

    /**
     * This method returns a loan term.
     * @return
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * This method sets a loan term.
     * @param loanTerm
     */
    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    /**
     * This method returns an apr, which is a value between 0.0 and 1.0.
     * @return
     */
    public double getApr() {
        return apr;
    }

    /**
     * This method sets an apr, which should be a value between 0.0 and 1.0.
     * @param apr
     */
    public void setApr(double apr) {
        this.apr = apr;
    }

    /**
     * This method returns the operating cost of a Financed Server. If the loan term exceeds the given number of years, then
     * a different formula is used to calculate the operatingCost.
     * @param years
     * @return operatingCost, depending on the given number of years
     */
    @Override
    public double getOperatingCost(int years){
        if (years > loanTerm) {
            return getBaseCost() * apr * loanTerm + getBaseCost() + (1 + getFailureRate()) * years * getMaintenanceCost();
        }
        else {
            return getBaseCost() * apr * years + ((getBaseCost() / loanTerm) * years) + (1 + getFailureRate()) * years * getMaintenanceCost();
        }
    }

    /**
     * This method returns the information of a FinancedServer in String format.
     * @return
     */
    @Override
    public String toString(){
        return super.toString().substring(0, super.toString().lastIndexOf("N/A") - 4) + loanTerm + "," + apr;
    }
}
