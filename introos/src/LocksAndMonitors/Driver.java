package LocksAndMonitors;

import java.util.ArrayList;
import GUI.GUI;

public class Driver {
	public static final int seats = 10;
	public static final int maxStation = 8;
	static ArrayList<Station> stations = new ArrayList<Station>();
	static Thread train;
	static int currLocation = -1;
	static GUI gui;
	
	public static void start (GUI gui){
		Driver.gui = gui;
		station_init();
		boot();
	}
	
	public static void station_init(){
		for(int i=0; i < maxStation; i++) {
			stations.add(new Station(i, gui));
		}
		
		train = new Thread(new Train(stations, seats, gui));
	}
	
	public synchronized static void boot() {
		train.start();
	}
	
	public synchronized static void addPassenger(int x) {
		Thread passenger = new Thread(new Passenger(stations.get(x)));
		passenger.start();
	}
	
}
