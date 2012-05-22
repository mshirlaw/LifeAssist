import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

import javax.swing.JOptionPane;
import java.util.*;

/**
 * The MainPanel class creates a Panel to store
 * the main application window (TextArea) and List objects 
 * to display common words and common phrases and creates
 * Checkboxes and Buttons used in the application
 * @author mshirlaw
 */

public class MainPanel extends Panel
{
	//fields for main application window and stack
	private TextArea sentence;
	private Stack<String> undoStack;
		
	//fields for the three lists to be displayed on screen
	private List words;
	private List phrases;
	private List history;
	
	//internal workings of the lists
	private ArrayList<String> wordsList;
	private ArrayList<String> phrasesList;
	private String[] historyList;
	
	//fields for the checkboxes
	private CheckboxGroup grp;
	private CheckboxGroup grp2;
	
	//fields to create instances of the lists
	private CommonWords commonWords;
	private CommonPhrases commonPhrases;
	private HistoryItems historyItems;

	//fonts
	private Font font;
	private Font labelFont;
	private Font buttonFont;
	
	//colours
	private Color listColour;
	private Color textAreaColour;
	
	
	//panels used to create the overall shape of the GUI
	private Panel titlePanel;
	private Panel textWindowPanel;
	private Panel listPanel;
	private Panel checkButtonPanel;
	private Panel functionButtonPanel;
	private Panel combinedButtons;
	
	//labels for the checkboxes
	private Label voice;
	private Label speed;
	
	//checkboxes for setting voice and speed
	private Checkbox maleCheckbox;
	private Checkbox femaleCheckbox;
	private Checkbox childCheckbox;
	private Checkbox slowCheckbox;
	private Checkbox mediumCheckbox;
	private Checkbox fastCheckbox;
	
	//buttons for speaking, clearing and undo
	private Button speak;
	private Button clear;
	private Button undo;
	
	
	/**
	 * The Constructor sets a font and creates instance of the 
	 * commonWords, commonPhrases and historyItems classes. It also  
	 * creates a stack that is used to facilitate an undo button. It then 
	 * calls the makeTextWindow, makeLists, makeCheckButtons and makeFunctionButtons methods
	 * to make each of the individual panels. It then calls the makeGUI method to combine each 
	 * element
	 */
	
	public MainPanel()
	{	
	
		//set a font and colours
		font = new Font("Ariel", Font.PLAIN, 16);
		listColour = new Color(240,248,255);
		textAreaColour = new Color(245,245,245);
		
		//create instances of the lists
		commonWords = new CommonWords();
		commonPhrases = new CommonPhrases();
		historyItems = new HistoryItems();
		
		//create a stack to hold the text that is added to the TextArea
		undoStack = new Stack<String>();

		//create each of the individual panels
		makeTextWindow();
		makeLists();
		makeCheckButtons();
		makeFunctionButtons();

		//combine each of the elements as a GUI
		makeGUI(this);
		
	}
	
	/**
	 * The makeGUI method combines each of the individual panels as a GUI
	 * @param pan The mainPanel
	 */
	public void makeGUI(Panel pan)
	{
		//set a layout
		pan.setLayout(new BorderLayout());
			
		//add the TextArea and Lists
		pan.add(textWindowPanel, BorderLayout.NORTH);
		pan.add(listPanel, BorderLayout.CENTER);
			
		//combine the buttons on one panel
		combinedButtons = new Panel();
		combinedButtons.setLayout(new BorderLayout());
		combinedButtons.add(checkButtonPanel, BorderLayout.CENTER);
		combinedButtons.add(functionButtonPanel, BorderLayout.SOUTH);
		
		//add the combined buttons
		pan.add(combinedButtons, BorderLayout.SOUTH);
		
	}

	/**
	 * The makeTextWindow method creates a panel for the Main 
	 * Application Window (the TextArea)
	 */
	public void makeTextWindow()
	{
		textWindowPanel = new Panel();
		textWindowPanel.setLayout(new BorderLayout());
		
		//create a textField to store the sentence to be synthesised
		sentence = new TextArea();
		sentence.setFont(font);
		sentence.setBackground(textAreaColour);

		//add the TextField
		textWindowPanel.add(sentence, BorderLayout.NORTH);
	
	}
		
	 /**
	  * The makeLists method sets up the panel, 
	  * populates the Lists and
	  * adds the TextArea and List objects to the panel
	  */
	
