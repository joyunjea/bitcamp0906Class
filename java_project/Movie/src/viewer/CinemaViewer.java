package viewer;

import java.util.List;
import java.util.Scanner;

import controller.CinemaController;
import dto.CinemaDTO;
import dto.MemberDTO;
import util.ScannerUtil;

/*영화관 관리소*/
public class CinemaViewer {
	
	/*
	 영화관정보관리기계
	 기계 역할 : 영화관 정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
	*/
    private CinemaController cinemaController;
    /* 사용자 소통 도구*/
    private Scanner scanner;
    private ScannerUtil scannerUtil;

    /*영화관 관리소 생성자*/
    public CinemaViewer(CinemaController cinemaController, Scanner scanner) {
    	/* 영화관정보관리기계 외부(여기(CinemaViewer) 클래스 생성한 위치)에 생성되어 있는거 가져옴*/
        this.cinemaController = cinemaController;
        /* 사용자 소통 도구 외부로(여기(CinemaViewer) 클래스 생성한 위치) 부터 가져옴*/
        this.scanner = scanner;
        this.scannerUtil = ScannerUtil.getInstance();
    }

    /*가지고 있는 메뉴판 주세요*/
    /* 이 메뉴는 영화관 관리소를 사용하는 사용자에게 공개한 함수이기에 public*/
    public void showMenu(MemberDTO memberMyDTO) {
    	/*사용자가 가져온 신상정보를 확인하여 등급에 맞게 메뉴판을 보여줌*/
        if(MemberDTO.GRADE_ADMIN == memberMyDTO.getMemberGrade()) {
        	/*등급이 관리자라면 관리자 메뉴판*/
            showMenuAdmin(memberMyDTO);
        }else if(MemberDTO.GRADE_CRITIC == memberMyDTO.getMemberGrade()) {
        	/*등급이 비평가라면 비평가 메뉴판*/
            showMenuNormal(memberMyDTO);
        }else if(MemberDTO.GRADE_NORMAL == memberMyDTO.getMemberGrade()) {
        	/*등급이 일반이라면 일반인 메뉴판*/
            showMenuNormal(memberMyDTO);
        }
    }

    /*일반 메뉴를 보여줘*/
    /* 이 메뉴는 영화관 관리소에서 내부적으로만 사용하는 함수이기에 private 사용자는 다른 함수를 통해서 이 함수를 부를수만 있다.*/
    private void showMenuNormal(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
    	/**/
        String message = "1. 극장목록보기 2. 극장개별보기 3.돌아가기";
        boolean isContinue = true;

        while (isContinue) {
        	/* 사용자님 메뉴를 골라주세요*/
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectCinemaNo = -1;
            CinemaDTO selectCinemaDTO = null;

            switch (userChoice) {
            /* 1. 극장목록보기  */
            case 1:
            	/*요청 : 영화관정보 관리기계야 메모리칩에 있는 데이터 전체를 내어줘!!!*/
                 List<CinemaDTO> returnCinemaDTOs = cinemaController.getCinemaDTOs();

                 /* 데이터는 받았고 하나 하나 사용자에게 출력해줘야지*/
                 for(CinemaDTO tempDto : returnCinemaDTOs) {
                     System.out.println(tempDto);
                 }

                break;
            /*  2. 극장개별보기 */
            case 2:

            	/* 사용자님 상세보기할 극장번호 골라주세요*/
                selectCinemaNo = scannerUtil.nextInt(scanner, "상세보기할 극장번호를 입력해주세요");
                /*  영화관정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
                selectCinemaDTO =  cinemaController.selectOne(selectCinemaNo);

                /* 데이터가 존재 했다고 하면 보여주고 없으면 에러메시지를 찍어줘*/
                if(selectCinemaDTO != null) {
                    System.out.println(selectCinemaDTO);
                }else {
                    System.out.println("해당극장번호는 존재하지 않습니다.");
                }

                break;
           /*  3.돌아가기 */
            case 3:
                isContinue = false;
                break;
            default:
                System.out.println("없는 메뉴입니다.");
            }
        }

    }

