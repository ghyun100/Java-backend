package trainReservation.entity;

import java.util.List;

// 기차 정보 Entity class
public class Train {
	private String trainNumber; // 열차번호
	private String departureStation; // 출발역
	private String arrivalStation; // 도착역
	private String departureTime; // 출발시간
	private String arrivalTime; // 도착시간
	private int takeMinute; // 정차시간
	private String type; // 기차종류
	private List<StopStation> stopStations;
	private List<Seat> seats;

	public Train() {
	}

	public Train(String trainNumber, String departureStation, String departureTime, String arrivalStation,
			String arrivalTime, int takeMinute, String type, List<StopStation> stopStations, List<Seat> seats) {
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.takeMinute = takeMinute;
		this.type = type;
		this.stopStations = stopStations;
		this.seats = seats;
	}

	public String getTrainNumber() {
		return this.trainNumber;
	}

	public String getDepartureStation() {
		return this.departureStation;
	}

	public String getArrivalStation() {
		return this.arrivalStation;
	}

	public String getDepartureTime() {
		return this.departureTime;
	}

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public int getTakeMinute() {
		return this.takeMinute;
	}

	public String getType() {
		return this.type;
	}

	public List<StopStation> getStopStations() {
		return this.stopStations;
	}

	public List<Seat> getSeats() {
		return this.seats;
	}

	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", departureStation=" + departureStation + ", arrivalStation="
				+ arrivalStation + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", takeMinute="
				+ takeMinute + ", type=" + type + ", stopStations=" + stopStations + ", seats=" + seats + "]";
	}

}
