package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class HighlightListener implements MouseListener {
	
	private JPanel panel;
	private Color color;
	private Color newColor;
	private Color click;
	
	public HighlightListener(JPanel panel) {
		this.panel = panel;
		color = panel.getBackground();
		newColor = new Color(120, 120, 120);
		click = new Color(80, 80, 80);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.setBackground(click);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panel.setBackground(newColor);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(newColor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		panel.setBackground(color);
	}
}