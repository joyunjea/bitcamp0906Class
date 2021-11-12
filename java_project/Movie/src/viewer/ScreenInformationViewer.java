package viewer;

import java.util.List;
import java.util.Scanner;

import controller.CinemaController;
import controller.MovieController;
import controller.MovieRateController;
import controller.ScreenInformationController;
import dto.CinemaDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.MovieRateDTO;
import dto.ScreenInformationDTO;
import util.ScannerUtil;

/*영화상영정보관리 관리소*/
public class ScreenInformationViewer {
    
    private ScreenInformationController screenInformationController;
    private CinemaController cinemaController;
    private MovieController movieController;
    private Scanner scanner;
    private ScannerUtil scannerUtil;
    
    public ScreenInformationViewer(ScreenInformationController screenInformationController
    		,CinemaController cinemaController,MovieController movieController, Scanner scanner) {
        this.screenInformationController = screenInformationController;
        this.cinemaController = cinemaController;
        this.movieController = movieController;
        this.scanner = scanner;
        this.scannerUtil = ScannerUtil.getInstance();
    }
    
    public void showMenu(MemberDTO memberMyDTO) {
        if(MemberDTO.GRADE_ADMIN == memberMyDTO.getMemberGrade()) {
            showMenuAdmin(memberMyDTO);
        }else if(MemberDTO.GRADE_CRITIC == memberMyDTO.getMemberGrade()) {
            showMenuNormal(memberMyDTO);
        }else if(MemberDTO.GRADE_NORMAL == memberMyDTO.getMemberGrade()) {
            showMenuNormal(memberMyDTO);
        }
    }

