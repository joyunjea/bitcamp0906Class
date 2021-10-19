package chapter07;

public class BaseEnSpeaker extends Speaker{
	
	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	//오버라이딩
	//상위 클래스의 메소드의 선언부를 일치시키고
	//처리부를 변경하는것!
	
	//@에노테이션
	//@Override : 상위 클래스의 메소드를 오버라이딩 한다!...오버라이딩 규칙에 맞게 정의하는지 체크
	@Override
	public void showCurrentState() {
		super.showCurrentState();
		System.out.println("베이스크기 : "+baseRate);
	}
	
	public static void main(String[] args) {
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.showCurrentState();
		
		System.out.println("=============================");
		
		Speaker speaker = new Speaker();
		speaker.showCurrentState();
		
		System.out.println("============================");
		//다형성
		//상위타입의 참조변수 = 하위 타입의 인스턴스
		//참조변수의 타입에 정의된 멤버만 사용이 가능하다
		Speaker sp = new BaseEnSpeaker();
		sp.showCurrentState();
		//sp.setBaseRate(100); 오류가남 ,하지만 메모리에는 존재함
		
	}
}
