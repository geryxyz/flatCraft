import flatcraft.Building;
import flatcraft.World;
import flatcraft.blocks.Block;

public class Bridge implements Building {

	private int length;
	
	public Bridge(int length) {
		this.length = length;
	}
	
	@Override
	public void build(World world, int x, int y) {
		Block planks = new PlanksBlock();
		
		for(int _x = x; _x < x + length; _x++) {
			world.placeBlock(_x, y, planks);
		}
	}

}