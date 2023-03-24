package chapter3.B_VariableMethod;

// 클래스에서의 변수
// 인스턴스변수: 각각의 인스턴스마다 고유하게 가지고 있어야하는 속성을 지정할 때 사용
// 클래스변수: 해당 클래스로 만들어진 모든 인스턴스가 
// 동일하게 가지고 있어야하는 속성을 지정할 때 사용(= 스태틱변수)
// 지역변수: 메서드 내에서 선언된 변수 (인스턴스변수와 클래스 변수는 전역변수)
//클래스 메소드 (static메소드)
//static 키워드를 사용하여 선언되며 클래스의 개체를 만들 필요 없이 
//class 이름을 통해 바로 호출 할 수 있다
class GalaxyPhone {
	// 인스턴스변수: 인스턴스마다 고유하게 가지고 있는 속성
	// 인스턴스변수는 인스턴스가 생성된 후에 사용가능
	String model;
	String owner;
	String telNumber;
	// 클래스변수: 해당 클래스로 생성된 모든 인스턴스가 동일하게 가지고 있는 속성
	// static 데이터타입 변수명;
	// 클래스변수는 인스턴스 생성없이 클래스로 사용가능(인스턴스로도 사용가능)
	static String maker = "SAMSUNG";
	
}

class MonitorSize {
	static final int HEIGHT = 1080;
	static final int WIDTH = 1920;
	
}
public class VariableMethod {
	// VariableMethod 클래스의 전역변수
	int number = 10;
	
	int size = MonitorSize.HEIGHT * MonitorSize.WIDTH;
	public static void main(String[] args) {
		// void는 반환하는 타입이 없다는 뜻
		// main 메서드의 지역변수
		double decimal = 10.0;
		
		
		GalaxyPhone myS23 = new GalaxyPhone();
		myS23.model = "S23";
		myS23.owner = "백가현";
		myS23.telNumber = "010-1111-1111";
		
		GalaxyPhone myS22 = new GalaxyPhone();
		myS22.model = "S22";
		myS22.owner = "백가현";
		myS22.telNumber = "010-2222-2222";
		
		System.out.println(myS23.telNumber);
		System.out.println(myS22.telNumber);
		
		myS23.maker = "SAMSUNG";
		
		System.out.println(myS23.maker);
		System.out.println(myS22.maker);
		System.out.println(GalaxyPhone.maker);// 이렇게 쓰면 maker에 노란줄 안뜸
		
		
	}

}
