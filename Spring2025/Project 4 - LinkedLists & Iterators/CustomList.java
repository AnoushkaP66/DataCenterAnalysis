/***
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 4 - LinkedLists & Iterators
 * @version 3/8/2025
 * This project is about implementing LinkedLists and using a class that implements that interface to return a set of elements
 * and traverse through a list using nodes instead of a traditional index. The methods from the CMSC256LinkedList class are
 * used to add, remove, modify, or analyze duplicates a set of elements in a list. The program handles exceptions for empty
 * lists or invalid values.
 */
package cmsc256;

public class CustomList<T> extends CMSC256LinkedList<T> {

    public static void main (String[] args) {
        CustomList<Integer> myList = new CustomList<>();
        myList.add(34);
        myList.add(98);
        myList.add(22);
        myList.add(12);
        myList.add(76);
        myList.add(81);
        myList.add(101);
        System.out.println(myList.getMiddleElement());
    }

    /**
     *  Returns the middle element of the
     *  If the number of elements in the list is even, there will be two middle nodes,
     *  so return the second one.
     *  For example, if the list contains [23, 34, 98, 22, 12, 76, 81], the
     *  method returns 22
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101], the
     *  method returns 12
     * @throws  IllegalStateException if the list is empty or null
     * @return an instance T
     */
    public T getMiddleElement() {
        if (isEmpty()) {
            throw new IllegalStateException("List cannot be empty");
        }

        //Calculation for middle element
        int middleElement = (this.getLength() + 1) / 2;

        //If the length is an even number, then the second number in the middle is the middle element
        if (this.getLength() % 2 == 0) {
            middleElement++;
        }

        //Return the middle element
        return this.getEntry(middleElement);
    }

