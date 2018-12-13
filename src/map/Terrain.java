package map;

import java.awt.Graphics;
import java.awt.Image;

import civ.Civilization;

public abstract class Terrain {

	private double ATTACKBOOST;
	private double DEFBOOST;
	
	private boolean hasUnit;
	private boolean hasBuilding;
	private boolean hasResource;
	
	private Civilization civ;
	
	private Image img;
	
	public Terrain (Image img) {
		this.img = img;
	}
	
	public abstract void changeCiv (Civilization nCiv);
	
	public abstract void draw (Graphics g);
	
	public abstract int applyAttackBuff (int cAttack);
	public abstract int applyDefenseBuff (int cDefense);
	
	public abstract boolean hasUnit ();
	public abstract boolean hasBuilding ();
	public abstract boolean hasResource ();
	
}
