package flatcraft;

import java.awt.Point;

import flatcraft.blocks.*;
import flatcraft.gui.ImageGrid;

public abstract class World {
		
	private int rows;
	private int columns;
	private Block[][] blocks;
	private boolean playersAllowed = false;
	protected Point spawnPosition;
	
	public World(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.blocks = new Block[columns][rows];
		this.spawnPosition = new Point(0, 0);
	}
	
	protected void onGameStart() {
		playersAllowed = true;
	}
	
	protected void buildFromBlockMatrix(Block[][] blockMatrix) {
		for(int y = 0; y < blockMatrix.length; y++) {
			for(int x = 0; x < blockMatrix[y].length; x++) {
				placeBlock(x, y, blockMatrix[blockMatrix.length - 1 - y][x]);
			}
		}
	}
	
	public void placeBlock(int x, int y, Block block) {
		placeBlock(x, y, block, null);
	}

	void placeBlock(int x, int y, Block block, String label) {
		ImageGrid imageGrid = Game.mainWindow.getImageGrid();
		imageGrid.setImage(x, rows - 1 - y, block.getImage());
		if(label != null) {
			imageGrid.setLabel(x, rows - 1 - y, label);
		}
		blocks[x][y] = block;
	}
	
	public void breakBlock(int x, int y) {
		placeBlock(x, y, new AirBlock(), "");
	}
	
	public Block getBlock(int x, int y) {
		if(x >= columns || y >= rows || x < 0 || y < 0) {
			return null;
		}
		return blocks[x][y];
	}
	
	public void addPlayer(Player player) {
		if(!playersAllowed) {
			throw new IllegalStateException("Game must be started before adding players.");
		}
		player.setWorld(this);
		player.setPosition(spawnPosition.x, spawnPosition.y);
		Game.mainWindow.addKeyListener(player);
	}

	public Point getSpawnPosition() {
		return spawnPosition;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
}
