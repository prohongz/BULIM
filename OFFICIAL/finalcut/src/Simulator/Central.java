package Simulator;

import java.awt.Point;
import java.util.Random;

/**CENTRAL CLASS ACTS LIKE A HEADQUARTER CONTAIN ALL THE INFORMATION FOR VEHICLES, FACTORIES, CDC
 * 
 * @author Sim Hong Xun
 * 
 * */

public class Central {
	private static final Constant constant = Constant.getInstance();

	//MAIN PLOT
	public static int cdcdemandcount = 0;
	public static int[] factdemandcount = new int[30];
	
	public static int cdcprioritycount = 0;
	public static int[] factprioritycount = new int[30];
	
	public static int cdcdemandcountx = 0;
	public static int[] factdemandcountx = new int[30];
	
	public static int cdcprioritycountx = 0;
	public static int[] factprioritycountx = new int[30];
	
	public static int cdcoverload = 0;
	public static int factoverload = 0;
	
	public static int[][] factdock = new int[30][constant.Factbay];
	public static int[] cdcdock = new int[constant.CDCbay];
	
	//REAL TIME PLOT
	public static int truckactive = 0;
	public static int truckinactive = constant.TruckQty;
	
	public static int agvactive = 0;
	public static int agvinactive = constant.AgvQty;
	
	public static int cdccargoserve = 0;
	public static int cdccargounserve = 0;
	
	public static int factcargoserve = 0;
	public static int factcargounserve = 0;
	
	public static int totalcargoserve = 0;
	public static int totalcargounserve = 0;
	
	public static double totalfuel = 0;
	
	public static int[] trucklocation = new int[constant.TruckQty];
	public static int[] agvlocation = new int[constant.AgvQty];
	
	public static int[] factdistance = new int [30];
	
	public static Point[] factorylocation = {
		new Point (220,55),
		new Point (263,55),
		new Point (306,55),
		new Point (349,55),
		new Point (392,55),
		new Point (435,55),
		new Point (478,55),
		new Point (521,55),
		new Point (564,55),
		new Point (607,55),
		new Point (650,55),
		new Point (693,55),
		new Point (736,55),
		new Point (779,55),
		new Point (822,55),
		new Point (822,135),
		new Point (779,135),
		new Point (736,135),
		new Point (693,135),
		new Point (650,135),
		new Point (607,135),
		new Point (564,135),
		new Point (521,135),
		new Point (478,135),
		new Point (435,135),
		new Point (392,135),
		new Point (349,135),
		new Point (306,135),
		new Point (263,135),
		new Point (220,135),
		new Point (180,440)
	};
	
	public Central(){
		
	}
	
	//FOR CDC
	static int spawnfactdemand(){
		Random randomgen = new Random();
		int factorynumber = randomgen.nextInt(30);
		return factorynumber;
	}
	
	static int spawndemandtarget(){
		Random randomgen = new Random();
		int factorynumber = randomgen.nextInt(30);
		return factorynumber;
	}
	
	//FOR CDC AND FACTORY
	static int spawndemandtime(){
		Random randomgen = new Random();
		int demandtime = randomgen.nextInt(60);
		return demandtime;
	}
}
