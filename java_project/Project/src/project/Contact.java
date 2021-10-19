package project;

import java.util.Scanner;

public class Contact {

	// 변수
	private String name; // 이름
	private String phoneNumber; // 번호
	private String email; // 이메일
	private String address; // 주소
	private String birthday; // 생일
	private String group; // 그룹

	// 생성자
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	// 기본 생성자
	public Contact() {
	}

	// 정보 출력 메소드
	public void ShowData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("생일 : " + birthday);
		System.out.println("그룹 : " + group);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	void Update(Contact c) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 항목을 선택해 주십시오");
		System.out.println("1. 이름  2. 전화번호 3. 이메일 4. 주소 5. 생일 6. 그룹 7. 수정 완료");
		
		boolean isContinue = true;
		while (isContinue) {
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("새로 저장할 이름을 입력하세요.");
				c.setName(scanner.nextLine());
				break;
			case 2:
				System.out.println("새로 저장할 전화번호를 입력하세요 ");
				c.setPhoneNumber(scanner.nextLine());
				break;
			case 3:
				System.out.println("새로 저장할 이메일을 입력하세요 ");
				c.setEmail(scanner.nextLine());
				break;
			case 4:
				System.out.println("새로 저장할 주소를 입력하세요 ");
				c.setAddress(scanner.nextLine());
				break;
			case 5:
				System.out.println("새로 저장할 생일 날짜를 입력하세요 ");
				c.setBirthday(scanner.nextLine());
				break;
			case 6:
				System.out.println("새로 저장할 그룹을 입력하세요 ");
				c.setGroup(scanner.nextLine());
				isContinue = false;
				break;
			case 7:
				System.out.println("수정 완료");
			default:
			}
		}

	}

}
