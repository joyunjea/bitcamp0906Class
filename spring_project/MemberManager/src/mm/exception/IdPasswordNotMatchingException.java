//누가봐도 예외클래스인걸 알 수 있도록 이름을 지어줌
//Exception의 생성자중 예외타입의 message
package mm.exception;

public class IdPasswordNotMatchingException extends Exception {
	//누가봐도 예외클래스인걸 알 수 있도록 이름을 지어줌
	public IdPasswordNotMatchingException(String msg) {
		super(msg);	//Exception의 생성자중 예외타입의 message
	}
}