package edu.iastate.cs228.hw2;
/*
 * @ Jia Han Tan
 */
import java.util.Comparator;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public abstract class SorterWithStatistics implements Sorter {
	private Stopwatch timer = new Stopwatch();
	private int wordsLastSorted; 	//instance variable to count words last sorted
	private int totalWordsSorted; 	//instance variable to count total words sorted
	private long timesSorted; 		//instance variable to count times words sorted
	private long totalTimesSorted; //instance variable to count total times sorted
        /***
         * Default constructor
         */
	public SorterWithStatistics() {
          //TODO
	}

        /***
         * Public interface to sortHelper that keeps track of performance
         * statistics, including counting words sorted and timing sort
         * instances.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
         */
	public void sort(String[] words, Comparator<String> comp){
          //TODO
		//int a = 1000000000;
		timer.start();
		sortHelper(words , comp);
		timer.stop();
		timesSorted = timer.getElapsedTime(); // times words sorted
		//System.out.println("Times words sorted: " + timesSorted);
		totalTimesSorted+=timesSorted;  // total times sorted
		//System.out.println("Total time spent sorting: " + totalTimesSorted);
		wordsLastSorted=words.length;  // words sorted, add words.length to wordsSorted
		//System.out.println("Words sorted each time: " + wordsLastSorted); // length of the word list
		totalWordsSorted+=wordsLastSorted; // total words sorted 
		//System.out.println("Total number of words sorted: " + totalWordsSorted);
		//System.out.println(totalTimesSorted);// average time required to sort the word list
		//System.out.println(totalWordsSorted);// words sorted per second
		System.out.println();
	}
	
	/**
	 * Sorts the array words.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
	 */
	protected abstract void sortHelper(String[] words, Comparator<String> comp);

	/**
	 * Returns number of words sorted in last sort.  Throws IllegalStateException if nothing has been sorted.
	 * @return number of words sorted in last sort.
	 */
	public int getWordsSorted() {
        //if words sorted instance variable is 0, throw exception
		//else return words sorted instance variable
		
		//TODO
		try{
			return wordsLastSorted;
		}catch(Exception e){
			throw new IllegalStateException(); // if nothing has been sorted
		}
	}
	
	/**
	 * Returns time the last sort took.  Throws IllegalStateException if nothing has been sorted.
	 * @return time last sort took.
	 */
	public long getTimeToSortWords() {
          //TODO
		try{
			//return timer.getElapsedTime();
			return timesSorted;
		}catch(Exception e){
			throw new IllegalStateException();
		}
	}
	
	/**
	 * Returns total words sorted by this instance.
	 * @return total number of words sorted.
	 */
	public int getTotalWordsSorted() {
          //TODO
		//return this.getWordsSorted();
		return totalWordsSorted;
	}
	
	/**
	 * Returns the total amount of time spent sorting by this instance.
	 * @return total time spent sorting.
	 */
	public long getTotalTimeToSortWords() {
          //TODO
		//timer.getElapsedTime();
		//return this.timer.getElapsedTime();
		return totalTimesSorted;
	}
}
