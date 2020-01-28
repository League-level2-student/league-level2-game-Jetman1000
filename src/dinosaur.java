import java.awt.Graphics;
import java.awt.image.BufferedImage;

//This class is purposed to create the functions and object of the dinosaur.
public class dinosaur extends GameObject{
//member variables
	int dinoVelo= 0;
	int gravity=1;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
	//boolean ducking=false;
	boolean jump= false;
	
	//-------------------------constructor
	dinosaur(int x, int y, int width, int height){
		super( x, y,  width,  height);
		if (needImage) {
		    loadImage ("Dino.png");
		}
		
	}
	
	
	//-------------------------methods
	
	//method for updating the dinosaur
	void update(){

		super.update();
		dinoVelo+=gravity;
		y+=dinoVelo;
		if(y>Game.gHeight-height) {
			System.out.println("jmp");
			y=Game.gHeight-height;
			jump =true;
		}
	
//		
	}
	
	//method to draw the dinosaur
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}else {
		g.fillRect(x,y, width, height);
	}
	}
	

	
	 //method for code for making the dinosaur jump
	void jump() {
		
		
		if(jump == true) {
			
			
			dinoVelo = -15;
			jump=false;
		}
	}
	
	
	
	
	
}
