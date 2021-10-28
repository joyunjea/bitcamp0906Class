package project2_1;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("===연락처 관리 프로그램===");
			System.out.println("1. 연락처 등록");
			System.out.println("2. 연락처 목록(이름검색)");
			System.out.println("3. 연락처 수정(이름검색)");
			System.out.println("4. 연락처 삭제(이름검색)");
			System.out.println("5. 연락처 검색 정보보기");
			System.out.println("6. 프로그램종료");
			
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				sp.insert();
				break;
			case 2:
				sp.printAll();
				break;
			case 3:
				sp.update();
				break;
			case 4:
				sp.delete();
				break;
			case 5:
				sp.searchName();
				break;
			case 6:
				System.out.println("프로그램 종료합니다");
				System.exit(0);
			}
		}
	}

}
