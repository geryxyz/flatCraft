package flatcraft.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import flatcraft.Game;

public class MainWindowGui extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public static final int BLOCK_ROWS = Game.BLOCK_ROWS;
	public static final int BLOCK_COLUMNS = Game.BLOCK_COLUMNS;
	public static final int WINDOW_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 2 / 3;
	public static final int WINDOW_WIDTH = WINDOW_HEIGHT * BLOCK_COLUMNS / BLOCK_ROWS;
	public static final int BLOCK_SIZE = WINDOW_WIDTH / BLOCK_COLUMNS;
	public static final boolean DRAW_BLOCK_BORDERS = true;
	
	private ImageGrid imageGrid;

	public MainWindowGui() {
		super("FlatCraft");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setLayout(new BorderLayout()); 
		
		if(DRAW_BLOCK_BORDERS) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			imageGrid = new ImageGrid(BLOCK_ROWS, BLOCK_COLUMNS, border);
		} else {
			imageGrid = new ImageGrid(BLOCK_ROWS, BLOCK_COLUMNS);
		}
		
		for(int x = 0; x < BLOCK_COLUMNS; x++) {
			for(int y = 0; y < BLOCK_ROWS; y++) {
				imageGrid.setToolTip(x, y, String.format("( %d, %d )", x, BLOCK_ROWS - 1 - y));
			}
		}
		
		add(imageGrid);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
	}

	public ImageGrid getImageGrid() {
		return imageGrid;
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
}