	public void makeLists()
	{
		//create a panel for the lists
		listPanel = new Panel();
		listPanel.setLayout(new GridLayout(1,3));
		
		//create a list to store common words
		words = new List();
		words.setMultipleMode(false);
		words.setBackground(listColour);
		
		//create an instance of the CommonWords class to store the words
		//in an ArrayList
		wordsList = commonWords.getWordsList();
				
		for(int i = 0; i<wordsList.size(); i++)
		{
			words.add(wordsList.get(i));
		}
		words.setFont(font);
		
		//add an action listener to the words list
		words.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				append(e.getActionCommand());
			}
		});
		
		listPanel.add(words);
		
		//create a list to store common phrases
		phrases = new List();
		phrases.setMultipleMode(false);
		phrases.setBackground(listColour);
		
		//create an instance of the CommonPhrases class to store the words
		//in an ArrayList
		phrasesList = commonPhrases.getPhrasesList();
				
		for(int i = 0; i<phrasesList.size(); i++)
		{
			phrases.add(phrasesList.get(i));
		}
		phrases.setFont(font);
	
		//add an action listener to the phrases list
		phrases.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				append(e.getActionCommand());
			}
		});
							
		listPanel.add(phrases);
		
		//create a list to store history
		history = new List();
		history.setMultipleMode(false);
		history.setBackground(listColour);
		
		//create an instance of the HistoryItems class to store the history
		//in an array
		historyList = historyItems.getHistoryArray();

		for(int i = 0; i<historyList.length; i++)
		{
			history.add(historyList[i]);
		}
		history.setFont(font);
		
		//add an action listener to the history list
		history.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				append(e.getActionCommand());
			}
		});
			
		listPanel.add(history);


	}
	
	/**
	 * The makeCheckbuttons method sets up the panel, 
	 * creates a series of checkboxes and  labels and
	 * adds the checkboxes and label objects to the panel
	 */
	
	public void makeCheckButtons()
	{
		
			checkButtonPanel = new Panel();
			checkButtonPanel.setLayout(new GridLayout(2,4));
			
			buttonFont = new Font("Ariel", Font.PLAIN, 14);
			setFont(buttonFont);
			
			labelFont = new Font("Ariel", Font.PLAIN, 14);
			
			//set the layout of the button panel
			setLayout(new GridLayout(3,3));
			
			//create a label for the voice
			voice = new Label("Select a voice:");
			voice.setFont(labelFont);
			
			//create a checkbox group for the voice and the speed
			grp = new CheckboxGroup();
			grp2 = new CheckboxGroup();
			
			//create checkboxes for voice
			maleCheckbox = new Checkbox("Male",grp,true);
			femaleCheckbox = new Checkbox("Female",grp,false);
			childCheckbox = new Checkbox("Child",grp,false);
			
			//create a label for the speed
			speed = new Label("Select the speed:");
			speed.setFont(labelFont);
			
			//create checkboxes for speed	
			slowCheckbox = new Checkbox("Slow",grp2,true);
			mediumCheckbox = new Checkbox("Medium",grp2,false);
			fastCheckbox = new Checkbox("Fast",grp2,false);		

			//add the voice Label
			checkButtonPanel.add(voice);
			
			//add the checkboxes for the voices
			checkButtonPanel.add(maleCheckbox);
			checkButtonPanel.add(femaleCheckbox);
			checkButtonPanel.add(childCheckbox);
					
			//add the speed Label
			checkButtonPanel.add(speed);
			
			//add the checkboxes for the speed
			checkButtonPanel.add(slowCheckbox);
			checkButtonPanel.add(mediumCheckbox);
			checkButtonPanel.add(fastCheckbox);
		
	}

	/**
	 * The makeFunctionButtons method sets up a panel, 
	 * creates a series of buttons and
	 * adds the button objects to the panel
	 */
	
	public void makeFunctionButtons()
	{

		functionButtonPanel = new Panel();
		functionButtonPanel.setLayout(new GridLayout(1,4));
			
		//create the speak button and register an event listener
		speak = new Button("Speak");
		speak.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Now speaking: \n"+getText()+
						"\n---------------------" +
						"\nVoice: "+grp.getSelectedCheckbox().getLabel()
+ 						"\nSpeed: "+grp2.getSelectedCheckbox().getLabel());
				
				//add text that was synthesised to the history list
				historyItems.addToHistory(getText());
				
				//update the history list in the GUI
				replaceHistoryItems(historyItems.getHistoryArray());
			}
		});
		
		//create the undo button and register an event listener
		undo = new Button("Undo");
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				undoLast();
			}
		});
		
		//create the clear button and register an event listener
		clear = new Button("Clear");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clear();
			}
		});

		//add the buttons
		functionButtonPanel.add(speak);
		functionButtonPanel.add(undo);
		functionButtonPanel.add(clear);
		
		//a blank label for spacing
		functionButtonPanel.add(new Label()); 
		
	}
	

	/**
	 * The append method adds a string to the TextField
	 * after the user has chosen words and phrases to synthesise. It 
	 * also pushes the text added to the TextField to a stack to facilitate the
	 * undo feature
	 * @param str The String to append to the TextField
	 */
	
	public void append(String str)
	{
		//add a white space
		String textToAdd = str+" ";
		
		//add the new text to the stack
		undoStack.push(textToAdd);
		
		//append the new text to the TextArea
		sentence.append(textToAdd);
	}

	/**
	 * The clear method clears the text in the TextField
	 */

	public void clear()
	{
		//clear the TextField
		sentence.setText("");
		
		//empty the stack
		while(!undoStack.empty())
			undoStack.pop();
	}
	
	/**
	 * The getText method returns the text in the TextField
	 */
	
	public String getText()
	{
		return sentence.getText();
	}
	
	/**
	 * The undoLast method allows the user to remove words and phrases
	 * in the order that they were added
	 */
	
	public void undoLast()
	{
		try
		{
			String remove = undoStack.pop();
			String oldSentence = getText();
			String newSentence = oldSentence.substring(0,oldSentence.lastIndexOf(remove));
			sentence.setText(newSentence);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	/**
	 * The replaceHistoryItems method updates the List of history items 
	 * in the GUI with the most recent phrase at the top
	 * @param array An array which contains the most recent history items
	 */
	
	public void replaceHistoryItems(String[] array)
	{
		for(int i=0; i<array.length;i++)
			history.replaceItem(array[i], i);
	}
}
