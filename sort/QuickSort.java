package edu.iastate.cs228.hw2;
/*
 * @ Jia Han Tan
 */
import java.util.Arrays;
import java.util.Comparator;

public class QuickSort extends SorterWithStatistics {
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
        //TODO -- implement quicksort
        //You will need a helper method, i.e., partition()
		//Arrays.sort(words, comp);
		 if ( words == null || words.length == 0 )
			 throw new RuntimeException("Null pointer or zero size");
		 //String level = ">"; // for showing the level of recursion
		 quickSortRec(words, 0, words.length-1 , comp);
	}
		// The code involving parameter level and print statements is for showing
		// the contents of each subarray at the start and end of each call.
		// The code should be removed in any program submitted for grading.
		private static void quickSortRec(String[] arr, int first, int last , Comparator<String> comp){
			if ( comp.compare(arr[first] , arr[last]) >= 0  ) return;
			int mid = partition(arr, first, last , comp); // performs a partition
			//String sublevel = level + ">"; // for showing the level of recursion
			quickSortRec(arr, first, mid , comp); // recursive calls
			quickSortRec(arr, mid+1, last , comp);
		}  //  quickSortRec

		// Note that the code needs to be revised if a different method is used to select the pivot.
		// Otherwise, the code may not work correctly.
		private static int partition(String[] arr, int first, int last , Comparator<String> comp){
			String  pivot = arr[first]; // A simple way to select the pivot.
			int  left = first;
			int  right = last;
			//showArray(arr, "recursion level: " + level + " partition: start " + " pivot: " + pivot, first, first-1, last); // for demo only;
			while ( true ){
				while ( comp.compare(arr[left] , pivot) < 0) // arr[left] < pivot 
			    left++;
			    while ( comp.compare(arr[right] , pivot) > 0) // arr[right] > pivot
			    	right--;
			    	if ( comp.compare(arr[left] , arr[right]) < 0){
			    		//beforeAndAfterSwap(arr, "recursion level: " + level + " swap: before ", first, last, left, right); // for demo only
			    		String t = arr[left];
			    		arr[left++] = arr[right];
			    		arr[right--] = t;
			    		//beforeAndAfterSwap(arr, "recursion level: " + level + " swap: after ", first, last, left, right); // for demo only
			    	}  // swap
			    	else
			    		break;
			 }  // partition
			  //showArray(arr, "recursion level: " + level + " partition: end ", first, right, last); // for demo only; can be removed
			  return right; // partition index
		}
}
