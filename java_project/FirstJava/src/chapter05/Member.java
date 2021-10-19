package chapter05;

public class Member {

	// 1.Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고,
	// main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
	// ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소

	//변수 -> 생성자 -> 메소드 순서
	// private : 클래스 내부의 맵버들만 엑세스가 가능하다!
	private String name; // 이름
	private String phoneNumber; // 010-9018-0000
	private String major; // 전공
	private int grade; // 학년
	private String email; // 이메일 QQQ@dd.com
	private String birthday; // 생일 20001020, 2000-10-20. 2000/10/20
	private String address;

	////////////////////////////////////////////////////////////
	// 생성자
	// ③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의

	public Member(String name, String phoneNumber, String major, int grade, String email, 
			String birthday,String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}

	public Member(String name, String phoneNumber, String major, int grade, String email) {
		// this.name=name;
		// this.phoneNumber=phoneNumber;
		// this.major=major;
		// this.grade=grade;
		// this.email=email;
		//this(name, phoneNumber, major, grade, email, null, null);
		this(name, phoneNumber, major, grade, email, "생일정보 없음", "주소정보 없음");

	}

	// 기본 생성자
	public Member() {
	}

	/////////////////////////////////////////////////////////////
	// 메소드

	// ② 위에서 정의한 정보를 출력하는 메소드 정의
	public void showData() {
		System.out.println("이름:" + this.name);
		System.out.println("전화번호:" + this.phoneNumber);
		System.out.println("전공:" + this.major);
		System.out.println("학년:" + this.grade);
		System.out.println("이메일:" + this.email);
		
		
		System.out.println("생일:"+ this.birthday);
		System.out.println("주소:" + this.address);
		
		// null
//		if(this.birthday == null) {
//			System.out.println("생일: 생일정보 없음");
//		} else {
//			System.out.println("생일:"+ this.birthday);
//		}
//		
//		if(this.address == null) {
//			System.out.println("주소: 정보 없음");
//		} else {
//			System.out.println("주소:" + this.address);
//		}
		
		
	}

	// ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력

}
//class Member1{}
//class Member2{}