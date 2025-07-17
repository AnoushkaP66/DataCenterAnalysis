/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 2 - Interface Implementation
 * @version 2/7/2025
 * This project utilizes interfaces, specifically the WackyStringInterface.java file. The methods from that interface are
 * implemented and then are modified in this class. Additionally, a custom exception is thrown for one of the methods below.
 * This project is mainly about string modification and utilizing StringBuilder class in order to achieve this.
 */

package cmsc256;

public class RamString implements WackyStringInterface {
    //Instance variables
    private String string;

    /**
     * This is a default constructor for a String object. It assigns the string instance variable to "Make it Real."
     */
    public RamString() {
        this.string = "Make it Real";
    }

    /**
     * This is a parameterized constructor for a RamString object. It implements the setaWackyString method to assign
     * string to value.
     * @param string value to be set
     */
    public RamString(String string) {
        setWackyString(string);
    }

    /**
     * This method modifies a string, which is the wacky string.
     * @param string The value to be set
     * @throws IllegalArgumentException thrown when String is null
     */
    @Override
    public void setWackyString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String cannot be null.");
        }
        this.string = string;
    }

    /**
     * This method returns the string variable
     * @return string
     */
    @Override
    public String getWackyString() {
        return string;
    }

    /**
     * Returns a string that consists of all and only the characters
     * in every other position in the current string beginning with position 1,
     * in the same order and with the same case as in the current string.
     * The first character in the string is considered to be in Position 1.
     *
     * @return String made of characters in every other position in the
     * current string
     */
    @Override
    public String getEveryOtherCharacter() {
        //Create new StringBuilder object
        StringBuilder newString = new StringBuilder();
        //Iterate through every other character and add those characters to the StringBuilder object
        for (int i = 0; i < string.length(); i+=2) {
            newString.append(string.charAt(i));
        }
        //Return the StringBuilder object in String format
        return newString.toString();
    }

    /**
     * Returns a string that consists of all and only the characters
     * in either the odd positions (i.e., first, third, fifth, and so on)
     * or in the even positions (i.e., second, fourth, sixth, and so on)
     * current string, in the same order and with the same case as in
     * the current string.
     * Odd or even is determined by the length of the string. If the string length
     * is odd, return the odd characters; if the length is even, return the even
     * characters.
     * The first character in the string is considered to be in Position 1.
     *
     * @return newString - String made of characters in odd positions in the current string
     */
    @Override
    public String getEvenOrOddCharacters() {
        StringBuilder newString = new StringBuilder();
        //If the length of the string is even, all the characters in the even positions are added to the
        //newString variable
        if (string.length() % 2 == 0) {
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 1) {
                    newString.append(string.charAt(i));
                }
            }
        }
        //If the length of string is odd, all the characters in the odd positions are added to the newString
        //variable
        else {
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 0) {
                    newString.append(string.charAt(i));
                }
            }
        }
        return newString.toString();
    }

    /**
     * Returns the number of characters that are digits in the current string.
     *
     * @return Number of digits in the current string
     */
    @Override
    public int countDigits() {
        int count = 0;
        //Iterate through the characters in the string
        for (int i = 0; i < string.length(); i++) {
            //Increment count if a digit is found in the string
            if(Character.isDigit(string.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method returns the number of times a number between 10-99 occurs in a String. It does this by checking if two
     * indexes are digits, then checks if there are extra digits to avoid so that the digits are between 10-99.
     * @return count the number of double digits
     * */
    @Override
    public int countRangeOfNumbers() {
        int count = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i + 1))) {
                //Convert from char to int
                int num = (string.charAt(i) - '0') * 10 + (string.charAt(i + 1) - '0');

                //Checks if the num is between 10-99
                //Two boolean values are created
                if (num >= 10 && num <= 99) {
                    //Returns true if i is either 0 or the digit character before is not a digit
                    boolean beforeValid = (i == 0 || !Character.isDigit(string.charAt(i - 1)));
                    //afterValid checks if the index plus 2 equals the length of the string or
                    //if the index after is not a digit
                    //This is to avoid triple digit cases and focus on two indexes
                    boolean afterValid = (i + 2 == string.length() || !Character.isDigit(string.charAt(i + 2)));

                    //Increment count if beforeValid and afterValid do not have triple digits
                    if (beforeValid && afterValid) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * This method replaces the digits between the startPosition and endPosition with the same characters in reverse order.
     * @param startPosition  Position of the first character to consider
     * @param endPosition    Position of the last character to consider
     * @throws MyIndexOutOfBoundsException thrown when startPosition or endPosition are out of bounds
     * @throws IllegalArgumentException thrown when the startPosition is a larger number than the endPosition
     */
    @Override
    public void reverseSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException, IllegalArgumentException {
        if (startPosition < 1 || endPosition > string.length()) {
            throw new MyIndexOutOfBoundsException("Start or end position is out of bounds");
        }
        if (startPosition > endPosition) {
            throw new IllegalArgumentException("Start position cannot be larger than end position");
        }

        // Create new StringBuilder object.
        // Since startPosition cannot be 0, the index can be assigned to startPosition - 1 in case user inputs 1
        // endPosition remains
        StringBuilder reverseString = new StringBuilder(string.substring(startPosition - 1, endPosition));

        //Assign and concatenate string to the startPosition, a reversed StringBuilder object, and endPosition
        this.string = string.substring(0, startPosition - 1) + reverseString.reverse().toString() + string.substring(endPosition);
    }
}
