package chapter3.E_Inheritance;

// 상속
// 기존 클래스를 재사용해서 새로운 클래스를 작성하는 것
// 코드의 재사용성을 높이고 코드의 중복을 제거 -> 생산성이 향상, 유지보수성이 향상

// 사용 방법:
// class 클래스명 extends 조상클래스 { ...}

class Human {
	String name;
	int age;
	String telNumber;
	String country;
	
	Human() {}
	
	Human(String name, int age) {
		this.name = name;
		this.age = age;
		this.telNumber = "010-1111-2222";
		this.country = "Korea";
	}
	
	void eat(String food) {
		System.out.println(this.name + "가 " + food + "를 먹습니다.");
	}
}

// Develop 클래스는 Human의 속성과 기능을 모두 사용 가능
class Developer extends Human {
	String position;
	String language;
	
	Developer() {}
	
	Developer(String name, int age, String position, String language) {
		// super : 부모 클래스를 지칭
		// super() : 부모 클래스의 생성자를 지칭
		super(name, age);
		this.position = position;
		this.language = language;
	}
	
	void develope() {
		System.out.println(super.name + "가 " + this.language + "로 " + this.position + "개발을 합니다.");
	}// 출력에 super.name과 같이 어느 변수인지 정확한 지칭을 해줘야 함
}


public class Inheritance {

	public static void main(String[] args) {
		Developer developer1 = new Developer();
		// 클래스      이름     = new  생성자();
		developer1.name = "john doe";
		developer1.position = "Back end";
		developer1.language = "Java";
		
		developer1.eat("사과");
		developer1.develope();
		System.out.println();
		
		Developer developer2 = new Developer("Michle", 29, "Front end", "Javascript");
		developer2.eat("바나나");
		developer2.develope();
		System.out.println();
		// 모든 클래스는 Object를 상속받고 있다.
		
		
	}

}
