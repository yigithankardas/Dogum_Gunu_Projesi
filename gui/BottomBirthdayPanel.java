package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BottomBirthdayPanel extends JPanel {
	
	public BottomBirthdayPanel() {
		super();
		this.setPreferredSize(new Dimension(840, 100));
		this.setBackground(new Color(40, 40, 40));
		this.setBorder(BorderFactory.createLineBorder(Color.red, 1));
	}
}