import java.awt.Graphics;

//this class is responsible for the "actions" and "Managing the objects"
public class ObjectManager {
	//member variables 
dinosaur dino;
Obstacle ob;



//--------------------------------constructor
ObjectManager(dinosaur dino){
	this.dino=dino;
	this.ob=ob;
}


//---------------------------------methods
//this method uses the draw method from the dinosaur class and calls it
void draw(Graphics g) {
	dino.draw(g);
	ob.draw(g);

}

//this method uses the update method from the dinosaur class and calls it
void update() {
	dino.update();
	ob.update();
}



}
