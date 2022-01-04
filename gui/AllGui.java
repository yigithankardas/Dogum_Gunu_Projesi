package gui;

import javax.swing.*;

import dates.AbstractCalendar;
import fileio.FileHandler;

import java.awt.*;

import java.util.ArrayList; 

public class AllGui {
	
	private FileHandler handler;
	
	private static ArrayList<BottomBirthdayPanel> birthdayPanelList;
	private static JPanel bottomPanel;
	private static JPanel upcomingPanel;
	private static JLabel noUpcomingBirthday;
	
	public AllGui(FileHandler handler) {
		
		this.handler = handler;
		ArrayList<Component> componentList = new ArrayList<>();
		birthdayPanelList = new ArrayList<>();
		
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
		
		noUpcomingBirthday = new JLabel();
		noUpcomingBirthday.setText("Yaklaþan doðumgünleri burada görünür.");
		noUpcomingBirthday.setSize(500, 50);
		noUpcomingBirthday.setLocation(345, 70);
		noUpcomingBirthday.setFont(new Font("SansSerif", Font.ITALIC, 16));
		noUpcomingBirthday.setForeground(new Color(70, 70, 70));
		componentList.add(noUpcomingBirthday);
		
		JLabel searchLabel = new JLabel();
		ImageIcon searchIcon = new ImageIcon(AllGui.class.getResource("/images/Search.png"));
		searchIcon.setImage(searchIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		searchLabel.setSize(25, 22);
		searchLabel.setLocation(2, 0);
		searchLabel.setIcon(searchIcon);
		componentList.add(searchLabel);
		
		JLabel searchLabel2 = new JLabel();
		searchLabel2.setSize(100, 25);
		searchLabel2.setLocation(30, -2);
		searchLabel2.setText("Doðumgünü ara");
		searchLabel2.setFont(new Font("SansSerif", Font.ITALIC, 12));
		searchLabel2.setForeground(Color.gray);
		componentList.add(searchLabel2);
		
		JLabel addLabel = new JLabel();
		addLabel.setText("+");
		addLabel.setFont(new Font("SansSerif", Font.PLAIN, 65));
		addLabel.setForeground(new Color(200, 200, 200));
		addLabel.setSize(40, 40);
		addLabel.setLocation(5, 3);
		componentList.add(addLabel);
		
		JTextField searchField = new JTextField();
		searchField.setSize(846, 25);
		searchField.setLocation(0, 0);
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
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 1, 1));
		bottomPanel.setBackground(new Color(40, 40, 40));
		bottomPanel.addMouseListener(new FocusListenerForPanel(bottomPanel));
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
		
