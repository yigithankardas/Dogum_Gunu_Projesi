package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		this.setLocation(262, 9);
		this.setSize(new Dimension(1000, 800));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		MainPanel mainPanel = new MainPanel();
		this.add(mainPanel);
	}
}