package project2_1;

import java.util.Scanner;

public class SmartPhone {
	
	Scanner sc = new Scanner(System.in);
	private Contact[] contacts;
	private int cnt;
	
	// 생성자
	// 생성자는 리턴타입 x
	public SmartPhone() {
		contacts = new Contact[10];
		cnt = 0;
	}
	//등록
	public void insert(int select) {
		System.out.println("연락처 등록을 시작합니다");
		System.out.println("저장할 이름을 입력해주세요>>");
		String name = sc.nextLine();
		System.out.println("저장할 전화번호를 입력해주세요>>");
		String phoneNumber = sc.nextLine();
		System.out.println("저장할 이메일을 입력해주세요>>");
		String email = sc.nextLine();
		System.out.println("저장할 주소를 입력해주세요>>");
		String address = sc.nextLine();
		System.out.println("저장할 생일을 입력해주세요>>");
		String birthday = sc.nextLine();
		System.out.println("저장할 그룹을 입력해주세요>>");
		String group = sc.nextLine();
		
		if(select == 1) {
			System.out.println("회사이름을 입력하세요. >>");
			String companyName = sc.nextLine();
			System.out.println("부서이름을 입력하세요. >>");
			String divName = sc.nextLine();
			System.out.println("직급을 입력하세요. >>");
			String job = sc.nextLine();
			Contact c = new CompanyContact(name, phoneNumber, email, address, birthday, group, companyName, divName, job);
			addContact(c);
			
		}else {
			System.out.println("거래처 회사이름을 입력하세요. >>");
			String companyName = sc.nextLine();
			System.out.println("거래품목을 입력하세요. >>");
			String product = sc.nextLine();
			System.out.println("담당자의 직급을 입력하세요. >>");
			String job = sc.nextLine();
			Contact c = new CustomerContact(name, phoneNumber, email, address, birthday, group, companyName, product, job);
			addContact(c);
		}

	}
	//추가
	public void addContact(Contact contact) {
		contacts[cnt++] = contact;
	}
	//출력
	// 0번 인덱스부터 시작해서 현재 저장된 연락처의 갯수만큼 스캔
				// 1번 연락처~ 5번 연락처 까지 스캔시 (cnt =5)
				// 인덱스는 0부터 4까지(총 5명)
				// 따라서 i는 0 부터 4까지 스캔

	            // 해당 배열 연락처의 이름만 출력
	public void printAll() {
		System.out.println("리스트를 출력합니다"+cnt+"명");
		System.out.println("===================");
		for(int i = 0; i < cnt; i++) {
			contacts[i].showList();
			System.out.println("---------------");
		}
		
		
	}
	
	//검색한이름 찾는기능
	// 전체 배열을 돌면서 같은 이름이 있는 연락처가
			// 배열의 몇번째 인덱스에 있는지 (i 번쨰 인덱스)
			// 찾아서 index 에 할당.
			// 따라서 같은 이름이 있으면 index 는 i 가 되고
			// 없으면 index에 i가 할당되지 않는다.
	public int searchIndex(String name) {
		int index = -1;
		
		for(int i = 0; i < cnt; i++) {
			if(contacts[i].getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}
	
	//삭제
	// index <0 의 반대 >> index가 0보다 같거나 크다면 >> 같은 이름을 찾았다

				// 같은 이름의 연락처는 index 번 인덱스에 있다.
				// for 문을 돌면서 그 index 번 연락처를 index+1 번 연락처로 덮어 씌운다
				// 빈 칸이 없도록 뒤의 연락처들도 차례대로 덮어씌운다.
	public void delete() {
		System.out.println("삭제할 이름을 입력해주세요>>");
		String name = sc.nextLine();
		int index = searchIndex(name);
		if(index <0) {
			System.out.println("찾으시는"+name+"이 없습니다.");
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
		System.out.println("찾으시는 이름을 입력하세요");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("찾으시는"+name+"이 없습니다");			
		}else {
			System.out.println("연락처 재등록을 시작합니다");
			System.out.println("저장할 이름을 입력해주세요>>");
			name = sc.nextLine();
			System.out.println("저장할 전화번호를 입력해주세요>>");
			String phoneNumber = sc.nextLine();
			System.out.println("저장할 이메일을 입력해주세요>>");
			String email = sc.nextLine();
			System.out.println("저장할 주소를 입력해주세요>>");
			String address = sc.nextLine();
			System.out.println("저장할 생일을 입력해주세요>>");
			String birthday = sc.nextLine();
			System.out.println("저장할 그룹을 입력해주세요>>");
			String group = sc.nextLine();
			
			Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
			c.setName(name);
			c.setPhoneNumber(phoneNumber);
			c.setEmail(email);
			c.setAddress(address);
			c.setBirthday(birthday);
			c.setGroup(group);
			
			contacts[index] = c;
			System.out.println("연락처를 수정하였습니다");
		}
	}
	//검색이름 데이터(정보)출력
	public void searchName() {
		System.out.println("찾으시는 이름을 입력하세요>>");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("찾으시는"+name+"의 데이터가 없습니다");			
		}else {
			System.out.println(contacts[index].toString());
			System.out.println("---------------------");
		}
		
	}
}
