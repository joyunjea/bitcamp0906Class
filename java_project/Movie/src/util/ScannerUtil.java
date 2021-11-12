package util;

import java.util.Scanner;

/**
 * 

  * @FileName : ScannerUtil.java
  * @Project : javaTest
  * @Date : 2021. 10. 1. 

  * @작성자 : 12bos

  * @변경이력 :

  * @프로그램 설명 :
 */
public class ScannerUtil {

    private static ScannerUtil instance;
    
    private ScannerUtil() {
        // TODO Auto-generated constructor stub
    }
    
    public static ScannerUtil getInstance() {
        if(instance == null) {
            instance = new ScannerUtil();
        }
        
        return instance;
    }
    
    private void printMessage(String message) {
        System.out.println(message);
        System.out.print("> ");
    }

    /**
     * 
    
      * @Method Name : nextInt
    
      * @작성일 : 2021. 10. 1.
    
      * @작성자 : 12bos
    
      * @변경이력 : 
    
      * @Method 설명 : 다음 입력한 숫자를 읽어서 리턴해 준다.
    
      * @param scanner
      * @param message
      * @return 입력한 글자
     */
    public int nextInt(Scanner scanner, String message) {
        printMessage(message);
        return scanner.nextInt(); /*block 함수*/
    }

    public int nextInt(Scanner scanner, String message, int min, int max) {
        int num = nextInt(scanner, message);

        while (!(num >= min && num <= max)) {
            System.out.println("===============================");
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("===============================\n");
            num = nextInt(scanner, message);
        }

        return num;
    }

    public String nextLine(Scanner scanner, String message) {
        
        printMessage(message);
        String temp = scanner.nextLine();

        if (temp.isEmpty()) {
            temp = scanner.nextLine();
        }

        return temp;
    }
 
}
