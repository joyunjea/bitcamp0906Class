package project2;

import java.util.Scanner;

public class SmartPhone{
	
	// 변수
	private Contact[] contacts;
	private int cnt;
	private Scanner sc = new Scanner(System.in);
	
	
	// 생성자
	public SmartPhone() {
		contacts = new Contact[10];
		cnt = 0;
	}
	
	// 메소드
	
	
	
	
	// 추가

	public void insert() {
		
		System.out.println("연락처 등록을 시작합니다.");
		System.out.println("이름>>");
		String name = sc.nextLine();
		System.out.println("전화>>");
		String phoneNumber = sc.nextLine();
		System.out.println("이메일>>");
		String email = sc.nextLine();
		System.out.println("주소>>");
		String address = sc.nextLine();
		System.out.println("생일");
		String birthday = sc.nextLine();
		System.out.println("그룹>>");
		String group = sc.nextLine();
		
		Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
		
		
		addContact(c);
	}
	//추가
	public void addContact(Contact contact) {
		contacts[cnt++] = contact;
	}
	
	
	// 삭제	
	public void delete() {
		System.out.println("삭제할 이름을 입력하세요.");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("찾는이름"+ name +"이 존재하지 않습니다");
		}else {
			for(int i = index; i < cnt-1; i++) {
				contacts[i] = contacts[i+1];
				
			}
			cnt--;
			System.out.println(name+" 의 데이터가 삭제되었습니다.");
		}
	}
	
	// 수정
	
    // 읽기
	
	
	// 찾는 사람의 인덱스를 반환
	// 없을시 -1을 반환
	// 접근 제한자를 private 으로 하여 다른 클래스에서 참조가 불가능하도록 캡슐화
	// 왜냐하면 searchIndex 메소드는 이 클래스 내에서만 쓰는 메소드이기 때문
     private int searchIndex(String info) {
		int index = -1;
		for(int i = 0; i< cnt; i++) {
			if(contacts[i].getName().equals(info)) {
				index = i;
			}
		}
		return index;
	}
	
	
	
}
