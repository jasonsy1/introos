package Semaphore;

public class Passenger implements Runnable {
	Station station;
	
	public Passenger(Station station) {
		this.station = station;
	}
	
	public synchronized void run() {
		station.station_wait_for_train();
	}
}