/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This abstract creates stores all the methods common to all birds. 
Bugs: None.
*/
import java.awt.*;

public abstract class AbstractBird implements Bird{
	protected Color color;
	protected Point position;
	protected int x;
	protected int y;
	
	public AbstractBird(int x, int y){
		this.setPosition(x, y);
	}
	
	public abstract Color getColor();
	
	public Point setPosition(int x, int y){
		position = new Point(x, y);
		return position;
	}
	
	public Point getPosition(){
		return position;
	}

	public abstract void fly();

}
