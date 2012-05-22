import java.io.*;
import java.util.*;

/**
 * The CommonWords class creates an ArrayList of common words 
 * which can be used by the user to synthesise text
 * @author mshirlaw
 */

public class CommonWords
{
	private String filename = "words.dat";
	private ArrayList<String> wordList;
	private File file;
	
	/**
	 * Create an ArrayList of type String and 
	 * sets up a file for reading from
	 */
	public CommonWords()
	{
		//create a file
		file = new File(filename);
		wordList = new ArrayList<String>();
		readNames();
	}

	/**
	 * Reads names from file and stores them in the ArrayList
	 */
	public void readNames()
	{
		//read data from file and store in ArrayList
		try
		{
			Scanner inputFile = new Scanner(file);
			while(inputFile.hasNext())
			{
				wordList.add(inputFile.nextLine());
			}
		
			inputFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(filename+" not found");
		}
	}
	
	/**
	 * Accessor method for access to the ArrayList
	 * @return wordsList The ArrayList<String> of the commonly used words
	 */
	
	public ArrayList<String> getWordsList()
	{
		return wordList;
	}
}
