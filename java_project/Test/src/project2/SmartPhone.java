package project2;

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
	//출력
	public void printAll() {
		System.out.println("리스트를 출력합니다.("+cnt+"명)");
		System.out.println("===================");
		for(int i = 0; i < cnt; i++) {
			contacts[i].showList();	//해당배열 이름만출력
			System.out.println("--------------");
		}
	}
	//검색한이름 찾는기능
	public int searchIndex(String info) {
		int index = -1;
		for(int i = 0; i< cnt; i++) {
			if(contacts[i].getName().equals(info)) {
				index = i;
			}
		}
		return index;
	}
	//삭제
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
	
	//수정
	public void update() {
		System.out.println("수정할 이름을 입력하세요");
		String name = sc.nextLine();
		int index = searchIndex(name);
		 
		
		if(index <0) {
			System.out.println("찾는이름"+ name +"이 존재하지 않습니다");
			
		}else {
			System.out.println("연락처 재등록을 시작합니다.");
			System.out.println("이름>>");
			name = sc.nextLine();
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
			c.setName(name);
			c.setPhoneNumber(phoneNumber);
			c.setEmail(email);
			c.setAddress(address);
			c.setBirthday(birthday);
			c.setGroup(group);
			
			// 기존 정보와 바꿔야함
			// 기존에 연락처는 contacts[index]
			// 얘를 삭제하고
			// 그 자리에 c 연락처를 추가
			
			// = 덮어씌우면 됨 >> contacts[index] = c;
			
			contacts[index] = c;
			
			System.out.println(name+ " 의 정보가 수정되었습니다.");
		}				
	}
	//검색이름 데이터(정보)출력
		public void searchName() {
			System.out.println("리스트를 출력합니다.("+cnt+"명)");
			System.out.println("검색할 이름을 입력하세요");
			String name = sc.nextLine();
			int index = searchIndex(name);
			
			if(index <0) {
				System.out.println("찾는이름"+ name +"이 존재하지 않습니다");
			}else {
				System.out.println("검색 결과 입니다.");
				System.out.println("-------------");
				System.out.println(contacts[index].toString());
			}
		}
	
	
	
	
	
	
}