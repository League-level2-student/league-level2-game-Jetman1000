//This class is purposed to create the functions and object of the dinosaur.
public class dinosaur extends GameObject{
//member variables
	int dinoVelo= 30;
	int gravity=1;
	
	boolean jump= false;
	
	//-------------------------constructor
	dinosaur(int x, int y, int width, int height){
		
	}
	
	
	//-------------------------methods
	
	//method for updating the dinosaur
	void update(){
		if(jump==true) {
			jump();
		}
	}
	 //method for code for making the dinosaur jump
	
	void jump() {
		y+=dinoVelo;
	}
	
	
}
