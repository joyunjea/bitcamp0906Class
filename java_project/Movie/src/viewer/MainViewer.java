package viewer;

import java.util.Scanner;

import util.ScannerUtil;
import controller.CinemaController;
import controller.MemberController;
import controller.MovieController;
import controller.MovieRateController;
import controller.ScreenInformationController;
import dto.MemberDTO;

/*메인 관리소 모든 관리소 화면을 총괄하는 중심화면*/
public class MainViewer {
	
	 /*영화관 관리소*/
	private CinemaViewer cinemaViewer;
	/*회원정보 관리소*/
	private MemberViewer memberViewer;
	/*영화평점 관리소*/
	private MovieRateViewer movieRateViewer;
	/*영화 관리소*/
	private MovieViewer movieViewer;
	/*영화 상영정보 관리소*/
	private ScreenInformationViewer screenInformationViewer;
	
	/*키보드입력기계*/
	private Scanner scanner;
	/*키보드입력플러그인기계*/
	private ScannerUtil scannerUtil;
	
	public MainViewer(CinemaController cinemaController,
			MemberController memberController, MovieController movieController,
			MovieRateController movieRateController,
			ScreenInformationController screenInformationController,
			Scanner scanner) {
		
		this.scanner = scanner;
		this.scannerUtil = ScannerUtil.getInstance();
		
		/*영화관 관리소를 설립하면서  MainRunner에서 넣어준 영화관 관리기계와,키보드입력기계를 안에 넣어줌*/
		this.cinemaViewer = new CinemaViewer(cinemaController, scanner);
		/*회원정보 관리소를 설립하면서  MainRunner에서 넣어준 회원정보 관리기계와,키보드입력기계를 안에 넣어줌*/
		this.memberViewer = new MemberViewer(memberController, scanner);
		/*영화 평점 관리소를 설립하면서  MainRunner에서 넣어준 영화 평점 관리기계와 , 영화관리기계, 키보드입력기계를 안에 넣어줌*/
		this.movieRateViewer = new MovieRateViewer(movieRateController, movieController, scanner);
		/*영화 관리소를 설립하면서  MainRunner에서 넣어준 영화 관리기계와, 키보드입력기계를 안에 넣어줌*/
		this.movieViewer = new MovieViewer(movieController, scanner);
		/*영화상영정보 관리소를 설립하면서  MainRunner에서 넣어준 영화상영정보 관리기계와  영화관관리기계, 영화관리기계,키보드입력기계를 안에 넣어줌*/
		this.screenInformationViewer = new ScreenInformationViewer(screenInformationController, cinemaController, movieController, scanner);
		
	}

	public void MainMenu(MemberDTO memberMyDTO) {
		// TODO Auto-generated method stub
		String message = "1.회원관리  2.영화관 관리  3.영화 관리  4.영화점수관리  5.상영정보관리  6.로그아웃";
        boolean isContinue = true;
        
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            StringBuffer sbr = null;
            
            switch (userChoice) {
            case 1:
            	/*회원정보 관리소에게 로그인한 USER정보를 넘겨주면서 메뉴를 열라고 요청 */        
                this.memberViewer.showMenu(memberMyDTO);
                break;
            
            case 2:
            	/*영화관 관리소에게 로그인한 USER정보를 넘겨주면서 메뉴를 열라고 요청 */        
               this.cinemaViewer.showMenu(memberMyDTO);
               break;    
            
            case 3:
            	/*영화 관리소에게 로그인한 USER정보를 넘겨주면서 메뉴를 열라고 요청 */
               this.movieViewer.showMenu(memberMyDTO); 
               break;                    
            
            case 4:
            	/*영화평점 관리소에게 로그인한 USER정보를 넘겨주면서 메뉴를 열라고 요청 */
                this.movieRateViewer.showMenu(memberMyDTO); 
                break;
               
            case 5:
            	/*영화상영시간 관리소에게 로그인한 USER정보를 넘겨주면서 메뉴를 열라고 요청 */
                this.screenInformationViewer.showMenu(memberMyDTO); 
                break;
                
            case 6:
                isContinue = false;
                break;
                
             default:
                 System.out.println("없는 메뉴입니다.");
             
            }
        }
	}

	
	
	
}