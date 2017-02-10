package edu.iastate.cs228.hw2;
/*
 * @ Jia Han Tan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String args[]) {
          //TODO
          //You may do anything you like here in order to get the behavior 
          //described in the PDF.
          //A recommended structure is to first check the arguments, then
          //read the configuration (character ordering).  With the configuration
          //in hand, you'll be able to read the word list and check that the 
          //words are valid.  Next, initilize your sorters.  Since these all
          //inherit from SorterWithStatistics, you can put them in an array.
          //Run the sorts on the word list and process and display the
          //statistics.
		//File f = new File("ordering");
		//args[0] = "ordering";
		//args[1] = "words";
		char[] charFile;
		String [] wordFile;  // words, comp // isValid(String word, comparator)
		try{
			charFile = readCharacterOrdering( args[0] );
		}catch (Exception e){
			System.out.println("Character file Exception. ");
			return;
		}
		CustomComparator cc = new CustomComparator(charFile);
		try{
			wordFile = readWordsFile( args[1] , cc );
		}catch (Exception e){
			System.out.println("Words file Exception. ");
			return;
		}
		SorterWithStatistics ss = new SelectionSort();
		SorterWithStatistics qs = new QuickSort();
		SorterWithStatistics ms = new MergeSort();
		SorterWithStatistics[] arr = {ss, qs, ms};
		for (int i = 0 ; i <=2 ; i++){ // 3 sorting methods/files
			arr[i].sort( wordFile , cc );
			if(i==0)
				System.out.println("Selection Sort");
			else if(i==1)
				System.out.println("Quick Sort");
			else
				System.out.println("Merge Sort");
			System.out.println("Length of the word list: " + wordFile.length ); //1.
			//System.out.println("Times words sorted: " + ms.getTimeToSortWords() );
			System.out.println("Total time spent sorting: " + (double) arr[i].getTotalTimeToSortWords()/1000000000 + " seconds"); //3.
			//System.out.println("Words sorted each time: " + ms.getWordsSorted() );
			System.out.println("Total number of words sorted: " + arr[i].getTotalWordsSorted() ); //2.
			System.out.println("Average Time required to sort the words list: " + (double) arr[i].getTotalTimeToSortWords()/(wordFile.length*charFile.length*arr[i].getTotalWordsSorted()) + " seconds");// average time required to sort the word list // 1m/totaltime
			System.out.println("Words sorted per second: " + (double) arr[i].getTotalWordsSorted() / arr[i].getTotalTimeToSortWords()*1000000000 );// words sorted per second
		}
		//Main m = new Main();
		//String ordering;
		//readCharacterOrdering(ordering);
		//String words;
		//CustomComparator c = new CustomComparator();
		//m.readWordsFile(words, c.);
		//readCharacterOrdering(ordering);
		//readWordsFile(words);
		/*
		try {
			File f = new File("10.alphabet.txt");
			Scanner sc = new Scanner(f);
			char[] charArr = new char[(int)f.length()];
			int index = 0;
			while(sc.hasNextLine()) {
				charArr[index] = sc.nextLine().charAt(0);
				index++;
			}
			//comp = new CustomComparator(charArr);
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}
		*/
	}
	
	/**
	 * Reads the characters contained in filename (the input alphabet) and returns them as a character array.
	 * @param filename the file containing the list of characters
	 * @returns an char array representing the ordering of characters to be used 
	 *          or null if there is an exception.
         * FileNotFoundException is thrown when filename is does not exist.
         * FileConfigurationException is thrown when any line of the input file is repeated or when any line contains other than exactly 1 byte before the terminating newline.
	 */
	public static char[] readCharacterOrdering(String filename)
			throws FileNotFoundException, FileConfigurationException {
        //TODO
			Scanner input = new Scanner(new File (filename));
			List<Character> lines = new ArrayList<Character>();
			while (input.hasNextLine()){
				String a = input.nextLine();
				if ( a.length()==0 || lines.contains(a.charAt(0))) // if line contains > 1 byte || if line is repeated
						throw new FileConfigurationException();
				lines.add(a.charAt(0));
			}
			char [] arr = new char [lines.size()];
				for (int i = 0; i <= lines.size()-1 ; i++) // start from 0 to end
					arr[i] = lines.get(i) ;
			return arr;
	}
	
	/**
	 * Reads the words from the file and returns them as a String array.
	 * @param filename file containing words
	 * @return the words contained in the file or null if there was an exception.
         * FileNotFoundException is thrown when filename is does not exist.
         * FileConfigurationException is thrown when the file contains any characters that didn't first appear in the input alphabet.
	 */
	public static String[] readWordsFile(String filename, CustomComparator comp)
			throws FileNotFoundException, FileConfigurationException {
		//TODO
			Scanner input = new Scanner(new File (filename));
			List<String> lines = new ArrayList<String>();
			while (input.hasNextLine()){
				String currentLine = input.nextLine();
				boolean z = true;
				if(lines.contains(currentLine)){
					 z = isValid(currentLine, comp);
					input.close();
					throw new FileConfigurationException();
				}else if(z ==false){
					System.out.println("String in words file is not valid");
				}
				else lines.add(currentLine);
			}
			String [] arr = new String [lines.size()];
				//char[] arr = (char[])( lines.toArray());
				for (int i = 0; i <= lines.size()-1 ; i++)
					arr[i] = lines.get(i) ;
			return arr;
	}
	/*
	 public static String[] readWordsFile(String filename, CustomComparator comp)
			throws FileNotFoundException, FileConfigurationException {
		//TODO
			Scanner input = new Scanner(new File (filename));
			List<String> lines = new ArrayList<String>();
			while (input.hasNextLine()){
				lines.add(input.nextLine());
				if(lines.contains(input)) //
					throw new FileConfigurationException();
			}
			String [] arr = new String [lines.size()];
				//char[] arr = (char[])( lines.toArray());
				for (int i = 0; i <= lines.size()-1 ; i++)
					arr[i] = lines.get(i) ;
			return arr;
	}
	 */
	
	/**
	 * Returns whether or not word is valid.
	 * @param word word to be checked.
	 * @param comparator comparator used to check if characters are valid.
	 * @return true if every character in the word is in the input alphabet, else false.
	 */
	public static boolean isValid(String word, CustomComparator comparator) {
        //TODO
		//if (Pattern.matches("[a-zA-Z]" , word))
//		if(comparator.equals(word)) //
//			return true;
//		else
//			return false;
		for (int i = 0  ; i < word.length()-1 ; i++){
			if(comparator.getCharacterOrdering(word.charAt(i)) < 0 )
				return false;
		}
		return true;
	}
	
	private static class FileConfigurationException extends Exception {
	}
}
