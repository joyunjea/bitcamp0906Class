package controller;

import java.util.ArrayList;
import java.util.List;



import dto.MemberDTO;
import dto.MovieRateDTO;
/*Control + Shift + O 로 안쓰는 임포트 정리 */
import dto.ScreenInformationDTO;

/*
 영화상영정보관리기계
 기계 역할 : 영화상영 정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
 * */
public class ScreenInformationController {

	  /*
    	영화상영정보를 저장하고 있는 메모리 칩
    	입력하는 순서대로 0,1,2,3 인덱스를 가지고 차례대로 저장한다.
      */
    private ArrayList<ScreenInformationDTO> screenInformationDTOs;

    /*
    	영화상영정보 하나 하나를 고유번호를 생성해서 코드를 부여해준다.(여기서는 숫자를 차례대로 부여해준다.)
     */
    private int screeningInformationNo;/*ALT+SHIFT+R로 해당 변수를 참조하고 있는 모든 코드의 이름을 한번에 바꿔줄 수 있다.*/

    public ScreenInformationController() {
    	/*메모리칩 장착*/
        this.screenInformationDTOs = new ArrayList<ScreenInformationDTO>();
        /*데이터 고유번호 생성 숫자 초기화 */
        this.screeningInformationNo = 0;
        /*영화상영정보관리기계에 초기임시 데이터를 넣어준다.*/
        this.tumpDataInput();
    }


