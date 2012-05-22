import java.awt.*;
import java.awt.event.*;

/**
 * The CenteredFrame class creates a top level window
 * and centres it in the middle of the screen
 * regardless of the size of the screen
 * @author mshirlaw
 */

public class CenteredFrame extends Frame
{
	private int screenHeight;
	private int screenWidth;
	
	/**Constructor builds a window centred 
	 * in the middle of the screen.
	 * @param title The title of the frame
	 */
	
	public CenteredFrame(String title)
	{
		//call the super class constructor to set the window title and colour
		super(title);
		setBackground(new Color(240,255,255));
		setForeground(Color.BLACK);
		
		//work out the size of the screen that the window is to be displayed on
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = d.height;
		screenWidth = d.width;
		setSize(screenWidth/2, screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		
		//window listener so that the window is disposed when the user clicks close
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				CenteredFrame.this.dispose();
					}
			});	
		}	
			
	/*			
		//Used for debugging
		//@param args Command line argument (not used)

		public static void main(String[] args) 
		{
			CenteredFrame frame = new CenteredFrame("iPad Frame");
			frame.setVisible(true);
		}
	 */	

}

