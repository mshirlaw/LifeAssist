import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The HelpMenu class creates a pop up window which 
 * displays a simple FAQ to provide help for the user
 * @author mshirlaw
 *
 */

public class HelpMenu extends CenteredFrame
{
	Label title;
	Button close;
	TextArea text;
	ArrayList<String> textArray;
	File file;
	
	/**
	 * Constructor
	 * Creates a new help menu window to display the FAQ
	 * @param title The title of the Frame
	 */
	public HelpMenu(String title)
	{
		//set the title of the help menu
		super(title);
		
		//set layout
		setLayout(new BorderLayout());
				
		//set the location of the help menu to the centre of the screen
		setLocation(super.getX()+super.getWidth()/4, super.getY()+super.getHeight()/4);
		setSize(super.getWidth()/2, super.getHeight()/2);
	
		//construct the GUI
		makeGUI();
		
		setVisible(true);
	}
	
	/**
	 * The makeGUI class creates the title, text area and close button 
	 * for the help menu pop up window
	 */
	public void makeGUI()
	{
		//create the title and set the font
		title = new Label("Frequently Asked Questions", Label.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 18));
		
		//create the close button and register an action listener to dispose of the window
		close = new Button("Close");
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				HelpMenu.this.dispose();
			}
		});
		
		//create the text area and set the scrollbars to vertical only
		text = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		//read the FAQ from file
		readHelpFile();
		
		//display the contents of the FAQ in the TextArea
		for(int i = 0; i<textArray.size(); i++)
		{
			text.append(textArray.get(i)+"\n");
		}	
		
		//add the components to the frame
		add(title, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);
		add(close, BorderLayout.SOUTH);
	}
	
	/**
	 * Reads the FAQ from file and stores them in
	 * an ArrayList<String>
	 */
	
	public void readHelpFile()
	{
		textArray = new ArrayList<String>();
		//read data from file and store in TextField
		try
		{
			file = new File("help.dat");
			Scanner inputFile = new Scanner(file);
			while(inputFile.hasNext())
			{
				textArray.add(inputFile.nextLine());
			}
			inputFile.close();
		}
		catch(FileNotFoundException e)
		{	
			System.out.println(file+" not found");
		}
	}
}
