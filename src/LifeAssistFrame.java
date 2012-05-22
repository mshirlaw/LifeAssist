import java.awt.*;
import java.awt.event.*;

/**
 * The LifeAssist class is the main class of the text-to-speech 
 * application. It combines the TitlePanel, CentrePanel and ButtonsPanel
 * using a BorderLayout. 
 * @author mshirlaw
 */

public class LifeAssistFrame extends CenteredFrame
{
	/**
	 * Constructor sets the title of the frame by calling the 
	 * superclass constructor and then constructs the main GUI
	 */
	
	public LifeAssistFrame(String title)
	{
		super(title);
		makeGUI(this);
	}
	
	/**
	 * the makeGUI method creates the main GUI by adding elements to 
	 * a frame. 
	 * @param f The main frame which is used to display the GUI
	 */
	
	public void makeGUI(Frame f)
	{
		//set the overall layout of the Frame
		f.setLayout(new BorderLayout());
		
		//create an instance of the main title and add it to the frame
		TitlePanel titlePanel = new TitlePanel();
		f.add(titlePanel, BorderLayout.NORTH);
		
		//create an instance of the centre panel and add it to this frame
		MainPanel main = new MainPanel();
		f.add(main, BorderLayout.CENTER);
		
		
	}
	
	/**
	 * The main method is used to create an instance of the LifeAssistFrame and display it.
	 * @param args Command line argument (not used)
	 */
	
	public static void main(String[] args)
	{
		LifeAssistFrame lifeAssist = new LifeAssistFrame("LifeAssist");
		lifeAssist.setVisible(true);
	}
}
