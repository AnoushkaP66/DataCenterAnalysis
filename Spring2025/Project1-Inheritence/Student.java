/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 1 - Inheritance
 * @version 1/24/2025
 * The purpose of this class is to print out information about a Student. It uses the constructors and data from the Person
 * class in order to reduce redundancy of the code. The Student class not only stores and prints the name, home address, phone number,
 * email, and ID of a Student object but also the grade level. Exception handling is used when inputting their grade level.
 */

package cmsc256;

public class Student extends Person {
    //Instance variables
    private String level;

    /**
     * This is the default constructor for a Student object. It uses the default constructor from the Person class and also
     * initiates a default grade level, which is "Freshman."
     */
    public Student () {
        super();
        this.level = "Freshman";
    }

    /**
     * This is a parameterized constructor of the Student class. It implements the parameterized Person constructor to initialize
     * the full name, home address, phone number, and email for a Student. This constructor also initializes the Student grade
     * level, which can ONLY be "Freshman", "Sophomore", "Junior", "Senior", and "Graduate."
     * @param first first name of Student
     * @param middle middle name of Student
     * @param last last name of Student
     * @param homeAddress home address of Student
     * @param phoneNumber phone number of Student
     * @param email email of Student
     * @param level level of Student
     * @throws IllegalArgumentException is thrown when level is invalid
     */
    public Student(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String level) throws IllegalArgumentException {
        super(first, middle, last, homeAddress, phoneNumber, email);
        setLevel(level);
    }

    /**
     *
     * @return Student grade level
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method modifies a Student grade level but the user must enter either "Freshman", "Sophomore", "Junior", "Senior",
     * or "Graduate"; otherwise, an error is thrown.
     * @param level Student grade level
     * @throws IllegalArgumentException if user enters an invalid grade level
     */
    public void setLevel(String level) throws IllegalArgumentException {
        if (isValidLevel(level)) {
            this.level = level;
        }
        else {
            throw new IllegalArgumentException(level + " is not a valid level.");
        }
    }

    /**
     * This method checks if the user entered a valid grade level.
     * @param level must be Freshman, Sophomore, Junior, Senior, or Graduate
     * @return true if the level is either Freshman, Sophomore, Junior, Senior, or Graduate and false if otherwise
     */
    public boolean isValidLevel(String level) {
        return level.equals("Freshman") || level.equals("Sophomore") || level.equals("Junior") || level.equals("Senior") || level.equals("Graduate");
    }

    /**
     * This method returns the information about a Student. It uses the toString() method of the Person class and also
     * prints out the grade level to reduce lines in the code.
     * @return name, home address, phone number, email, ID, and grade level of the Student
     */
    @Override
    public String toString() {
        String personSubstring = super.toString().substring(7);
        return "Student:" + personSubstring + "Student Level: " + level + "\n";
    }
}
