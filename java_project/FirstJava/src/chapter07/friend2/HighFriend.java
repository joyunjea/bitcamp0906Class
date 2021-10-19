package chapter07.friend2;

public class HighFriend extends Friend{
	
	 String work;
	
	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work;	//work도 초기화해줌
	}

	@Override
	public void showData() {
		super.showData();	//상위클래스의 메소드들을 호출해준다
		System.out.println("직업:"+work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화:"+phoneNumber);
	}
	
	
}
