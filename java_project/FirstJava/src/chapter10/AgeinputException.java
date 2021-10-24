package chapter10;

public class AgeinputException extends Exception {
	public AgeinputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
	
	public AgeinputException(int age) {
		super(age +"는 유효한 나이정보가 아닙니다");
	}
	
	public void print() {
		System.out.println("예외 클래스에 정의한 메소드입니다");
	}
}
