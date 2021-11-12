package viewer;

import java.util.List;
import java.util.Scanner;

import controller.CinemaController;
import controller.MovieController;
import dto.CinemaDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import util.ScannerUtil;

/* 영화관리소 */
public class MovieViewer {
    
    private MovieController movieController;
    private Scanner scanner;
    private ScannerUtil scannerUtil;
    
    public MovieViewer(MovieController movieController, Scanner scanner) {
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
        String message = "1. 영화목록보기 2. 영화개별보기 3.돌아가기";
        boolean isContinue = true;
        
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectMovieNo = -1;
            MovieDTO selectMovieDTO = null;

            switch (userChoice) {
            case 1:
                 List<MovieDTO> returnMovieDTOs = movieController.getMovieDTOs();
                 
                 for(MovieDTO tempDto : returnMovieDTOs) {
                     System.out.println(tempDto);
                 }
                
                break;
            case 2:
                
                selectMovieNo = scannerUtil.nextInt(scanner, "상세보기할 영화번호를 입력해주세요");
                selectMovieDTO =  movieController.selectOne(selectMovieNo);
                
                if(selectMovieDTO != null) {
                    System.out.println(selectMovieDTO);
                }else {
                    System.out.println("해당영화번호는 존재하지 않습니다.");
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
    
    private void showMenuAdmin(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 영화목록보기 2. 영화개별보기 3.영화추가하기 4.영화수정하기 5.영화삭제하기 6.나가기";
        boolean isContinue = true;
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectMovieNo = -1;
            int resultInt = -1;
            MovieDTO selectMovieDTO = null;
            MovieDTO insertMovieDTO = null;
            MovieDTO updateMovieDTO = null;
            MovieDTO deleteMovieDTO = null;
            String movieName = null;
            String movieSummary =  null;
            String movieGrade = null;
            
            switch (userChoice) {
            
            case 1:
                List<MovieDTO> returnMovieDTOs = movieController.getMovieDTOs();
                
                for(MovieDTO tempDto : returnMovieDTOs) {
                    System.out.println(tempDto);
                }
               
               break;
           case 2:
               
               selectMovieNo = scannerUtil.nextInt(scanner, "상세보기할 영화번호를 입력해주세요");
               selectMovieDTO =  movieController.selectOne(selectMovieNo);
               
               if(selectMovieDTO != null) {
                   System.out.println(selectMovieDTO);
               }else {
                   System.out.println("해당영화번호는 존재하지 않습니다.");
               }
               
               break;
               
           case 3:
               
               movieName = scannerUtil.nextLine(scanner, "영화 이름을 입력하시오");              
               if(movieName == null || "".equals(movieName)) {
                   System.out.println("영화이름이 입력되지 않았습니다. 종료합니다.");
                   break;
               }
               
               movieSummary = scannerUtil.nextLine(scanner, "영화 요약내용을 입력하시오");              
               if(movieSummary == null || "".equals(movieSummary)) {
                   System.out.println("영화요약내용이 입력되지 않았습니다. 종료합니다.");
                   break;
               }
               
               movieGrade = scannerUtil.nextLine(scanner, "영화등급을 입력하시오(0:전체관람가,1:12세이상,2:15세이상,3:18세이상)");              
               if(movieGrade == null || "".equals(movieGrade)) {
                   System.out.println("영화등급이 입력되지 않았습니다. 종료합니다.");
                   break;
               }
               
               insertMovieDTO = new MovieDTO(movieName,movieSummary,Integer.parseInt(movieGrade));
               
               resultInt = movieController.insert(insertMovieDTO);
               if(resultInt >= 1) {
                   System.out.println("입력에 성공하였습니다.");
               }else {
                   System.out.println("입력에 실패하였습니다.");     
               }
               break;
               
           case 4:
               selectMovieNo = scannerUtil.nextInt(scanner, "수정할 영화번호를 입력해주세요");
               updateMovieDTO =  movieController.selectOne(selectMovieNo);
               
               if(updateMovieDTO != null) {
                   
                   movieName = scannerUtil.nextLine(scanner, "영화 이름을 입력하시오 (안할거면 엔터)");              
                   if(movieName != null && !"".equals(movieName)) {
                       updateMovieDTO.setMovieName(movieName);
                   }
                   movieSummary = scannerUtil.nextLine(scanner, "영화 요약내용을 입력하시오(안할거면 엔터)");              
                    if(movieSummary != null && !"".equals(movieSummary)) {
                        updateMovieDTO.setMovieSummary(movieSummary);
                   }
                   
                   movieGrade = scannerUtil.nextLine(scanner, "영화등급을 입력하시오(0:전체관람가,1:12세이상,2:15세이상,3:18세이상)(안할거면 엔터)");              
                    if(movieGrade != null && !"".equals(movieGrade)) {
                        updateMovieDTO.setMovieGrade(Integer.parseInt(movieGrade));
                   }
                   
                   resultInt = movieController.update(updateMovieDTO);
                   if(resultInt > 0) {
                       System.out.println("입력에 성공하였습니다.");
                   }else {
                       System.out.println("입력에 실패하였습니다.");
                   }
                   
               }else {
                   System.out.println("해당 영화번호는 존재하지 않습니다.");
                     
               }
               break;
           case 5:
               selectMovieNo = scannerUtil.nextInt(scanner, "삭제할 영화번호를 입력해주세요");
               deleteMovieDTO =  movieController.selectOne(selectMovieNo);
               
               if(deleteMovieDTO != null) {
                   String deleteYn = scannerUtil.nextLine(scanner, "정말 삭제하시겠습니까?(맞을시 Y입력 엔터)");
                   if("Y".equals(deleteYn)) {
                       movieController.delete(deleteMovieDTO);
                   }    
               }else {
                   System.out.println("해당 영화는 존재하지 않습니다.");
                     
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
    
}
