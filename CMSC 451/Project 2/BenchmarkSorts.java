/*
 * File: BenchmarkSorts.java
 * Author: David Robbins
 * Date: 2017.10.12
 * Purpose: creates the BenchmarkSorts object which calls the Sort methods as 
 *          well as displays for the user the data including: Data Set Size, 
 *          Average Critical Operation Count, Standard Deviation of Count, and 
 *          Average Execution Time of iterative and recursive calls of the 
 *          insertion sort
 */

import java.util.Random;

public class BenchmarkSorts {
    
    //Class variables
    int[] randomData, itCountList = new int[50], reCountList = new int[50]; 
    int n, itCount=0, reCount=0, reLocate=0, itLocate=0;
    long itTime, reTime;
    long[] itTimeList = new long[50], reTimeList = new long[50];
    
    Sort sort = new Sort();
    
    //Constructor for use in main method
    public BenchmarkSorts(int[] sizes)throws Exception{
        System.out.println("\t\t\t\t\t\t\t\t\t\tIterative" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Recursive\n");
        System.out.printf("%-20s%-36s%-32s%-28s%-34s%-40s%-36s%-30s%-42s\n", "Data Set Size n", "Average Critical Operation Count", 
                          "Standard Deviation of Count", "Average Execution Time", "Standard Deviation of Time",
                          "Average Critical Operation Count", "Standard Deviation of Count", 
                          "Average Execution Time", "Standard Deviation of Time");
        for(int i = 0; i < sizes.length; i++){
            n = sizes[i];
            BenchmarkSorts sort = new BenchmarkSorts(n);
        }
    }
    
    //Constructor for use within class to call runSorts and displayReport methods
    private BenchmarkSorts(int n)throws Exception{
        for(int i = 1; i < 50; i++){
            randomData = new int[n];
            for(int j = 0; j < n; j++){
                Random data = new Random();
                randomData[j] = (data.nextInt(50000));
            }
            runSorts();
        }
        displayReport(n);
    }
    
    //Method to run the recursive and iterative sorts
    public void runSorts() throws Exception{
        int count;
        long time;
        
        // Running recursive sort and storing critical count and time data
        int[] reArr = randomData;
        sort.recursiveSort(reArr, 1, reArr.length - 1);
        count = sort.getCount();
        time = sort.getTime();
        reCount = reCount + count;
        reTime = reTime + time;
        reCountList[reLocate] = reCount;
        reTimeList[reLocate] = reTime;
        reLocate++;
        
        // Running iterative sort and storing critical count and time data
        int[] itArr = randomData;
        sort.iterativeSort(itArr, itArr.length);
        count = sort.getCount();
        time = sort.getTime();
        itCount = itCount + count;
        itTime = itTime + time;
        itCountList[itLocate] = itCount;
        itTimeList[itLocate] = itTime;
        itLocate++;
    }
    
    //Method used to figure averages and standard deviations of count and time
    public void displayReport(int n){
        //Figuring averages
        double itAvgCount = itCount/49, reAvgCount = reCount/49, itAvgTime = itTime/49, reAvgTime = reTime/49;
        
        //Figuring standard deviations
        double itSdCount=0, reSdCount=0, itSdTime=0, reSdTime=0;
        for(int i = 1; i < 50; i++){
            reSdCount = reSdCount + Math.pow((reCountList[i] - reAvgCount), 2);
            reSdTime = reSdTime + Math.pow((reTimeList[i] - reAvgTime), 2);
            itSdCount = itSdCount + Math.pow((itCountList[i] - itAvgCount), 2);
            itSdTime = itSdTime + Math.pow((itTimeList[i] - itAvgTime), 2);
        }
        
        //fixed a mistake where I had placed a 2 instead of the value of n in this section of code
        //which was causing a large difference in the average and standard deviation
        reSdCount = Math.pow(reSdCount, .5)/n;
        reSdTime = Math.pow(reSdTime, .5)/n;
        itSdCount = Math.pow(itSdCount, .5)/n;
        itSdTime = Math.pow(itSdTime, .5)/n;
        
        //Final output for user
        System.out.printf("%-20s%-36s%-32s%-28s%-34s%-40s%-36s%-30s%-42s\n", n, itAvgCount, itSdCount, itAvgTime, itSdTime, reAvgCount, reSdCount, reAvgTime, reSdTime);
    }
    
}