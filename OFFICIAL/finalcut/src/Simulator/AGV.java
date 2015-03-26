package Simulator;
/**
 * 
 * @author Sim Hong Xun
 *
 */
public class AGV extends Vehicle{
	private static final Constant constant = Constant.getInstance();
	
	AGV(){
		super();
		acceleration = constant.AgvAccSpd;
		decceleration = constant.AgvDecSpd;
		maxspeed = constant.AgvSpd;
		timegap = constant.AgvTimeGap;
		distgap = constant.AgvDistGap;
	}
}
