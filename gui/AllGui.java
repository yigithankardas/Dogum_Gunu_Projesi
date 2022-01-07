package gui;

import javax.swing.*;

import dates.AbstractCalendar;
import fileio.FileHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList; 

public class AllGui {
	
	private FileHandler handler;
	private ArrayList<BottomBirthdayPanel> birthdayPanelList;
	
	private JFrame frame;
	
	private JPanel mainPanel;
	private JPanel upcomingPanel;
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel bottomPanel;
	private JPanel searchPanel;
	private JPanel settingsPanel;
	private JPanel upcomingAnnotationPanel;
	private JPanel addPanel;
	
	private JLabel noUpcomingBirthday;
	private JLabel settingsLabel;
	private JLabel upcomingLabel;
	private JLabel searchLabel;
	private JLabel searchLabel2;
	private JLabel addLabel;
	
	private JTextField searchField;
	
	private JScrollPane scroll;
	private JScrollPane scroll2;
	
	public AllGui(FileHandler handler) {
		this.handler = handler;
	}
	
	public AllGui() {}
	
	public void initiate() {
		birthdayPanelList = new ArrayList<>();
		initiateLabels();
		initiateTextFields();
		
		frame = new JFrame();
		frame.setLocation(262, 1);
		frame.setSize(1000, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		initiatePanels();
		initiateScrollPanes();
		addNecessaryComponentsToEachOther();
		
		frame.setVisible(true);
		frame.add(mainPanel);
		createBirthdayPanels();
		arrangeBirthdayPanels();
		setUpomingBirthdays();
		
		bottomPanel.requestFocus();
	}
	
	private void addNecessaryComponentsToEachOther() {
		mainPanel.add(scroll2);
		mainPanel.add(searchPanel);
		mainPanel.add(topPanel);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		mainPanel.add(scroll);
		
		topPanel.add(upcomingAnnotationPanel);
		topPanel.add(settingsPanel);
		
		settingsPanel.add(settingsLabel);
		
		upcomingPanel.add(noUpcomingBirthday);
		
		upcomingAnnotationPanel.add(upcomingLabel);
		
		leftPanel.add(addPanel);
		
		searchPanel.add(searchLabel);
		searchPanel.add(searchLabel2);
		searchPanel.add(searchField);
		
		addPanel.add(addLabel);
	}

	private void initiateLabels() {
		settingsLabel = new JLabel();
		settingsLabel.setText("Ayarlar");
		settingsLabel.setSize(70, 24);
		settingsLabel.setLocation(10, -1);
		settingsLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		settingsLabel.setForeground(new Color(220, 220, 220));
		
		upcomingLabel = new JLabel();
		upcomingLabel.setText("YAKLAÞAN DOÐUMGÜNÜ");
		upcomingLabel.setSize(240, 24);
		upcomingLabel.setLocation(4, 0);
		upcomingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		upcomingLabel.setForeground(new Color(220, 220, 220));
		
		noUpcomingBirthday = new JLabel();
		noUpcomingBirthday.setText("Yaklaþan doðumgünleri burada görünür.");
		noUpcomingBirthday.setSize(500, 50);
		noUpcomingBirthday.setLocation(345, 70);
		noUpcomingBirthday.setFont(new Font("SansSerif", Font.ITALIC, 16));
		noUpcomingBirthday.setForeground(new Color(70, 70, 70));
		
		searchLabel = new JLabel();
		ImageIcon searchIcon = new ImageIcon(AllGui.class.getResource("/images/Search.png"));
		searchIcon.setImage(searchIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		searchLabel.setSize(25, 22);
		searchLabel.setLocation(2, 0);
		searchLabel.setIcon(searchIcon);
		
		searchLabel2 = new JLabel();
		searchLabel2.setSize(100, 25);
		searchLabel2.setLocation(30, -2);
		searchLabel2.setText("Doðumgünü ara");
		searchLabel2.setFont(new Font("SansSerif", Font.ITALIC, 12));
		searchLabel2.setForeground(Color.gray);
		
		addLabel = new JLabel();
		addLabel.setText("+");
		addLabel.setFont(new Font("SansSerif", Font.PLAIN, 65));
		addLabel.setForeground(new Color(200, 200, 200));
		addLabel.setSize(40, 40);
		addLabel.setLocation(5, 3);
	}
	
	private void initiateTextFields() {
		searchField = new JTextField();
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
	}
	
	private void initiatePanels() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 1, 1));
		bottomPanel.setBackground(new Color(40, 40, 40));
		bottomPanel.addMouseListener(new FocusListenerForPanel(bottomPanel));
		
		topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setSize(985, 25);
		topPanel.setLocation(1, 2);
		topPanel.setBackground(new Color(80, 80, 80));
		
		settingsPanel = new JPanel();
		settingsPanel.setSize(70, 24);
		settingsPanel.setLayout(null);
		settingsPanel.setLocation(915, 0);
		settingsPanel.setBackground(new Color(100, 100, 100));
		settingsPanel.addMouseListener(new SettingsListener(settingsPanel));
		
		upcomingPanel = new JPanel();
		upcomingPanel.setLayout(null);
		upcomingPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		upcomingPanel.setBackground(new Color(35, 35, 35));
		
		upcomingAnnotationPanel = new JPanel();
		upcomingAnnotationPanel.setLayout(null);
		upcomingAnnotationPanel.setLocation(365, 0);
		upcomingAnnotationPanel.setSize(240, 24);
		upcomingAnnotationPanel.setBackground(Color.blue);
		
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setSize(70, 558);
		leftPanel.setLocation(0, 225);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		leftPanel.setBackground(new Color(50, 50, 50));
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setSize(70, 558);
		rightPanel.setLocation(916, 225);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		rightPanel.setBackground(new Color(50, 50, 50));
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setSize(846, 22);
		searchPanel.setLocation(70, 229);
		searchPanel.setBackground(Color.black);
		
