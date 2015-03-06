package assignment1;

import java.util.Random;

/**
 * Abstract Class to create and fill an array, to sort the array, and to print 
 * the array.
 */
public abstract class AbstractSort {
    
    private int[] array;
    protected int size;
 
    public AbstractSort(int size) {
        this.size = size;
    }
    
    public abstract int[] fillArray();
       
    public abstract int[] sortArray();
    
    public abstract void print(int perLine);
}
