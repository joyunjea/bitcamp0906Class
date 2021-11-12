package main;

import java.util.Scanner;

import util.ScannerUtil;
import viewer.MainViewer;
import controller.CinemaController;
import controller.MemberController;
import controller.MovieController;
import controller.MovieRateController;
import controller.ScreenInformationController;
import dto.MemberDTO;

public class MainRunner {
	
	public static void main(String[] args) {

		/*영화관 관리기계*/
	    CinemaController cinemaController = new CinemaController();
	    /*회원정보 관리기계*/
		MemberController memberController = new MemberController();
		/*영화 관리기계*/
		MovieController movieController = new MovieController();
		/*영화 평점관리기계*/
		MovieRateController movieRateController = new MovieRateController();
		/*영화상영정보관리기계*/
	    ScreenInformationController screenInformationController = new ScreenInformationController();

	    /*키보드입력기계*/
	    Scanner scanner = new Scanner(System.in);
	    /*키보드입력플러그인기계*/
	    ScannerUtil scannerUtil = ScannerUtil.getInstance();
	    
	    /*메인화면관리소*/
	    /*메인화면관리소를 [영화관 관리기계,회원정보 관리기계,영화 관리기계,영화 평점관리기계,영화상영정보관리기계] 넣어주면서 설립 */ 
	    MainViewer mainViewer = new MainViewer(cinemaController, memberController, movieController, movieRateController, screenInformationController, scanner);
	    
	    /*아래 분기문에서 사용할 변수들 선언*/
	    String memberId;
	    String memberPw;
	    String memberNick;
	    String memberGrade;
	    
	    /*회원 가입때 회원가입서로 사용하기 위해 회원가입서 양식 템플릿생성*/
	    MemberDTO insertMemberDTO = null;
	    
	    String message = "1. 로그인 2. 회원가입  3. 나가기";
	    
        boolean isContinue = true;
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);

            switch (userChoice) {
            case 1:
            	
            	memberId = scannerUtil.nextLine(scanner, "아이디를 입력하세요");              
                if(memberId == null || "".equals(memberId)) {
                    System.out.println("아이디가 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                memberPw = scannerUtil.nextLine(scanner, "패스워드를 입력하세요");              
                if(memberPw == null || "".equals(memberPw)) {
                    System.out.println("패스워드가 입력되지 않았습니다. 종료합니다.");
                    break;
                }
          
                /* 회원정보 관리기계를 이용하여 입력받은 아이디와 패스워드가 존재하는지 확인 존재하면 
                 * 해당 회원 정보 복사하여 전달 (해당 종이에 권한과 닉네임도 있음)
                 */
            	MemberDTO memberDTO = memberController.login(memberId, memberPw);
            	
            	if(memberDTO == null){
            		System.out.println("일치하는 정보가 없습니다.");
            	}else{
            		mainViewer.MainMenu(memberDTO);
            	}
            	
                break;
            
            case 2:
            	
            	memberId = scannerUtil.nextLine(scanner, "아이디를 입력하세요");              
                if(memberId == null || "".equals(memberId)) {
                    System.out.println("아이디가 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                memberPw = scannerUtil.nextLine(scanner, "패스워드를 입력하세요");              
                if(memberPw == null || "".equals(memberPw)) {
                    System.out.println("패스워드가 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                memberNick = scannerUtil.nextLine(scanner, "닉네임를 입력하세요");              
                if(memberNick == null || "".equals(memberNick)) {
                    System.out.println("닉네임이 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                memberGrade = scannerUtil.nextLine(scanner, "변경할 권한을 입력하세요 (0: 일반,1: 비평가,2: 관리자) ");
                if(memberGrade == null || "".equals(memberGrade)) {
                	  System.out.println("권한이 입력되지 않았습니다. 종료합니다.");
                      break;
                }
                /*회원가입양식서 받아서 위에서 입력받은 내용 기입*/
                insertMemberDTO = new MemberDTO(memberId, memberPw, memberNick, Integer.parseInt(memberGrade));
            	
                /* 회원정보 관리기계를 이용하여 입력받은 내용 저장해달라고 넣음 
                 */
            	int resultInt = memberController.insert(insertMemberDTO);
            	
            	 if(resultInt >= 1) {
                     System.out.println("입력에 성공하였습니다.");
                 }else {
                     System.out.println("입력에 실패하였습니다.");     
                 }
            	
                break;
                
            case 3:
                isContinue = false;
                break;
            default:
                System.out.println("없는 메뉴입니다.");
            }
        }
	    
		
	}

	
}