package flatcraft;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import flatcraft.gui.MainWindowGui;

public final class Images {

	static BufferedImage PLAYER;
	static BufferedImage PLAYER_LADDER;
	static BufferedImage SHEEP_RIGHT;
	static BufferedImage SHEEP_LEFT;
	
	public static BufferedImage DOOR;
	public static BufferedImage LADDER;
	public static BufferedImage TREE;
	public static BufferedImage APPLE;
	public static BufferedImage BLOCK_AIR;
	public static BufferedImage BLOCK_DIRT;
	public static BufferedImage BLOCK_GRASS;
	public static BufferedImage BLOCK_STONE;
	public static BufferedImage BLOCK_BRICK;
	public static BufferedImage BLOCK_PLANKS;
	
	static {
		PLAYER = getResizedImage("/resources/images/player.jpg");
		PLAYER_LADDER = getResizedImage("/resources/images/player_ladder.jpg");
		SHEEP_RIGHT = getResizedImage("/resources/images/sheep_right.jpg");
		SHEEP_LEFT = getResizedImage("/resources/images/sheep_left.jpg");
		
		DOOR = getResizedImage("/resources/images/door.jpg");
		LADDER = getResizedImage("/resources/images/ladder.jpg");
		TREE = getResizedImage("/resources/images/tree.jpg");
		APPLE = getResizedImage("/resources/images/apple.jpg");
		BLOCK_AIR = getResizedImage("/resources/images/block_air.jpg");
		BLOCK_DIRT = getResizedImage("/resources/images/block_dirt.jpg");
		BLOCK_GRASS = getResizedImage("/resources/images/block_grass.jpg");
		BLOCK_STONE = getResizedImage("/resources/images/block_stone.jpg");
		BLOCK_BRICK = getResizedImage("/resources/images/block_brick.jpg");
		BLOCK_PLANKS = getResizedImage("/resources/images/block_planks.jpg");
	}
	
	private static BufferedImage getResizedImage(String path) {
		BufferedImage img = getImage(path);
		return resize(img, MainWindowGui.BLOCK_SIZE, MainWindowGui.BLOCK_SIZE);
	}

	private static BufferedImage getImage(String path) {
		BufferedImage result = null;
		try {
			result = ImageIO.read(Images.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) { 
	    Image tmp = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	    BufferedImage result = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = result.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return result;
	}
	
}
