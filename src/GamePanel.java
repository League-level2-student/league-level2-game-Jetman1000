import java.awt.Graphics;

import javax.swing.JPanel;

//This class is responsible for the collision, interaction, game obstacles, and function of the game.
public class GamePanel extends JPanel{
//member variables
	
	
	
//-----------------------------	Constructor
	GamePanel(){
		
	}
	
//----------------------------- methods
	void drawFloor(Graphics g) {
		g.fillRect(50,50,50,50);
	}
	
}
