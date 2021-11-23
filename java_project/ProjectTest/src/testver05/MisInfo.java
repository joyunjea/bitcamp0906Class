package testver05;


public class MisInfo extends Exception{
	
	public MisInfo() {
		System.out.println("올바른 메뉴를 입력하세요");
	}
	
	
	public int selectMenu(int choice) throws MisInfo{
		
		
		if(!(choice >=1 && choice<=6)) {
			throw new MisInfo();
		}else {
			return choice;
		}
	
	}

}
