package introos;

import java.util.ArrayList;

public class Station {
	
	int stationNum;
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	Train currTrainNum;
	
	
	public Station(int stationNum, ArrayList<Passenger> passengers, Train currTrainNum) {
		this.stationNum = stationNum;
		this.passengers = passengers;
		this.currTrainNum = currTrainNum;
	}


	public int getStationNum() {
		return stationNum;
	}


	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}


	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


	public Train getCurrTrainNum() {
		return currTrainNum;
	}


	public void setCurrTrainNum(Train currTrainNum) {
		this.currTrainNum = currTrainNum;
	}
	
	

}
