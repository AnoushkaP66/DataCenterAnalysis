/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 1 - Inheritance
 * @version 1/24/2025
 * The purpose of this class is to print out information about an Employee. This class will be used by other classes to
 * specify different types of Employees in order to encourage abstraction of the program and reduce redundancy of the code.
 * Additionally, the Employee class uses the constructors and methods from the Person class for a cleaner, more readable code.
 * The Employee class will store and print out the name, home address, phone number, email, office, ID, office, salary, and
 * the hiring date of an Employee.
 */

package cmsc256;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Employee extends Person {
    //Instance variables
    private String office;
    private int salary;
    private LocalDate hireDate;

    /**
     * This is the default constructor for an Employee object. It uses the default constructor from the Person class, which
     * would output either "None given" if it's a String or 0 for primitive types. Additionally, it also assigns the office
     * variable as "Unassigned", salary as 0, and hire date as null.
     */
    public Employee(){
        super();
        this.office = "Unassigned";
        this.salary = 0;
        hireDate = null;
    }

    /**
     * This is a parameterized constructor for an Employee object. It uses the attributes of its parent class, Person to
     * implement the basic Employee information. It also incorporates the Employee's office, their salary, and the date hired.
     * The LocalDate class was used to input the month, day, and year the Employee was hired.
     * @param first Employee first name
     * @param middle Employee middle name
     * @param last Employee last name
     * @param homeAddress Employee home address
     * @param phoneNumber Employee phone number
     * @param email Employee email
     * @param office Employee office
     * @param salary Employee salary
     * @param month Employee month hired
     * @param day Employee day hired
     * @param year Employee year hired
     * @throws IllegalArgumentException when user enters an invalid date
     * @throws DateTimeException when user enters invalid date
     */
    public Employee(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                    int salary, int month, int day, int year) throws IllegalArgumentException, DateTimeException {
        super(first, middle, last, homeAddress, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        hireDate = LocalDate.of(year,month,day);
    }

    /**
     * This method returns the office of an Employee.
     * @return the Employee's office
     */
    public String getOffice() {
        return office;
    }

    /**
     * This method modifies the Employee's office
     * @param office Employee office
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * This method returns the salary of an Employee.
     * @return Employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * This method modifies the Employee's salary
     * @param salary Employee salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * This method returns the hire date of an Employee.
     * @return Employee hire date
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * This method modifies an Employee hire date.
     * @param hireDate Employee hire date
     */
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    /**
     * This method returns the Employee data in String format
     * @return name, homeAddress, phoneNumber, email, ID, office, salary, and hireDate of an Employee
     */
    @Override
    public String toString() {
        String personSubstring = super.toString().substring(7);
        return "Staff:" + personSubstring + "Office: " + office + "\n" + "Salary: $" + salary + "\n" + "Date Hired: " + hireDate;
    }
}
