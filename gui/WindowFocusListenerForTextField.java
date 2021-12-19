package gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowFocusListenerForTextField implements FocusListener {

	private JTextField textField;
	private JLabel label1;
	private JLabel label2;
	
	public WindowFocusListenerForTextField(JTextField textField, JLabel label1, JLabel label2) {
		this.textField = textField;
		this.label1 = label1;
		this.label2 = label2;
	}

	@Override
	public void focusGained(FocusEvent e) {
		textField.setOpaque(true);
		label1.setVisible(false);
		label2.setVisible(false);
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (textField.getText().equals("")) {
			textField.setOpaque(false);
			label1.setVisible(true);
			label2.setVisible(true);
			textField.setText("");
		}
	}
}