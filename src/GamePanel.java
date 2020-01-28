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
	int speed=70;
dinosaur dino= new dinosaur (100, 350 , 50, DINOheight);
	ObjectManager OM=new ObjectManager(dino);


//-----------------------------	Constructor
	GamePanel(){
		
		scoreMeasure = new Timer (1000/10,this);
		scoreMeasure.start();
		
		frameDraw = new Timer(1000 / speed, this);
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
			currentState++;
			scoreMeasure.stop();
			OM.reset();
			frameDraw.stop();
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
		g.drawString("Score: "+getScore(),375,250);
		
		//drawing the dinosaur
		OM.draw(g);
		
	}
	
	//-------
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.RED);
		g.drawString("YOU DIED", 375, 250);
		g.drawString("Your score was " + score, 340, 300);
		g.drawString ("Press ENTER twice to restart",310 ,330);
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
			if( score % 100==0) {
				System.out.println(speed);
				speed+=20;
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
			if(currentState==GAME) {
			score=0;
			frameDraw.start();
			scoreMeasure.start();
			OM.restart();
			}
			System.out.println(currentState);
			//System.out.println("qwertyuio");
		}
		 
		if(e.getKeyCode()==KeyEvent.VK_ENTER&&currentState==END) {
			currentState = MENU;
			//score = 0;
		}
		
		
		if(currentState>END) {
			currentState=MENU;
			
		}
		
		if(currentState == MENU) {
			OM.reset();
		}else if(currentState==GAME) {
			
			
			dino.isActive=true;
			//dino.x=100;
			//dino.y=350;
			
		
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
