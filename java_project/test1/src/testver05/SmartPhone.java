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
			
			CompanyContact c = new CompanyContact(name, phoneNumber, email, address, birthday, group, 
					companyName, divName, job);
			addContact(c);
		}else {
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
		// 추가 정보 입력
		System.out.println("거래처이름>>");
		String customerName = getInfo(sc.nextLine());
		System.out.println("거래품목>>");
		String product = getInfo(sc.nextLine());
		System.out.println("직급>>");
		String job = getInfo(sc.nextLine());

		addContact(new CustomerContact(name, phoneNumber, email, address, birthday, group, customerName, product,
				job));

	}
	System.out.println("연락처 등록이 완료되었습니다.");
}
	public void addContact(Contact contact) {
		contacts[cnt++]= contact;
			
		
	}
	public void printAll() {
		System.out.println("리스트를 출력합니다.("+cnt+"명)");
		System.out.println("=========================");
		for(int i = 0; i < cnt; i++) {
			contacts[i].showList();
			System.out.println("----------------");
			
		}
	}
	public void delete() {
		System.out.println("삭제할 이름을 입력해주세요");
		
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("이름을 찾지 못했습니다.");
		}else {
			for(int i = index; i < cnt-1; i++) {
				contacts[i] = contacts[i + 1];
			}
			cnt--;
			System.out.println(name+"의 데이터가 삭제되었습니다.");
		}
		
	}
	public void update() {
		System.out.println("수정할 이름을 입력하세요");
		
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색한 이름이없습니다");
		}else {
			Contact c = contacts[index];
			
			if(c instanceof CompanyContact) {
				CompanyContact c1 = (CompanyContact) c;
				System.out.println("이름>>");
				String newName = getInfo(sc.nextLine());
				
				String newphoneNumber = getPhone();
				
				System.out.println("이메일>>");
				String newemail = getInfo(sc.nextLine());
				System.out.println("주소>>");
				String newaddress = getInfo(sc.nextLine());
				System.out.println("생일>>");
				String newbirthday = getInfo(sc.nextLine());
				System.out.println("그룹>>");
				String newgroup = getInfo(sc.nextLine());
				// 추가 정보 입력
				System.out.println("회사이름>>");
				String newCompanyName = getInfo(sc.nextLine());
				System.out.println("부서>>");
				String newDivName = getInfo(sc.nextLine());
				System.out.println("직급>>");
				String newJob = getInfo(sc.nextLine());

				c1.setName(newName);
				c1.setPhoneNumber(newphoneNumber);
				c1.setEmail(newemail);
				c1.setAddress(newaddress);
				c1.setBirthday(newbirthday);
				c1.setGroup(newgroup);
				c1.setCompanyName(newCompanyName);
				c1.setDivName(newDivName);
				c1.setJob(newJob);
				System.out.println(name + " 의 정보가 수정되었습니다.");

			} else if (c instanceof CustomerContact) {

				CustomerContact c2 = (CustomerContact) c;
				// 거래처 연락처의 정보를 수정
				// contacts 배열의 index 번 인덱스가 사용자가 수정할 연락처입니다.
				// 새 정보를 입력받습니다.
				System.out.println("이름>>");
				String newName = getInfo(sc.nextLine());
				
				String newphoneNumber = getPhone();
				
				System.out.println("이메일>>");
				String newemail = getInfo(sc.nextLine());
				System.out.println("주소>>");
				String newaddress = getInfo(sc.nextLine());
				System.out.println("생일>>");
				String newbirthday = getInfo(sc.nextLine());
				System.out.println("그룹>>");
				String newgroup = getInfo(sc.nextLine());
				// 추가 정보 입력
				System.out.println("거래처이름>>");
				String newCustomerName = getInfo(sc.nextLine());
				System.out.println("거래품목>>");
				String newProduct = getInfo(sc.nextLine());
				System.out.println("직급>>");
				String newJob = getInfo(sc.nextLine());

				c2.setName(newName);
				c2.setPhoneNumber(newphoneNumber);
				c2.setEmail(newemail);
				c2.setAddress(newaddress);
				c2.setBirthday(newbirthday);
				c2.setGroup(newgroup);
				c2.setCustomerName(newCustomerName);
				c2.setProduct(newProduct);
				c2.setJob(newJob);
				System.out.println(name + " 의 정보가 수정되었습니다.");

			}

		}
	}

	// 검색한 이름 정보출력
	public void searchName() {
		System.out.println("이름 검색 시작...");
		System.out.println("찾고자 하는 이름을 입력하세요>>");
		String name = sc.nextLine();
		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("찾는이름" + name + "이 존재하지 않습니다.");
		} else {
			System.out.println("검색 결과 입니다.");
			System.out.println("-------------------------");
			System.out.println(contacts[index].toString());// toString으로 사용할경우
			// contacts[index].ShowMenu(); //따로 만들어둔 데이터출력메소드를 사용할경우
		}
	}

	// 사용자가 검색한 이름을 찾는 기능
	public int searchIndex(String info) {// info : 사용자가 검색한 이름
		int index = -1;

		for (int i = 0; i < cnt; i++) {
			if (contacts[i].getName().equals(info)) {
				index = i;
			}
		}
		return index;
	}

	// 공백을 받으면 다시 입력하도록 하여 정상적인 정보를 반환하는 메소드
	private String getInfo(String info) {

		
		while (true) {
			if (info.trim().length() == 0) {
				System.out.println("공백입니다. 다시 입력하세요");
				info = sc.nextLine();
			} else {
				break;
			}
		}

		return info.replaceAll(" ", "");

	}

	// 전화번호를 입력받는 메소드
	private String getPhone() {

		///////////////////////////////////////////////////
		System.out.println("전화번호>>");
		
		String phoneNumber = getInfo(sc.nextLine());
		
		
		
		if(phoneNumber.trim().equals("")) {
			
		}
		
		//String phoneNumber = getInfo(sc.nextLine());
		
		while (checkPhoneNumber(phoneNumber)) {
			System.out.println("중복된 전화번호입니다.");
			phoneNumber = getInfo(sc.nextLine());
		}
		
		phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
		////////////////////////////////////////////////////

		return phoneNumber;
	}

	// 입력한 전화번호가 중복된 전화번호인지 확인하는 메소드
	private boolean checkPhoneNumber(String number) {

		boolean result = false;

		for (int i = 0; i < cnt; i++) {
			if (contacts[i].phoneNumber.equals(number.replaceAll("[^0-9]", ""))) {
				result = true;
				break;
			}
		}

		return result;
	}

}	
			}
		}
	}
	
}