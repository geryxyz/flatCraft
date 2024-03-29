package flatcraft.gui;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	private String label;
	
    public ImagePanel() {
    	label = "";
    }

    public ImagePanel(BufferedImage image, int width, int height) {
      this.image = image;
    } 

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
            
        Font font = new Font("Courier", Font.PLAIN, 10);
        g.setFont(font);
        g.drawString(label, getSize().width / 2 - label.length() * 5 / 2 - 3, 10);
    }
	
	public BufferedImage getImage() {
		return image;
	}

	public synchronized void setImage(BufferedImage image) {
		this.image = image;
		revalidate();
		repaint();
	}
	
	public synchronized void setLabel(String label) {
		this.label = label;
	}

}
