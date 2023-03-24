package trainReservation.entity;

// 남아있는 좌석 Entity class
public class Seat {
	private int roomNumber; // 호차
	private String seatNumber; // 좌석번호
	private boolean seatStatus; // 좌석상태

	public Seat() {
	}

	public Seat(int roomNumber, String seatNumber, boolean seatStatus) {
		this.roomNumber = roomNumber;
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public String getSeatNumber() {
		return this.seatNumber;
	}

	public boolean isSeatStatus() { // boolean형태라서 is라고 바뀜
		return this.seatStatus;
	}

	public void setSeatStatus(boolean seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "Seat [roomNumber=" + roomNumber + ", seatNumber=" + seatNumber + ", seatStatus=" + seatStatus + "]";
	}

}