    public void tumpDataInput() {

    	this.insert(new ScreenInformationDTO(1, 1, "07:00"));
        this.insert(new ScreenInformationDTO(1, 1, "08:00"));
        this.insert(new ScreenInformationDTO(1, 1, "09:00"));
        this.insert(new ScreenInformationDTO(1, 1, "10:00"));
        this.insert(new ScreenInformationDTO(1, 1, "11:00"));
        this.insert(new ScreenInformationDTO(1, 1, "13:00"));
        this.insert(new ScreenInformationDTO(1, 2, "07:00"));
        this.insert(new ScreenInformationDTO(1, 2, "08:00"));
        this.insert(new ScreenInformationDTO(1, 2, "09:00"));
        this.insert(new ScreenInformationDTO(1, 3, "07:00"));
        this.insert(new ScreenInformationDTO(1, 3, "08:00"));
        this.insert(new ScreenInformationDTO(1, 3, "09:00"));
        this.insert(new ScreenInformationDTO(1, 3, "13:00"));
        this.insert(new ScreenInformationDTO(2, 1, "07:30"));
        this.insert(new ScreenInformationDTO(2, 1, "08:30"));
        this.insert(new ScreenInformationDTO(2, 2, "07:30"));
        this.insert(new ScreenInformationDTO(2, 2, "08:30"));
        this.insert(new ScreenInformationDTO(2, 3, "07:00"));
        this.insert(new ScreenInformationDTO(2, 3, "08:00"));
        this.insert(new ScreenInformationDTO(2, 3, "09:00"));
        this.insert(new ScreenInformationDTO(2, 3, "13:00"));
        this.insert(new ScreenInformationDTO(3, 1, "07:30"));
        this.insert(new ScreenInformationDTO(3, 2, "07:30"));
        this.insert(new ScreenInformationDTO(3, 3, "07:00"));


    }
    /*요청 : 메모리칩에 있는 데이터 전체를 내어줘!!!*/
    public List<ScreenInformationDTO> getScreenInformationDTOs() {

    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
        List<ScreenInformationDTO> screenInformationDTOTemps = new ArrayList<ScreenInformationDTO>();

        /*가지고 있던 메모리 칩에 내용을 새로운 메모리 칩에 영화상영정보 하나 하나 복사해서 넣어준다.*/
        for(ScreenInformationDTO tempDto : this.screenInformationDTOs) {
        	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
            ScreenInformationDTO copyDto = new ScreenInformationDTO(tempDto);
            screenInformationDTOTemps.add(copyDto);
        }
        /*복사완료된 메모리 칩을 내어준다.*/
        return screenInformationDTOTemps;

    }
    /*요청 : 입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아줘!!*/
      public int findIndex(int screeningInformationNo) {
    	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.screenInformationDTOs.size() ; iIndex++ ) {
        	/* 하나하나 끄집어 내서 */
            ScreenInformationDTO tempDto = this.screenInformationDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 확인 요청 들어온 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getScreeningInformationNo() == screeningInformationNo ) {
            	/* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }
        /*찾아봐도 없으면 -1을 넘겨준다.*/
        return -1;
      }
      /*요청 : 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾아줘*/
      public int findIndex(ScreenInformationDTO findDto) {
    	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
          for(int iIndex = 0 ; iIndex < this.screenInformationDTOs.size() ; iIndex++ ) {
        	  /* 하나하나 끄집어 내서 */
              ScreenInformationDTO tempDto = this.screenInformationDTOs.get(iIndex);
              /* 뽑은 데이터에 들어 있는 고유번호가 찾아달라고 입력받은 데이터 내용안에 있는 고유번호와 같은지 확인해서 같으면*/
              if(tempDto.getScreeningInformationNo() == findDto.getScreeningInformationNo()) {
            	  /* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                  return iIndex;
              }
          }
          /*찾아봐도 없으면 -1을 넘겨준다.*/
          return -1;
      }
      /*  입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
      public ScreenInformationDTO selectOne(int screeningInformationNo) {
    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(screeningInformationNo);

          if(iIndex != -1) {
        	  /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
              ScreenInformationDTO tempDto = this.screenInformationDTOs.get(iIndex);
              /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
              ScreenInformationDTO copyDto = new ScreenInformationDTO(tempDto);
              /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
              return copyDto;
          }else {
              return null;
          }

      }

      /* 입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 바꾼다. */
      public int update(ScreenInformationDTO updateDto) {
    	  /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(updateDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /* 메모리칩에 해당 인덱스의(iIndex)의 데이터를 입력받은 데이터로 바꿔넣는다. */
              this.screenInformationDTOs.set(iIndex, updateDto);
              /*한건 업데이트 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 업데이트 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }
      /*  입력받은 고유번호를 가지고 있는 데이터를 지워라 */
      public int delete(int screeningInformationNo) {
    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(screeningInformationNo);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.screenInformationDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /*  입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 삭제한다. */
      public int delete(ScreenInformationDTO deleteDto) {
    	  /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(deleteDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.screenInformationDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /* 입력받은 데이터에 영화관고유번호,영화고유번호,시간대 세개의 정보가
       * 칩에 들어있는 데이터들의  내용중 영화관고유번호,영화고유번호,시간대 세개의 정보가 모두 일치하는 데이터가 없다면
       * 해당 데이터에 고유번호를 새로 부여하고
                  메모리칩에 추가 입력한다. */
      public int insert(ScreenInformationDTO insertDto) {

          if(insertDto == null) {
              return 0;
          }

          /*입력받은 데이터 안에 내용중 영화관고유번호,영화고유번호,시간대 세개의 정보가
           * 이미 기입력된 메모리칩에 데이터와 세개모두 일치하는 데이터가 있는지 확인 하여 없다면
           * TRUE 있으면 false리턴 */
          if(!canUseScreenInformation(insertDto)){
              System.out.println("중복된 정보가 존재합니다.");
              System.out.println(insertDto);
              return 0;
          }
          /*여기까지 왔으면 입력하기전 검증은 완료 되었다.
          입력전에 고유번호를 새로 부여해주기 위하여 지금까지 부여된 최종번호에 1을 더해주고 입력하려는 데이터의
          고유번호에 부여된 번호를 넣어준다.*/
          this.screeningInformationNo = this.screeningInformationNo + 1;
          insertDto.setScreeningInformationNo(this.screeningInformationNo);
          /*메모리 칩에 넣어준다.*/
          this.screenInformationDTOs.add(insertDto);
          return 1;

      }
      /*입력받은 데이터 안에 내용중 영화관고유번호,영화고유번호,시간대 세개의 정보가
       * 이미 기입력된 메모리칩에 데이터와 세개모두 일치하는 데이터가 있는지 확인 하여 없다면
       * TRUE 있으면 false리턴 */
      public boolean canUseScreenInformation(ScreenInformationDTO insertDto) {
          for(ScreenInformationDTO tempDto : this.screenInformationDTOs) {

              if (
                      (tempDto.getCinemaNo() == insertDto.getCinemaNo())
                   && (tempDto.getMovieNo() == insertDto.getMovieNo())
                   && (tempDto.getShowTime().equals(insertDto.getShowTime()))
                 ) {
                  return false;
              }

          }
          return true;
      }

      /*요청 : 메모리칩에 있는 영화관 상영정보 데이터들 중  입력받은 영화관고유번호랑 꺼낸 데이터에 들어있는 영화관고유번호 필드에 숫자가 같은 데이터가 있으면 해당 데이터들을 모아서 줘 */
	public List<ScreenInformationDTO> getScreenInformationDTOsWithCinemaNo(int cinemaNo) {
		// TODO Auto-generated method stub
		/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
		List<ScreenInformationDTO> screenInformationDTOTemps = new ArrayList<ScreenInformationDTO>();
		/*가지고 있던 메모리 칩에 데이터를 하나 하나 꺼내서 확인한다.*/
        for(ScreenInformationDTO tempDto : this.screenInformationDTOs) {
        	/*입력받은 영화관 고유번호랑 꺼낸 데이터에 들어있는 영화관 고유번호 필드에 숫자가 같은 데이터가 있으면*/
        	if (tempDto.getCinemaNo() == cinemaNo){
        		/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
        		ScreenInformationDTO copyDto = new ScreenInformationDTO(tempDto);
        		screenInformationDTOTemps.add(copyDto);

            }

        }
        /*호출한곳으로 넘겨준다.*/
        return screenInformationDTOTemps;
	}

	/*요청 : 메모리칩에 있는 영화관 상영정보 데이터들 중  입력받은 영화고유번호랑 꺼낸 데이터에 들어있는 영화고유번호 필드에 숫자가 같은 데이터가 있으면 해당 데이터들을 모아서 줘 */
	public List<ScreenInformationDTO> getScreenInformationDTOsWithMovieNo(int movieNo) {
		// TODO Auto-generated method stub
		/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
		List<ScreenInformationDTO> screenInformationDTOTemps = new ArrayList<ScreenInformationDTO>();
		/*가지고 있던 메모리 칩에 데이터를 하나 하나 꺼내서 확인한다.*/
        for(ScreenInformationDTO tempDto : this.screenInformationDTOs) {
        	/*입력받은 영화 고유번호랑 꺼낸 데이터에 들어있는 영화 고유번호 필드에 숫자가 같은 데이터가 있으면*/
        	if (tempDto.getMovieNo() == movieNo){
        		/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
        		ScreenInformationDTO copyDto = new ScreenInformationDTO(tempDto);
        		screenInformationDTOTemps.add(copyDto);

            }

        }
        /*호출한곳으로 넘겨준다.*/
        return screenInformationDTOTemps;
	}

}
