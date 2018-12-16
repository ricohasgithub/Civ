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
		int age = (int) Math.random() * 3;
		
		// This variable determines how large a perfect continent would be
		int pCSize = (int) (((N * N) * 0.3) / numContinents);
		
		// This loop randomly generates numContinents continents
		for (int cont=0; cont<numContinents; cont++) {
			// All numContinents continents are proportional to a third of the size of the total size (N * N) / numContinents
			
			// Get the size of the continent (with noise)
			int cSize = addNoiseToContSize(pCSize);
			
			// Randomly initialize continent center position
			int x = (int) Math.random() * N;
			int y = (int) Math.random() * N;
			
			addContinentToMap(x, y, cSize);
			
		}
		
		// Default tile is grassland for land based tiles and ocean for water based tile
		
	}
	
	// This method adds a continent (all grassland) to the map
	private void addContinentToMap (int x, int y, int size) {
		// Get the approximate 
		int rad = (int) Math.sqrt(size / Math.PI);
		
		grid[x][y] = new Grassland(null, null, null);
		
		// Top left corner
		int x1 = x - rad;
		int y1 = y - rad;
		// Bottom Right corner
		int x2 = x + rad;
		int y2 = y + rad;
		
		for (int r=x1; r<x2; r++) {
			for (int c=y1; c<y2; c++) {
				grid[r][c] = new Grassland(null, null, null);
			}
		}
		
	}
	
	// This method adds noise to a perfect sized continent
	private int addNoiseToContSize (int pCSize) {
		// This variable determines the variance (-25% to +25%)
		double ranProportion = Math.random() - 0.75;
		return (int) (pCSize * ranProportion);
	}

}
