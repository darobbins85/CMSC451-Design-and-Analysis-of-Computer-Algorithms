/*
 * File: SortInterface.java
 * Author: David Robbins
 * Date: 2017.09.15
 * Purpose: Interface to be used in Sort class
 */

public interface SortInterface {
    
    public void recursiveSort(int arr[], int i, int n) throws Exception;
    
    public void iterativeSort(int arr[], int n) throws Exception;
    
    public int getCount();
    
    public long getTime();

}
