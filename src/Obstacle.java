import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

//this class is purposed to create the code and draw the obstacles
public class Obstacle extends GameObject {
//member variables
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	

	//-----------------constructor
	Obstacle(int x, int y, int width, int height){
		super (x, y, width, height);
		if (needImage) {
		    loadImage ("grassBlock.png");
		}
	}

	//-----------------methods
//this method draws the obstacle
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}
	}
	
//this method is supposed to make the obstacle move from right to left
	void update() {
		
		super.update();
		x-=5;
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	
	
}
