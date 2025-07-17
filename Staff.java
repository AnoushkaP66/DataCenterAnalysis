/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 1 - Inheritance
 * @version 1/24/2025
 * The purpose of this class is to print out information about a Staff member. It uses the constructors and data from the Staff
 * class in order to reduce redundancy of the code. The Staff class not only stores and prints the name, home address, phone number,
 * email, ID, office, salary, and hire date of a Staff object but also their job title.
 */

package cmsc256;

public class Staff extends Employee{
    //Instance variables
    private String title;

    /**
     * This is the default constructor for a Staff object. It uses the Employee default constructor to initialize a
     * default name, address, phone number, email, office, salary, and hire date. The default value for a title is "None
     * given."
     */
    public Staff(){
        super();
        this.title = "None given";
    }

    /**
     * This is the parameterized constructor for a Staff object. It uses the attributes of its parent class, Employee to
     * implement the basic Staff information. This constructor also initializes a Staff title.
     * @param first first name of Staff
     * @param middle middle name of Staff
     * @param last last name of Staff
     * @param homeAddress home address of Staff
     * @param phoneNumber phone number of Staff
     * @param email email of Staff
     * @param office office of Staff
     * @param salary salary of Staff
     * @param day day when Staff was hired
     * @param month month when Staff was hired
     * @param year year when Staff was hired
     * @param title Staff title
     */
    public Staff(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                 int salary, int day, int month, int year, String title) {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, day, month, year);
        this.title = title;
    }

    /**
     * This method returns a job title
     * @return job title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method modifies a job title
     * @param title Staff job title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the Staff information in String format
     * @return name, homeAddress, phoneNumber, email, ID, office, salary, hireDate, and title of Staff member
     */
    @Override
    public String toString() {
        String personSubstring = super.toString().substring(7);
        return "Staff: " + "\n" + personSubstring + "\n" + "Title: " + title + "\n";
    }
}
