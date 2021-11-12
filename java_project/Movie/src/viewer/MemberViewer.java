package viewer;

import java.util.List;
import java.util.Scanner;

import controller.MemberController;
import dto.MemberDTO;
import util.ScannerUtil;

/*회원 관리소*/
public class MemberViewer {

	/*회원정보관리기계
	 기계 역할 : 회원 정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
	 부가 기능 : 회원 검증 및 관련 데이터 리턴 기능
	 * */
    private MemberController memberController;
    /* 사용자 소통 도구*/
    private Scanner scanner;
    private ScannerUtil scannerUtil;
    
    /*회원 관리소 생성자*/
    public MemberViewer(MemberController memberController, Scanner scanner) {
    	/* 회원정보관리기계 외부(여기(MemberViewer) 클래스 생성한 위치)에 생성되어 있는거 가져옴*/
        this.memberController = memberController;
        /* 사용자 소통 도구 외부로(여기(MemberViewer) 클래스 생성한 위치) 부터 가져옴*/
        this.scanner = scanner;
        this.scannerUtil = ScannerUtil.getInstance();
    }
    /*가지고 있는 메뉴판 주세요*/
    /* 이 메뉴는 회원 관리소를 사용하는 사용자에게 공개한 함수이기에 public*/
    public void showMenu(MemberDTO memberMyDTO) {
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
    /* 이 메뉴는 회원 관리소에서 내부적으로만 사용하는 함수이기에 private 사용자는 다른 함수를 통해서 이 함수를 부를수만 있다.*/
    private void showMenuNormal(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 상세정보기(본인것) 2. 내정보 수정하기 3. 탈퇴하기 4.돌아가기";
        boolean isContinue = true;
        while (isContinue) {
        	/* 사용자님 메뉴를 골라주세요*/
            int userChoice = scannerUtil.nextInt(scanner, message);

            switch (userChoice) {
            /* 1. 상세정보기(본인것) */
            case 1:
            	/* 내 정보는 구지 회원정보관리 기계에다가 안물어봐도 MainView에서 로그인할때 받았던 내정보를 함수의 인자로 받았기 때문에 그대로 보여주면 된다. */
                System.out.println(memberMyDTO);
                break;
            /* 2. 내정보 수정하기 */
            case 2:
                
                String memberPw = scannerUtil.nextLine(scanner, "변경할 비밀번호를 입력하세요(안할거면 엔터)");
                if(memberPw != null &&  !"".equals(memberPw)) {
                    memberMyDTO.setMemberPw(memberPw);
                }
                String memberNick = scannerUtil.nextLine(scanner, "변경할 닉네임을 입력하세요(안할거면 엔터)");
                if(memberNick != null && !"".equals(memberNick)) {
                    memberMyDTO.setMemberNick(memberNick);
                }
                
                /* 복사해서 준 데이터 수정해봤으니깐 원본데이터를 이 데이터로 바꿔줘 (이 데이터는 MainView에서 로그인할때 복사해서 받았던 내 정보다) */
                int resultInt = memberController.update(memberMyDTO);
                if(resultInt > 0) {
                    System.out.println("입력에 성공하였습니다.");
                }else {
                    System.out.println("입력에 실패하였습니다.");
                }
                
                break;
            /*  3. 탈퇴하기 */
            case 3:
                
                String deleteYn = scannerUtil.nextLine(scanner, "정말 탈퇴하시겠습니까?(맞을시 Y입력 엔터)");
                if("Y".equals(deleteYn)) {
                	/*  입력받은 데이터 내용으로(내정보) 해당 데이터의 고유번호랑
                    	메모리칩에 동일한  고유번호를 가진 데이터를 삭제해줘 >> 내 데이터 지워줘
                	 */
                    resultInt = memberController.delete(memberMyDTO);
                    if(resultInt >= 1) {
                        System.out.println("탈퇴에 성공하였습니다.");
                    }else {
                        System.out.println("탈퇴에 실패하였습니다.");
                    }
                }
                break;
            /* 4.돌아가기 */
            case 4:
                isContinue = false;
                break;
            default:
                System.out.println("없는 메뉴입니다.");
            }
        }
        
    }
    
    
    /*관리자 메뉴를 보여줘*/
    /* 이 메뉴는 회원 관리소에서 내부적으로만 사용하는 함수이기에 private 사용자는 다른 함수를 통해서 이 함수를 부를수만 있다.*/
    private   void showMenuAdmin(MemberDTO memberMyDTO) {
        // TODO Auto-generated method stub
        String message = "1. 전체멤버보기 2. 특정멤버 수정하기 3. 특정멤버 탈퇴하기 4. 특정멤버 권한변경하기 5.돌아가기";
        boolean isContinue = true;
        while (isContinue) {
            int userChoice = scannerUtil.nextInt(scanner, message);
            int memberNo = 0;
            MemberDTO updateMemberDTO = null;
            MemberDTO deleteMemberDTO = null;
            String memberGrade = "";
            
            switch (userChoice) {
            /*  1. 전체멤버보기 */
            case 1:
                List<MemberDTO> returnMemberDTOs = memberController.getMemberDTOs();
                for(MemberDTO tempDto : returnMemberDTOs) {
                    System.out.println(tempDto);
                }
                break;
            /*  2. 특정멤버 수정하기 */
            case 2:
                memberNo = scannerUtil.nextInt(scanner, "수정할 멤버번호를 입력해주세요");
                /*  회원정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
                updateMemberDTO =  memberController.selectOne(memberNo);
                
                if(updateMemberDTO != null) {
                    
                    String memberPw = scannerUtil.nextLine(scanner, "변경할 비밀번호를 입력하세요(안할거면 엔터)");
                    if(memberPw != null && !"".equals(memberPw)) {
                        updateMemberDTO.setMemberPw(memberPw);
                    }
                    String memberNick = scannerUtil.nextLine(scanner, "변경할 닉네임을 입력하세요(안할거면 엔터)");
                    if(memberNick != null && !"".equals(memberNick)) {
                        updateMemberDTO.setMemberNick(memberNick);
                    }
                    /* 복사해서 준 데이터 수정해봤으니깐 원본데이터를 이 데이터로 바꿔줘*/
                    int resultInt = memberController.update(updateMemberDTO);
                    /* 업데이트 성공한 건수가 resultInt로 넘어옴으로 1이면성공 0이면 실패 */
                    if(resultInt > 0) {
                        System.out.println("입력에 성공하였습니다.");
                    }else {
                        System.out.println("입력에 실패하였습니다.");
                    }
                }else {
                    System.out.println("해당 멤버는 존재하지 않습니다.");
                      
                }
                break;
            /*3. 특정멤버 탈퇴하기*/ 
            case 3:
                memberNo = scannerUtil.nextInt(scanner, "삭제할 멤버번호를 입력해주세요");
                /*  회원정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
                deleteMemberDTO =  memberController.selectOne(memberNo);
                
                if(deleteMemberDTO != null) {
                    String deleteYn = scannerUtil.nextLine(scanner, "정말 탈퇴하시겠습니까?(맞을시 Y입력 엔터)");
                    if("Y".equals(deleteYn)) {
                    	/* 사용자가 Y라고 하니깐 요 복사된 데이터의 원본 데이터 삭제해줘*/
                        memberController.delete(deleteMemberDTO);
                    }    
                }else {
                    System.out.println("해당 멤버는 존재하지 않습니다.");
                      
                }
                
                break;
            /*4. 특정멤버 권한변경하기*/
            case 4:
                
                memberNo = scannerUtil.nextInt(scanner, "권한을 변경할 멤버번호를 입력해주세요");
                /*  회원정보 관리기계야 메모리칩에서 입력받은 고유번호를 가지고 있는 데이터를 찾아서 복사해서 줘 */
                updateMemberDTO =  memberController.selectOne(memberNo);
                
                if(updateMemberDTO != null) {
                    
                    memberGrade = scannerUtil.nextLine(scanner, "변경할 권한을 입력하세요 (0: 일반,1: 비평가,2: 관리자) ");
                    if(memberGrade != null && !"".equals(memberGrade)) {
                        updateMemberDTO.setMemberGrade(Integer.parseInt(memberGrade));
                    }
                    
                    /* 복사해서 준 데이터 수정해봤으니깐 원본데이터를 이 데이터로 바꿔줘*/
                    memberController.update(updateMemberDTO);
                    
                }else {
                    System.out.println("해당 멤버는 존재하지 않습니다.");
                      
                }
               
                break;
            /*나가기*/
            case 5:
                isContinue = false;
                break;
            default:
                System.out.println("없는 메뉴입니다.");
            }
        }
    }

    
}
