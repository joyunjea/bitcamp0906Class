package exam;
//①각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
public class Male extends Person{
	
//②각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
	String age;
	String job;

//③Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
	@Override
	public void Greet(String name, String age) {
		super.Greet(name, age);
	}

//④Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.
	public Male(String name, String jumin, String age, String job) {
		super(name, jumin);
		this.age = age;
		this.job = job;
	}	

	//기본생성자
	public Male() {
		
	}
	public void MaleJob(String job) {
		System.out.println("저의 성별은 남자이고 제 직업은" +job+ " 입니다.");
	} 
}
