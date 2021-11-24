package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		this.setLocation(400, 100);
		this.setSize(new Dimension(800, 500));
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}