package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class FocusListenerForTextField implements MouseListener {
	
	private JTextField textField;
	
	public FocusListenerForTextField(JTextField textField) {
		this.textField = textField;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		textField.requestFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}