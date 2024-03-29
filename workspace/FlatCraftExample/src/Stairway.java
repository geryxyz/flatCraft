import flatcraft.Building;
import flatcraft.World;
import flatcraft.blocks.Block;


public class Stairway implements Building {
	
	private int height;
	
	public Stairway(int height) {
		this.height = height;
	}

	@Override
	public void build(World world, int x, int y) {
		Block brick = new BrickBlock();
		
		for(int _y = y; _y < y + height; _y++) {
			for(int _x = x; _x < x + height; _x++) {
				if(_y - y <= _x - x) {
					world.placeBlock(_x, _y, brick);
				}
			}
		}
	}
	
}
