package testver01;

public class ContactMain {
	public static void main(String[] args) {
		
		//인스턴스 생성////멤버변수의 정보들을 입력
	
		Contact contact1 = new Contact("손흥민", "010-1234-1234", "son@gmail", "서울", "1919-10-10","친구");
		Contact contact2 = new Contact("이강인", "010-1234-4321", "2020-10-20");
		
		//getter메소드로 출력
		System.out.println(contact1.getName());
		System.out.println(contact1.getPhoneNumber());
		System.out.println(contact2.getName());
		System.out.println(contact2.getGroup());//정보가 없으므로 null값
		
		//저장된 데이터출력////참조변수.메소드호출
		contact1.ShowMenu();	//참조변수인 contact1의 정보들을 입력받아 출력
		System.out.println("----------------");
		contact2.ShowMenu();	//참조변수인 contact2의 정보들을 입력받아 출력
		
		
		//데이터변경 setter메소드로 입력
		contact1.setName("박지성");
		contact1.setPhoneNumber("010-1010-1010");
		contact1.setEmail("1a1a@naver.com");
		contact1.setAddress("강남");
		contact1.setBirthday("2000-11-11");
		contact1.setGroup("가족");
		System.out.println("======set메소드 입력받아 정보가 변경된후 출력==========");
		contact1.ShowMenu();
		
		
	}
}
