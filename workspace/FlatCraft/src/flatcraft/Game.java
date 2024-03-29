package flatcraft;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import flatcraft.gui.MainWindowGui;
import flatcraft.worlds.*;

public class Game {
	
	public static final int BLOCK_ROWS = 10;
	public static final int BLOCK_COLUMNS = 20;
	
	public static MainWindowGui mainWindow;
	
	private World world;
	
	public Game(Level level) {
		initGui();
		createWorld(level);	
	}

	public void start() {
		world.onGameStart();
	}
	
	private void initGui() {
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					mainWindow = new MainWindowGui();
					mainWindow.setVisible(true);
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void createWorld(Level level) {
		switch(level) {
			case EMPTY:
				world = new EmptyWorld(BLOCK_ROWS, BLOCK_COLUMNS);
				break;
			case FLAT:
				world = new FlatWorld(BLOCK_ROWS, BLOCK_COLUMNS);
				break;
			case STAIR_BUILDER:
				world = new StairwayWorld(BLOCK_ROWS, BLOCK_COLUMNS);
				break;
			case SHEPHERD:
				world = new SheepWorld(BLOCK_ROWS, BLOCK_COLUMNS);
				break;
			case PLATFORMS:
				world = new PlatformsWorld(BLOCK_ROWS, BLOCK_COLUMNS);
				break;
		}
	}

	public World getWorld() {
		return world;
	}

}
