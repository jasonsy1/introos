package introos;

public class Train {
	
	int trainNum;
	int currPassengerNum;
	int stationNum;
	
	public Train(int trainNum, int currPassengerNum) {
		this.trainNum = trainNum;
		this.currPassengerNum = currPassengerNum;
	}

	public int getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}

	public int getCurrPassengerNum() {
		return currPassengerNum;
	}

	public void setCurrPassengerNum(int currPassengerNum) {
		this.currPassengerNum = currPassengerNum;
	}

	public int getStationNum() {
		return stationNum;
	}

	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	

	
}
