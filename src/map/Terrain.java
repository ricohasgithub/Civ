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
	private boolean isSelected;
	
	private int resource;
	
	private Civilization civ;
	
	private Unit unit;
	
	private Image img;
	private Image depImg;
	private Image fullImg;
	private Image selectedImage;
	
	private int N;
	
	public Terrain () {
		
	}
	
	public Terrain (Image img, Image depImg, Image fullImg, Image selectedImage, int N) {
		this.img = img;
		this.depImg = depImg;
		this.fullImg = fullImg;
		this.selectedImage = selectedImage;
		this.N = N;
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
	public abstract boolean isSelected ();
	
}
