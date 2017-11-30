package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private int numClick = -1;
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		super("Color Generator");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//create buttons
		JButton changeButton = new JButton("Change");
		JButton resetButton = new JButton("Reset");
		JButton closeButton = new JButton("Close");
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(changeButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(closeButton);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions
		Action changeAction = new Action(1);
		Action resetAction = new Action(2);
		Action closeAction = new Action(3);
		
		//associate actions with buttons
		changeButton.addActionListener(changeAction);
		resetButton.addActionListener(resetAction);
		closeButton.addActionListener(closeAction);	
		
	}
	
	/* An action listener that sets the panel's background color */
	private class Action implements ActionListener
	{
		private int button;
		
		public Action( int click)
		{
			switch (click){
			case 1: button = 1;
			break;
			case 2: button = 0;
			break;
			case 3: button = -1;
			break;
			
			}
			
			
		}
		
		public void actionPerformed(ActionEvent event)
		{
			switch(button) {
			case -1: System.exit(0);
			break;
			case 0: numClick = -1;
			break;
			case 1: numClick++;
			break;
			
			}
			switch(numClick % 4) {
			
			
			case 0: buttonPanel.setBackground(Color.BLACK);
			break;
			case 1: buttonPanel.setBackground(Color.GREEN);
			break;
			case 2: buttonPanel.setBackground(Color.ORANGE);
			break;
			case 3: buttonPanel.setBackground(Color.PINK);
			break;
			
			
			}
			if(button == 0) buttonPanel.setBackground(Color.GRAY);
			
		}
	}
}
