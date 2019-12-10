import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

//This class is responsible for the collision, interaction, game obstacles, and function of the game.
public class GamePanel extends JPanel implements ActionListener, KeyListener{
//member variables
	Font titleFont;
	Timer frameDraw;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	
	int currentState= MENU;
	
dinosaur dino= new dinosaur (100, 350 , 50, 50);
	ObjectManager OM=new ObjectManager(dino);


//-----------------------------	Constructor
	GamePanel(){
		
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		
	}
	
//----------------------------- methods
	
	//methods for updating states of the game
	void updateStartState(){
		
	}
	void updateGameState() {
		OM.update();
	}
	void updateEndState() {
		
	}
	
	//This method makes sure that the draw methods are being called
			@Override
			public void paintComponent(Graphics g) {
				if (currentState == MENU) {
					
					drawStartState(g);
				} else if (currentState == GAME) {
					drawGameState(g);
					
				} else if (currentState == END) {
					drawEndState(g);
				}
			}
	
	//methods for drawing each state
	void drawStartState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		//Text for the State
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("Dinosuar Game", 350, 180);
		g.drawString("How to Play", 359, 250);
		g.drawString("Press Space/UP arrow = JUMP", 306,290);
		g.drawString("Press DOWN arrow = CROUCH", 303, 330);
	}
	
	//-------
	void drawGameState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		
		//drawing the line on the floor
		g.setColor(Color.BLACK);
		g.drawLine(0,400,800,Game.gHeight);
		
		//drawing the dinosaur
		OM.draw(g);
		
	}
	
	//-------
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}

	
	//allows for methods to be called
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState==MENU) {
			
			updateStartState();
		}else if (currentState==GAME) {
			updateGameState();
		}else if(currentState==END) {
			updateEndState();
		}
		repaint();
	}
//_____________________________________________
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	//_________________________________________
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			currentState++;
			
			//System.out.println("qwertyuio");
		}
		
		if(currentState>END) {
			currentState=MENU;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
			dino.jump();
		}
		
	}

	
	//___________________________________________
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	
	
	
		
	
	
	
	
	
}
