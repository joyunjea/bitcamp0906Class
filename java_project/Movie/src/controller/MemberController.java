package controller;

import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

/*회원정보관리기계
 기계 역할 : 회원 정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
 부가 기능 : 회원 검증 및 관련 데이터 리턴 기능
 * */
public class MemberController {

	 /*	회원정보를 저장하고 있는 메모리 칩 입력하는 순서대로 0,1,2,3 인덱스를 가지고 차례대로 저장한다.*/
    private List<MemberDTO> memberDTOs;
     /* 회원정보 하나 하나를 고유번호를 생성해서 코드를 부여해준다.(여기서는 숫자를 차례대로 부여해준다.)*/
    private int memberNoIndex;

    public MemberController() {

    	/*메모리칩 회원정보관리기계에 장착*/
        this.memberDTOs = new ArrayList<MemberDTO>();
        /*데이터 고유번호 생성 숫자 초기화 */
        this.memberNoIndex   = 0;
        /*회원정보관리기계에 초기임시 데이터를 넣어준다.*/
        tumpDataInput();

    }

    public void tumpDataInput() {
        this.insert(new MemberDTO("airjore1", "airjore1", "에어졸1" , MemberDTO.GRADE_NORMAL));
        this.insert(new MemberDTO("airjore2", "airjore2", "에어졸2" , MemberDTO.GRADE_ADMIN));
        this.insert(new MemberDTO("airjore3", "airjore3", "에어졸3" , MemberDTO.GRADE_CRITIC));
    }

    /*요청 : 메모리칩에 있는 데이터 전체를 내어줘!!!*/
    public List<MemberDTO> getMemberDTOs() {

    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
    	List<MemberDTO> returnList = new ArrayList<MemberDTO>();
        /*가지고 있던 메모리 칩에 내용을 새로운 메모리 칩에 회원정보 하나 하나 복사해서 넣어준다.*/
        for(MemberDTO tempDto : this.memberDTOs) {

        	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
            MemberDTO copyDto = new MemberDTO(tempDto);
            returnList.add(copyDto);
        }
        /*복사완료된 메모리 칩을 내어준다.*/
        return returnList;
    }

