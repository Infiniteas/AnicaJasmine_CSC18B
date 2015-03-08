package review;

import java.util.Random;

/**
 *
 * BaseSort inherits and implements the methods from the Abstract class 
 */
public class BaseSort extends AbstractSort {
    
    public BaseSort(int size) {
        super(size);
    }
    
    protected int[] array;
    
    @Override
    public int[] fillArray() {
        
       //create array size
       array = new int[size];

       //to remember how to use Random
       //to call random numbers with bounds: rand.nextInt(upperbound-lowerbound)
       //                                                   + lowerbound;
       Random rand = new Random();
       int upperBound = 99;
       int lowerBound = 10;
       //this loop fills the array with random numbers
       for (int i = 0; i < array.length; i++) {
           this.array[i] = rand.nextInt(upperBound - lowerBound) + lowerBound;
       }
       return array;
    }
       
    @Override
    public int[] sortArray() {
        int temp;
        int firstLoopBound = array.length - 1;
        int secondLoopBound = array.length;
        
        //top refers the the top number of the array as it loops
        for (int top = 0; top < firstLoopBound; top++) {
            //next refers to the numbers after the top in this loop
            for(int next = top + 1; next < secondLoopBound; next++) {
                if (this.array[top] > this.array[next]) {
                    //temp stores the smaller value
                   temp = this.array[next];
                   //swaps the smaller number to the bigger number
                   this.array[next] = this.array[top];
                   //swaps from bigger number to smaller number
                   this.array[top] = temp;
                }
            }
        } 
        return this.array;
    }
    
    //prints array by passing in array and numbers per line
    @Override
    public void print(int perLine){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
            if(i % perLine == (perLine - 1)) {
                System.out.println();
            }
        }
    }
    

    
}
