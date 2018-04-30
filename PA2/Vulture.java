/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a Bird objects called Vulture, 
which inherits from the AbstractBird abstract class and implements the bird interface. 
It accesses the Facing enum to keep track of which direction the bird is facing. The 
Vulture moves in a counterclockwise circle.
Bugs: None.
*/

import java.awt.*;

public class Vulture extends AbstractBird implements Bird{

	//fields
	private Facing direction = Facing.UP;
	
	//constructor creates a new Vulture object at coordinates x,y
	public Vulture(int x, int y) {
		super(x, y);
	}

	@Override
	//getColor returns black
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	//fly moves the vulture around in a counterclockwise circle
	public void fly() {
		Point position = this.getPosition();
		switch(direction){
		case DOWN:
			position.y += 1;
			direction = Facing.RIGHT;
			break;
		case LEFT:
			position.x -= 1;
			direction = Facing.DOWN;
			break;
		case RIGHT:
			position.x += 1;
			direction = Facing.UP;
			break;
		case UP:
			position.y -= 1;
			direction = Facing.LEFT;
			break;
		}
	}
}
