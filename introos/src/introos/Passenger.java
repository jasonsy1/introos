package introos;


public class Passenger {
	
	String name;
	Station startStation;
	Station endStation;
	
	public Passenger(String name, Station startStation, Station endStation) {
		this.name = name;
		this.startStation = startStation;
		this.endStation = endStation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}

	public Station getEndStation() {
		return endStation;
	}

	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}
	
	

}
