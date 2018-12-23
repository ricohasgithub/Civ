package civ;

import java.awt.Image;

import java.util.ArrayList;

public abstract class Civilization {
	
	public String civ;
	
	public Image symbol;
	public Image leader;
	
	private ArrayList<City> citiesList;
	
	public Civilization () {
		
	}
	
	public int getCaptialCityX () {
		return citiesList.get(0).getX();
	}
	
	public int getCaptialCityY () {
		return citiesList.get(0).getY();
	}
	
}
