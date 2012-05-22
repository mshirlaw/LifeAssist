import java.awt.Component;
import java.io.*;
import java.util.*;

/**
 * The HistoryItems class is used to store recently used 
 * phrases as a list of history items and save the recent
 * history of phrases to a file called "history.dat"
 * @author mshirlaw
 */

public class HistoryItems
{
	private final static int MAX_HISTORY_ITEMS = 10;
	private String filename = "history.dat";
	private String[] historyArray;
	private File file;
	
	/**
	 * Sets up a file for reading and writing
	 * Initialises an array of String objects to store the
	 * history of recent phrases
	 */
	public HistoryItems()
	{
		//create a file
		file = new File(filename);
		historyArray = new String[MAX_HISTORY_ITEMS];
		readHistory();
	}	
	
	/**
	 * the readHistory method reads history items from file and stores them in an array
	 */
	public void readHistory()
	{
		
		//read history items from file and store in an array
		try
		{
			int i = 0;
			Scanner inputFile = new Scanner(file);
			while(inputFile.hasNext())
			{
				historyArray[i] = inputFile.nextLine();
				i++;
			}
		
			inputFile.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * The writeHistory method writes the list of history items to 
	 * file so that it can be saved for future use
	 */
	public void writeHistory()
	{
		try
		{
			PrintWriter outputFile = new PrintWriter(file);
			for(int i=0; i<historyArray.length; i++)
				outputFile.println(historyArray[i]);
			
			outputFile.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Accessor method provides access to the array to populate the history List
	 * @return historyArray The array of recently used phrases
	 */
	
	public String[] getHistoryArray()
	{
		return historyArray;
	}
	
	/**
	 * Static method for adding to the array of history items
	 * @param item The item to add to the history list
	 */
	
	public void addToHistory(String item)
	{
		//create a temporary array of string objects to hold the history items
		String[] temp = new String[MAX_HISTORY_ITEMS];
		
		//move all items along one and add the new item to the front of the array
		for(int i = temp.length-1; i>0; i--)
			temp[i] = historyArray[i-1];
		temp[0] = item;
		historyArray = temp;
		
		//save the new history list to file
		writeHistory();
	}
}
