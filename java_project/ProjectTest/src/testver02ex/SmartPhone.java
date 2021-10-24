package testver02ex;

import java.util.Scanner;

public class SmartPhone {

	// 변수

	// 배열
	private Contact[] contacts;
	private int cnt;
	Scanner sc = new Scanner(System.in);
	// 매개변수가 없는 생성자
	public SmartPhone() {
		contacts = new Contact[10];
		cnt = 0;
	}

	// 메소드

	// 저장
	public void insert() {
		// 객체를 생성해서 add 메소드에 매개변수로 준다.
		// add 메소드는 그 객체를 받아서 배열에 저장한다.
		
		
		// 연락처 객체 하나를 생성해서 사용자로부터 정보를 받아서 
		// 연락처의 이름,이메일,전화번호... 로 설정.
		//Contact c = new Contact(// 사용자가 입력한 정보들)
		
		System.out.println("연락처 등록을 시작합니다....");
		System.out.println("이름>>");
		String name = sc.nextLine();
		System.out.println("전화번호>>");
		String phoneNumber = sc.nextLine();
		System.out.println("이메일>>");
		String email = sc.nextLine();
		System.out.println("주소>>");
		String address = sc.nextLine();
		System.out.println("생일>>");
		String birthday = sc.nextLine();
		System.out.println("그룹>>");
		String group = sc.nextLine();
		
		Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
		
		// 생성된 연락처 c를 add에 매개변수로 준다.
		// add 메소드는 c를 받아 배열에 저장한다.
		add(c);
		
	}
	
	// 추가
	public void add(Contact abc) {
		// 연락처 객체를 받아서 배열에 추가한다.
		//contacts[//인덱스에] 할당 = // 받은 연락처를
		contacts[cnt] = abc;
		cnt = cnt+1;
		// 저장하고 나서 cnt의 값을 1 증가.
		// 그러면 다음에 추가되는 연락처는 0번이 아니라
		// 1번 인덱스에 저장됨
		// 그 다음 추가되는 연락처는 2인덱스에 저장됨.
	}
	

	// 출력
	
	public void printAll() {
		// 배열 전체를 스캔하면서 각각의 연락처 정보를 출력합니다.
		// 전체를 스캔하기 위해 for문 사용
		for(int i =0; i<cnt; i++) {
			// 0번 인덱스부터 시작해서 현재 저장된 연락처의 갯수만큼 스캔
			// 1번 연락처~ 5번 연락처 까지 스캔시 (cnt =5)
			// 인덱스는 0부터 4까지(총 5명)
			// 따라서 i는 0 부터 4까지 스캔
			
//			String userInfo = contacts[i].toString();
//			System.out.println(userInfo);
			
			System.out.println(contacts[i].toString());
			
			// toString() = 객체에 저장된 정보를 내가 지정한 양식의 문자열로 반환
			// 그 문자열을 println 으로 출력.
		}
	}

	// 삭제
	
	public void delete() {
		// 검색할 이름을 입력받는다.
		System.out.println("삭제할 이름을 입력하세요");
		
		
		
		// 전체 배열을 돌면서 같은 이름이 있는 연락처가
		// 배열의 몇번째 인덱스에 있는지 (i 번쨰 인덱스)
		// 찾아서 index 에 할당.
		// 따라서 같은 이름이 있으면 index 는 i 가 되고
		// 없으면 index에 i가 할당되지 않는다.
//		int index = -1312423;
//		String name = sc.nextLine();
//		for(int i =0; i< cnt ; i++) {
//			if(contacts[i].getName().equals(name)) {
//				index = i;
//			}
//		}
	
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		////////////////////////////////////
		// 같은 이름이 있었다면 index 는 i가 될것이고
		// 없었다면 index =  -1 이다.
		
		if(index < 0 ) {
			// 만약 index 가 0보다 작다면 = 같은 이름이 없다.
			System.out.println("이름을 찾지 못했습니다.");
			
		}else {
			// index <0 의 반대 >> index가 0보다 같거나 크다면 >> 같은 이름을 찾았다
			
			
            // 같은 이름의 연락처는 index 번 인덱스에 있다.
			// for 문을 돌면서 그 index 번 연락처를 index+1 번 연락처로 덮어 씌운다
			// 빈 칸이 없도록 뒤의 연락처들도 차례대로 덮어씌운다.
			for(int i = index ; i< cnt-1; i++) {
				contacts[i] = contacts[i+1];
			}
			
			cnt--;
			
		}
		
		
		
	}

	// 수정
	public void update() {
		System.out.println("수정할 이름을 입력하세요");
		
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index <0) {
			System.out.println("검색한 이름이 연락처에 없습니다");
			
		}else {
			// 맞는 이름을 찾았습니다.
			// contacts 배열의 index 번 인덱스가 사용자가 수정할 연락처입니다.
			// 새 정보를 입력받습니다.
			System.out.println("이름>>");
			String newName = sc.nextLine();
			System.out.println("전화번호>>");
			String newphoneNumber = sc.nextLine();
			System.out.println("이메일>>");
			String newemail = sc.nextLine();
			System.out.println("주소>>");
			String newaddress = sc.nextLine();
			System.out.println("생일>>");
			String newbirthday = sc.nextLine();
			System.out.println("그룹>>");
			String newgroup = sc.nextLine();
			
			contacts[index].setName(newName);
			contacts[index].setPhoneNumber(newphoneNumber);
			contacts[index].setEmail(newemail);
			contacts[index].setAddress(newaddress);
			contacts[index].setBirthday(newbirthday);
			contacts[index].setGroup(newgroup);
		}
	}
	public void searchName() {
		System.out.println("이름 검색 시작...");
		System.out.println("찾고자 하는 이름을 입력하세요>>");
		String name = sc.nextLine();
		int index = searchIndex(name);
		if(index < 0) {
			System.out.println("찾으시는 이름"+ name + "의 정보가 존재하지 않습니다.");
		}else {
			System.out.println("검색 결과 입니다.");
			System.out.println("-------------------------");
			System.out.println(contacts[index].toString());
		}
	}
	
	// 이름 검색 기능
	public int searchIndex(String info) {//info : 사용자가 검색한 이름
		int index = -1;
		
		for(int i =0; i< cnt ; i++) {
			if(contacts[i].getName().equals(info)) {
				index = i;
			}
		}
		return index;
	}

}
