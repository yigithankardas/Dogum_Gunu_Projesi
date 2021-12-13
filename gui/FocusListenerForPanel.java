package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FocusListenerForPanel implements MouseListener {
	
	private JPanel panel;
	
	public FocusListenerForPanel(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		panel.requestFocus();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.requestFocus();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panel.requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		panel.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		panel.requestFocus();
	}
}