		addPanel = new JPanel();
		addPanel.setLayout(null);
		addPanel.setSize(50, 50);
		addPanel.setLocation(10, 240);
		addPanel.setBackground(new Color(70, 70, 70));
		addPanel.addMouseListener(new HighlightPlusForAddPanel(addPanel, handler, this));
	}
	
	private void initiateScrollPanes() {
		scroll = new JScrollPane(bottomPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setLocation(69, 251);
		scroll.setSize(848, 535);
		scroll.getVerticalScrollBar().setUnitIncrement(40);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		
		scroll2 = new JScrollPane(upcomingPanel);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setSize(986, 202);
		scroll2.setLocation(0, 27);
		scroll2.getVerticalScrollBar().setUnitIncrement(40);
		scroll2.setBorder(BorderFactory.createEmptyBorder());
	}
	
	private void createBirthdayPanels() {
		ArrayList<String> list = handler.getBirthdayList();
		for (int i = 0; i < list.size(); i++) {
			BottomBirthdayPanel bbp = new BottomBirthdayPanel();
			bottomPanel.add(bbp);
			birthdayPanelList.add(bbp);
		}
	}
	
	public void updateBirthdayPanels(FileHandler handler) {
		ArrayList<String> list = handler.getBirthdayList();
		birthdayPanelList.clear();
		bottomPanel.setVisible(false);
		bottomPanel.removeAll();
		for (int i = 0; i < list.size(); i++) {
			BottomBirthdayPanel bbp = new BottomBirthdayPanel();
			bottomPanel.add(bbp);
			birthdayPanelList.add(bbp);
		}
		bottomPanel.setVisible(true);
		arrangeBirthdayPanels();
		setUpomingBirthdays();
	}
	
	private void arrangeBirthdayPanels() {
		ArrayList<String> birthdayList = handler.getBirthdayList();
		for (int i = 0; i < birthdayPanelList.size(); i++) {
			BottomBirthdayPanel currentPanel = birthdayPanelList.get(i);
			currentPanel.setVisible(false);
			String currentBirthday = birthdayList.get(i);
			String date = currentBirthday.substring(0, currentBirthday.indexOf("=") - 1);
			String name = currentBirthday.substring(currentBirthday.indexOf("=") + 4);
			Font font = new Font("SansSerif", Font.PLAIN, 25);
			
			JLabel nameLabel = new JLabel();
			nameLabel.setText(name);
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.white);
			nameLabel.setBounds(300, 5, 300, 75);
			
			JLabel dateLabel = new JLabel();
			dateLabel.setText(date);
			dateLabel.setFont(font);
			dateLabel.setForeground(Color.white);
			dateLabel.setBounds(50, 5, 200, 75);
			
			JLabel deleteLabel = new JLabel();
			deleteLabel.setText("X");
			deleteLabel.setForeground(Color.white);
			deleteLabel.setBounds(5, 2, 15, 15);
			deleteLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
			
			JPanel deletePanel = new JPanel();
			deletePanel.setLayout(null);
			deletePanel.setBounds(750, 50, 20, 20);
			deletePanel.setBackground(new Color(60, 60, 60));
			deletePanel.addMouseListener(new MouseListener() {
				private Color color1 = new Color(60, 60, 60);
				private Color color2 = new Color(80, 80, 80);
				private Color color3 = new Color(120, 120, 120);
				@Override
				public void mouseClicked(MouseEvent e) {
					int answer = JOptionPane.showConfirmDialog(null, "Silme iþlemini onaylýyor musunuz?", null, JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						handler.remove(name);
						updateBirthdayPanels(handler);
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					deletePanel.setBackground(color2);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					deletePanel.setBackground(color3);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					deletePanel.setBackground(color3);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					deletePanel.setBackground(color1);
				}
			});
			deletePanel.add(deleteLabel);
			
			currentPanel.add(nameLabel);
			currentPanel.add(dateLabel);
			currentPanel.add(deletePanel);
			currentPanel.setVisible(true);
		}
	}
	
	public FileHandler getHandler() {
		return handler;
	}

	public ArrayList<BottomBirthdayPanel> getBirthdayPanelList() {
		return birthdayPanelList;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JPanel getUpcomingPanel() {
		return upcomingPanel;
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public JPanel getBottomPanel() {
		return bottomPanel;
	}

	public JPanel getSearchPanel() {
		return searchPanel;
	}

	public JPanel getSettingsPanel() {
		return settingsPanel;
	}

	public JPanel getUpcomingAnnotationPanel() {
		return upcomingAnnotationPanel;
	}

	public JPanel getAddPanel() {
		return addPanel;
	}

	public JLabel getNoUpcomingBirthday() {
		return noUpcomingBirthday;
	}

	public JLabel getSettingsLabel() {
		return settingsLabel;
	}

	public JLabel getUpcomingLabel() {
		return upcomingLabel;
	}

	public JLabel getSearchLabel() {
		return searchLabel;
	}

	public JLabel getSearchLabel2() {
		return searchLabel2;
	}

	public JLabel getAddLabel() {
		return addLabel;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JScrollPane getScroll2() {
		return scroll2;
	}

	private void setUpomingBirthdays() {
		upcomingPanel.setVisible(false);
		upcomingPanel.removeAll();
		ArrayList<String> list = handler.find(AbstractCalendar.getCurrentDate());
		if (list == null) {
			upcomingPanel.setLayout(null);
			if (upcomingPanel.getComponentCount() == 0)
				upcomingPanel.add(noUpcomingBirthday);
			noUpcomingBirthday.setLocation(345, 70);
			upcomingPanel.setVisible(true);
			noUpcomingBirthday.setVisible(true);
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
	
	public static void firstTime() {
		JFrame frame = new JFrame();
		frame.setBounds(500, 300, 450, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 50, 50));
		panel.setLayout(new BorderLayout(10, 30));
		frame.add(panel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(new Color(50, 50, 50));
		
		JPanel label1Panel = new JPanel();
		label1Panel.setLayout(new FlowLayout());
		label1Panel.setBackground(new Color(50, 50, 50));
		
		JPanel label2Panel = new JPanel();
		label2Panel.setLayout(new FlowLayout());
		label2Panel.setBackground(new Color(50, 50, 50));
		
		JLabel label1 = new JLabel();
		label1.setText(System.getenv("USERPROFILE") + "/DogumGunleri.txt");
		label1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		label1.setForeground(Color.white);
		
		JLabel label2 = new JLabel();
		label2.setText("Veriler bu konumunda depolanacaktýr.");
		label2.setFont(new Font("SansSerif", Font.PLAIN, 23));
		label2.setForeground(new Color(180, 180, 180));
		
		JButton button = new JButton();
		button.setText("Tamam");
		button.setPreferredSize(new Dimension(110, 25));
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		label1Panel.add(label1);
		panel.add(label1Panel, BorderLayout.NORTH);
		label2Panel.add(label2);
		panel.add(label2Panel, BorderLayout.CENTER);
		buttonPanel.add(button);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(frame.getWidth() + 1, frame.getHeight());
	}
}