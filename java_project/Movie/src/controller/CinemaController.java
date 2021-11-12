package controller;

import java.util.ArrayList;
import java.util.List;

import dto.CinemaDTO;
import dto.MemberDTO;

/*
 영화관정보관리기계
 기계 역할 : 영화관 정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
*/
public class CinemaController {


    /*
    영화관정보를 저장하고 있는 메모리 칩
    입력하는 순서대로 0,1,2,3 인덱스를 가지고 차례대로 저장한다.
    */
    private ArrayList<CinemaDTO> cinemaDTOs;

    /*
     영화관정보 하나 하나를 고유번호를 생성해서 코드를 부여해준다.(여기서는 숫자를 차례대로 부여해준다.)
    */
    private int cinemaNoIndex;


    public CinemaController() {
    	/*메모리칩 장착*/
        this.cinemaDTOs = new ArrayList<CinemaDTO>();
        /*데이터 고유번호 생성 숫자 초기화 */
        this.cinemaNoIndex = 0;
        /*영화관정보관리기계에 초기임시 데이터를 넣어준다.*/
        tumpDataInput();
    }

    public void tumpDataInput() {

        this.insert(new CinemaDTO("롯데시네마(월드타워)", "서울시송파구잠실", "00000000"));
        this.insert(new CinemaDTO("CGV(곡성)", "서울시곡성", "11111111"));
        this.insert(new CinemaDTO("메가박스(남원)", "서울시남원", "22222222"));
    }


    /*요청 : 메모리칩에 있는 데이터 전체를 내어줘!!!*/
    public List<CinemaDTO> getCinemaDTOs() {

    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
        List<CinemaDTO> cinemaDTOs = new ArrayList<CinemaDTO>();

        /*가지고 있던 메모리 칩에 내용을 새로운 메모리 칩에 영화관관리정보 하나 하나 복사해서 넣어준다.*/
        for(CinemaDTO tempDto : this.cinemaDTOs) {
        	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
            CinemaDTO copyDto = new CinemaDTO(tempDto);
            cinemaDTOs.add(copyDto);
        }

        /*복사완료된 메모리 칩을 내어준다.*/
        return cinemaDTOs;

    }

     /*요청 : 입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아줘!!*/
      public int findIndex(int cinemaNo) {

    	/* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.cinemaDTOs.size() ; iIndex++ ) {

        	/* 하나하나 끄집어 내서 */
            CinemaDTO tempDto = this.cinemaDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 확인 요청 들어온 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getCinemaNo() == cinemaNo ) {
            	/* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }
        /*찾아봐도 없으면 -1을 넘겨준다.*/
        return -1;
      }

