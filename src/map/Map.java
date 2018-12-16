package map;

public class Map {
	
	public Terrain [][] grid;
	
	private int N;
	private int numContinents;
	
	// Default Constructor - make the map 255 by 255 terrain blocks
	public Map () {
		N = 255;
		grid = new Terrain[255][255];
		initializeRanTerrain();
	}
	
	// Custom constructor - make the map N by N terrain blocks
	public Map (int N) {
		this.N = N;
		grid = new Terrain[N][N];
		initializeRanTerrain();
	}
	
	// This method would randomly initialize the grid 2D array with random terrain blocks
	private void initializeRanTerrain () {
		// Randomly decide the number of continents to have (1 - 3)
		numContinents = ((int) Math.random() * 3) + 1;
		
		// Random variable for temperature / equator deserts (how dry to world is)
		int temp = (int) Math.random() * 3;
		
		// Random variable for climate - overall ratio of wetlands and forests
		int climate = (int) Math.random() * 3;
		
		// Random variable for age - mountain ratio
		
		// This loop randomly generates numContinents continents
		for (int cont=0; cont<numContinents; cont++) {
			
		}
		
		// Default tile is grassland on land and ocean on water
		
	}

}
