package ver02;
// 스캐너 버그

import java.util.Scanner;

public class test {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("숫자를 입력하세요");
    int num = sc.nextInt();
    
    
    System.out.println("문자를 입력하세요");
    String 휴지통 = sc.nextLine();
    String str = sc.nextLine();
    
    
    
    
    System.out.println("입력한 숫자: "+num+"입력한 문자: "+str);
    System.out.println("휴지통: "+휴지통);
    
    sc.close();
	
}
}
