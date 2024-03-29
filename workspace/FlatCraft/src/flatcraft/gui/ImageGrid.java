package flatcraft.gui;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class ImageGrid extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private ImagePanel[][] images;
	
	public ImageGrid(int rows, int columns) {
		super(new GridLayout(rows, columns));
		this.images = new ImagePanel[columns][rows];
		
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				ImagePanel image = new ImagePanel();
				images[x][y] = image;
				add(image);
			}
		}
	}
	
	public ImageGrid(int rows, int columns, Border border) {
		this(rows, columns);
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				images[x][y].setBorder(border);
			}
		}
	}
	
	public BufferedImage getImage(int x, int y) {
		return images[x][y].getImage();
	}
	
	public synchronized void setImage(int x, int y, BufferedImage image) {
		images[x][y].setImage(image);
	}
	
	public synchronized void setLabel(int x, int y, String label) {
		images[x][y].setLabel(label);
	}
	
	public void setToolTip(int x, int y, String text) {
		images[x][y].setToolTipText(text);
	}
	
}
