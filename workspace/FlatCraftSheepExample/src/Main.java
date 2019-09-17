/* TASK: Help the sheep to find a way to the door by changing the environment. */

import flatcraft.*;
import flatcraft.blocks.Block;

public class Main {

	public static void main(String[] args) {
		
		// create game with the selected level
		Game game = new Game(Level.SHEPHERD);
		
		// get the game world
		World world = game.getWorld();
		
		// declare planks block (the class needs to be created first)
		Block planks = new PlanksBlock();
		
		// cut the trees
		world.breakBlock(3, 6);
		world.breakBlock(8, 3);
		world.breakBlock(17, 3);
		
		// build the bridge
		for(int x = 9; x < 14; x++) {
			world.placeBlock(x, 2, planks);
		}
		
		// start game
		game.start();
	}

}
