
//next class you planned to create code for updating the dinosaur's jumping and drawing, you recently added another class called "GameObject"

//This class sets up the window and the floor of the game.
import javax.swing.JFrame;

public class Game {
	//member variables
	JFrame frame;
	GamePanel GP;
public static int HEIGHT = 500;
public static int WIDTH=800; 

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
