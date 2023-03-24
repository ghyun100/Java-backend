package trainReservation;

import java.util.Scanner;

import trainReservation.controller.ReservationController;

public class MainApplication {

	private static ReservationController reservationController = new ReservationController();

	public static void main(String[] args) {
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String endPoint = scanner.nextLine();
			
			if (endPoint.equals("POST /reservation")) {// 열차있는지 보여주는거
			reservationController.reservation();
			}
			if (endPoint.equals("GET /reservation")) {// 열차예약하는거
			reservationController.getReservation();
			}
			
			
		}
	
	}

}
