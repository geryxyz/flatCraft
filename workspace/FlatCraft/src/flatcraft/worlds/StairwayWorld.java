package flatcraft.worlds;

import flatcraft.blocks.Block;
import flatcraft.blocks.DirtBlock;
import flatcraft.blocks.DoorBlock;

public class StairwayWorld extends FlatWorld {

	public StairwayWorld(int rows, int columns) {
		super(rows, columns);
		
		Block dirt = new DirtBlock();
		Block door = new DoorBlock();
		
		placeBlock(18, 7, dirt);
		placeBlock(19, 7, dirt);
		placeBlock(19, 8, door);
	}

}
