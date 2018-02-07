/*
 * File: Sort.java
 * Author: David Robbins
 * Date: 2017.10.12
 * Purpose: used to create insertion sort iteratively and recursively as well as 
 *          count the critical operations and find execution times
 */

public class Sort implements SortInterface{
    //Class variables
    int countR=0, countI=0;
    long timeR=0, timeI=0;
    public UnsortedException unsorted;
    
    //Method that provides a recursive insertion sort
    @Override
    public void recursiveSort(int[] arr, int i, int n) throws Exception {
        long start = System.nanoTime();
        
        int value = arr[i];
        int j = i;
        // find index j within the sorted subset arr[0...i-1] where element arr[i] belongs
        while(j > 0 && arr[j-1] > value){
            arr[j] = arr[j-1];
            j--;
            
            // critical operation to count - where it was in Project 1 - PLACING IT HERE YIELDS VERY HIGH RESULTS
            //countR++;
        }
        
        // moved critical operatino count and standard deviation looks a lot 
        // better than it did when the count was within the above loop
        // PLACING IT HERE YIELDS SIMILAR TO ITERATIVE RESULTS
        //countR++;
        
        arr[j] = value;        
        //note that subarray arr[j...i-1] is shifted to the right by one position so arr[j+1...i]
        
        if(i + 1 <= n){
            recursiveSort(arr, i+1, n);
            //PLACING IT HERE RESULTS IN CONSISTANTLY ONE LESS THAN ITERATIVE RESULTS
            //this seems the best option for counting the recursive method as with the 
            //insertion sort iterative yields O(1) while recursive yeilds O(n)
            countR++;
        }
        //countR++;
        
        long end = System.nanoTime();
        // Actual run time of this method
        timeR = end - start;
        
        // Throwing UnsortedException
        for(int k = 0; k < arr.length - 1; k++){
            if(arr[k] > arr[k+1]){
                unsorted = new UnsortedException("***Array was not sorted***");
                throw unsorted;
            }
        }
    }
    
    //method that provides an iterative insertion sort
    @Override
    public void iterativeSort(int[] arr, int n) throws Exception{
        long start = System.nanoTime();

        // start from second element (element at index 0 is already sorted (base case - best case)
        for(int i = 1; i < n; i++){
            int value = arr[i];
            int j = i;
            
            // find the index j within the sorted subset arr[0...i-1] where element arr[i] belongs
            while(j > 0 && arr[j-1] > value){
                arr[j] = arr[j-1];
                j--;
            }
            // note that subarray arr[j...i-1] is shifted to the right by one position so arr[j+1...i]
            // critical operation to count
            countI++;
            arr[j] = value;
        }
        
        long end = System.nanoTime();
        // Actual run time of this method
        timeI = end - start;
        
        // Throwing UnsortedException
        for(int k = 0; k < arr.length - 1; k++){
            if(arr[k] > arr[k+1]){
                unsorted = new UnsortedException("***Array was not sorted***");
                throw unsorted;
            }
        }
    }
    
    //Method the returns the count of critical operations
    @Override
    public int getCount() {
        int total = countR + countI;
        countR = 0;
        countI = 0;
        return total;
    }
    
    //Method that returns the execution time
    @Override
    public long getTime() {
        long total = timeR + timeI;
        timeR = 0;
        timeI = 0;
        return total;
    }
        
}
