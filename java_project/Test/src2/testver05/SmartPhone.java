package testver05;

import java.util.Scanner;

public class SmartPhone {

	private Contact[] contacts;
	private int cnt;
	Scanner sc = new Scanner(System.in);
	
	public SmartPhone() {
		contacts = new Contact[10];
		cnt = 0;
	}
	
	public void insert() {
		System.out.println("연락처 등록을 시작합니다.");
		System.out.println("1.회사 연락처 등록 2.거래처 연락처 등록");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice == 1) {
			System.out.println("이름>>");
			String name = getInfo(sc.nextLine());
			
			String phoneNumber = getPhone();
			
			System.out.println("이메일>>");
			String email = getInfo(sc.nextLine());
			System.out.println("주소>>");
			String address = getInfo(sc.nextLine());
			System.out.println("생일>>");
			String birthday = getInfo(sc.nextLine());
			System.out.println("그룹>>");
			String group = getInfo(sc.nextLine());
			System.out.println("회사이름>>");
			String companyName = getInfo(sc.nextLine());
			System.out.println("부서>>");
			String divName = getInfo(sc.nextLine());
			System.out.println("직급>>");
			String job = getInfo(sc.nextLine());
			
			CompanyContact c = new CompanyContact
		}
	}
}