package flatcraft.worlds;

import java.awt.Point;

import flatcraft.World;
import flatcraft.blocks.*;

public class FlatWorld extends World {

	public FlatWorld(int rows, int columns) {
		super(rows, columns);
		spawnPosition = new Point(1, 3);
		
		Block air = new AirBlock();
		Block dirt = new DirtBlock();
		Block grass = new GrassBlock();
		
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				if(y == 2) {
					placeBlock(x, y, grass);
				}
				else if(y < 2) {
					placeBlock(x, y, dirt);
				} else {
					placeBlock(x, y, air);
				}
			}
		}
	}
	
}
