package Simulator;

import java.awt.Point;

/**
 * 
 * @author Sim Hong Xun
 *
 */
public class Factory extends Building{

	private int factorynumber = 0;
	
	
	Factory(int number, int x, int y){
		super();
		factorynumber = number;
		setlocation(new Point(x,y));
	}
	
	public int getfactorynumber(){
		return factorynumber;
	}
}
