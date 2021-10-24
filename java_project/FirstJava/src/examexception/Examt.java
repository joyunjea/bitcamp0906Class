package examexception;

import java.util.Scanner;

public class Examt {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int year = 0;
		String name = null;
		
		try {
			name = getName();
			System.out.println("아이디 : "+ name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			year = getYear();
			System.out.println("태어난해 : "+ year);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public static String getName() throws BadinputException{
		String name = null;
		
		System.out.println("아이디(영문자와 숫자만 조합) >> ");
		name = sc.nextLine();
		
		if(!name.matches("^[a-zA-Z0-9]*$")) {
			//예외객체생성
			BadinputException e = new BadinputException(name);
			throw e;
		}
		return name;
	}
	public static int getYear() {
		System.out.println("태어난 년도");
		int year = sc.nextInt();
		return year;
	}
}