    /*요청 : 입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아줘!!*/
    public int findIndex(int memberNo) {

    	/* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.memberDTOs.size() ; iIndex++ ) {

        	/* 하나하나 끄집어 내서 */
            MemberDTO tempDto = this.memberDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 확인 요청 들어온 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getMemberNo() == memberNo ) {
            	/* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }

        return -1;
    }
    /*요청 : 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾아줘*/
    public int findIndex(MemberDTO findDto) {
  	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.memberDTOs.size() ; iIndex++ ) {
      	  /* 하나하나 끄집어 내서 */
            MemberDTO tempDto = this.memberDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 찾아달라고 입력받은 데이터 내용안에 있는 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getMemberNo() == findDto.getMemberNo()) {
          	  /* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }
        /*찾아봐도 없으면 -1을 넘겨준다.*/
        return -1;
    }
    /*  입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
    public MemberDTO selectOne(int memberNo) {
        /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
        int iIndex = findIndex(memberNo);

        if(iIndex != -1) {
            /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
            MemberDTO tempDto = this.memberDTOs.get(iIndex);
            /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
            MemberDTO copyDto = new MemberDTO(tempDto);
            /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
            return copyDto;
        }else {
            return null;
        }

    }
    /* 입력받은 데이터 내용으로 해당 데이터의 고유번호랑
    메모리칩에 동일한  고유번호를 가진 데이터를 바꾼다. */
     public int update(MemberDTO updateDto) {

         /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
         int iIndex = findIndex(updateDto);
         if(iIndex != -1) {
             /* 메모리칩에 해당 인덱스의(iIndex)의 데이터를 입력받은 데이터로 바꿔넣는다. */
             this.memberDTOs.set(iIndex, updateDto);
             /*한건 업데이트 되었다는 의미로 1 리턴*/
             return 1;
         }
         /*해당 고유번호가 메모리 칩에 존재하지 않는다면 업데이트 내역이 없다는 표시로 0을 응답준다.*/
         return 0;
    }
     /*  입력받은 고유번호를 가지고 있는 데이터를 지워라 */
     public int delete(int memberNo) {
   	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
         int iIndex = findIndex(memberNo);
         /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
         if(iIndex != -1) {
       	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
             this.memberDTOs.remove(iIndex);
             /*한건 삭제 되었다는 의미로 1 리턴*/
             return 1;
         }
         /*삭제한 데이터가 없다는 의미로 0 리턴*/
         return 0;
    }

     /*  입력받은 데이터 내용으로 해당 데이터의 고유번호랑
               메모리칩에 동일한  고유번호를 가진 데이터를 삭제한다.
     */
     public int delete(MemberDTO deleteDto) {
         /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
         int iIndex = findIndex(deleteDto);
         /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
         if(iIndex != -1) {
       	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
             this.memberDTOs.remove(iIndex);
             /*한건 삭제 되었다는 의미로 1 리턴*/
             return 1;
         }
         /*삭제한 데이터가 없다는 의미로 0 리턴*/
         return 0;
    }
     /* 입력받은 데이터 내용으로
      * 해당 데이터에 고유번호를 새로 부여하고
                 메모리칩에 추가 입력한다. */
     public int insert(MemberDTO insertDto) {

        if(insertDto == null) {
            return 0;
        }

        /*
         	회원정보는 ID가 중복되면 안된다는 추가 제약조건이 있다.
         	그래서 ID를 사용할 수 있는지 확인한 후 사용할 수 없다고 나오면
         	에러메시지를 뿌리고 0을(입력된 숫자 없음) 리턴하며 종료한다.
         */
        if(!canUseId(insertDto.getMemberId())){
            System.out.println("중복된 ID가 존재합니다.");
            System.out.println(insertDto);
            return 0;
        }

        /*++ 가 앞에붙고 뒤에 붙는 차이를 풀면 아래와 같다.*/

        //this.memberNoIndex = this.memberNoIndex + 1;
        //insertDto.setMemberNo(this.memberNoIndex);
        // ==> insertDto.setMemberNo(++this.memberNoIndex);

        //insertDto.setMemberNo(this.memberNoIndex);
        //this.memberNoIndex = this.memberNoIndex + 1;
        // ==> insertDto.setMemberNo(this.memberNoIndex++);

        /*입력전에 고유번호를 발급하고 입력 데이터에 넣어준 후 메모리칩에 넣어준다.*/
        this.memberNoIndex = this.memberNoIndex + 1;
        insertDto.setMemberNo(this.memberNoIndex);
        this.memberDTOs.add(insertDto);

        return 1;
    }

     /*멤버ID를 가지고 내 판을 다 뒤져서 이미 사용하고 있는 ID인지를 확인 한 후
      * 다 뒤질때까지 안나오면 사용가능하다고 알려주고 있으면 사용할 수 없다고 알려준다.*/
     public boolean canUseId(String memberId) {
         for(MemberDTO tempDto : memberDTOs) {
             if(tempDto.getMemberId().equals(memberId)) {
                 return false;
             }
         }
         return true;
     }

     /*
      내가 가진 메모리칩을 순서대로 모두 뒤져서
      요청받은 ID 를 가지고 있는 종이를 찾은 후
      해당종이의 적혀있는 패스워드가 입력받은 패스워드와 같은지를 확인해서
      같으면 true를 리턴하고
       종이가 없거나, 비밀번호가 틀리면 false를 리턴한다.
      */
     public MemberDTO login(String memberId,String memberPw) {

         for(MemberDTO tempDto : memberDTOs) {
             if(tempDto.getMemberId().equals(memberId)) {
                 if(tempDto.getMemberPw().equals(memberPw)) {
                	 /*찾은 고유 no를  고유NO로 데이터를 찾아주는 함수에 집어넣어서 해당 데이터를 호출한 곳으로 넘겨준다.*/
                     return selectOne(tempDto.getMemberNo());
                 }else {
                     System.out.println("비밀번호가 틀립니다.");
                     return null;
                 }
             }
         }
         System.out.println("존재하지 않는 아이디입니다.");
         return null;

     }

}
