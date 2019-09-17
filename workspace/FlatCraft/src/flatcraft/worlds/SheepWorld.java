package flatcraft.worlds;

import java.awt.Point;

import flatcraft.Sheep;
import flatcraft.blocks.AirBlock;
import flatcraft.blocks.Block;
import flatcraft.blocks.DirtBlock;
import flatcraft.blocks.DoorBlock;
import flatcraft.blocks.GrassBlock;
import flatcraft.blocks.TreeBlock;

public class SheepWorld extends FlatWorld {

	public SheepWorld(int rows, int columns) {
		super(rows, columns);
		spawnPosition = new Point(1, 6);
		
		Block air = new AirBlock();
		Block drt = new DirtBlock();
		Block grs = new GrassBlock();
		Block doo = new DoorBlock();
		Block tre = new TreeBlock();

		Block[][] blockMatrix = new Block[][]
				{
					{ air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ air, air, air, tre, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ grs, grs, grs, grs, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ drt, drt, drt, drt, grs, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air },
					{ drt, drt, drt, drt, drt, grs, air, air, tre, air, air, air, air, air, air, air, air, tre, air, doo },
					{ drt, drt, drt, drt, drt, drt, grs, grs, grs, air, air, air, air, air, grs, grs, grs, grs, grs, grs },
					{ drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, air, air, air, drt, drt, drt, drt, drt, drt, drt },
					{ drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt, drt }
				};
		
		buildFromBlockMatrix(blockMatrix);
	}

	@Override
	protected void onGameStart() {
		super.onGameStart();
		Sheep sheep = new Sheep();
		addPlayer(sheep);
		sheep.startPatrol();
	}

}
