package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fileio.FileHandler;

public class HighlightPlusForAddPanel extends HighlightListener {
	
	private JFrame frame;
	public static String[] thirtys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
	public static String[] thirtyOnes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public static String[] february29 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
	public static String[] february28 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
	public static String[] monthArray = {"Ocak", "Þubat", "Mart", "Nisan", "Mayýs", "Haziran", "Temmuz", "Aðustos", "Eylül", "Ekim", "Kasým", "Aralýk"};
	private FileHandler handler;
	private GUI gui;

	public HighlightPlusForAddPanel(JPanel panel, FileHandler handler, GUI gui) {
		super(panel);
		this.handler = handler;
		this.gui = gui;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		frame = new JFrame();
		frame.setBounds(500, 300, 450, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(50, 50, 50));
		frame.add(mainPanel);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Ýsim:");
		nameLabel.setBounds(20, 15, 100, 25);
		nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		
		JLabel dateLabel = new JLabel();
		dateLabel.setText("Tarih:");
		dateLabel.setBounds(20, 55, 100, 25);
		dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		dateLabel.setForeground(Color.white);
		
		JTextField name = new JTextField();
		name.setBounds(100, 15, 250, 23);
		name.setForeground(Color.white);
		name.setBackground(Color.black);
		name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		name.setCaretColor(Color.gray);
		name.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		JComboBox<String> days = new JComboBox<>(thirtyOnes);
		days.setBounds(100, 55, 100, 25);
		JComboBox<String> months = new JComboBox<>(monthArray);
		months.setBounds(205, 55, 100, 25);
		months.addItemListener(new ItemListenerForComboBox(mainPanel, days, months));
		
		JButton button = new JButton();
		button.setText("Ekle");
		button.setBounds(165, 150, 100, 30);
		button.setFont(new Font("SansSerif", Font.PLAIN, 15));
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {
				String birthday = (String)days.getSelectedItem() + " " + (String)months.getSelectedItem();
				if (! name.getText().equals("")) {
					handler.add(name.getText(), birthday);
					gui.updateBirthdayPanels(handler);
					frame.dispose();
					mouseClicked(e);
				}
			}	
		});
		
		mainPanel.add(name);
		mainPanel.add(nameLabel);
		mainPanel.add(dateLabel);
		mainPanel.add(days);
		mainPanel.add(months);
		mainPanel.add(button);
	}
}