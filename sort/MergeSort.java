package edu.iastate.cs228.hw2;
/*
 * @ Jia Han Tan
 */
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort extends SorterWithStatistics {
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
        //TODO -- implement merge sort
        //You'll probably need a helper method here, i.e., merge()
		//Arrays.sort(words, comp);
	        if (words.length >= 2){
	            String[] left = new String[words.length / 2];
	            String[] right = new String[words.length - words.length / 2];
	            for (int i = 0; i < left.length; i++){
	                left[i] = words[i];
	            }
	            for (int i = 0; i < right.length; i++){
	                right[i] = words[i + words.length / 2];
	            }
	            sortHelper(left , comp);
	            sortHelper(right, comp);
	            merge(words, left, right ,comp);
	        }
	    }
	    public static void merge(String[] result, String[] left, String[] right , Comparator<String> comp){
	        int i1 = 0;
	        int i2 = 0;
	        for (int i = 0; i < result.length; i++) {
	            if (i2 >= right.length || (i1 < left.length && comp.compare(left[i1], right[i2]) <0) ){ // i2 >= right.length || (i1 < left.length && left[i1].compareToIgnoreCase(right[i1])<0)
	                      result[i] = left[i1];
	                      i1++;
	                } else {
	                      result[i] = right[i2];
	                      i2++;
	                }
	        }
	    }
}		
		/*
		    if ( words == null || words.length == 0 )
		      throw new IllegalArgumentException("Null pointer or zero size");
		    //int t;
		    String[] tmp = new String[words.length]; // a working array
		    //String level = ">"; // for showing recursion level
		    mergeSortRec(words , tmp , 0 , words.length - 1 , comp);
	}
	private static void mergeSortRec(String[] arr, String[] tmp, int first, int  last , Comparator<String> comp){
		    //if ( first < 0 || last >= arr.length )
		    //	throw new IllegalArgumentException("index out of bound");
		    if ( comp.compare(arr[first], arr[last]) >= 0 )  return; // a subarray of size 1 is already sorted by itself. //  first >= last
		    int i, j, k;
		    int mid = (first + last) / 2; // partition index
		    //System.out.print( level + ": " ); // for display only; can be removed
		    //for ( i = first; i <= mid; i++ )
		    //  System.out.print( arr[i] + " ");
		    //System.out.print( " | ");
		    //for ( ;  i <= last; i++ )
		    //  System.out.print( arr[i] + " ");
		    //System.out.print( "\n");
		    //String sublevel = level + ">";
		    mergeSortRec(arr, tmp, first, mid , comp); // sorts each subarray
		    mergeSortRec(arr, tmp, mid+1, last , comp);
		    k = first;
		    for ( i = first, j = mid+1; i <= mid && j <= last; ){ // for ( i = first, j = mid+1; i <= mid && j <= last; )
		      if ( comp.compare(arr[i] , arr[j] )<=0 )
		        tmp[k++] = arr[i++];
		      else
		        tmp[k++] = arr[j++];
		    }  // merges two sorted subarrays
		    while (comp.compare(arr[i], arr[mid]) <= 0) // at most one of the two while loops gets executed //  i <= mid 
		        tmp[k++] = arr[i++];
		    while (comp.compare(arr[j], arr[last]) <= 0) // copies the rest of one subarray  // j <= last
		        tmp[k++] = arr[j++];
		    if ( k != last + 1 )
		      throw new RuntimeException("Error in index");
		    for ( k = first; k <= last; k++ ) // keeps the results in arr
		        arr[k] = tmp[k];
		    //System.out.print( level + ": " ); // for display only; can be removed
		    //for ( i = first; i <= last; i++ )
		    //  System.out.print( arr[i] + " ");
		    //System.out.print( "\n\n");
		  }
}*/
