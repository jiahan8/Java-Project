package edu.iastate.cs228.hw2;
/*
 * @ Jia Han Tan
 */
import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort extends SorterWithStatistics {
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
        //TODO -- implement selection sort
		//String[] a = words;
		selectionSort(words, comp);
		//System.out.println("");
	}
	/**
	   * 2. Same algorithm, but modified to sort Strings. Instead
	   * of using "<" to compare elements, we use the fact that String
	   * implements the Comparable interface, and therefore has a method
	   * compareTo().  Also, the temp variable is changed to type String.
	   * Those are the only two changes in the code.
	   */
	  private static void selectionSort(String[] arr, Comparator<String> comp){
		if ( arr == null || arr.length == 0 )
			throw new IllegalArgumentException("Null pointer or zero size");
	    for (int i = 0; i < arr.length -1 ; i++){ // i < arr.length-1
	    	int minIndex = i;
	    	for (int j = i + 1; j < arr.length ; j++){
	    	// "<" changed to use of compareTo()
	    		if (comp.compare(arr[j], arr[minIndex]) < 0) // select the smallest, (arr[j].compareTo(arr[minIndex]) < 0)
	    			minIndex = j;
	    		if ( i != minIndex ){ // if index i isNot pos, SWAP, inside if just a condition, if delete still will work
	    			String t = arr[i];
	    			arr[i] = arr[minIndex];
	    			arr[minIndex] = t;
	    		}
//	    	String temp = arr[i]; // swap with the smallest
//	    	arr[i] = arr[minIndex];
//	    	arr[minIndex] = temp;
	    	}
	    }
	  }
	   /*
	public static void selectionSort(String [] a){ // start from first element, choose the smallest element after the element, then SWAP
        if ( a == null || a.length == 0 )
          throw new IllegalArgumentException("Null pointer or zero size");
        //showArray(a, "at the start of selectionSort", -1); // for demo; can be removed.
        for ( int i = 0; i < a.length - 1; i++ ){ // i from 0 to 8
            int pos = i; // store index i into pos
            for ( int j = i + 1; j < a.length; j++ ){ // j from 1 to 9
              if ( a[pos] > a[j] ) // if a[i] > a[j], if left element > right element
                pos = j; // i = j, place index j into index i
            }
            if ( i != pos ){ // if index i isNot pos, SWAP, inside if just a condition, if delete still will work
              int t = a[i];
              a[i] = a[pos];
              a[pos] = t;
            }
          showArray(a, "at the end of iteration " + i, i); // for demo; can be removed.
        } // for i
    } // selectionSort
	*/
	  
//		Collections.sort(words, new Comparator<String>() {
//      @Override
//      public int compare(String s1, String s2) {
//          return s1.compareToIgnoreCase(s2);
//      }
//	}
	  
}



