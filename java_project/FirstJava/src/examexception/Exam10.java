package examexception;
//1.콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 
//입력했는지 확인하는 프로그램을 만들어봅시다.
//①사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//②예외 클래스 이름은 BadIdInputException이라고 정의합시다.
//2.Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 
//이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam10 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String name = null;
		int year = 0;
		
		try {
			name = getName();
			System.out.println("아이디: " + name );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			year = getYear();
			System.out.println("태어난 해 : " + year);
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	public static String getName() throws BadinputException {
		
		String name = null;
		
		System.out.println("아이디(영문자와 숫자만 조합) >> ");
		name = sc.nextLine();
		
		//boolean checkStr = !(name.matches("^[a-zA-Z0-9]*$"));
		
		for(int i=0 ; i<name.length(); i++) {
			
			char c = name.charAt(i);
		
			if(!('a'<=c && c<='z' || 'A'<=c && c<='Z' || '0'<=c && c<='9')) {
				//Exception e = new Exception("영문자 또는 숫자 이외의 문자가 포함됨.");
				// 사용자 정의 예외 클래스
				BadinputException be = new BadinputException(name);
				throw be;
			}
		}
		
		return name;
	}

	public static int getYear() {
		System.out.println("태어난 년도를 입력하세요 >>");
		int year = sc.nextInt(); 
		return year;
	}
	
}