    private void showMenuAdmin(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 상영시간 입력 하기 2. 상영시간 수정 하기 3. 상연시간 삭제 하기  4.영화관 별 상영시간 보기  5.영화별 상영시간 보기 6.돌아가기 ";
        boolean isContinue = true;
        
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectScreeningInformationNo = -1;
            
            int resultInt = -1;
            ScreenInformationDTO insertScreenInformationDTO = null;
            ScreenInformationDTO updateScreenInformationDTO = null;
            ScreenInformationDTO deleteScreenInformationDTO = null;
            List<CinemaDTO> returCinemaDTOs = null;
            List<MovieDTO> returnMovieDTOs = null;
            List<ScreenInformationDTO> returnScreenInformationDTOs = null;
            
            int cinemaNo;
            int movieNo;
            String showTime;
            
            StringBuffer sbr = null;
            
            switch (userChoice) {
            case 1:
            	
            	returCinemaDTOs = cinemaController.getCinemaDTOs();
                sbr = new StringBuffer();
                for(CinemaDTO tempDto : returCinemaDTOs) {
                    sbr.append("[" + tempDto.getCinemaNo()+":"+tempDto.getCinemaName()+"]");
                }
                
                cinemaNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화관 번호를 입력하시오");              
                
                if(cinemaController.findIndex(cinemaNo) < 0) {
                    System.out.println("없는 영화관번호입니다. 종료합니다. : " + cinemaNo);
                    break;
                }
                
                returnMovieDTOs = movieController.getMovieDTOs();
                sbr = new StringBuffer();
                for(MovieDTO tempDto : returnMovieDTOs) {
                    sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                }
                
                movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화 번호를 입력하시오");              
                
                if(movieController.findIndex(movieNo) < 0) {
                    System.out.println("없는 영화번호입니다. 종료합니다. : " + movieNo);
                    break;
                }
                
                showTime = scannerUtil.nextLine(scanner, "상영시간을 입력하시오[HH:MM]");
                
                if(showTime == null || "".equals(showTime)) {
                    System.out.println("상영시간이 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                
                insertScreenInformationDTO = new ScreenInformationDTO(movieNo, cinemaNo, showTime);
                
                resultInt = this.screenInformationController.insert(insertScreenInformationDTO);
                if(resultInt >= 1) {
                    System.out.println("입력에 성공하였습니다.");
                }else {
                    System.out.println("입력에 실패하였습니다.");     
                }
                break;
                
            case 2:
                
            	selectScreeningInformationNo = this.scannerUtil.nextInt(scanner, "수정할 상영정보번호를 입력해주세요");
            	updateScreenInformationDTO =  this.screenInformationController.selectOne(selectScreeningInformationNo);
                
                if(updateScreenInformationDTO != null) {
                    
                	showTime = this.scannerUtil.nextLine(scanner, "상영시간을 입력하시오[HH:MM]");             
                     if(showTime != null && !"".equals(showTime)) {
                    	 updateScreenInformationDTO.setShowTime(showTime);
                    }
                   
                    resultInt = this.screenInformationController.update(updateScreenInformationDTO);
                    if(resultInt > 0) {
                        System.out.println("입력에 성공하였습니다.");
                    }else {
                        System.out.println("입력에 실패하였습니다.");
                    }
                    
                }else {
                    System.out.println("해당 평론번호는 존재하지 않습니다.");
                      
                }
                break;
             
            case 3:
            	selectScreeningInformationNo = this.scannerUtil.nextInt(scanner, "삭제할 상영정보번호를 입력해주세요");
            	deleteScreenInformationDTO =  this.screenInformationController.selectOne(selectScreeningInformationNo);
                
                
                if(deleteScreenInformationDTO != null) {
                    String deleteYn = scannerUtil.nextLine(scanner, "정말 삭제하시겠습니까?(맞을시 Y입력 엔터)");
                    if("Y".equals(deleteYn)) {
                    	this.screenInformationController.delete(deleteScreenInformationDTO);
                    }    
                }else {
                    System.out.println("해당 평론은 존재하지 않습니다.");
                      
                }
                
                break;
            case 4:
            	
            	returCinemaDTOs = cinemaController.getCinemaDTOs();
                sbr = new StringBuffer();
                for(CinemaDTO tempDto : returCinemaDTOs) {
                    sbr.append("[" + tempDto.getCinemaNo()+":"+tempDto.getCinemaName()+"]");
                }
                
                cinemaNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화관 번호를 입력하시오");              
                
                if(cinemaController.findIndex(cinemaNo) < 0) {
                    System.out.println("없는 영화관번호입니다. 종료합니다. : " + cinemaNo);
                    break;
                }
                
                returnScreenInformationDTOs = this.screenInformationController.getScreenInformationDTOsWithCinemaNo(cinemaNo);
                
                for(ScreenInformationDTO tempDto : returnScreenInformationDTOs) {
                	 
                	MovieDTO movieDTO = this.movieController.selectOne(tempDto.getMovieNo());
                	CinemaDTO cinemaDTO = this.cinemaController.selectOne(tempDto.getCinemaNo());
                	System.out.println("["+movieDTO.getMovieName()+"]["+cinemaDTO.getCinemaName()+"]["+tempDto.getShowTime()+"]");
                }
                
                break;
            
            case 5:
                
            	returnMovieDTOs = movieController.getMovieDTOs();
                sbr = new StringBuffer();
                for(MovieDTO tempDto : returnMovieDTOs) {
                    sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                }
                
                movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화 번호를 입력하시오");              
                
                if(movieController.findIndex(movieNo) < 0) {
                    System.out.println("없는 영화번호입니다. 종료합니다. : " + movieNo);
                    break;
                }
                
                returnScreenInformationDTOs = this.screenInformationController.getScreenInformationDTOsWithMovieNo(movieNo);
                
                for(ScreenInformationDTO tempDto : returnScreenInformationDTOs) {
                	MovieDTO movieDTO = this.movieController.selectOne(tempDto.getMovieNo());
                	CinemaDTO cinemaDTO = this.cinemaController.selectOne(tempDto.getCinemaNo());
                	System.out.println("["+movieDTO.getMovieName()+"]["+cinemaDTO.getCinemaName()+"]["+tempDto.getShowTime()+"]");
                }
                
                break;
           
            case 6:
                isContinue = false;
                break;
                
             default:
                 System.out.println("없는 메뉴입니다.");
             
            }
        }
        
    }
    
    private void showMenuNormal(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
    	 String message = "1.영화관 별 상영시간 보기  2.영화별 상영시간 보기 3.돌아가기 ";
         boolean isContinue = true;
         
         while (isContinue) {
             int userChoice = scannerUtil.nextInt(scanner, message);
             List<CinemaDTO> returCinemaDTOs = null;
             List<MovieDTO> returnMovieDTOs = null;
             List<ScreenInformationDTO> returnScreenInformationDTOs = null;
             
             int cinemaNo;
             int movieNo;
             
             StringBuffer sbr = null;
             
             switch (userChoice) {
            
             case 1:
             	
             	returCinemaDTOs = cinemaController.getCinemaDTOs();
                 sbr = new StringBuffer();
                 for(CinemaDTO tempDto : returCinemaDTOs) {
                     sbr.append("[" + tempDto.getCinemaNo()+":"+tempDto.getCinemaName()+"]");
                 }
                 
                 cinemaNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화관 번호를 입력하시오");              
                 
                 if(cinemaController.findIndex(cinemaNo) < 0) {
                     System.out.println("없는 영화관번호입니다. 종료합니다. : " + cinemaNo);
                     break;
                 }
                 
                 returnScreenInformationDTOs = this.screenInformationController.getScreenInformationDTOsWithCinemaNo(cinemaNo);
                 
                 for(ScreenInformationDTO tempDto : returnScreenInformationDTOs) {
                	 
                	 MovieDTO movieDTO = this.movieController.selectOne(tempDto.getMovieNo());
                	 CinemaDTO cinemaDTO = this.cinemaController.selectOne(tempDto.getCinemaNo());                	 
                	 System.out.println("["+movieDTO.getMovieName()+"]["+cinemaDTO.getCinemaName()+"]["+tempDto.getShowTime()+"]");
                	 
                 }
                 
                 break;
             
             case 2:
                 
             	returnMovieDTOs = movieController.getMovieDTOs();
                 sbr = new StringBuffer();
                 for(MovieDTO tempDto : returnMovieDTOs) {
                     sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                 }
                 
                 movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n영화 번호를 입력하시오");              
                 
                 if(movieController.findIndex(movieNo) < 0) {
                     System.out.println("없는 영화번호입니다. 종료합니다. : " + movieNo);
                     break;
                 }
                 
                 returnScreenInformationDTOs = this.screenInformationController.getScreenInformationDTOsWithMovieNo(movieNo);
                 
                 for(ScreenInformationDTO tempDto : returnScreenInformationDTOs) {
                	 
                	 MovieDTO movieDTO = this.movieController.selectOne(tempDto.getMovieNo());
                	 CinemaDTO cinemaDTO = this.cinemaController.selectOne(tempDto.getCinemaNo());
                	 System.out.println("["+movieDTO.getMovieName()+"]["+cinemaDTO.getCinemaName()+"]["+tempDto.getShowTime()+"]");
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
