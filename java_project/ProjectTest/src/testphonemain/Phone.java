package testphonemain;

public class Phone {
	
	private Contact[] contacts;
	private int cnt;
	
	public void SmartPhone(int Size) {
		contacts = new Contact[Size];
		cnt = 0;
	}
	SmartPhone sp = new SmartPhone(10);
	(=================================)
	
	private Contact[] contacts;
	private int cnt;
	
	public void SmartPhone() {
		contacts = new Contact[10];
		cnt = 0;
	}
	SmartPhone sp = new SmartPhone();
	
	
}
