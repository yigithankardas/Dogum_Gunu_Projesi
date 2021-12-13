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
		
		JLabel upcomingLabel = new JLabel();
		upcomingLabel.setText("YAKLA�AN DO�UMG�N�");
		upcomingLabel.setSize(240, 24);
		upcomingLabel.setLocation(4, 0);
		upcomingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		upcomingLabel.setForeground(new Color(220, 220, 220));
		
		JLabel noUpcomingBirthday = new JLabel();
		noUpcomingBirthday.setText("Yakla�an do�umg�nleri burada g�r�n�r.");
		noUpcomingBirthday.setSize(500, 50);
		noUpcomingBirthday.setLocation(345, 65);
		noUpcomingBirthday.setFont(new Font("SansSerif", Font.ITALIC, 16));
		noUpcomingBirthday.setForeground(new Color(50, 50, 50));
		
		JFrame frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(1000, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(40, 40, 40));
		mainPanel.addKeyListener(new QuitListener(frame));
		mainPanel.addMouseListener(new FocusListener(mainPanel));
		
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
		settingsPanel.addMouseListener(new SettingsListener(settingsPanel));
		
		JPanel upcomingPanel = new JPanel();
		upcomingPanel.setSize(986, 200);
		upcomingPanel.setLocation(0, 27);
		upcomingPanel.setLayout(null);
		upcomingPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		upcomingPanel.setBackground(new Color(35, 35, 35));
		
		JPanel upcomingAnnotationPanel = new JPanel();
		upcomingAnnotationPanel.setLayout(null);
		upcomingAnnotationPanel.setLocation(365, 0);
		upcomingAnnotationPanel.setSize(240, 24);
		upcomingAnnotationPanel.setBackground(Color.blue);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setSize(70, 558);
		leftPanel.setLocation(0, 225);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		leftPanel.setBackground(new Color(50, 50, 50));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setSize(70, 558);
		rightPanel.setLocation(916, 225);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		rightPanel.setBackground(new Color(50, 50, 50));
		
		
		frame.setVisible(true);
		settingsPanel.add(settingsLabel);
		topPanel.add(upcomingAnnotationPanel);
		upcomingPanel.add(noUpcomingBirthday);
		upcomingAnnotationPanel.add(upcomingLabel);
		topPanel.add(settingsPanel);
		mainPanel.add(upcomingPanel);
		mainPanel.add(topPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		frame.add(mainPanel);
		
		mainPanel.requestFocus();
	}
}