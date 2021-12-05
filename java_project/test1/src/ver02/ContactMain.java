package ver02;

public class ContactMain {

	public static void main(String[] args) {
		
		//생성자를 생성하여 매개변수정보를 입력
		Contact contact1 = new Contact("손흥민", "010-1234-5678", "son@naver.com", "서울시", "01-23", "친구");
		Contact contact2 = new Contact("이강인", "경기도");
		
		//tostring으로 출력됨
		System.out.println(contact1);
		System.out.println("============");
		System.out.println(contact2);
		System.out.println("============");
		
		//전체 정보를 출력하는 printContact메소드를 출력
		contact1.printContact();
		System.out.println("============");
		contact2.printContact();
		System.out.println("============");
		
		//매개변수에 입력된 이름값만 출력
		System.out.println(contact1.getName());
		System.out.println(contact2.getName());
		System.out.println("============");
		
		//setter 메소드를 이용해 값을 입력받고 printContact 메소드로 입력받은 정보를 출력
		contact2.setPhoneNumber("010-1234-1234");
		contact2.setEmail("lee@naver.com");
		contact2.setBirthday("12-31");
		contact2.setGroup("가족");
		contact2.printContact();
		
		
		
	}

}
