package trainReservation.entity;

// 비용 Entity class
public class Cost {
	private String departureStation; // 출발역
	private String arrivalStation; // 도착역
	private int amount; // 금액

	public Cost() {
	}

	public Cost(String departureStation, String arrivalStation, int amount) {
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.amount = amount;
	}

	public String getDepratureStation() {
		return this.departureStation;
	}

	public String getArrivalStation() {
		return this.arrivalStation;
	}

	public int getAmount() {
		return this.amount;
	}

	public String toString() { // toString 오버라이드 한거
		return "Cost[departureStation: " + this.departureStation + ", arrivalStation" + this.arrivalStation
				+ ", amount: " + this.amount + "]";
	}

}
