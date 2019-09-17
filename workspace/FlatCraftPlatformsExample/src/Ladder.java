import flatcraft.Building;
import flatcraft.World;
import flatcraft.blocks.Block;
import flatcraft.blocks.LadderBlock;

public class Ladder implements Building {

	private int height;
	
	public Ladder(int height) {
		this.height = height;
	}

	@Override
	public void build(World world, int x, int y) {
		Block ladder = new LadderBlock();
		
		for(int _y = y; _y < y + height; _y++) {
			world.placeBlock(x, _y, ladder);
		}
	}
	
}