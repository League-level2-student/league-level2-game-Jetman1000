import java.awt.Graphics;

//this class is responsible for the "actions" and "Managing the objects"
public class ObjectManager {
	//member variables 
dinosaur dino;


//--------------------------------constructor
ObjectManager(dinosaur dino){
	this.dino=dino;
}


//---------------------------------methods
//this method uses the draw method from the dinosaur class and calls it
void draw(Graphics g) {
	dino.draw(g);

}

//this method uses the update method from the dinosaur class and calls it
void update() {
	dino.update();
}



}
