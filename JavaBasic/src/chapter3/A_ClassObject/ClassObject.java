package chapter3.A_ClassObject;

import java.awt.image.SampleModel;

// class
// 객체를 정의해 놓은 것
// 객체를 생성하는 기반
// 객체를 정의하는 틀 또는 설계도

// 클래스는 객체의 상태를 나타내는 필드와 객체의 행동을 나타내는 메소드로 구성됨
// 필드: 클래스에 포함된 변수 또는 상수
// 메서드: 어떠한 특정 작업을 수행하기 위한 명령문의 집합

// object
// 실제로 존재하는 모든 것들 
// 클래스로 생성된 실체

// 클래스로 생성된 각각의 객체는 독립적으로 존재함
// 같은 클래스로 생성된 객체라 하더라도 
// 각각이 가지고 있는 '속성 값'은 다를 수 있음(일반적으로 다름)

// 클래스 선언 방법
// class 클래스명 { 속성1, 속성2, ... , 기능1, 기능2, ...}
// 속성: 변수, 특성, 필드, 상태
// 기능: 메서드, 함수, 행위

// 클래스 명은 UpperCamelCase 명명 규칙을 따름
class SmartPhone {
	// 기종
	String modelName;
	// 색상
	String color;
	// 메모리
	int memory;
	// 전화번호
	String telNumber;
	// 전원
	boolean power;
	
	// 전화걸기
	void call(String toTellNumber) {
		System.out.println(toTellNumber + "로 전화를 겁니다.");
	}
	// 영상시청
	void showVideo() {
		System.out.println("영상을 시청합니다.");
	}
	// 메세지
	void sendMessage(String message, String toTelNumber) {
		System.out.println(toTelNumber + "로 " + message +"를 보냅니다.");
	}
	// 전원키고 끄기
	void setPower() {
		power = !power;
	}
	
	
}
public class ClassObject {


	public static void main(String[] args) {
		// 인스턴스
		// 특정 클래스로 생성된 객체를 인스턴스라 라고 함
		// 클래스로 객체를 생성하는 행위를 '인스턴스화'라고 함
		
		// 인스턴스 선언 방법
		// 클래스명 참조변수명(인스턴스명)
	
		SmartPhone iphone14;
		
		// 인스턴스 생성 방법
		// 참조변수명 = new 클래스명();
		iphone14 = new SmartPhone();
		SmartPhone iphone14Pro = new SmartPhone();
		
		
		System.out.println(iphone14);
		System.out.println(iphone14Pro);
		
		
		// 인스턴스의 속성 접근 및 기능 사용(속성값초기화가능)
		// 속성 사용: 참조변수.멤버변수;
		// 기능 사용: 참조변수.메서드(매개변수);
		iphone14.modelName = "IPHONE";
		iphone14.color = "black";
		iphone14.memory = 512;
		iphone14.telNumber = "010-111-1111";
		iphone14.power = false;
		
		System.out.println(iphone14.modelName);
		System.out.println(iphone14.telNumber);
		
		System.out.println(iphone14Pro.modelName);
		System.out.println(iphone14Pro.memory);
		System.out.println(iphone14Pro.power);
		// -인스턴스에서만 int, boolean과 같은 기본형 데이터 타입은
		// 모두 0이 들어가 있음(0 또는 false)
		// -인스턴스에서만 String은 참조형 데이터 타입이고 
		// 주소를 지정하지 않아서 null이 출력
		
		iphone14.call("010-2222-2222");
		iphone14.showVideo();
		System.out.println(iphone14.power);
		iphone14.setPower();
		System.out.println(iphone14.power);
		
		
		iphone14Pro = iphone14;
		// (주소를 넘겨줌 iphone14Pro를 바꾸면 iphone14도 바뀜)
		iphone14Pro.telNumber = "010-9999-9999";
		System.out.println(iphone14.telNumber);
		
		
		
		// 객체배열
		// 클래스명[] 객체배열명 = new 클래스명[길이];
		SmartPhone[] smartPhoneList = new SmartPhone[3];
		
		smartPhoneList[0] = iphone14;
		smartPhoneList[1] = iphone14Pro;
		smartPhoneList[2] = new SmartPhone();
		
//		SmartPhone smartPhone =new SmartPhone();(세개가 같은주소)
		for (int index = 0; index < smartPhoneList.length; index++) {
			SmartPhone smartPhone = new SmartPhone();//(세개가 다른 주소)
			smartPhone.telNumber = "010-1111-111" + index;
			smartPhoneList[index] =smartPhone;
		}
		
		for ( SmartPhone phone: smartPhoneList) {
			System.out.println(phone.telNumber);
		}	

	}

}

