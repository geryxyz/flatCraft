/* TASK: Find a way to reach the door by changing the environment and controlling the player. */

import flatcraft.*;

public class Main {

	public static void main(String[] args) {
		
		// create game with the selected level
		Game game = new Game(Level.STAIR_BUILDER);
		
		// get the game world
		World world = game.getWorld();

		// create new block type (e.g. brick)
		// and build the stairs
		//   - write a simple function
		//   - OR implement the "Building" interface in a new class
		Stairway stairway = new Stairway(5);
		stairway.build(world, 13, 3);
		
		// start the game
		game.start();
		
		// create a player and add it to the game world
		Player player = new SmartPlayer("Name");
		world.addPlayer(player);
		
		// move the player to the door
		// (comment out this line after implementing "SmartPlayer")
		moveToDoor(player);
	}
	
	public static void moveToDoor(Player player) {
		int distance = 18;
		
		for(int x = 0; x < distance; x++) {
			if(x < 11 || x > 15) {
				player.act(Action.MOVE_RIGHT);
			} else {
				player.act(Action.JUMP_RIGHT);
			}
		}
	}

}
