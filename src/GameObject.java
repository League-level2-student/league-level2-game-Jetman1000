import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameObject {
//member variables
	int x;
	int y;
	int width;
	int height;
	
	boolean isActive=true;
	
	Rectangle collisionBox;
	
	

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
	
	

//-----------------------constructor	
	
	GameObject(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		this.collisionBox=new Rectangle(x,y,width,height);
		
	}
	
	void update(){
		collisionBox.setBounds(x,y,width,height);
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
