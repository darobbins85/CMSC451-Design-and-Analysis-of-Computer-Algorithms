/*
 * File: UnsortedException.java
 * Author: David Robbins
 * Date: 2017.09.15
 * Purpose: exception thrown in case the the data is not sorted
 */

public class UnsortedException extends Exception{

private static final long serialVersionUID = 1L;
  
    public UnsortedException(String msg) {
        super(msg);
    }

}
