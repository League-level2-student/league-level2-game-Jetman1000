import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

//add obstacles
//this class is responsible for the "actions" and "Managing the objects"
public class ObjectManager implements ActionListener{
	//member variables 
dinosaur dino;
Timer ObstacleSpawn;
ArrayList<Obstacle> OB =new ArrayList<Obstacle>();

//--------------------------------constructor
ObjectManager(dinosaur dino){
	this.dino=dino;
	
}


//---------------------------------methods

//this method uses the draw method from the dinosaur class and iterate/draws all the obstacles
void draw(Graphics g) {
	dino.draw(g);
	System.out.println(OB.size());

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
	}
}

//this method iterates, sets a timer for the spawning of the obstacles, and "starts" the game for the obstacles
   void startGame() {
ObstacleSpawn = new Timer(1000, this);
   ObstacleSpawn.start();
   }

//this method adds the obstacles 
void addObstacles(){
	OB.add(new Obstacle(400, 350, 25, 25 ));
	System.out.println("adfDFADFAFADFADFA");
}









@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addObstacles();
}


}
