/**
 * Server Operating Costs
 *
 * This is the Server abstract class. It implements some of the important methods that other classes will rely on in this
 * project, such as the operating cost.
 *_____________________________________________________
 * Anoushka Poojary
 * 11/22/2024
 * CMSC 255 002 Intro to Object-Oriented Programming
 */

package Projects.ServerOperatingCosts;

public abstract class Server implements Comparable<Server> {
    //Implement instance variables
    private String brand;
    private static int compareNumYears = 5;

    /**
     * This is a constructor for a Server object that assigns a name to the brand variable.
     * @param name
     */
    public Server(String name) {
        this.brand = name;
    }

    /**
     * This method returns a Server brand name.
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method is used to set a brand name
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This is an abstract method used to find the operatingCost using formulas. It is implemented in the other classes.
     * @param years
     * @return operating cost
     */
    public abstract double getOperatingCost(int years);

    /**
     * This method sets the number of years.
     * @param time
     */
    public static void setCompareNumYears(int time) {
        compareNumYears = time;
    }

    /**
     * This method returns the number of years.
     * @return compareNumYears
     */
    public static int getCompareNumYears() {
        return compareNumYears;
    }

    /**
     * This method returns the int value of an operatingCost being compared with another Server object.
     * @param other the object to be compared.
     * @return int value of an operatingCost
     */
    @Override
    public int compareTo(Server other) {
        return Double.compare(this.getOperatingCost(compareNumYears), other.getOperatingCost(compareNumYears));
    }

    /**
     * This method returns the values of a Server object in String format.
     * @return Server object in String format
     */
    @Override
    public String toString(){
        return String.format("%s", brand);
    }
}
