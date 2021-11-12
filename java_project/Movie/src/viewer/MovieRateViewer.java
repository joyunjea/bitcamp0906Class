package viewer;

import java.util.List;
import java.util.Scanner;

import controller.CinemaController;
import controller.MovieController;
import controller.MovieRateController;
import dto.CinemaDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.MovieRateDTO;
import util.ScannerUtil;

/*영화평점 관리소*/
public class MovieRateViewer {
    
    private MovieRateController movieRateController;
    private MovieController movieController;
    private Scanner scanner;
    private ScannerUtil scannerUtil;
    
    public MovieRateViewer(MovieRateController movieRateController,MovieController movieController, Scanner scanner) {
        this.movieRateController = movieRateController;
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

    private void showMenuNormal(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 평론 입력 하기 2. 평론 수정 하기 3. 평론 삭제 하기 4. 내가 평가 한 평론 보기 "
                + "5.영화별 전체 평점만 보기 6.영화별 평론가 평점+평론 목록 보기 7.영화별 일반 관람객 평점 평균만 보기 8.돌아가기";
        boolean isContinue = true;
        
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectMovieRateNo = -1;
            
            int resultInt = -1;
            MovieRateDTO insertMovieRateDTO = null;
            MovieRateDTO updateMovieRateDTO = null;
            MovieRateDTO deleteMovieRateDTO = null;
            List<MovieDTO> returnMovieDTOs = null;
            List<MovieRateDTO> returnMovieRateDTOs = null;
            int userNo;
            int memberGrade;
            int movieNo;
            String movieRate;
            String movieReview = null;
            StringBuffer sbr = null;
            
            userNo = memberMyDTO.getMemberNo();
            memberGrade = memberMyDTO.getMemberGrade();

            switch (userChoice) {
            case 1:
                
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
                
                movieRate = scannerUtil.nextLine(scanner, "평점을 입력하시오[0~10]");
                
                if(Integer.parseInt(movieRate) < 0 || Integer.parseInt(movieRate) > 10) {
                    System.out.println("평점이 잘못 입력되었습니다.. 종료합니다. : " + movieRate);
                    break;
                }
                
                movieReview = scannerUtil.nextLine(scanner, "영화평론을 입력하세요");              
                if(movieReview == null || "".equals(movieReview)) {
                    System.out.println("영화평론이 입력되지 않았습니다. 종료합니다.");
                    break;
                }
                
                insertMovieRateDTO = new MovieRateDTO(userNo, memberGrade, movieNo, Integer.parseInt(movieRate), movieReview);
                
                resultInt = movieRateController.insert(insertMovieRateDTO);
                if(resultInt >= 1) {
                    System.out.println("입력에 성공하였습니다.");
                }else {
                    System.out.println("입력에 실패하였습니다.");     
                }
                break;
                
            case 2:
                
                selectMovieRateNo = scannerUtil.nextInt(scanner, "수정할 영화평론번호를 입력해주세요");
                updateMovieRateDTO =  movieRateController.selectOne(userNo,selectMovieRateNo);
                
                if(updateMovieRateDTO != null) {
                    
                    movieRate = scannerUtil.nextLine(scanner, "평점을 입력하시오[0~10] (안할거면 엔터)");              
                     if(movieRate != null && !"".equals(movieRate)) {
                         updateMovieRateDTO.setMovieRate(Integer.parseInt(movieRate));
                    }
                     
                     movieReview = scannerUtil.nextLine(scanner, "영화평론을 입력하세요 (안할거면 엔터)");              
                    if(movieReview != null && !"".equals(movieReview)) {
                        updateMovieRateDTO.setMovieReview(movieReview);
                    }
                   
                    resultInt = movieRateController.update(updateMovieRateDTO);
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
                selectMovieRateNo = scannerUtil.nextInt(scanner, "삭제할 평론번호를 입력해주세요");
                deleteMovieRateDTO =  movieRateController.selectOne(userNo,selectMovieRateNo);
                
                
                if(deleteMovieRateDTO != null) {
                    String deleteYn = scannerUtil.nextLine(scanner, "정말 삭제하시겠습니까?(맞을시 Y입력 엔터)");
                    if("Y".equals(deleteYn)) {
                        movieRateController.delete(deleteMovieRateDTO);
                    }    
                }else {
                    System.out.println("해당 평론은 존재하지 않습니다.");
                      
                }
                
                break;
            case 4:
                
                returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithUserNo(userNo);
                
                for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                    System.out.println(tempDto);
                }
                
                break;
            
            case 5:
                
                returnMovieDTOs = movieController.getMovieDTOs();
                sbr = new StringBuffer();
                for(MovieDTO tempDto : returnMovieDTOs) {
                    sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                }
                
                movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                
                returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNo(movieNo);
                
                for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                    System.out.println(tempDto);
                }
                
                break;
            
            case 6:
                
                returnMovieDTOs = movieController.getMovieDTOs();
                sbr = new StringBuffer();
                for(MovieDTO tempDto : returnMovieDTOs) {
                    sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                }
                
                movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                
                returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNoAndMemberGrade(movieNo, MemberDTO.GRADE_CRITIC);
                
                for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                    System.out.println(tempDto);
                }
                
                break;    
            
            case 7:
                
                returnMovieDTOs = movieController.getMovieDTOs();
                sbr = new StringBuffer();
                for(MovieDTO tempDto : returnMovieDTOs) {
                    sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                }
                
                movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                
                returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNoAndMemberGrade(movieNo, MemberDTO.GRADE_NORMAL);
                
                int sumRate = 0;
                int sumRateCnt = returnMovieRateDTOs.size();
                
                for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                	sumRate = sumRate + tempDto.getMovieRate();
                }
                
