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
	Timer scoreMeasure;
	Timer frameDraw;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int DINOheight = 50;
	int score=0;
	int currentState= MENU;
	int n=60;
dinosaur dino= new dinosaur (100, 350 , 50, DINOheight);
	ObjectManager OM=new ObjectManager(dino);


//-----------------------------	Constructor
	GamePanel(){
		
		scoreMeasure = new Timer (1000/10,this);
		scoreMeasure.start();
		
		frameDraw = new Timer(1000 / n, this);
		frameDraw.start();
		OM.startGame();
		
	}
	
//----------------------------- methods
	
	//methods for updating states of the game
	void updateStartState(){
		
	}
	void updateGameState() {
		OM.update();
		
		if(dino.isActive==false) {
			currentState=END;
		}
		 
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
		g.drawString("Press Space to JUMP", 330,290);
		//g.drawString("Press DOWN arrow = CROUCH", 303, 330);
	}
	
	//-------
	void drawGameState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		
		
		//drawing the line on the floor
		g.setColor(Color.BLACK);
		g.drawLine(0,400,800,Game.gHeight);
		
		//drawing the scoreboard                          **********
		g.drawString("Score: "+getScore(),400,250);
		
		//drawing the dinosaur
		OM.draw(g);
		
	}
	
	//-------
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}

	
	public int getScore() {
		return score;
	}
	
	
	
	
	//allows for methods to be called
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frameDraw) {
		if(currentState==MENU) {
			
			updateStartState();
		}else if (currentState==GAME) {
			updateGameState();
	
		}else if(currentState==END) {
			updateEndState();
		}
		repaint();
		}
		
		if(e.getSource()==scoreMeasure) {
			score++;
		}
		
		
		if(e.getSource() == scoreMeasure) {
			if(score == 100) {
				n+=10;
			}
		}
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
