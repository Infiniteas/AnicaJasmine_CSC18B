/*
 * File: Assignment_1
 * //////////////////////////////
 * Programmer: Jasmine Anica
 * //////////////////////////////
 * Class: CSC-18B
 * //////////////////////////////
 * Date: 2/26/2015
 *
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author Jasmine
 */
public class Assignment1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //create the size of the array
        int size = 20;
        
        //create BinarySearch Object 
        BinarySearch search = new BinarySearch(size);

        System.out.println("This is the Original array: ");
        search.fillArray(); //uses Basesort methods
        search.print(10);
        
        System.out.println("This is the Sorted array: ");      
        search.setArray(search.sortArray());
        search.print(10);

        Scanner input = new Scanner(System.in);
        
        //allows the user to input the number they want to find
        System.out.println("Enter number you want found in array: ");
        int find = input.nextInt();
        
        //binary search is used to find a variable in an array
        search.sortedBinarySearch(find, 0, size); 
    }
    
}
