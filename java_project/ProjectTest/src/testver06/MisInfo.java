package testver06;


public class MisInfo extends Exception{
	
	public MisInfo() {
		
	}
	
	public MisInfo(String message) {
		System.out.println(message);
	}
	
	
	public int selectMenu(int choice) throws MisInfo{
		
		
		if(!(choice >=1 && choice<=6)) {
			throw new MisInfo("올바른 메뉴를 입력해주세요");
		}else {
			return choice;
		}
	
	}
	
	
}
