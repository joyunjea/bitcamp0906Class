package exam;

import java.util.Scanner;

public class Contact {

	private String name;		// 이름
	private String phoneNumber;	// 전화번호
	private String eMail;		// 이메일
	private String address;		// 주소
	private String birthDay;	// 생일
	private String group;		// 그룹
	
	// getter 와 setter 메소드
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
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	// 기본 생성자
	public Contact() {
		
	}

	// 매개변수 있는 생성자
	public Contact(String name, String phoneNumber, String eMail, String address, String birthDay, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.address = address;
		this.birthDay = birthDay;
		this.group = group;
	}
	
	// 정보 출력 메소드
	public void printInfo() {
		System.out.println("=====================================");
		System.out.println("이름: " + this.getName());
		System.out.println("전화번호: " + this.getPhoneNumber());
		System.out.println("이메일주소: " + this.geteMail());
		System.out.println("주소: " + this.getAddress());
		System.out.println("생일: " + this.getBirthDay());
		System.out.println("그룹: " + this.getGroup());
		System.out.println("=====================================\n");
	}
	
	// 변수값을 바꾸는 setter 메소드를 이용한 정보 수정 메소드
	public void updateInfo(Scanner scanner) {
		System.out.println("정보를 수정합니다.\n");
		System.out.println("수정할 이름을 입력해주세요.");
		System.out.print("> ");
		this.setName(scanner.nextLine());
		
		System.out.println("수정할 전화번호를 입력해주세요. (예. 010-0000-0000)");
		System.out.print("> ");
		this.setPhoneNumber(scanner.nextLine());
		
		System.out.println("수정할 이메일 주소를 입력해주세요. (예. email@email.com)");
		System.out.print("> ");
		this.seteMail(scanner.nextLine());
		
		System.out.println("수정할 주소를 입력해주세요.");
		System.out.print("> ");
		this.setAddress(scanner.nextLine());
		
		System.out.println("수정할 생일을 입력해주세요. (예. 1900-01-01)");
		System.out.print("> ");
		this.setBirthDay(scanner.nextLine());
		
		System.out.println("수정할 그룹을 입력해주세요.");
		System.out.print("> ");
		this.setGroup(scanner.nextLine());
	}







	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// scanner 사용을 위해 초기화
		
		// 생성자 호출
		Contact cont = new Contact();
		
		// 사용자의 입력을 받아 인스턴스 생성
		System.out.println("이름을 입력해주세요.");
		System.out.print("> ");
		String name = new String(scanner.nextLine());
		
		System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
		System.out.print("> ");
		String phoneNumber = new String(scanner.nextLine());
		
		System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
		System.out.print("> ");
		String eMail = new String(scanner.nextLine());
		
		System.out.println("주소를 입력해주세요.");
		System.out.print("> ");
		String address = new String(scanner.nextLine());
		
		System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
		System.out.print("> ");
		String birthDay = new String(scanner.nextLine());
		
		System.out.println("그룹을 입력해주세요.");
		System.out.print("> ");
		String group = new String(scanner.nextLine());
		
		cont = new Contact(name, phoneNumber, eMail, address, birthDay, group);
		
		// 변수값 반환하는 getter 메소드를 호출하여 데이터 출력
		System.out.println("이름: " + cont.getName());
		System.out.println("전화번호: " + cont.getPhoneNumber());
		System.out.println("이메일주소: " + cont.geteMail());
		System.out.println("주소: " + cont.getAddress());
		System.out.println("생일: " + cont.getBirthDay());
		System.out.println("그룹: " + cont.getGroup());
		
		// 정보 출력 메소드 실행
		cont.printInfo();
		
		// 정보 수정 메소드 실행
		cont.updateInfo(scanner);
		
		// 정보 출력 메소드 실행
		cont.printInfo();
		
		scanner.close();	// scanner 사용 종료
	}
	
}