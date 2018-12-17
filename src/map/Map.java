package map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	public Terrain [][] grid;
	
	private int N;
	private int numContinents;
	
	Image grasslandDef;
	Image oceanDef;
	
	// Default Constructor - make the map 255 by 255 terrain blocks
	public Map () {
		
		try {
			grasslandDef = ImageIO.read(new File("images/tGrassland.png"));
			oceanDef = ImageIO.read(new File("images/tOcean.png"));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		grasslandDef = grasslandDef.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		oceanDef = oceanDef.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
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
	
	public void drawMap (Graphics g) {
		System.out.println("Drawing Map");
		int cx = 0;
		for (int r=0; r<N; r++) {
			int cy = 0;
			for (int c=0; c<N; c++) {
				grid[r][c].draw(g, cx, cy);
				cy += 50;
			}
			cx += 50;
		}
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
		System.out.println("Adding Oceans...");
		// Initialize all other tiles with ocean
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (grid[r][c] == null) {
					grid[r][c] = new Ocean(oceanDef, oceanDef, oceanDef);
				}
			}
		}
		
		System.out.println("Done Adding Oceans");
		
	}
	
	// This method adds a continent (all grassland) to the map
	private void addContinentToMap (int x, int y, int size) {
		// Get the approximate 
		int rad = (int) Math.sqrt(size / Math.PI);
		
		grid[x][y] = new Grassland(grasslandDef, grasslandDef, grasslandDef);
		
		// Top left corner (x - rad or 0)
		int x1 = Math.max(x - rad, 0);
		int y1 = Math.max(y - rad, 0);
		// Bottom Right corner
		int x2 = Math.min(x + rad, N - 1);
		int y2 = Math.min(y + rad, N - 1);
		
		for (int r=x1; r<x2; r++) {
			for (int c=y1; c<y2; c++) {
				if (r >= N || c >= N) {
					break;
				}
				grid[r][c] = new Grassland(grasslandDef, grasslandDef, grasslandDef);
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
