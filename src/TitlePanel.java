import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The TitlePanel class creates a panel to display the title of the 
 * application
 * @author mshirlaw
 */

public class TitlePanel extends Panel
{
	Font font;
	Icon icon; 
	JLabel mainTitle;
	Label helpMenu;
	
	/**
	 * Constructor creates a Labels and adds them to the panel
	 */
	
	public TitlePanel()
	{

		//set the layout for this panel and create a font
		setLayout(new GridLayout(1,2));
		font = new Font("Ariel", Font.BOLD, 12);

		//create the icon for the logo
		icon = new ImageIcon("logo.jpeg");
		
		//create the main title for the application and set the font
		mainTitle = new JLabel();
		mainTitle.setIcon(icon);
		mainTitle.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		mainTitle.setFont(font);
		
		//create help label
		helpMenu = new Label("Help\t", Label.RIGHT);
		helpMenu.setForeground(Color.BLUE);
		helpMenu.setFont(font);
		helpMenu.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				HelpMenu help = new HelpMenu("Help Menu");
			}
		});
	
		add(mainTitle);
		add(helpMenu);
		
	}

}
