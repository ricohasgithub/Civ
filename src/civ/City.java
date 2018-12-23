package civ;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import building.Building;

public class City {
	
	private String name;

	private int x;
	private int y;
	
	private boolean isCapital;
	
	private ArrayList<Building> buildingsList;
	
	private Image image;
	
	public City (String name, int x, int y, boolean isCapital, Image image) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.isCapital = isCapital;
		this.image = image;
		buildingsList = new ArrayList<Building>();
	}
	
	public void addBuilding (Building newBuilding) {
		buildingsList.add(newBuilding);
	}
	
	public void draw (Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
	public String getName () {
		return name;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public boolean isCapital () {
		return isCapital;
	}
	
}
