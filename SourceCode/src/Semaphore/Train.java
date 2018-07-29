package Semaphore;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import GUI.GUI;

public class Train implements Runnable{
	ArrayList<Station> stations;
	static Semaphore availableSeats;
	static int currLocation = -1;
	GUI gui;
	
	Scanner read = new Scanner(System.in);
	
	 public Train(ArrayList<Station> stations, Semaphore availableSeats, GUI gui){
		 this.stations = stations;
		 Train.availableSeats = availableSeats;
		 this.gui = gui;
	 }
	 
	 public void run() {
		 int i;
		 
		 while(true) {
			 i = 0;
		 	while(i < stations.size()) {
		 		
		 		try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		
		 		switch(i) {
		 		case 0: gui.goStation1(); break;
		 		case 1: gui.goStation2(); break;
		 		case 2: gui.goStation3(); break;
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
		 Train.availableSeats.release(Driver.seats-Train.availableSeats.availablePermits());
	 }
}
