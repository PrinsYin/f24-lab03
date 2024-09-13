package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private final SortedIntList sortedList; 
    private int totalAdded; 

    /**
     * Constructs a new DelegationSortedIntList.
     */
    public DelegationSortedIntList() {
        this.sortedList = new SortedIntList();
        this.totalAdded = 0; 
    }

    /**
     * Attempts to add an element to the list and increments the count of total added elements.
     *
     * @param value the integer value to be added to the list
     * @return true if the value was successfully added, false otherwise
     */
    public boolean add(int value) {
        totalAdded++; 
        return sortedList.add(value); 
    }

    /**
     * Attempts to add all elements from the collection to the list and increments the count of total added elements.
     *
     * @param values the collection of integer values to be added to the list
     * @return true if all values were successfully added, false otherwise
     */
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return sortedList.addAll(list);
    }

    /**
     * Returns the total number of attempted element insertions.
     *
     * @return the total number of insertions attempted
     */
    public int getTotalAdded() {
        return totalAdded; // Return the total count of attempted insertions
    }

    public int get(int index) {
        return sortedList.get(index);
    }

    public boolean remove(int value) {
        return sortedList.remove(value);
    }

    public int size() {
        return sortedList.size();
    }

    public boolean removeAll(IntegerList list) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            flag |= sortedList.remove((Integer) list.get(i)); 
        }
        return flag;
    }

}