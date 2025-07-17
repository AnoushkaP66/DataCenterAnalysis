/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 1 - Inheritance
 * @version 1/24/2025
 * The purpose of this class is to print out information about a Faculty member. It uses the constructors and data from the Employee
 * class in order to reduce redundancy of the code. The Faculty class not only stores and prints the name, home address, phone number,
 * email, ID, office, salary, and hire date of a Faculty object but also their rank. Exception handling is used when inputting
 * their rank.
 */

package cmsc256;

public class Faculty extends Employee {
    //Instance variable
    private String rank;

    /**
     * This is the default constructor for a Faculty object. It uses the Employee default constructor to initialize a
     * default name, address, phone number, email, office, salary, and hire date. The default rank for a Faculty object
     * is "Instructor".
     */
    public Faculty() {
        super();
        this.rank = "Instructor";
    }

    /**
     * This is the parameterized constructor for a Faculty object. It implements the parameterized Employee constructor to initialize
     * the full name, home address, phone number, email, and hire date for a Faculty member. This constructor also initializes
     * the Faculty rank, which can ONLY be "Adjunct", "Instructor", "Assistant Professor", ""Associate Professor"", and
     * "Professor."
     * @param first first name of Faculty
     * @param middle middle name of Faculty
     * @param last last name of Faculty
     * @param homeAddress home address of Faculty
     * @param phoneNumber phone number of Faculty
     * @param email email of Faculty
     * @param office office of Faculty
     * @param salary salary of Faculty
     * @param month month when Faculty member was hired
     * @param day day when Faculty member was hired
     * @param year year when Faculty member was hired
     * @param rank Faculty member rank
     * @throws IllegalArgumentException is thrown when an invalid rank is entered
     */
    public Faculty(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                   int salary, int month, int day, int year, String rank) throws IllegalArgumentException {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        setRank(rank);
    }

    /**
     * This method returns a Faculty rank value
     * @return Faculty rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * This method modifies a Faculty rank. It uses the isValidRank method to check if the user enters either "Adjunct",
     * "Instructor", "Assistant Professor", ""Associate Professor", or "Professor". If the user enters either of those
     * values, then rank is initialized. Otherwise, an error is thrown.
     * @param rank Faculty rank
     * @throws IllegalArgumentException if user enters an invalid rank
     */
    public void setRank(String rank) throws IllegalArgumentException {
        if (isValidRank(rank)) {
            this.rank = rank;
        }
        else {
            throw new IllegalArgumentException(rank + "is not a valid rank.");
        }
    }

    /**
     * This method checks if the user entered a valid grade level.
     * @param rank the rank of a Faculty member
     * @return true if the rank entered is either "Adjunct", "Instructor", "Assistant Professor", ""Associate Professor",
     * or "Professor" and false if otherwise
     */
    public boolean isValidRank(String rank) {
        return rank.equals("Adjunct") || rank.equals("Instructor") || rank.equals("Assistant Professor") || rank.equals("Associate Professor") || rank.equals("Professor");
    }

    /**
     * This method returns the Faculty information in String format
     * @return name, homeAddress, phoneNumber, email, ID, office, salary, hireDate, and rank of Faculty
     */
    @Override
    public String toString() {
        String personSubstring = super.toString().substring(7);
        return "Faculty: " + "\n" + personSubstring + "\n" + "Rank: " + rank + "\n";
    }
}
