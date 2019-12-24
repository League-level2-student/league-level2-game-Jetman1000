import java.awt.Graphics;

//This class is purposed to create the functions and object of the dinosaur.
public class dinosaur extends GameObject{
//member variables
	int dinoVelo= 0;
	int gravity=1;
	
	boolean ducking=false;
	boolean jump= false;
	
	//-------------------------constructor
	dinosaur(int x, int y, int width, int height){
		super( x, y,  width,  height);
	}
	
	
	//-------------------------methods
	
	//method for updating the dinosaur
	void update(){
		
		dinoVelo+=gravity;
		y+=dinoVelo;
		if(y>Game.gHeight-height) {
			y=Game.gHeight-height;
			jump =true;
		}
	
//		
	}
	
	//method to draw the dinosaur
	void draw(Graphics g) {
		g.fillRect(x,y, width, height);
	}
	

	
	 //method for code for making the dinosaur jump
	void jump() {
		
		
		if(y == Game.gHeight-height) {
			dinoVelo = -15;
		}
	}
	
	//method for code that will make the dinosaur duck
		void duck() {
			ducking=true;
			
			if(ducking==true) {
					height= height/2;
			}
		}
	
	
	
	
}
