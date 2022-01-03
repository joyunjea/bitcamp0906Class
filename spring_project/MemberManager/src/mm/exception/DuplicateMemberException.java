//Exception을 상속하고 있으니까 shift+ alt + s 
//상위클래스로부터 constructors 생성자를 생성해줌
package mm.exception;

public class DuplicateMemberException extends Exception {

	public DuplicateMemberException(String message) {
		super(message);
	}

	
	
}