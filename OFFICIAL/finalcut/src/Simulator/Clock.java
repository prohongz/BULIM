package Simulator;

public class Clock {
	private static final Constant constant = Constant.getInstance();
	
	static double time = 0.;
	double endtime = 0.;
	static int day=0, hour=0, min=0, sec=0;
	
	Clock(){
		day=0;
		hour=0;
		min=0;
		sec=0;
	}
	
	public static void clockupdate() {
		// TODO Auto-generated method stub

		min = (int) (time / 60.0);
		sec = (int) (time - min * 60.0);
		
		hour = (int) (min / 60.0);
		min = (int) (min - hour * 60.0);
		
		day = (int) (hour / 24.0);
		hour = (int) (hour - day * 24.0);
	}
	
	public static int returnhour(){
		return hour;
	}
	
	public static int returnminute(){
		return min;
	}
	
	public static double calendtime() {
		double temp = (constant.endday * 24 * 60 * 60) + (constant.endhour * 60 * 60);
		
		return temp;
	}
}
