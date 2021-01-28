/**
 * List Data Type. Write a data type List.java that
 * represents an listay of homogeneous elements. 
 * Implement the following public API which can be 
 * used as an API for the rest of your course.
 * 
 * @author Praveen Garimella
 * @author Siva Sankar
 * @author Jagan
 * 
 * @since August - 2018
 */

import java.util.Arrays;

public abstract class AbstractList implements ListInterface  {
    // Implement all the methods mentioned to build a ListADT and 
    // OrderedList ADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An listay would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an listay of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the listay to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the listay then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the listay such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    
    // declare a private int[]
    // don't create the listay yet using new
    // that's the job of the List constructor

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the listay. Do they mean the same?
     * No, listay length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * listay = [1,2,3,0,0,0,0,0,0,0]
     * The length of the listay is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     * 
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    public int[] intList;
    public int size;

    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
    public AbstractList() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an listay size like 10

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        intList = new int[10];
        size = 0;
    }
    
    /*
     * Overloaded constructor with list capacity as argument
     * The default constructor sets the list capacity to 10
     * So, adding an item when the list size is 10
     * raises a Index Out of Bounds Exception
     * There will be some clients of the ADT that will require
     * the list to contain n elements which is known
     * at the time of creating the list.
     * 
     * The overloaded constructor is a way to initialize a list with
     * a list capacity of n items where n is given as an argument to
     * constructor.
     * 
     */
    public AbstractList(int capacity) {
        size = 0;
        intList = new int[capacity];
    }
    
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the listay?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here.
        
    }

    /**
     * Given an index and an item, adds this item at a particular index.
     * 
     * Example:
     * 
     * Let's say for example the List object contains : [5,-2,3,1,6,-1]
     * 
     * Input : add(1, 2)
     * First Move all the elements to the right by one upto the given index. So, you
     * will be having a gap at the given index where you can insert a new element / item
     * that is passed as parameter.
     * Output : [5,2,-2,3,1,6,-1]
     * 
     * Can you think of the following works:
     * Let's say for example the List object contains : [5,-2,3,1,6,-1]
     * Input: add(20, 2) : As there are 6 elements, you can't insert an element / item
     * after 6th index.
     * 
     * Output: [5,2,-2,3,1,6,-1]
     * 
     * Think of on which object this method can be called. List / OrderedList and etc.
     */
    public final void add(int index, int item) {
        // TODO
        // Your code goes here.
        if (index<=size && index>=0) {
            for (int i=size; i>=index; i--){
                intList[i+1] = intList[i];
            }
            intList[index] = item;
            size += 1;
        }
        
    }

    /**
     * Appends all of the elements in the specified list to the end of this list, or
     * it will be added in order if the list is OrderedList, in the order that
     * they are returned by the specified list's Iterator.
     * 
     * @param lst list containing elements to be added to this list.
     */
    public void addAll(List lst) {
        // TODO
        // Your code goes here.
        
    }

    /**
     * This method adds all the items of the arr to this list.
     * @param arr is an array of items that should be added to 
     * this list.
     */
    public void addAll(int[] arr ){
        // TODO
        // Your code goes here.
        
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     * 
     * The method returns an int. Empty list should return 0.
     */
    public int size() {
        // replace the code below to implement the size method
        // TODO
        // Your code goes here.
        return size;
    }

    /**
     * Resizes the array by doubling the space.
     */
    public void resize() {
        // TODO
        // Your code goes here.
        intList = Arrays.copyOf(intList, intList.length*2);
    }

    /*
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when 
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * listay = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an listay?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new listay looks like this.
     * listay = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    public void remove(int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        // TODO
        // Your code goes here.
        if (index < size){
            for (int i = index; i<size; i++) {
                intList[i] = intList[i+1];
            }
            intList[size-1] = 0; 
            size -= 1;
        }
    }

    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the 
     * number of items in the list? Would size variable be useful?
     */
    public int get(int index) {
        // Replace the code below to write the code for get
        // TODO
        // Your code goes here.
        if (index<size && index>=0) {
            return intList[index];}
            else {
                return -1;
            }
    }

    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     * 
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The listay may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the listay.
     *
     */
    public String toString() {
        // Replace the code below
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<size-1; i++)
            sb.append(intList[i] + ",");
        sb.append(intList[size-1]);
        sb.append("]");
        return sb.toString();
    } 
    
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    public boolean contains(int item) {
        // TODO
        // Your code goes here.
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                return true;
            }
        } return false;
    }

    /*
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int indexOf(int item) {
        // TODO
        // Your code goes here.

        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, 
     * or -1 if this list does not contain the element. 
     * More formally, returns the highest index i, or -1 if there is no such index.
     * @param item, element to search for
     * @return the index of the last occurrence of the specified element in this list, 
     * or -1 if this list does not contain the element
     */
    public int lastIndexOf(int item) {
        // TODO
        // Your code goes here.
        int flag = 0, sample=0;
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                flag = 1;
                sample = i;
            }
        }
        if (flag == 1){
            return sample;
        }else return -1;
    }

    /**
     * Given an item, counts the number of occurances of the item in this list.
     * @param item to be counted in this list.
     * @return the number of occurances of the item in this list.
     */
    public int count(int item) {
        // TODO
        // Your code goes here.
        int countVar=0;
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                countVar += 1;
            }
        } return countVar;
    } 

    /**
     * Returns a view of the portion of this list between the specified fromIndex, 
     * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, 
     * the returned list is empty.) The returned list is backed by this list, 
     * so non-structural changes in the returned list are reflected in this list,
     *  and vice-versa. The returned list supports all of the optional list operations.
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     */
    public List subList(int fromIndex, int toIndex) {
        // TODO
        // Your code goes here.
        List sub = new List();
        if (fromIndex == toIndex || toIndex < 0 || fromIndex < 0) {
            return null;
        }else if (fromIndex >= 0 && toIndex >=0)  {
            for (int i=fromIndex; i<toIndex; i++) {
                sub.intList[sub.size] = intList[i];
                sub.size += 1;
            }
        }
        return sub;
    }

    /**
     * Replaces the element at the specified position in this list 
     * with the specified element.
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public void set(int index, int item) {
        // TODO
        // Your code goes here.
        if (index <= size){
            intList[index] = item;
        }
    }
}