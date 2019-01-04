package main;

import java.awt.*;
import javax.swing.*;

import map.FieldView;
import map.Map;

import java.awt.event.*;

public class Main extends JPanel implements KeyListener, MouseListener {

	Map map;
	FieldView playerView;

	boolean inPlayerView;
	
	public Main () {
		System.out.println("Generating Map...");
		map = new Map();
		System.out.println("Done Generating Map!");
		System.out.println("Spawning Players...");
		playerView = new FieldView(map, 10, 10);
		System.out.println("Done Spawning Players!");
		inPlayerView = false;
		repaint();
	}

	public void keyPressed (KeyEvent e) {
		if (inPlayerView) {
			// Player Interaction Events
		} else {
			// Map Interaction Events
		}
	}

	public void keyReleased (KeyEvent e) {

	}

	public void keyTyped (KeyEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void paintComponent (Graphics g) {
		if (!inPlayerView) {
			map.drawMap(g);
		} else {
			playerView.draw(g);
		}
	}

	// Method to add delays for smoother animations
	public void delay(int mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			System.out.println("ERROR IN SLEEPING");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Main");
		frame.getContentPane().add(new Main());
		frame.setSize(1000, 1000);
		// frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
