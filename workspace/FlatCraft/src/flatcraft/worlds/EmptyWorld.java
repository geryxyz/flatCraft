package flatcraft.worlds;

import flatcraft.World;
import flatcraft.blocks.*;

public class EmptyWorld extends World {

	public EmptyWorld(int rows, int columns) {
		super(rows, columns);
		
		Block air = new AirBlock();
		
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				placeBlock(x, y, air);
			}
		}
	}
	
}
