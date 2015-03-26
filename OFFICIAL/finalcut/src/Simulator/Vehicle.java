package Simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
/**
 * 
 * @author Sim Hong Xun
 *
 */
@SuppressWarnings("unused")
public class Vehicle {
	private static final Constant constant = Constant.getInstance();

	Point position = new Point(180,440);
	private boolean cargo = false;
	
	private double loadingclock = .0;
	//Time in which vehicle enter loading bay
	
	private int PreviousPhase = 0;
	private int Phase = 0;
	/*
	Phase 0: Idle
	Phase 1: Driving to factory empty (to pick up cargo)
	Phase 2: Driving to CDC w cargo
	Phase 3: Driving to factory w cargo
	Phase 4: Driving to CDC empty
	Phase 5: Driving to CDC on order
	phase 6: Loading/Unloading
	*/
	
	private int destination = 100;
	/*
	CDC = 100
	Factory = [0,29]
	No destination = 99
	 */
	
	private double fuel = .0;
	
	private int lane = 0;
	private int zone = 1;
	private double theta = 0;
	
	protected double acceleration = 0;
	protected double decceleration = 0;
	protected double maxspeed = 0;
	protected double timegap = 0;
	protected double distgap = 0;
	private double velocity = 0;
	
	private int bay = 0;
	
	
	
	
	Vehicle(){
		position = new Point(180,440);
		cargo = false;
		loadingclock = .0;
		Phase = 0;
		destination = 100;
		lane = 0;
		zone = 1;
		theta = 0;
		
		acceleration = 0;
		decceleration = 0;
		maxspeed = 0;
		timegap = 0;
		distgap = 0;
		velocity = 0;
		
		bay = 0;
	}

	void setbay(int i){
		bay = i;
	}
	
	int setbay(){
		return bay;
	}
	
	double returnvelo(){
		return velocity;
	}
	
	void accelerate(){
		velocity = velocity + acceleration*constant.TIMESTEP_S;
		if(velocity >= maxspeed){
			velocity = maxspeed;
		}
	}
	
	double calcdistance(){
		double distance; // return in pixels
		distance = velocity*constant.TIMESTEP_S;
		
		return distance*constant.scale;
	}
	
	void move(double distance, int destination){
		
		while(distance != 0)
		{
			//System.out.println(distance);
			if(zone == 1){
				
				if((position.y + distance) >=588){
					theta = 0;
					zone = 2;
					distance = (position.y + distance)- 588;
				}else{
					theta = 0;
					zone = 1;
					position.x = 180;
					position.y += distance;
					distance = 0;
					//System.out.println("HERE");
				}
			}
			
			if(zone == 2){
				if(((distance/40)+theta) >= Math.PI){
					theta = Math.PI;
					zone = 3;
					distance = distance - (0.25*Math.PI* 40);
					position.y = 553;
					System.out.println("Going into 3");
				}else{
					theta  =  theta + (distance/40);
					//System.out.println(theta);
					zone = 2;

					position.x =(int) (140+  40 * Math.cos((theta)));
					position.y =(int) (588+  40 * Math.sin((theta)));
					distance = 0;
				}	
			}
			
			if(zone == 3){
				if((position.y - distance) <=155){
					theta = Math.PI;
					zone = 4;
					distance = 155 - (position.y - distance);
				}else{
					theta = Math.PI;
					zone = 3;
					position.x = 100;
					position.y -= distance;
					distance = 0;
				}
			}
			
			if(zone == 4){
				if((distance/100)+theta >= 1.5*Math.PI){
					theta = 1.5*Math.PI;
					zone = 5;
//					distance = distance - (0.25*Math.PI* 100);
					distance = distance - ((1.5*Math.PI -theta)* 100);
				}else{
					theta  =  theta + (distance/100);
					zone = 4;
					
					position.x =(int) (200-   100 * Math.cos(theta - Math.PI));
					position.y =(int) (155-    100 * Math.sin(theta - Math.PI));
					distance = 0;
				}	
			}
			
			if(zone == 5){
				if((position.x + distance) >=850){
					theta = 1.5*Math.PI;
					zone = 6;
					distance = 850 - (position.x + distance);
				}else{
					theta = 1.5*Math.PI;
					zone = 5;
					if(((position.x+distance) >= Central.factorylocation[destination].x) && (position.y == Central.factorylocation[destination].y)){
						position.x = Central.factorylocation[destination].x;
					}else{
						position.x += distance;
					}
					position.y = 55;
					distance = 0;
				}
			}
			
			if(zone == 6){
				if((distance/40)+theta >= 2.5*Math.PI){
					theta = 0.5*Math.PI;
					zone = 7;
					distance = distance - ((0.5*Math.PI - theta)* 40);
				}else{
					theta  =  theta + (distance/40);
					zone = 6;
					
					position.x =(int) (850+   40 * Math.cos(theta));
					position.y =(int) (95+    40 * Math.sin(theta));
					distance = 0;
				}		
			}
			
			if(zone == 7){
				if((position.x - distance) <=200){
					theta = 0.5*Math.PI;
					zone = 8;
					distance = 200 - (position.x - distance);
				}else{
					theta = 0.5*Math.PI;
					zone = 7;
					if(((position.x-distance) <= Central.factorylocation[destination].x) && (position.y == Central.factorylocation[destination].y)){
						position.x = Central.factorylocation[destination].x;
					}else{
						position.x -= distance;
					}
					position.y = 135;
					distance = 0;
				}
			}
			
			if(zone == 8){
				if(theta-(distance/20) <= 0){
					theta=0;
					zone = 1;
					distance = distance - (theta * 20);
				}else{
					theta  =  theta - (distance/20);
					zone = 8;
					
					position.x =(int) (200-   20 * Math.cos(theta));
					position.y =(int) (155-    20 * Math.sin(theta));
					distance = 0;
				}	
			}
		}

	}
	
