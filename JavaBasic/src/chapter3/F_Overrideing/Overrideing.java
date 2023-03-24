package chapter3.F_Overrideing;

// 오버라이딩
// 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것
// 상속받은 메서드를 자손 클래스에 맞게 변경 시키고자 할 때 오버라이딩을 사용
class Human {
	String name;
	
	void eat(String food) {
		System.out.println(this.name + "가 " + food + "를 먹습니다.");
	}
}

class Developer extends Human {
	// Overload
	void eat() {
		System.out.println(super.name + "가 식사를 합니다.");
	}
	// Override       (이거는 상속이고 추상이 아님, 추상클래스는 상속받으면 꼭 overriding(부모가 안적어놓은거 자식이 적기))
	void eat(String food) {
		System.out.println(super.name + "가 " + food + "를 절반만 먹습니다.");
	}
}

public class Overrideing {

	public static void main(String[] args) {
		Developer developer = new Developer();
		developer.name = "John doe";
		developer.eat("사과");
		
		Human human = new Human();
		human.name = "Michle";
		human.eat("바나나");
		
		
	}

}
