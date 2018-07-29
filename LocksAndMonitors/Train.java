package LocksAndMonitors;

import java.util.ArrayList;
import java.util.Scanner;

import GUI.*;

public class Train implements Runnable {
	ArrayList<Station> stations;
	static int seats;
	static int currLocation = -1;
	GUI gui;
	 
	 Scanner read = new Scanner(System.in);
	 
	 public Train(ArrayList<Station> stations, int seats, GUI gui){
		 this.stations = stations;
		 Train.seats = seats;
		 this.gui = gui;
	 }
	 
	 public void run() {
		 int i;
		 
		 while(true) {
			 i = 0;
			 
		 	while(i < stations.size()) {
		 		
		 		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		
		 		switch(i) {
		 		case 0: gui.goStation1(); break;
		 		case 1: gui.goStation2(); break;
		 		case 2: gui.goStation3(); break;
		 		case 3: gui.goStation4(); break;
		 		}
		 		
		 		currLocation = i;
	 			gui.appendConsole("Train arrives at Station " + (i+1));
		 		stations.get(i).station_load_train();
		 		i++;
		 		
		 		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
		 	
		 	train_destination();
		 }
	 }
	 
	 public void train_destination() {
		 gui.appendConsole("Train arrived at its Destination");
		 gui.appendConsole("Unloading all passengers");
		 gui.appendConsole("Seats available: 10");
		 gui.goToDestination();
		 gui.updateTrain(10);
		 Train.seats = 10;
	 }
}
