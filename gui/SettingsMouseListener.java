package gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SettingsMouseListener implements MouseListener {
	
	private JLabel label;
	private java.net.URL newURL;
	private ImageIcon newImage;
	private ImageIcon current;
	
	public SettingsMouseListener(JLabel label, ImageIcon icon) {
		this.label = label;
		current = icon;
		this.newURL = AllGui.class.getResource("/images/SettingsHighlighted.png");
		this.newImage = new ImageIcon(newURL);
		this.newImage.setImage(newImage.getImage().getScaledInstance(24, 22, Image.SCALE_AREA_AVERAGING));
		try {
			Thread.sleep(30);
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException in \"SettingsMouseListener\" class.");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setIcon(newImage);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setIcon(current);
	}
}