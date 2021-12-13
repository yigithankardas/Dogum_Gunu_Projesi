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
		upcomingLabel.setText("YAKLAÞAN DOÐUMGÜNÜ");
		upcomingLabel.setSize(240, 24);
		upcomingLabel.setLocation(4, 0);
		upcomingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		upcomingLabel.setForeground(new Color(220, 220, 220));
		
		JLabel noUpcomingBirthday = new JLabel();
		noUpcomingBirthday.setText("Yaklaþan doðumgünleri burada görünür.");
		noUpcomingBirthday.setSize(500, 50);
		noUpcomingBirthday.setLocation(345, 65);
		noUpcomingBirthday.setFont(new Font("SansSerif", Font.ITALIC, 16));
		noUpcomingBirthday.setForeground(new Color(70, 70, 70));
		
		JLabel searchLabel = new JLabel();
		ImageIcon searchIcon = new ImageIcon(AllGui.class.getResource("/images/Search.png"));
		searchIcon.setImage(searchIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		searchLabel.setSize(25, 25);
		searchLabel.setLocation(2, 0);
		searchLabel.setIcon(searchIcon);
		
		JLabel searchLabel2 = new JLabel();
		searchLabel2.setSize(100, 25);
		searchLabel2.setLocation(30, -1);
		searchLabel2.setText("Doðumgünü ara");
		searchLabel2.setFont(new Font("SansSerif", Font.ITALIC, 12));
		searchLabel2.setForeground(Color.gray);
		
		JTextField searchField = new JTextField();
		searchField.setSize(846, 25);
		searchField.setLocation(2, 0);
		searchField.setBackground(Color.black);
		searchField.setForeground(Color.white);
		searchField.setCaretColor(Color.white);
		searchField.setBorder(null);
		searchField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		searchField.setOpaque(false);
		searchField.addMouseListener(new FocusListenerForTextField(searchField));
		searchField.addFocusListener(new WindowFocusListenerForTextField(searchField, searchLabel, searchLabel2));
		
		JFrame frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(1000, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(40, 40, 40));
		mainPanel.addKeyListener(new QuitListener(frame));
		mainPanel.addMouseListener(new FocusListenerForPanel(mainPanel));
		
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
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setSize(846, 25);
		searchPanel.setLocation(70, 227);
		//searchPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		searchPanel.setBackground(Color.black);
		
		
		frame.setVisible(true);
		settingsPanel.add(settingsLabel);
		topPanel.add(upcomingAnnotationPanel);
		upcomingPanel.add(noUpcomingBirthday);
		upcomingAnnotationPanel.add(upcomingLabel);
		
		searchPanel.add(searchLabel);
		searchPanel.add(searchLabel2);
		searchPanel.add(searchField);

		topPanel.add(settingsPanel);
		mainPanel.add(upcomingPanel);
		mainPanel.add(searchPanel);
		mainPanel.add(topPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		frame.add(mainPanel);
		
		mainPanel.requestFocus();
	}
}