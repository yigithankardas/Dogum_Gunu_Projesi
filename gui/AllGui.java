package gui;

import javax.swing.*;
import java.awt.*;


public class AllGui {

	public AllGui() {
		JLabel settingsButtonLabel = new JLabel();
		java.net.URL settingsImageURL = AllGui.class.getResource("/images/Settings.png");
		ImageIcon settingsImageIcon = new ImageIcon(settingsImageURL);
		settingsImageIcon.setImage(settingsImageIcon.getImage().getScaledInstance(26, 22, Image.SCALE_AREA_AVERAGING));
		settingsButtonLabel.setIcon(settingsImageIcon);
		
		JFrame frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(new Dimension(1000, 820));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(40, 40, 40));
		frame.add(mainPanel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setSize(985, 25);
		topPanel.setLocation(1, 2);
		topPanel.setBackground(new Color(80, 80, 80));
		mainPanel.add(topPanel);
		
		JPanel settingsButtonPanel = new JPanel();
		settingsButtonPanel.setSize(28, 27);
		settingsButtonPanel.setLocation(956, -4);
		settingsButtonPanel.setBackground(new Color(80, 80, 80));
		topPanel.add(settingsButtonPanel);
		settingsButtonPanel.add(settingsButtonLabel);
	}
}