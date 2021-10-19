package exam;
//3. main()메소드를 정의해봅시다.
public class PersonMain {

	public static void main(String[] args) {
		
		Male m1 = new Male();
		Female f1 = new Female();
		
		//① Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
		
		m1.MaleJob("학생");
		f1.FemaleAddress("서울시");
		//② 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.

		m1.Greet("홍길동", "30");
		f1.Greet("백설공주", "25");
	}

}
