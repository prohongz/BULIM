package Simulator;
/**
 * 
 * @author Sim Hong Xun
 *
 */
public class Truck extends Vehicle{
	private static final Constant constant = Constant.getInstance();
	
	Truck(){
		super();
		acceleration = constant.TruckAccSpd;
		decceleration = constant.TruckDecSpd;
		maxspeed = constant.TruckSpd;
		timegap = constant.TruckTimeGap;
		distgap = constant.TruckDistGap;
	}

}
