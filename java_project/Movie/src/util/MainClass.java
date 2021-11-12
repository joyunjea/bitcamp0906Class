package util;

public class MainClass {

    public static void main(String[] args) {

        ScannerUtil scannerUtil = ScannerUtil.getInstance();
        //Scanner scanner = new Scanner(System.in);
        //scannerUtil.nextInt(scanner, "숫자를 입력하시오",1,20); 
        //System.out.println(scannerUtil.nextLine(scanner, "자료를 입력하세요 "));
        
        String BB = "bbb";
        
        if(BB.equals("bbb")) {
            System.out.println("BB.equals(\"bbb\") : 같습니다.");
        }
        
        if(BB.equalsIgnoreCase("bbb")) {
            System.out.println("BB.equalsIgnoreCase : 같습니다.");
        }
        
    }
}