package testver05;

public class MisInfo extends Exception {

	
	
	public int selectMenu(int select) throws MisInfo {
		if (!(select >= 1 && select <= 6)) {
			// 조건과 맞지 않는다면 호출한 곳으로 예외를 발생시킴
			throw new MisInfo();
		} else {
			return select;
		}

	}

}
