package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class QuitListener implements KeyListener {
	
	private JFrame frame;
	
	public QuitListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			frame.dispose();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}