		upcomingPanel = new JPanel();
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
		searchPanel.setSize(846, 22);
		searchPanel.setLocation(70, 229);
		searchPanel.setBackground(Color.black);
		componentList.add(searchPanel);
		
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);
		addPanel.setSize(50, 50);
		addPanel.setLocation(10, 240);
		addPanel.setBackground(new Color(70, 70, 70));
		//addPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		addPanel.addMouseListener(new HighlightPlusForAddPanel(addPanel, handler));
		componentList.add(addPanel);
		
		setQuitListener(componentList, frame);
		
		JScrollPane scroll = new JScrollPane(bottomPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setLocation(69, 251);
		scroll.setSize(848, 535);
		scroll.getVerticalScrollBar().setUnitIncrement(40);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		
		JScrollPane scroll2 = new JScrollPane(upcomingPanel);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setSize(986, 202);
		scroll2.setLocation(0, 27);
		scroll2.getVerticalScrollBar().setUnitIncrement(40);
		scroll2.setBorder(BorderFactory.createEmptyBorder());
		
		frame.setVisible(true);
		settingsPanel.add(settingsLabel);
		topPanel.add(upcomingAnnotationPanel);
		upcomingPanel.add(noUpcomingBirthday);
		upcomingAnnotationPanel.add(upcomingLabel);
		searchPanel.add(searchLabel);
		searchPanel.add(searchLabel2);
		searchPanel.add(searchField);
		topPanel.add(settingsPanel);
		
		leftPanel.add(addPanel);
		addPanel.add(addLabel);
		
		mainPanel.add(scroll2);
		mainPanel.add(searchPanel);
		mainPanel.add(topPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		mainPanel.add(scroll);
		frame.add(mainPanel);
		
		createBirthdayPanels(bottomPanel, birthdayPanelList);
		arrangeBirthdayPanels(handler.getBirthdayList(), birthdayPanelList);
		setUpomingBirthdays(handler, upcomingPanel, noUpcomingBirthday);
		bottomPanel.requestFocus();
	}
	
	private void setQuitListener(ArrayList<Component> list, JFrame frame) {
		for (Component a : list)
			if (a instanceof JPanel)
				a.addKeyListener(new QuitListener(frame));
	}
	
	private void createBirthdayPanels(JPanel bottomPanel, ArrayList<BottomBirthdayPanel> birthdayPanelList) {
		ArrayList<String> list = handler.getBirthdayList();
		for (int i = 0; i < list.size(); i++) {
			BottomBirthdayPanel bbp = new BottomBirthdayPanel();
			bottomPanel.add(bbp);
			birthdayPanelList.add(bbp);
		}
	}
	
	public static void updateBirthdayPanels(FileHandler handler) {
		ArrayList<String> list = handler.getBirthdayList();
		birthdayPanelList.clear();
		bottomPanel.removeAll();
		for (int i = 0; i < list.size(); i++) {
			BottomBirthdayPanel bbp = new BottomBirthdayPanel();
			bottomPanel.add(bbp);
			birthdayPanelList.add(bbp);
		}
		arrangeBirthdayPanels(handler.getBirthdayList(), birthdayPanelList);
		setUpomingBirthdays(handler, upcomingPanel, noUpcomingBirthday);
	}
	
	private static void arrangeBirthdayPanels(ArrayList<String> birthdayList, ArrayList<BottomBirthdayPanel> birthdayPanelList) {
		for (int i = 0; i < birthdayPanelList.size(); i++) {
			BottomBirthdayPanel currentPanel = birthdayPanelList.get(i);
			currentPanel.setVisible(false);
			String currentBirthday = birthdayList.get(i);
			String name = currentBirthday.substring(0, currentBirthday.indexOf("=") - 1);
			String date = currentBirthday.substring(currentBirthday.indexOf("=") + 3);
			Font font = new Font("SansSerif", Font.PLAIN, 25);
			
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			nameLabel.setBounds(50, 5, 200, 75);
			
			JLabel dateLabel = new JLabel();
			dateLabel.setText(date);
			dateLabel.setFont(font);
			dateLabel.setForeground(Color.white);
			dateLabel.setBounds(300, 5, 300, 75);
			
			currentPanel.add(nameLabel);
			currentPanel.add(dateLabel);
			currentPanel.setVisible(true);
		}
	}
	
	private static void setUpomingBirthdays(FileHandler handler, JPanel upcomingPanel, JLabel noUpcomingBirthday) {
		JLabel label = null;
		for (int i = 0; i < upcomingPanel.getComponentCount(); i++) {
			if (upcomingPanel.getComponent(i) instanceof JLabel)
				label = (JLabel)upcomingPanel.getComponent(i);
		}
		upcomingPanel.setVisible(false);
		upcomingPanel.removeAll();
		ArrayList<String> list = handler.find(AbstractCalendar.getCurrentDate());
		if (list == null) {
			if (upcomingPanel.getComponentCount() == 0) {
				label.setVisible(true);
				upcomingPanel.add(label);
			}
			upcomingPanel.setVisible(true);
			return;
		}
		int size = list.size();
		if (size != 0) {
			noUpcomingBirthday.setVisible(false);
			upcomingPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 1, 1));
			
			if (size == 1) {
				UpcomingBirthdayPanel panel = new UpcomingBirthdayPanel();
				String date = list.get(0);
				
				JLabel nameLabel = new JLabel();
				nameLabel.setText(date.substring(0, date.indexOf("=") - 1));
				nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 35));
				nameLabel.setForeground(Color.white);
				nameLabel.setBounds(50, 5, 200, 75);
				
				JLabel dateLabel = new JLabel();
				dateLabel.setText(date.substring(date.indexOf("=") + 3));
				dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 35));
				dateLabel.setForeground(Color.white);
				dateLabel.setBounds(300, 5, 300, 75);
				
				panel.add(dateLabel);
				panel.add(nameLabel);
				upcomingPanel.add(panel);
			}
			else {
				for (String s : list) {
					UpcomingBirthdayPanel panel = new UpcomingBirthdayPanel();
					panel.setPreferredSize(new Dimension(980, 105));
					
					JLabel nameLabel = new JLabel();
					nameLabel.setText(s.substring(0, s.indexOf("=") - 1));
					nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
					nameLabel.setForeground(Color.white);
					nameLabel.setBounds(50, 5, 200, 75);
					
					JLabel dateLabel = new JLabel();
					dateLabel.setText(s.substring(s.indexOf("=") + 3));
					dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
					dateLabel.setForeground(Color.white);
					dateLabel.setBounds(300, 5, 300, 75);
					
					panel.add(dateLabel);
					panel.add(nameLabel);
					upcomingPanel.add(panel);
				}
			}
		}
		else {
			upcomingPanel.setLayout(null);
			noUpcomingBirthday.setVisible(true);
		}
		
		upcomingPanel.setVisible(true);
	}
}