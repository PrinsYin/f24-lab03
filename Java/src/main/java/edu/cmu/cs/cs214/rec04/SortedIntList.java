package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SortedIntList implements a sorted list of integers.
 */
public class SortedIntList extends AbstractIntList {
    private final List<Integer> sortedlist; 

    /**
     * Empty SortedIntList.
     */
    public SortedIntList() {
        sortedlist = new ArrayList<>(); 
    }

    @Override
    public boolean add(int value) {
        int index = Collections.binarySearch(sortedlist, value);
        if (index < 0) {
            index = -(index + 1); 
        }
        sortedlist.add(index, value); 
        return true; 
    }

    @Override
    public int get(int index) {
        return sortedlist.get(index); 
    }

    @Override
    public boolean remove(int value) {
        return sortedlist.remove((Integer) value); 
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            flag |= sortedlist.remove((Integer) list.get(i)); 
        }
        return flag;
    }

    @Override
    public int size() {
        return sortedlist.size(); 
    }
}