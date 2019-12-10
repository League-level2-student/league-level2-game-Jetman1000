import java.awt.Graphics;

//this class is purposed to create the code and draw the obstacles
public class Obstacle extends GameObject {
//member variables
	
	
	
	

	//-----------------constructor
	Obstacle(int x, int y, int width, int oHeight){
		super (x, y, width, oHeight);
		
	}

	//-----------------methods
//this method draws the obstacle
	void draw(Graphics g) {
		g.fillRect(x, y, width, oHeight);
	}
	
//this method is supposed to make the obstacle move from right to left
	void update() {
		x-=5;
	}
	
	
}
