//This class sets up the window and the floor of the game.
import javax.swing.JFrame;

public class Game {
	//member variables
	JFrame frame;
	GamePanel GP;
int height = 500;
int width=800; 

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
	frame.setSize(width, height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.addKeyListener(GP);
	frame.setVisible(true);
}




}