    /*관리자 메뉴를 보여줘*/
    /* 이 메뉴는 영화관 관리소에서 내부적으로만 사용하는 함수이기에 private 사용자는 다른 함수를 통해서 이 함수를 부를수만 있다.*/
    private void showMenuAdmin(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 극장목록보기 2. 극장개별보기 3.극장추가하기 4.극장수정하기 5.극장삭제하기 6.나가기";
        boolean isContinue = true;
        while (isContinue) {
        	/* 사용자님 메뉴를 골라주세요*/
            int userChoice = scannerUtil.nextInt(scanner, message);
            int selectCinemaNo = -1;
            int resultInt = -1;
            CinemaDTO selectCinemaDTO = null;
            CinemaDTO insertCinemaDTO = null;
            CinemaDTO updateCinemaDTO = null;
            CinemaDTO deleteCinemaDTO = null;
            String cinemaName = null;
            String location =  null;
            String cinemaPhoneNo = null;

            switch (userChoice) {

            /* 1. 극장목록보기  */
            case 1:
            	/*요청 : 영화관정보 관리기계야 메모리칩에 있는 데이터 전체를 내어줘!!!*/
                List<CinemaDTO> returnCinemaDTOs = cinemaController.getCinemaDTOs();
                /* 데이터는 받았고 하나 하나 사용자에게 출력해줘야지*/
                for(CinemaDTO tempDto : returnCinemaDTOs) {
                    System.out.println(tempDto);
                }

               break;
           /* 2. 극장개별보기 */
           case 2:
        	   /* 사용자님 상세보기할 극장번호 골라주세요*/
               selectCinemaNo = scannerUtil.nextInt(scanner, "상세보기할 극장번호를 입력해주세요");
               /*  영화관정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
               selectCinemaDTO =  cinemaController.selectOne(selectCinemaNo);

               /* 데이터가 존재 했다고 하면 보여주고 없으면 에러메시지를 찍어줘*/
               if(selectCinemaDTO != null) {
                   System.out.println(selectCinemaDTO);
               }else {
                   System.out.println("해당극장번호는 존재하지 않습니다.");
               }

               break;
           /* 3.극장추가하기 */
           case 3:

               cinemaName = scannerUtil.nextLine(scanner, "극장 이름을 입력하시오");
               if(cinemaName == null || "".equals(cinemaName)) {
                   System.out.println("극장이름이 입력되지 않았습니다. 종료합니다.");
                   break;
               }

               location = scannerUtil.nextLine(scanner, "극장 위치를 입력하시오");
               if(location == null || "".equals(location)) {
                   System.out.println("극장위치가 입력되지 않았습니다. 종료합니다.");
                   break;
               }

               cinemaPhoneNo = scannerUtil.nextLine(scanner, "극장 전화번호를 입력하시오");
               if(cinemaPhoneNo == null || "".equals(cinemaPhoneNo)) {
                   System.out.println("극장전화번호가 입력되지 않았습니다. 종료합니다.");
                   break;
               }

               insertCinemaDTO = new CinemaDTO(cinemaName, location, cinemaPhoneNo);
               /*요청 : 영화관정보 관리기계야 메모리칩에 내가 주는 데이터를 넣어줘!!!*/
               resultInt = cinemaController.insert(insertCinemaDTO);
               /* 입력된 건수를 resultInt에 넘겨주기로 했으니깐 1이면 성공 0이면 실패*/
               if(resultInt >= 1) {
                   System.out.println("입력에 성공하였습니다.");
               }else {
                   System.out.println("입력에 실패하였습니다.");
               }
               break;
           /* 4.극장수정하기  */
           case 4:
               selectCinemaNo = scannerUtil.nextInt(scanner, "수정할 극장번호를 입력해주세요");
               /*  영화관정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
               updateCinemaDTO =  cinemaController.selectOne(selectCinemaNo);

               /* 복사해서 받은 데이터가 있었다고 하면*/
               if(updateCinemaDTO != null) {

            	   /* 데이터 수정할 부분이 있으면 수정 해주고 
            	    * */
            	   
            	   
                   cinemaName = scannerUtil.nextLine(scanner, "변경할 극장이름을 입력하세요(안할거면 엔터)");
                   if(cinemaName != null && !"".equals(cinemaName)) {
                       updateCinemaDTO.setCinemaName(cinemaName);
                   }
                   location = scannerUtil.nextLine(scanner, "변경할 위치를 입력하세요(안할거면 엔터)");
                   if(location != null && !"".equals(location)) {
                       updateCinemaDTO.setLocation(location);
                   }

                   cinemaPhoneNo = scannerUtil.nextLine(scanner, "변경할 전화번호를 입력하세요(안할거면 엔터)");
                   if(cinemaPhoneNo != null && !"".equals(cinemaPhoneNo)) {
                       updateCinemaDTO.setCinemaPhoneNo(cinemaPhoneNo);
                   }

                   /* 복사해서 준 데이터 수정해봤으니깐 원본데이터를 이 데이터로 바꿔줘*/
                   resultInt = cinemaController.update(updateCinemaDTO);
                   /* 업데이트 성공한 건수가 resultInt로 넘어옴으로 1이면성공 0이면 실패 */
                   if(resultInt > 0) {
                       System.out.println("입력에 성공하였습니다.");
                   }else {
                       System.out.println("입력에 실패하였습니다.");
                   }

               }else {
                   System.out.println("해당 극장번호는 존재하지 않습니다.");

               }
               break;
           /*  5.극장삭제하기 */
           case 5:
               selectCinemaNo = scannerUtil.nextInt(scanner, "삭제할 극장번호를 입력해주세요");
               /*  영화관정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
               deleteCinemaDTO =  cinemaController.selectOne(selectCinemaNo);

               /* 복사해서 받은 데이터가 있었다고 하면*/
               if(deleteCinemaDTO != null) {
            	   /* 진짜 지우겠냐고 함 물어보고*/
                   String deleteYn = scannerUtil.nextLine(scanner, "정말 삭제하시겠습니까?(맞을시 Y입력 엔터)");
                   /* 사용자가 Y라고 하니깐 요 복사된 데이터의 원본 데이터 삭제해줘*/
                   if("Y".equals(deleteYn)) {
                       cinemaController.delete(deleteCinemaDTO);
                   }
               }else {
                   System.out.println("해당 극장은 존재하지 않습니다.");

               }

               break;
           /* 6.나가기 */
           case 6:
               isContinue = false;
               break;
            default:
                System.out.println("없는 메뉴입니다.");
            }
        }
    }

}