      /*요청 : 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾아줘*/
      public int findIndex(CinemaDTO findDto) {

    	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
          for(int iIndex = 0 ; iIndex <= this.cinemaDTOs.size() ; iIndex++ ) {

        	  /* 하나하나 끄집어 내서 */
              CinemaDTO tempDto = this.cinemaDTOs.get(iIndex);
              /* 뽑은 데이터에 들어 있는 고유번호가 찾아달라고 입력받은 데이터 내용안에 있는 고유번호와 같은지 확인해서 같으면*/
              if(tempDto.getCinemaNo() == findDto.getCinemaNo()) {
            	  /* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                  return iIndex;
              }
          }
          /*찾아봐도 없으면 -1을 넘겨준다.*/
          return -1;
      }

      /*  입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
      public CinemaDTO selectOne(int cinemaNo) {

          /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(cinemaNo);

          if(iIndex != -1) {
              /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
              CinemaDTO tempDto = this.cinemaDTOs.get(iIndex);
              /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
              CinemaDTO copyDto = new CinemaDTO(tempDto);
              /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
              return copyDto;
          }else {
              return null;
          }

      }

      /* 입력받은 데이터 내용으로 해당 데이터의 고유번호랑
                   메모리칩에 동일한  고유번호를 가진 데이터를 바꾼다. */
      public int update(CinemaDTO updateDto) {

    	  /*업데이트 하기전에 입력받은 데이터의 전화번호가 이미 메모리칩에 들어있는 데이터 인지 확인 요청한다.*/
    	  /*중복된 번호가 있다면 업데이트 실패 의미로 0을 응답준다.*/
          if(!canUseCinemaPhoneNo(updateDto.getCinemaPhoneNo())){
              System.out.println("중복된 전화번호가 존재합니다.");
              System.out.println(updateDto);
              return 0;
          }

          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(updateDto);

          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
              /* 메모리칩에 해당 인덱스의(iIndex)의 데이터를 입력받은 데이터로 바꿔넣는다. */
              this.cinemaDTOs.set(iIndex, updateDto);
              /*한건 업데이트 되었다는 의미로 1 리턴*/
              return 1;
          }

          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 업데이트 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /*  입력받은 고유번호를 가지고 있는 데이터를 지워라 */
      public int delete(int cinemaNo) {

    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(cinemaNo);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.cinemaDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }


      /*  입력받은 데이터 내용으로 해당 데이터의 고유번호랑
                   메모리칩에 동일한  고유번호를 가진 데이터를 삭제한다. */
      public int delete(CinemaDTO deleteDto) {

          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(deleteDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.cinemaDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /* 입력받은 데이터 내용으로
       * 해당 데이터 내용의 전화번호가 메모리칩에 들어있는 데이터들 중 같은 전화번호를 가진 데이터가 없다면
       * 해당 데이터에 고유번호를 새로 부여하고
                  메모리칩에 추가 입력한다. */
      public int insert(CinemaDTO insertDto) {

          if(insertDto == null) {
              return 0;
          }

          /*입력하려는 데이터에 들어있는 전화번호에 - 가 있다면 제거해준다.*/
          correction(insertDto);

          /*입력 하기전에 입력받은 데이터의 전화번호가 이미 메모리칩에 들어있는 데이터 인지 확인 요청한다.*/
    	  /*중복된 번호가 있다면 입력 실패의미로 0을 응답준다.*/
          if(!canUseCinemaPhoneNo(insertDto.getCinemaPhoneNo())){
              System.out.println("중복된 전화번호가 존재합니다.");
              System.out.println(insertDto);
              return 0;
          }

          /*여기까지 왔으면 입력하기전 검증은 완료 되었다.
            입력전에 고유번호를 새로 부여해주기 위하여 지금까지 부여된 최종번호에 1을 더해주고 입력하려는 데이터의
            고유번호에 부여된 번호를 넣어준다.*/
          this.cinemaNoIndex = this.cinemaNoIndex + 1;
          insertDto.setCinemaNo(this.cinemaNoIndex);
          /*메모리 칩에 넣어준다.*/
          this.cinemaDTOs.add(insertDto);

          return 1;
      }

      /*입력한 전화번호가 메모리칩에 들어있는 데이터들의 전화번호 내용에 동일한 전화번호를 가진 데이터가 있는지 확인하여
       * 없으면 입력한 전화번호가 사용할 수 잇음을 알려주고 있으면 사용할 수 없다고 알려준다. */
     public boolean canUseCinemaPhoneNo(String cinemaPhoneNo) {
    	 /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
          for(CinemaDTO tempDto : this.cinemaDTOs) {
        	  /* 뽑은 데이터에 들어 있는 전화번호가 찾아달라고 입력받은 데이터 내용안에 있는 전화번호 와 같은지 확인해서 같으면*/
              if(tempDto.getCinemaPhoneNo().equals(cinemaPhoneNo)) {
            	  /*중복된 데이터가 있네요 쓸수없어요*/
                  return false;
              }
          }
          /*중복된 데이터가 없네요 쓸수있어요*/
          return true;
      }

     /* 입력받은 데이터 내용안에 전화번호 내용에 - 가 있으면 제거해준다.*/
     private void correction(CinemaDTO insertDto) {
         // TODO Auto-generated method stub
         //insertDto.setCinemaPhoneNo(insertDto.getCinemaPhoneNo().replaceAll("-", ""));
    	 /*입력받은 데이터로 부터 전화번호 필드의 데이터를 끄집어낸 후 */
           String tempPhoneNo = insertDto.getCinemaPhoneNo();
           /* -를 제거한 후 다시 해당하는 필드에 덮어써준다.*/
           tempPhoneNo = tempPhoneNo.replaceAll("-", "");
           insertDto.setCinemaPhoneNo(tempPhoneNo);
      }


}
