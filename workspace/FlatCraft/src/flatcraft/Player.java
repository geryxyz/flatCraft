package flatcraft;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import flatcraft.blocks.AirBlock;
import flatcraft.blocks.AppleBlock;
import flatcraft.blocks.Block;
import flatcraft.blocks.DoorBlock;
import flatcraft.blocks.LadderBlock;

public class Player extends Block implements KeyListener {
	
	private static final int ACTION_TIME = 500;
	private static final int FALL_DELAY = 250;
	
	private String name;
	private World world;
	private Point position;
	private Timer fallTimer;
	private boolean isOnLadder = false;
	protected boolean canUseLadder = true;
	
	public Player(String name) {
		this.name = name;
		image = Images.PLAYER;
		position = new Point();
		
		fallTimer = new Timer(FALL_DELAY, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(!isOnLadder) {
		    		move(0, -1);
		    	}	
		    }
		});
		fallTimer.start();
	}
	
	void setWorld(World world) {
		this.world = world;
		Point spawnPoint = world.getSpawnPosition();
		position = new Point(spawnPoint.x, spawnPoint.y);
	}
	
	void setPosition(int x, int y) {
		world.breakBlock(position.x, position.y);
		position.x = x;
		position.y = y;
		world.placeBlock(x, y, this, name);
	}
	
	public boolean act(Action action) {
		return act(action, true, true);
	}
	
	protected boolean act(Action action, boolean wait, boolean showError) {	
		wait(ACTION_TIME);
		switch(action) {
			case MOVE_LEFT:
				return move(-1, 0, showError);
			case MOVE_RIGHT:
				return move(1, 0, showError);
			case JUMP_UP:
				return move(0, 1, showError);
			case JUMP_LEFT:
				return move(-1, 1, showError);
			case JUMP_RIGHT:
				return move(1, 1, showError);
			case JUMP_LONG_LEFT:
				if(!move(-1, 1, showError)) {
					return false;
				};
				fallTimer.restart();
				wait(ACTION_TIME / 4);
				move(-1, -1, false);
				return true;
			case JUMP_LONG_RIGHT:
				if(!move(1, 1, showError)) {
					return false;
				};
				fallTimer.restart();
				wait(ACTION_TIME / 4);
				move(1, -1, false);
				return true;
			default:
				return false;
		}
	}
	
	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected boolean move(int x, int y) {
		return move(x, y, false, false);
	}
	
	private boolean move(int x, int y, boolean showError) {
		return move(x, y, showError, true);
	}
	
	private boolean move(int x, int y, boolean showError, boolean exitOnError) {
		Block targetBlock = world.getBlock(position.x + x, position.y + y);
		
		if(targetBlock == null) {
			return false;
		}
		
		if(targetBlock instanceof DoorBlock) {
			fallTimer.stop();
			Game.mainWindow.showMessage("You won!");
			System.exit(0);
		}
		
		if(!(targetBlock instanceof AirBlock) &&
				!(targetBlock instanceof AppleBlock) &&
				!(targetBlock instanceof LadderBlock)) {
			if(showError) {
				Game.mainWindow.showMessage("You ran into wall!");
				if(exitOnError) {
					System.exit(0);
				}
			}
			return false;
		}
		
		if(world.getBlock(position.x, position.y - y) instanceof AirBlock && y > 0) {
			return false;
		}
		
		isOnLadder = image == Images.PLAYER_LADDER;
		
		if(canUseLadder) {
			if(targetBlock instanceof LadderBlock) {
				image = Images.PLAYER_LADDER;
			} else {
				image = Images.PLAYER;
			}
		}
		
		int oldX = position.x;
		int oldY = position.y;
			
		setPosition(position.x + x, position.y + y);
		
		if(isOnLadder) {
			world.placeBlock(oldX, oldY, new LadderBlock());
		}
		
		if(y > 0) {
			fallTimer.restart();
		}
		
		return true;
	}
	
	public String getName() {
		return name;
	}

	protected void onKeyDown(int keyCode) {}

	@Override
	public final void keyPressed(KeyEvent e) {
		onKeyDown(e.getKeyCode());
	}
	
	@Override
	public final void keyTyped(KeyEvent e) {}

	@Override
	public final void keyReleased(KeyEvent e) {}
	
}