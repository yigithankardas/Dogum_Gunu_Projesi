package gui;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ItemListenerForComboBox implements ItemListener {
	
	private JComboBox<String> days;
	private JComboBox<String> months;
	private JPanel panel;
	private Rectangle bounds;
	
	public ItemListenerForComboBox(JPanel panel, JComboBox<String> days, JComboBox<String> months) {
		this.panel = panel;
		this.days = days;
		this.months = months;
		bounds = days.getBounds();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String month = (String)months.getSelectedItem();
		int day = Integer.parseInt((String)days.getSelectedItem());
		days.setVisible(false);
		
		if (month.equals("Ocak")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("�ubat") ) {
			days = new JComboBox<>(HighlightPlusForAddPanel.february29);
			if (day > 29)
				days.setSelectedItem("29");
			else
				days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Mart")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Nisan") ) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtys);
			if (day > 30)
				days.setSelectedItem("30");
			else
				days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("May�s")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Haziran")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtys);
			if (day > 30)
				days.setSelectedItem("30");
			else
				days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Temmuz")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("A�ustos")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Eyl�l")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtys);
			if (day > 30)
				days.setSelectedItem("30");
			else
				days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Ekim")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		else if (month.equals("Kas�m")) {
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtys);
			if (day > 30)
				days.setSelectedItem("30");
			else
				days.setSelectedItem(Integer.toString(day));
		}
		else {		// Aral�k
			days = new JComboBox<>(HighlightPlusForAddPanel.thirtyOnes);
			days.setSelectedItem(Integer.toString(day));
		}
		
		days.setBounds(bounds);
		days.setVisible(true);
		panel.add(days);
	}
}