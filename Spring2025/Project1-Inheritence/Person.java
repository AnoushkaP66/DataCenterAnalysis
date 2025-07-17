/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 1 - Inheritance
 * @version 1/24/2025
 * In this project, a person's data is printed on the console. The Person class serves as a parent class for the other
 * subclasses that are different types of people. This class stores and outputs the name, home address, phone number,
 * email, and ID of a person.
 */

package cmsc256;

public class Person {
    //Private variables
    private final int ID;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber = 0;

    /**
     * This is the default constructor for a Person object. It uses the default name and home address constructors, which
     * would output either "None given" if it's a String or 0 for primitive types. However, the ID is always incremented
     * by one for each Person object created or utilized by incrementing the recordNumber and assigning the value to ID.
     */
    public Person() {
        name = new Name();
        homeAddress = new Address();
        phoneNumber = "None given";
        email = "None given";
        ID = ++recordNumber;
    }

    /**
     * This is the parameterized constructor for a Person object. It uses the input values of first, middle, and last String
     * values to create a Name object using the Name class. It also uses the parameters to assign values to the variables
     * homeAddress, phoneNumber, and email. The ID is always incremented by one for each Person object created or utilized
     * by incrementing the recordNumber and assigning the value to ID.
     * @param first first name
     * @param middle middle name
     * @param last last name
     * @param homeAddress Person's home address
     * @param phoneNumber Person's phone number
     * @param email Person's email
     */
    public Person (String first, String middle, String last, Address homeAddress, String phoneNumber, String email) {
        this.name = new Name(first, middle, last);
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ID = ++recordNumber;
    }

    /**
     * This method returns the ID of a Person
     * @return ID of a person
     */
    public int getId() {
        return ID;
    }

    /**
     * This method returns a Person's name
     * @return Person's name
     */
    public Name getName() {
        return name;
    }

    /**
     * This setter method modifies a Person's name.
     * @param name Person's name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * This method returns a Person's home address
     * @return homeAddress of a Person
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * This setter method modifies a Person's home address.
     * @param homeAddress Person's home address
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * This method returns a Person's phone number.
     * @return phoneNumber of a Person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This setter method modifies a Person's phone number.
     * @param phoneNumber Person's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns a Person's email.
     * @return email of a Person
     */
    public String getEmail(){
        return email;
    }

    /**
     * This setter method modifies a Person's email.
     * @param email Person's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the Person information in String format.
     * @return name, homeAddress, phoneNumber, email, and ID
     */
    @Override
    public String toString(){
        String result = "Person:" + "\n" + "---------------------------------------" + "\n" + name.toString() + "\n" +
                "---------------------------------------" + "\n";
        return result + "Home Address: " + homeAddress.toString() +"\n" + "Phone Number: " + phoneNumber + "\n" +
                "Email Address: " + email + "\n" + "ID: " + ID + "\n";
    }
}
