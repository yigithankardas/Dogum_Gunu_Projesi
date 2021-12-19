package gui;

import javax.swing.*;

import fileio.FileHandler;

import java.awt.*;

import java.util.ArrayList; 

public class AllGui {
	
	private FileHandler handler;
	
	public AllGui(FileHandler handler) {
		
		this.handler = handler;
		ArrayList<Component> componentList = new ArrayList<>();
		
		JLabel settingsLabel = new JLabel();
		settingsLabel.setText("Ayarlar");
		settingsLabel.setSize(70, 24);
		settingsLabel.setLocation(10, -1);
		settingsLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		settingsLabel.setForeground(new Color(220, 220, 220));
		componentList.add(settingsLabel);
		
		JLabel upcomingLabel = new JLabel();
		upcomingLabel.setText("YAKLAÞAN DOÐUMGÜNÜ");
		upcomingLabel.setSize(240, 24);
		upcomingLabel.setLocation(4, 0);
		upcomingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		upcomingLabel.setForeground(new Color(220, 220, 220));
		componentList.add(upcomingLabel);
		
		JLabel noUpcomingBirthday = new JLabel();
		noUpcomingBirthday.setText("Yaklaþan doðumgünleri burada görünür.");
		noUpcomingBirthday.setSize(500, 50);
		noUpcomingBirthday.setLocation(345, 65);
		noUpcomingBirthday.setFont(new Font("SansSerif", Font.ITALIC, 16));
		noUpcomingBirthday.setForeground(new Color(70, 70, 70));
		componentList.add(noUpcomingBirthday);
		
		JLabel searchLabel = new JLabel();
		ImageIcon searchIcon = new ImageIcon(AllGui.class.getResource("/images/Search.png"));
		searchIcon.setImage(searchIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		searchLabel.setSize(25, 25);
		searchLabel.setLocation(2, 0);
		searchLabel.setIcon(searchIcon);
		componentList.add(searchLabel);
		
		JLabel searchLabel2 = new JLabel();
		searchLabel2.setSize(100, 25);
		searchLabel2.setLocation(30, -1);
		searchLabel2.setText("Doðumgünü ara");
		searchLabel2.setFont(new Font("SansSerif", Font.ITALIC, 12));
		searchLabel2.setForeground(Color.gray);
		componentList.add(searchLabel2);
		
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
		componentList.add(searchField);
		
		JFrame frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(1000, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		componentList.add(frame);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		componentList.add(mainPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 1, 1));
		//bottomPanel.setSize(847, 531);
		//bottomPanel.setLocation(70, 252);
		bottomPanel.setBackground(new Color(40, 40, 40));
		bottomPanel.addMouseListener(new FocusListenerForPanel(bottomPanel));
		//bottomPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		componentList.add(bottomPanel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setSize(985, 25);
		topPanel.setLocation(1, 2);
		topPanel.setBackground(new Color(80, 80, 80));
		componentList.add(topPanel);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setSize(70, 24);
		settingsPanel.setLayout(null);
		settingsPanel.setLocation(915, 0);
		settingsPanel.setBackground(new Color(100, 100, 100));
		settingsPanel.addMouseListener(new SettingsListener(settingsPanel));
		componentList.add(settingsPanel);
		
		JPanel upcomingPanel = new JPanel();
		upcomingPanel.setSize(986, 200);
		upcomingPanel.setLocation(0, 27);
		upcomingPanel.setLayout(null);
		upcomingPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		upcomingPanel.setBackground(new Color(35, 35, 35));
		componentList.add(upcomingPanel);
		
		JPanel upcomingAnnotationPanel = new JPanel();
		upcomingAnnotationPanel.setLayout(null);
		upcomingAnnotationPanel.setLocation(365, 0);
		upcomingAnnotationPanel.setSize(240, 24);
		upcomingAnnotationPanel.setBackground(Color.blue);
		componentList.add(upcomingAnnotationPanel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setSize(70, 558);
		leftPanel.setLocation(0, 225);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		leftPanel.setBackground(new Color(50, 50, 50));
		componentList.add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setSize(70, 558);
		rightPanel.setLocation(916, 225);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		rightPanel.setBackground(new Color(50, 50, 50));
		componentList.add(rightPanel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setSize(846, 25);
		searchPanel.setLocation(70, 227);
		searchPanel.setBackground(Color.black);
		componentList.add(searchPanel);
		
		setQuitListener(componentList, frame);
		
		JScrollPane scroll = new JScrollPane(bottomPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setLocation(69, 250);
		scroll.setSize(849, 535);
		//scroll.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		
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
		mainPanel.add(scroll);
		frame.add(mainPanel);
		
		createBirthdayPanels(bottomPanel);
		bottomPanel.requestFocus();
	}
	
	private void setQuitListener(ArrayList<Component> list, JFrame frame) {
		for (Component a : list)
			if (a instanceof JPanel)
				a.addKeyListener(new QuitListener(frame));
	}
	
	private void createBirthdayPanels(JPanel bottomPanel) {
		ArrayList<String> list = handler.getBirthdayList();
		for (int i = 0; i < list.size(); i++) {
			BottomBirthdayPanel bbp = new BottomBirthdayPanel();
			bottomPanel.add(bbp);
		}
	}
}