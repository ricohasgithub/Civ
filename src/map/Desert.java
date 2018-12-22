package map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import civ.Civilization;
import unit.Unit;

public class Desert extends Terrain {

	private double ATTACKBOOST;
	private double DEFBOOST;

	private boolean hasUnit;
	private boolean hasBuilding;
	private boolean isHidden;
	private boolean isSelected;
	
	private int resources;

	private Unit unit;

	private Civilization civ;

	private Image defaultImg;
	private Image depImg;
	private Image fullImg;

	public Desert () {
		
		super();
		// Initialize resources
		initResourceWHP();
		// Initialize images for default (no resources), depleted resources, and full resources
		try {
			defaultImg = ImageIO.read(new File("images/tDesert.png"));
			depImg = ImageIO.read(new File("images/tDesert.png"));
			fullImg = ImageIO.read(new File("images/tDesert.png"));
		} catch (IOException e) {
			System.out.println("File not found");
		}

		defaultImg = defaultImg.getScaledInstance(5, 5, Image.SCALE_SMOOTH);
		depImg = depImg.getScaledInstance(5, 5, Image.SCALE_SMOOTH);
		fullImg = fullImg.getScaledInstance(5, 5, Image.SCALE_SMOOTH);

	}

	public Desert (Image defaultImg, Image depImg, Image fullImg) {
		super(defaultImg, depImg, fullImg);
		// Initialize resources
		initResourceWHP();
		// Initialize images for default (no resources), depleted resources, and full resources
		this.defaultImg = defaultImg;
		this.depImg = depImg;
		this.fullImg = fullImg;
	}

	// This method initializes the resource level of this tile
	public void initResourceWHP () {
		// Set resources randomly from 0 to 50
		resources = (int) Math.random() * 51;	
	}

	public void useResource () {
		// Decrement resources if there are still resources left
		if (hasResource()) {
			resources--;
		}
	}

	public void changeCiv (Civilization nCiv) {
		// Reassign the civ variable
		civ = nCiv;
	}

	public void draw (Graphics g, int x, int y) {
		// The following if-else block determines what image to draw
		if (resources == 0) {
			g.drawImage(defaultImg, x, y, null);
		} else if (resources < 25) {
			g.drawImage(depImg, x, y, null);
		} else if (resources <= 50) {
			g.drawImage(fullImg, x, y, null);
		}
	}

	public int applyAttackBuff (int cAttack) {
		return (int) ((cAttack * ATTACKBOOST) + cAttack);
	}

	public int applyDefenseBuff (int cDefense) {
		return (int) ((cDefense * DEFBOOST) + cDefense);
	}

	public boolean hasUnit () {
		return hasUnit;
	}

	public boolean hasBuilding () {
		return hasBuilding;
	}

	public boolean isHidden () {
		return isHidden;
	}

	public boolean hasResource () {
		// Return if there are resources left
		return (resources > 0);
	}
	
	public boolean isSelected () {
		return isSelected;
	}

}