    /**
     * Returns the first half of the list.
     * If the number of elements in the list is odd, include the extra element.
     * For example if the list contains [23, 34, 98, 22, 12, 76, 81], the
     * method returns a list [23, 34, 98, 22]
     *
     * @return an instance of a class that implements the ListInterface
     * @throws IllegalStateException if list is empty
     **/
    public ListInterface<T> getFirstHalf() {
        if (this.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        CustomList<T> firstHalf = new CustomList<>();
        //Calculation for the first half of the list
        int halfLength = (this.getLength() + 1) / 2;

        //Traversing through the list and indexing ends at the midpoint
        //Elements are added to the firstHalf list
        for (int i = 1; i <= halfLength; i++) {
            firstHalf.add(getEntry(i));
        }

        return firstHalf;
    }

    /**
     * Returns the last half of the list.
     * If the number of elements in the list is odd, exclude the extra element.
     * For example if the list contains [23, 34, 98, 22, 12, 76, 81], the
     * method returns a list containing [12, 76, 81]
     *
     * @return an instance of a class that implements the ListInterface
     * @throws IllegalStateException if list is empty
     * */
    public ListInterface<T> getLastHalf(){
        if (this.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        CustomList<T> lastHalf = new CustomList<>();
        //Calculation for the second half of the list
        int halfLength = (this.getLength() + 1) / 2;

        //Traversing starts at the beginning index of the second half of the list and all elements from that half are added
        for (int i = halfLength + 1; i <= getLength(); i++) {
            lastHalf.add(this.getEntry(i));
        }

        return lastHalf;
    }

    /**
     * Returns a List that consists of all and only the elements
     * in every fourth positions (i.e., fourth, eighth, and so on) in
     * the current string, in the same order as the current list.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101], the
     *  method returns [22, 101]
     * @return an instance of a class that implements the ListInterface
     * @throws IllegalStateException if the list is empty
     */
    public ListInterface<T> getEveryFourthElement() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        CustomList<T> everyFourthElement = new CustomList<>();

        //Add to the everyFourthElement list by doing modular division by 4
        for (int i = 1; i <= this.getLength(); i++) {
            if (i % 4 == 0) {
                everyFourthElement.add(getEntry(i));
            }
        }
        return everyFourthElement;
    }

    /**
     * @return true if there are any elements in the list that occur twice
     * false otherwise
     * Note: if an element occurs more that twice, do not include it
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method returns true
     * @throws IllegalStateException if list is empty
     */
    public boolean hasDuplicates() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        //Iterate through all the elements in the list
        for (int i = 1; i <= this.getLength(); i++) {
            T current = this.getEntry(i);

            //Check for duplicates
            for (int j = i + 1; j <= this.getLength(); j++) {
                T otherElement = this.getEntry(j);
                //Return true if a duplicate has been found in the list
                if (current.equals(otherElement)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return an instance of a class that implements the ListInterface that
     * contains those elements in this list that appear more than once.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method returns [23, 12]
     * @throws IllegalStateException if the list is empty
     **/
    public ListInterface<T> getAllMultiples() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        CustomList<T> multiplesList = new CustomList<>();
        //Iterate through the list
        for (int i = 1; i <= this.getLength(); i++){
            T current = this.getEntry(i);

            //Checks for duplicates in the ENTIRE list and if true, then the loops start
            if (this.hasDuplicates()) {
                boolean inMultiplesList = false;
                //Check if an element is already in the multiplesList (in cases where there's 3+ duplicates)
                //If it's already in the multiplesList, then the loop breaks and moves on to the next element
                for (int j = 1; j <= multiplesList.getLength(); j++) {
                    if (current.equals(multiplesList.getEntry(j))) {
                        inMultiplesList = true;
                        break;
                    }
                }
                //If the element is not in the multiplesList loop through elements after to find duplicates
                if (!inMultiplesList) {
                    for (int j = i + 1; j <= this.getLength(); j++) {
                        //Find duplicates and add to multiplesList if found
                        if (current.equals(this.getEntry(j))) {
                            multiplesList.add(current);
                            break;
                        }
                    }
                }
            }
        }
        //Return a list containing multiple elements
        return multiplesList;
    }

    /**
     * Alters the list by deleting any elements that occur twice in the list.
     * Elements that occur more than 2 times remain in the list.
     *  If the list contains [23, 34, 98, 22, 12, 76, 81, 101, 12, 23, 33, 23], the
     *  method removes 12 and the list becomes [23, 34, 98, 22, 76, 81, 101, 23, 33, 23]
     *  The method does not do anything if the list either has one element or is empty
     */
    public void removeAllDuplicates() {
        //Do nothing if the list is empty or has only one element
        if (this.isEmpty() || this.getLength() == 1) {
            return;
        }
        //Check for duplicates in the entire list
        if (hasDuplicates()) {
            for (int i = 1; i <= this.getLength(); i++) {
                T currentElement = this.getEntry(i);
                //Element after the current
                for (int j = i + 1; j <= this.getLength(); j++) {
                    //Removes the duplicate if a matching element is found
                    if (currentElement.equals(getEntry(j))) {
                        remove(i);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Removes the nth node from the end of the list
     * For example, if the list contains [43, 68, 11, 5, 69, 37, 70] and 1 is passed to the method
     * a value of 70 is returned and the list becomes [43, 68, 11, 5, 69, 37]
     * @return the element from the position that was removed
     * @throws IllegalArgumentException if n is zero or if n is greater than the length of the list
     * @throws IllegalStateException if list is empty
     * */
    public T removeNthNodeFromEnd(int n) {
        //Throw exception if n = 0 or greater than list length
        if (n == 0 || n > this.getLength()) {
            throw new IllegalArgumentException("Cannot be zero or greater than list length");
        }

        //Throw exception if list is empty
        if(this.getLength() == 0) {
            throw new IllegalStateException("List is empty");
        }

        //Find the nth node in the list starting from the end position (length)
        int nNode = this.getLength() - n + 1;
        //Node is removed and is returned
        return remove(nNode);
    }


}
