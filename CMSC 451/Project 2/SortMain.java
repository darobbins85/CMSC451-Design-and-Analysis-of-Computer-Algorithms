/*
 * File: SortMain.java
 * Author: David Robbins
 * Date: 2017.09.15
 * Purpose: Main class used to create main method for Project 1 for chosen 
 *          sort: Insertion Sort
 */

public class SortMain {
    
    //Main method
    public static void main(String[]args) throws Exception{
        
        //Create array of data set sizes
        int[] arr = {100, 150, 200, 250, 300, 350, 400, 450, 500, 1000};        
        
        //Create BenchmarkSorts object
        BenchmarkSorts bench = new BenchmarkSorts(arr);        
    
    }//End main method

}