               System.out.println("영화평점 : " + Math.round((sumRate/sumRateCnt)));
                
                break;                    
                
            case 8:
                isContinue = false;
                break;
                
             default:
                 System.out.println("없는 메뉴입니다.");
             
            }
        }
        
    }
    
    private void showMenuAdmin(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
    	 String message = "1.영화별 전체 평점만 보기 2.영화별 평론가 평점+평론 목록 보기  3.영화별 일반 관람객 평점 평균만 보기 4.돌아가기";
         boolean isContinue = true;
         
         while (isContinue) {
             int userChoice = scannerUtil.nextInt(scanner, message);
             
             List<MovieDTO> returnMovieDTOs = null;
             List<MovieRateDTO> returnMovieRateDTOs = null;
             int movieNo;
             StringBuffer sbr = null;
             
             switch (userChoice) {
             case 1:
                 
                 returnMovieDTOs = movieController.getMovieDTOs();
                 sbr = new StringBuffer();
                 for(MovieDTO tempDto : returnMovieDTOs) {
                     sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                 }
                 
                 movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                 
                 returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNo(movieNo);
                 
                 for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                     System.out.println(tempDto);
                 }
                 
                 break;
             
             case 2:
                 
                 returnMovieDTOs = movieController.getMovieDTOs();
                 sbr = new StringBuffer();
                 for(MovieDTO tempDto : returnMovieDTOs) {
                     sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                 }
                 
                 movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                 
                 returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNoAndMemberGrade(movieNo, MemberDTO.GRADE_CRITIC);
                 
                 for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                     System.out.println(tempDto);
                 }
                 
                 break;    
             
             case 3:
                 
                 returnMovieDTOs = movieController.getMovieDTOs();
                 sbr = new StringBuffer();
                 for(MovieDTO tempDto : returnMovieDTOs) {
                     sbr.append("[" + tempDto.getMovieNo()+":"+tempDto.getMovieName()+"]");
                 }
                 
                 movieNo = scannerUtil.nextInt(scanner, sbr.toString() + "\r\n조회할 영화 번호를 입력하시오");              
                 
                 returnMovieRateDTOs = movieRateController.getMovieRateDTOsWithMovieNoAndMemberGrade(movieNo, MemberDTO.GRADE_NORMAL);
                 
                 int sumRate = 0;
                 int sumRateCnt = returnMovieRateDTOs.size();
                 
                 for(MovieRateDTO tempDto : returnMovieRateDTOs) {
                 	sumRate = sumRate + tempDto.getMovieRate();
                 }
                 
                System.out.println("영화평점 : " + Math.round((sumRate/sumRateCnt)));
                 
                 break;                    
                 
             case 4:
                 isContinue = false;
                 break;
                 
              default:
                  System.out.println("없는 메뉴입니다.");
              
             }
         }
    }
    
}
