/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a Bird object called Cardinal, 
which inherits from the AbstractBird abstract class and implements the bird interface. 
It accesses the Facing enum to keep track of which direction the bird is facing.
The Cardinal moves up and down.
Bugs: None.
*/
import java.awt.*;

public class Cardinal extends AbstractBird implements Bird{
	//fields
	private Facing direction = Facing.UP;

	//constructor makes a new Cardinal at point x,y
	public Cardinal(int x, int y) {
		super(x, y);
	}

	@Override
	//getColor returns color Red
	public Color getColor() {
		return Color.RED;
	}

	@Override
	//fly moves the cardinal up and down within the confines of the aviary
	public void fly() {
		Point position = this.getPosition();
		if(direction.equals(Facing.UP)){
			flyUp(position);
		} else {
			flyDown(position);
		}
	}
	
	//flyUp moves the bird up one position if in range, otherwise changes the direction to down and moves the bird down one
	public void flyUp(Point position){
		if(position.y > 0){
			position.y -=1;
		} else {
			direction = Facing.DOWN;
			position.y += 1;
		}
	}
	
	//flyDown moves the bird down one position if in range, otherwise changes the direction to up and moves the bird up one
	public void flyDown(Point position){
		if(position.y < AviaryConstants.SIZE-1){
			position.y += 1;
		}else{
			direction = Facing.UP;
			position.y -= 1;
		}
	}
}
