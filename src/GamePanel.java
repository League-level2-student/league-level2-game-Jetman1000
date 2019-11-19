import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

//This class is responsible for the collision, interaction, game obstacles, and function of the game.
public class GamePanel extends JPanel implements ActionListener{
//member variables
	Font titleFont;
	Timer frameDraw;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int currentState= MENU;
	
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
		
	}
	
	//-------
	void drawEndState(Graphics g) {
		
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
	
	
		
	
	
	
	
	
}