	void setcargo(boolean bool){
		cargo = bool;
	}
	
	double getpositionx(){
		return position.getX();
	}
	
	double getpositiony(){
		return position.getY();
	}
	
	void addfuel(double x){
		fuel = fuel + x;
	}
	
	double getfuel(){
		return fuel;
	}
	
	void setlane(int i){
		lane= i;
	}
	
	int getlane(){
		return lane;
	}
	
	void setzone(int i){
		Phase = i;
	}
	
	int getzone(){
		return zone;
	}
	
	void setphase(int i){
		Phase = i;
	}
	
	int getphase(){
		return Phase;
	}
	
	void setpreviousphase(int i){
		PreviousPhase = i;
	}
	
	int getpreviousphase(){
		return PreviousPhase;
	}
	
	void setdestination(int i){
		destination = i;
	}
	
	int getdestination(){
		return destination;
	}
	
	int calculatedisttocdc(){
		int distance = 0;
		
		if(zone ==5){
				distance = (int) ((850-position.x) + ((2*Math.PI*findradius(6))/2) + 650 + ((2*Math.PI*findradius(8))/4) + 285);
		}
		
		if(zone ==6){
				distance = (int) (((2*Math.PI*findradius(6))/2)*((theta-((3/2)*Math.PI))/Math.PI) + 650 + ((2*Math.PI*findradius(8))/4) + 285);
		}
		
		if(zone ==7){
				distance = (int) ((position.x-200) + ((2*Math.PI*19)/4) + 285);
		}
		
		if(zone ==8){
				distance = (int) (((2*Math.PI*findradius(8))/4)*((Math.PI/2)-theta) + 285);
		}
		
		if(zone ==1){
				distance = (int) (440-position.y);
		}
		
		return distance;
	}
	
	int calculatedisttofact(int target){
		int distance = 0;
		
		
		if(target<15){
			if(zone ==5){
				distance = (int) (position.x - (220+(target*43)));
			}
			
			if(zone ==6){
				distance = -1;
			}
			
			if(zone ==7){
				distance = -1;
			}
			
			if(zone ==8){
				distance = -1;
			}
			
			if(zone ==1){
				distance = -1;
			}
		}
		if(target>=15){
			if(zone ==5){
				distance = -1;
			}
			
			if(zone ==6){
				distance = (int) (((2*Math.PI*findradius(6))/2)*((theta-((3/2)*Math.PI))/Math.PI) + (822-((target-15)*43)));
			}
			
			if(zone ==7){
				distance = (int) (position.x - (822-((target-15)*43)));
			}
			
			if(zone ==8){
				distance = -1;
			}
			
			if(zone ==1){
				distance = -1;
			}
		}
		
		
		return distance;
		
	}
	
	double findradius(int zone){
		double radius = 0;
		if(zone == 6){
			radius = Math.sqrt( (position.x - 850)^2 + (position.y - 96)^2 );
		}
		if(zone == 8){
			radius = Math.sqrt( (position.x - 200)^2 + (position.y - 155)^2 );
		}
		return radius;
	}
	//FOR SETTING WAITING TIME 
	void setloadingclock(double time, char type){
		if(type == 'c'){
			loadingclock = time + (constant.CDCcargoturnover * 60);
		}
		if(type == 'f'){
			loadingclock = time + (constant.Factcargoturnover * 60);
		}
	}
		
	double getloadingclock(){
		return loadingclock;
	}
	
	//FOR DRAWING THE TRUCK AND AGV IMAGE
	void drawupdate(Graphics g, char type){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		BufferedImage image = null;
		try {
			if (type == 't') {
				if (cargo == false) {
					image = ImageIO.read(new File("src/misc/Truck.gif"));
				}
				if (cargo == true) {
					image = ImageIO.read(new File("src/misc/Truckloaded.gif"));
				}
			}
			if (type == 'a') {
				if (cargo == false) {
					image = ImageIO.read(new File("src/misc/AGV.gif"));
				}
				if (cargo == true) {
					image = ImageIO.read(new File("src/misc/AGVloaded.gif"));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AffineTransform at = new AffineTransform();

		at.translate(position.x, position.y);
		at.rotate(theta);
		at.translate(-image.getWidth() / 4, -image.getHeight() / 2);
		at.scale(0.5, 0.5);
		g2.drawImage(image, at, null);
		

	}
	
}
