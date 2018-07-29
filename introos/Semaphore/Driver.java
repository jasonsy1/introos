package Semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import GUI.GUI;

public class Driver {
	public static final int seats = 10;
	public static final int maxStation = 4;
	static ArrayList<Station> stations = new ArrayList<Station>();
	static Thread train;
	static int currLocation = -1;
	static Semaphore availableSeats;
	static GUI gui;
	
	public static void start(GUI gui){	
		Driver.gui = gui;
		station_init();
		boot();
	}
	
	public static void station_init(){
		availableSeats = new Semaphore(seats, true);
		
		for(int i=0; i < maxStation; i++) {
			stations.add(new Station(i, gui));
		}
		
		train = new Thread(new Train(stations, availableSeats, gui));
	}
	
	public synchronized static void boot() {
		train.start();
	}
	
	public synchronized static void addPassenger(int x) {
		Thread passenger = new Thread(new Passenger(stations.get(x)));
		passenger.start();
	}
}


