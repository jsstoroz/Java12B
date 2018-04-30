/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a Bird objects called Hummingbird, 
which inherits from the AbstractBird abstract class and implements the bird interface. 
It accesses the Facing enum to keep track of which direction the bird is facing.
The Hummingbird moves randomly.
Bugs: None.
*/

import java.awt.*;
import java.util.*;

public class Hummingbird extends AbstractBird implements Bird{

	//constructor creates new Hummingbird object at Point x,y
	public Hummingbird(int x, int y) {
		super(x, y);
	}

	@Override
	//getColor returns color of the hummingbird, magenta
	public Color getColor() {
		return Color.MAGENTA;
	}

	@Override
	//fly moves the hummingbird randomly to x and y coordinates in the aviary
	public void fly() {
		Point position = this.getPosition();
		Random rand = new Random();
		int randX = rand.nextInt(20);
		int randY = rand.nextInt(20);
		position.setLocation(randX, randY);
	}

}
