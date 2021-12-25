package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UpcomingBirthdayPanel extends JPanel {
	
	public UpcomingBirthdayPanel() {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(980, 195));
		this.setBackground(new Color(35, 35, 35));
		this.setBorder(BorderFactory.createLineBorder(Color.red, 1));
	}
}