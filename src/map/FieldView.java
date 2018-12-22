package map;

import java.awt.Graphics;

public class FieldView {
	
	Map map;
	
	Terrain[][] playerView;
	
	int N;
	
	// These coordinates are the center of the player's view in terms of the maps
	int centerX;
	int centerY;
	
	public FieldView (Map map, int centerX, int centerY) {
		
		this.map = map;
		
		this.N = 10;
		playerView = new Terrain[N][N];
		
		this.centerX = centerX;
		this.centerY = centerY;
		
	}
	
	public FieldView (Map map, int N, int centerX, int centerY) {
		
		this.map = map;
		
		this.N = N;
		playerView = new Terrain[N][N];
		
		this.centerX = centerX;
		this.centerY = centerY;
		
	}
	
	public void draw (Graphics g) {
		int cx = 0;
		for (int r=0; r<N; r++) {
			int cy = 0;
			for (int c=0; c<N; c++) {
				playerView[r][c].draw(g, cx, cy);
				cy += 20;
			}
			cx += 20;
		}
	}
	
	public void updateCoords (int centerX, int centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}

}
