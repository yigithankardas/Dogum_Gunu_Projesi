package gui;

import javax.swing.*;
import java.awt.*;

public class AllGui {
	
	public AllGui() {
		
		JLabel settingsLabel = new JLabel();
		settingsLabel.setText("Ayarlar");
		settingsLabel.setSize(70, 24);
		settingsLabel.setLocation(10, -1);
		settingsLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		settingsLabel.setForeground(new Color(220, 220, 220));
		
		JFrame frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(new Dimension(1000, 820));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(40, 40, 40));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setSize(985, 25);
		topPanel.setLocation(1, 2);
		topPanel.setBackground(new Color(80, 80, 80));
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setSize(70, 24);
		settingsPanel.setLayout(null);
		settingsPanel.setLocation(915, 0);
		settingsPanel.setBackground(new Color(100, 100, 100));
		//settingsPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		settingsPanel.addMouseListener(new SettingsListener(settingsPanel));
		
		
		frame.add(mainPanel);
		mainPanel.add(topPanel);
		topPanel.add(settingsPanel);
		settingsPanel.add(settingsLabel);
	}
}