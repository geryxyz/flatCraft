/* TASK: Collect all the apples and find a way to the door without breaking any blocks. */

import flatcraft.*;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(Level.PLATFORMS);
		World world = game.getWorld();
		
		buildConstructions(world);
		
		game.start();
		
		SmartPlayer player = new SmartPlayer("Joe Scamfan");
		world.addPlayer(player);
		
		moveToDoor(player);
	}
	
	private static void buildConstructions(World world) {
		Stairway stairway = new Stairway(3, true);
		stairway.build(world, 3, 6);
		
		Bridge bridge = new Bridge(3);
		bridge.build(world, 5, 2);
		
		Ladder ladder = new Ladder(4);
		ladder.build(world, 16, 1);
	}
	
	private static void moveToDoor(SmartPlayer player) {
		player.act(Action.MOVE_RIGHT, 7);
		player.act(Action.JUMP_RIGHT, 2);
		player.act(Action.MOVE_RIGHT);
		player.act(Action.JUMP_LONG_RIGHT);
		player.act(Action.MOVE_LEFT);
		player.wait(1000);
		player.act(Action.MOVE_LEFT, 8);
		player.act(Action.JUMP_LEFT, 2);
		player.act(Action.MOVE_RIGHT, 11);
		player.wait(500);
		player.act(Action.MOVE_LEFT, 7);
		player.act(Action.MOVE_RIGHT, 11);
		player.act(Action.JUMP_UP, 4);
		player.act(Action.MOVE_LEFT);
		player.act(Action.JUMP_LONG_RIGHT, 2);
	}

}
