import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

//add obstacles
//this class is responsible for the "actions" and "Managing the objects"
public class ObjectManager implements ActionListener{
	//member variables 
dinosaur dino;

Timer ObstacleSpawn;


ArrayList<Obstacle> OB =new ArrayList<Obstacle>();
Random random=new Random(); 



//--------------------------------constructor
ObjectManager(dinosaur dino){
	this.dino=dino;

}


//---------------------------------methods

//this method uses the draw method from the dinosaur class and iterate/draws all the obstacles
void draw(Graphics g) {
	dino.draw(g);
	//System.out.println(OB.size());

	for(int i=0; i<OB.size(); i++) {
		Obstacle O= OB.get(i);
		O.draw(g);
	}
	
}



//this method uses the update method from the dinosaur class and iterates through all obstacles
void update() {
	
	dino.update();
	
	//iteration
for(int i=0; i<OB.size(); i++) {
	Obstacle O= OB.get(i);
	O.update();
	checkCollision();
	}
}

//this method iterates, sets a timer for the spawning of the obstacles, and "starts" the game for the obstacles
   void startGame() {   
	    
ObstacleSpawn = new Timer(random.nextInt(1001)+1001, this);
   ObstacleSpawn.start();
   }

  void restart() {
	  ObstacleSpawn.restart();
  }
   
   
//this method adds the obstacles 
void addObstacles(){
	OB.add(new Obstacle(800, 375, 25, 25 ));
	
}

//this method clears all obstacles
void reset() {
	OB.clear();
	ObstacleSpawn.stop();
}


//this method checks the collision of the obstacles to the dinosaur
void checkCollision() {
	for(int i=0; i<OB.size(); i++) {
		Obstacle o= OB.get(i);
		if(o.collisionBox.intersects(dino.collisionBox)) {
			o.isActive=false;
			dino.isActive=false;
		}
		
	}
}






@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addObstacles();
 ObstacleSpawn.setDelay(random.nextInt(1501)+1001);

 

 
 
 
}


}
