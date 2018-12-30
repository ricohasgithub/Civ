package civ;

import java.awt.Image;

import java.util.ArrayList;

public abstract class Civilization {
	
	public String civName;
	public String civNatName;
	public String civCapital;
	
	public Image symbol;
	public Image leader;
	
	private ArrayList<City> citiesList;
	
	public Civilization (String civName, int capX, int capY, Image capImage) {
		// Add capital city to cities list
		citiesList.add(new City(CivDetails.AMERICAN_CAPITALCITYNAME, capX, capY, true, capImage));
	}
	
	public int getCaptialCityX () {
		return citiesList.get(0).getX();
	}
	
	public int getCaptialCityY () {
		return citiesList.get(0).getY();
	}
	
}
