package ver02;

import java.util.Scanner;

public class SmartPhone {
	
	private Contact[] contacts;
	private int cnt;
	Scanner sc = new Scanner(System.in);
	
	public SmartPhone(int size) {
		contacts = new Contact[size];
		cnt = 0;
	}
	
}
