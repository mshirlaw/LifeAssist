import java.io.*;
import java.util.*;

/**
 * The CommonPhrases class creates an ArrayList of common phrases 
 * which can be used by the user to synthesise text
 * @author mshirlaw
 */

public class CommonPhrases
{
	private String filename = "phrases.dat";
	private ArrayList<String> phrasesList;
	private File file;
	
	/**
	 * Create an ArrayList of type String and 
	 * sets up a file for reading from
	 */
	public CommonPhrases()
	{
		//create a file
		file = new File(filename);
		phrasesList = new ArrayList<String>();
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
				phrasesList.add(inputFile.nextLine());
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
	 * @return phrasesList The ArrayList<String> of the commonly used phrases
	 */
	
	public ArrayList<String> getPhrasesList()
	{
		return phrasesList;
	}
}
