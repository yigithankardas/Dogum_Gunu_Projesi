package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsListener implements MouseListener {
	
	private JPanel panel;
	private Color currentBg;
	private Color newBg;
	
	public SettingsListener(JPanel panel) {
		this.panel = panel;
		this.currentBg = panel.getBackground();
		newBg = new Color(140, 140, 140);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JFrame settingsFrame = new JFrame();
		settingsFrame.setLocation(960, 65);
		settingsFrame.setSize(300, 500);
		settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settingsFrame.setResizable(false);
		settingsFrame.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(newBg);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		panel.setBackground(currentBg);
	}
}