
//For the next class, create code to make it so that when the score is like 100, 200, 300, and etc. speed increases. Also create code
//for the Ending State of the Game

//This class sets up the window and the floor of the game.
import javax.swing.JFrame;

public class Game {
	//member variables
	JFrame frame;
	GamePanel GP;
public static int HEIGHT = 500;
public static int WIDTH=800; 
public static int gHeight=400;

//------------------------------------ Constructor & main method
Game(){
	frame=new JFrame("Dinosaur Game"); 
	GP=new GamePanel();
	window();
}
  
public static void main(String[] args) {
	Game G = new Game();
	
}



//-------------------------------------- methods

void window() {
	frame.add(GP);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.addKeyListener(GP);
	frame.setVisible(true);
}




}
