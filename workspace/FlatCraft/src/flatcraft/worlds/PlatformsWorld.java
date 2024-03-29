package flatcraft.worlds;

import java.awt.Point;

import flatcraft.World;
import flatcraft.blocks.AirBlock;
import flatcraft.blocks.AppleBlock;
import flatcraft.blocks.Block;
import flatcraft.blocks.DirtBlock;
import flatcraft.blocks.DoorBlock;
import flatcraft.blocks.GrassBlock;
import flatcraft.blocks.TreeBlock;

public class PlatformsWorld extends World {

	public PlatformsWorld(int rows, int columns) {
		super(rows, columns);
		spawnPosition = new Point(0, 9);
		
		Block air = new AirBlock();
		Block drt = new DirtBlock();
		Block grs = new GrassBlock();
		Block doo = new DoorBlock();
		Block tre = new TreeBlock();
		Block apl = new AppleBlock();
		
		Block[][] blockMatrix = new Block[][]
				{
					{ air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ grs, grs, grs, air, air, air, air, air, air, air, air, air, air, grs, tre, air, air, air, air, air },
					{ drt, drt, air, air, air, air, air, air, air, grs, grs, air, apl, drt, grs, air, air, air, air, air },
					{ drt, air, air, air, air, air, air, air, grs, drt, air, air, grs, drt, drt, air, air, air, air, air },
					{ drt, apl, air, air, air, air, grs, grs, drt, air, air, air, drt, drt, drt, apl, air, air, air, doo },
					{ drt, grs, air, air, air, air, air, air, air, air, air, air, air, drt, drt, grs, air, grs, air, grs },
					{ drt, drt, grs, air, air, air, air, air, air, air, air, air, air, air, drt, drt, air, drt, air, drt },
					{ drt, drt, drt, grs, grs, air, air, air, grs, grs, grs, grs, air, air, drt, drt, air, drt, air, air },
					{ drt, drt, drt, drt, drt, apl, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt }
				};
		
		buildFromBlockMatrix(blockMatrix);
	}

}
