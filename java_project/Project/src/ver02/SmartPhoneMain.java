package ver02;

public class SmartPhoneMain {

	public static void main(String[] args) throws Exception {		
		
//		① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(3);

		
//		② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 
//		인스턴스가 가지고 있는 배열에 추가합니다.
		
//		③ 10번 반복해서 배열에 추가합니다.
		for(int i = 0; i < 3; i++) {
			phone.insertContact();
		}
		
//		④ 배열의 모든 요소를 출력합니다.
		phone.printAllData();
//		⑤ 배열의 모든 요소를 검색합니다.
		phone.searchPrint();
//		⑥ 배열의 요소를 삭제해 봅시다.
		phone.deleteContact();
//		⑦ 배열의 요소를 수정해 봅시다.
//		④ 배열의 모든 요소를 출력합니다.
		phone.printAllData();
        phone.insertContact();		
    	phone.printAllData();
        	
		
		phone.editContact();
// 		삭제와 변경 여부 확인
		phone.printAllData();

	}	

}
