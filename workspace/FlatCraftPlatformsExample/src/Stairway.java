import flatcraft.Building;
import flatcraft.World;
import flatcraft.blocks.Block;


public class Stairway implements Building {
	
	private int height;
	private boolean flip;

	public Stairway(int height) {
		this(height, false);
	}
	
	public Stairway(int height, boolean flip) {
		this.height = height;
		this.flip = flip;
	}

	@Override
	public void build(World world, int x, int y) {
		Block brick = new BrickBlock();
		
		for(int _y = y; _y < y + height; _y++) {
			for(int _x = x; _x < x + height; _x++) {
				if(!flip && _y - y == _x - x) {
					world.placeBlock(_x, _y, brick);
				}
				else if(flip && _y - y + _x - x == height - 1) {
					world.placeBlock(_x, _y, brick);
				}
			}
		}
	}
	
}
