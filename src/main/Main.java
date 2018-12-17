package main;

import java.awt.*;
import javax.swing.*;

import map.Map;

import java.awt.event.*;

public class Main extends JPanel implements KeyListener {
	
	Map map;
	
	public Main () {
		map = new Map();
		System.out.println("Done Generating Map!");
		repaint();
	}

	public void keyPressed (KeyEvent e) {
		
	}

	public void keyReleased (KeyEvent e) {
		
	}

	public void keyTyped (KeyEvent e) {
		
	}
	
	public void paintComponent (Graphics g) {
		map.drawMap(g);
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
