package ver07;

public class PhoneNumberPatternException extends Exception {

	public PhoneNumberPatternException() {
		super("전화번호 형식에 맞지 않습니다.(예 : 000-0000-0000)");
	}

	
}