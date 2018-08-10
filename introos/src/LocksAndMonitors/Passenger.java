package LocksAndMonitors;

public class Passenger implements Runnable {
	Station fromStation,toStation;
	
	public Passenger(Station fromStation,Station toStation) {
		this.fromStation = fromStation;
                this.toStation = toStation;
	}
	
	public synchronized void run() {
		fromStation.station_wait_for_train();
	}
}
