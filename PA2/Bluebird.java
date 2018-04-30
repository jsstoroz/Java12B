/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a Bird objects called Bluebird, 
which inherits from the AbstractBird abstract class and implements the bird interface. 
It accesses the Facing enum to keep track of which direction the bird is facing.
The Bluebird moves in a zigzag.
Bugs: None.
*/

import java.awt.*;

public class Bluebird extends AbstractBird implements Bird{

	//fields
	private Facing directionUpDown = Facing.UP;
	private Facing directionLeftRight = Facing.RIGHT;

	//constructor creates a Bluebird object at coordinates x,y
	public Bluebird(int x, int y) {
		super(x, y);
	}

	@Override
	//getColor returns blue
	public Color getColor() {
		return Color.BLUE;
	}

	@Override
	//fly controls the left-right motion of the bird
	public void fly() {
		Point position = this.getPosition();
		if(directionLeftRight.equals(Facing.RIGHT)){
			flyRight(position);
		} else {
			flyLeft(position);
		}
	}
	
	//flyRight makes the bird go zig-zag when it's going right
	public void flyRight(Point position){
		//if the bird is within the right boundary, go right one and
		//alternate the up/down movement
		if(position.x < AviaryConstants.SIZE-1){
			position.x += 1;
			if(directionUpDown.equals(Facing.UP)){
				position.y += 1;
				directionUpDown = Facing.DOWN;
			} else {
				position.y -= 1;
				directionUpDown = Facing.UP;
			}
		} else {
			//when you reach the right boundary, turn the bird around
			position.x -=1;
			position.y -=1;
			directionLeftRight = Facing.LEFT;
		}
	}
	
	//flyLeft makes the bird zig-zag when it's going left
	public void flyLeft(Point position){
		//if the bird is within the left boundary, go left one and
		//alternate the up/down movement
		if(position.x > 0){
			position.x -=1;
			if(directionUpDown.equals(Facing.UP)){
				position.y -= 1;
				directionUpDown = Facing.DOWN;
			} else {
				position.y += 1;
				directionUpDown = Facing.UP;
			}
		} else {
			//when you reach the left boundary, turn the bird around
			position.x +=1;
			position.y +=1;
			directionLeftRight = Facing.RIGHT;
		}
	}
}
