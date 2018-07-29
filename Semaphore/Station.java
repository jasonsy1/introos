package Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import GUI.GUI;

public class Station{
	private int stationLocation;
	Lock lock;
	int waiting_passengers;
	Semaphore mutex;
	GUI gui;
	
	public Station(int stationLoc, GUI gui) {
		this.stationLocation = stationLoc;
		lock = new ReentrantLock();
		waiting_passengers = 0;
		mutex = new Semaphore(1);
		this.gui = gui;
	}
	
	public synchronized void station_load_train() {
		if (waiting_passengers == 0){
			gui.appendConsole("GUARD UPDATE: No waiting passengers");
		} else {
			gui.appendConsole("GUARD UPDATE: Waiting passengers count: " + waiting_passengers);
			notifyAll();
		}
	}
	
	public synchronized void station_wait_for_train() {
		
		try {
			mutex.acquire();
			waiting_passengers++;
			gui.updateStation(stationLocation, waiting_passengers);
			gui.appendConsole("Waiting Passengers in Station " + (stationLocation+1) + ": " + waiting_passengers);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			mutex.release();
		}
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		station_on_board();
		
	}
	
	public void station_on_board() {		
		try {
			mutex.acquire();
			waiting_passengers--;
			gui.updateStation(stationLocation, waiting_passengers);
			if (Train.availableSeats.availablePermits() == 0) { // if no more seats, wait again
				mutex.release();
				station_wait_for_train();
				gui.appendConsole("Train departs at Station " + (stationLocation+1));
			} else {
				try {
					Train.availableSeats.acquire();
					gui.updateTrain(Train.availableSeats.availablePermits());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gui.appendConsole("GUARD UPDATE: One waiting passenger boarded the train");
				gui.appendConsole("Number of passengers waiting at Station " + (stationLocation+1) + ": " + waiting_passengers);
				gui.appendConsole("Train available seats: " + Train.availableSeats.availablePermits());
			}			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			mutex.release();
		}
	}
}