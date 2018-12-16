package map;

import java.awt.Graphics;
import java.awt.Image;

import civ.Civilization;
import unit.Unit;

public abstract class Terrain {

	private double ATTACKBOOST;
	private double DEFBOOST;
	
	private boolean hasUnit;
	private boolean hasBuilding;
	private boolean isHidden;
	
	private int resource;
	
	private Civilization civ;
	
	private Unit unit;
	
	private Image img;
	private Image depImg;
	private Image fullImg;
	
	public Terrain (Image img, Image depImg, Image fullImg) {
		this.img = img;
		this.depImg = depImg;
		this.fullImg = fullImg;
	}
	
	public abstract void changeCiv (Civilization nCiv);
	
	public abstract void draw (Graphics g, int x, int y);
	
	public abstract int applyAttackBuff (int cAttack);
	public abstract int applyDefenseBuff (int cDefense);
	
	public abstract void useResource ();
	
	public abstract boolean hasUnit ();
	public abstract boolean hasBuilding ();
	public abstract boolean isHidden ();
	public abstract boolean hasResource ();
	
}
