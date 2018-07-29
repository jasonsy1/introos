package LocksAndMonitors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import GUI.GUI;

public class Station{
	private int stationLocation;
	Lock lock;
	int waiting_passengers;
	GUI gui;
	
	public Station(int stationLoc, GUI gui) {
		this.stationLocation = stationLoc;
		lock = new ReentrantLock();
		waiting_passengers = 0;
		this.gui = gui;
	}
	
	public synchronized void station_load_train() {
		if (waiting_passengers == 0){
			gui.appendConsole("GUARD UPDATE: No Waiting Passengers");
			gui.appendConsole("Train departs at Station " + (stationLocation+1));
		} else {
			gui.appendConsole("GUARD UPDATE: Waiting passengers count: " + waiting_passengers);
			notifyAll();
		}
	}
	
	public synchronized void station_wait_for_train() {
		lock.lock();
			waiting_passengers++;
			gui.updateStation(stationLocation, waiting_passengers);
		lock.unlock();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		station_on_board();
		
	}
	
	public void station_on_board() {		
		lock.lock();
			waiting_passengers--;
			gui.updateStation(stationLocation, waiting_passengers);
			if (Train.seats == 0) { // if no more seats, wait again
				lock.unlock();
				station_wait_for_train();
				gui.appendConsole("Train departs at Station " + (stationLocation+1));
			} else {
				Train.seats--;
				gui.updateTrain(Train.seats);
				gui.appendConsole("GUARD UPDATE: One waiting passenger boarded the train");
				gui.appendConsole("GUARD UPDATE: Number of passengers waiting at Station " + (stationLocation+1) + ": " + waiting_passengers);
				gui.appendConsole("GUARD UPDATE: Train available seats: " + Train.seats);
			}			
		lock.unlock();
	}
}
