package Simulator;

import java.io.Serializable;

/**Constant is used to store intermediate values between the transition from Preset interface to Simulator interface.
 * 
 * @author Sim Hong Xun
 *
 */
public class Constant {
	private static Constant constant = new Constant();
	public static Constant getInstance() {
		return constant;
	}
	public static void setInstance(Constant constant) {
		Constant.constant = constant;
	}

	public int starthour =0;
	public int startminute =0;
	
	public int endday =0;
	
	public int endhour =0;
	public int endminute =0;
	
	public double fuelcost = .0;
	
	public int CDCstarth =0;
	public int CDCstartm =0;
	public int CDCendh =0;
	public int CDCendm =0;
	public int CDCcargoturnover = 0;
	public int CDCcargolimit = 0;
	public int CDCbay =0;
	public int CDCdemandh[] = new int[15];
	
	
	public int Factstarth =0;
	public int Factstartm =0;
	public int Factendh =0;
	public int Factendm =0;
	public int Factcargoturnover =0;
	public int Factcargolimit = 0;
	public int Factbay =0;
	public int Factdemandh[] = new int[15];
	
	
	public boolean Truckpriority = false;
	
	public boolean TruckMode = false;
	public int TruckQty = 0;
	public double TruckSpd = .0;
	public double TruckAccSpd = .0;
	public double TruckDecSpd = .0;
	public double TruckTimeGap = .0;
	public double TruckDistGap = .0;
	public double TruckPoliteness = .0;
	public double TruckChanging = .0;
	public double Truckfewcargo = .0;
	public double Truckfewocargo = .0;
	
	public boolean AgvMode = false;
	public int AgvQty = 0;
	public double AgvSpd = .0;
	public double AgvAccSpd = .0;
	public double AgvDecSpd = .0;
	public double AgvTimeGap = .0;
	public double AgvDistGap = .0;
	public double Agvfewcargo = .0;
	public double Agvfewocargo = .0;
	
	static final double TIMESTEP_S = 0.2;   // simulation time step
	public int tsleep_ms = 20;
	
	static final double scale = 0.43;
	
	static boolean suspended = false;	
}
