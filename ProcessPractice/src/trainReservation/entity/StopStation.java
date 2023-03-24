package trainReservation.entity;

// 정차역 Entity class
public class StopStation {
	private String stationName; // 역명
	private String departureTime; // 출발시간
	private String arrivalTime; // 도착시간

	public StopStation() {
	}

	public StopStation(String staionName, String arrivalTime, String departureTime) {
		this.stationName = staionName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getStationName() {
		return this.stationName;
	}

	public String getDepartureTime() {
		return this.departureTime;
	}

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	@Override
	public String toString() {
		return "StopStation [staionName=" + stationName + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
