package controller;

import java.util.ArrayList;
import java.util.List;

import dto.MovieDTO;

/*영화정보 관리기계
    기계 역할 : 영화정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
 * */
public class MovieController {

	   /*
    	영화정보를 저장하고 있는 메모리 칩
    	입력하는 순서대로 0,1,2,3 인덱스를 가지고 차례대로 저장한다.
    */
    private ArrayList<MovieDTO> movieDTOs;

    /*
    	영화정보 하나 하나를 고유번호를 생성해서 코드를 부여해준다.(여기서는 숫자를 차례대로 부여해준다.)
   */
    private int movieNoIndex;/*ALT+SHIFT+R로 해당 변수를 참조하고 있는 모든 코드의 이름을 한번에 바꿔줄 수 있다.*/

    public MovieController() {
    	/*메모리칩 장착*/
        this.movieDTOs = new ArrayList<MovieDTO>();
        /*데이터 고유번호 생성 숫자 초기화 */
        this.movieNoIndex = 0;
        /*영화정보관리기계에 초기임시 데이터를 넣어준다.*/
        tumpDataInput();
    }

    public void tumpDataInput() {

        this.insert(new MovieDTO("곡성", "귀신이야기", MovieDTO.GRADE_OVER_18));
        this.insert(new MovieDTO("뽀로로", "팽귄이야기", MovieDTO.GRADE_ALL));
        this.insert(new MovieDTO("오징어게임", "오징어이야기", MovieDTO.GRADE_OVER_15));

    }

    /*요청 : 메모리칩에 있는 데이터 전체를 내어줘!!!*/
    public List<MovieDTO> getMovieDTOs() {

    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
        List<MovieDTO> movieDTOTemps = new ArrayList<MovieDTO>();

        /*가지고 있던 메모리 칩에 내용을 새로운 메모리 칩에 영화정보 하나 하나 복사해서 넣어준다.*/
        for(MovieDTO tempDto : this.movieDTOs) {
        	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
            MovieDTO copyDto = new MovieDTO(tempDto);
            movieDTOTemps.add(copyDto);
        }
        /*복사완료된 메모리 칩을 내어준다.*/
        return movieDTOTemps;

    }
    /*요청 : 입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아줘!!*/
      public int findIndex(int movieNo) {
      	/* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.movieDTOs.size() ; iIndex++ ) {
        	/* 하나하나 끄집어 내서 */
            MovieDTO tempDto = this.movieDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 확인 요청 들어온 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getMovieNo() == movieNo ) {
            	/* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }
        /*찾아봐도 없으면 -1을 넘겨준다.*/
        return -1;
      }
      /*요청 : 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾아줘*/
      public int findIndex(MovieDTO findDto) {
    	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
          for(int iIndex = 0 ; iIndex < this.movieDTOs.size() ; iIndex++ ) {
        	  /* 하나하나 끄집어 내서 */
              MovieDTO tempDto = this.movieDTOs.get(iIndex);
              /* 뽑은 데이터에 들어 있는 고유번호가 찾아달라고 입력받은 데이터 내용안에 있는 고유번호와 같은지 확인해서 같으면*/
              if(tempDto.getMovieNo() == findDto.getMovieNo()) {
            	  /* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                  return iIndex;
              }
          }
          /*찾아봐도 없으면 -1을 넘겨준다.*/
          return -1;
      }
      /*  입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
      public MovieDTO selectOne(int movieNo) {
          /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(movieNo);

          if(iIndex != -1) {
              /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
              MovieDTO tempDto = this.movieDTOs.get(iIndex);
              /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
              MovieDTO copyDto = new MovieDTO(tempDto);
              /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
              return copyDto;
          }else {
              /*없다면 널을 리턴해준다. */
              return null;
          }

      }
      /* 입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 바꾼다. */
      public int update(MovieDTO updateDto) {
          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(updateDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
              /* 메모리칩에 해당 인덱스의(iIndex)의 데이터를 입력받은 데이터로 바꿔넣는다. */
              this.movieDTOs.set(iIndex, updateDto);
              /* 1개 업데이트 되었다는 의미로 1을 리턴해준다.*/
              return 1;
          }
          /* 업데이트 대상이 없었다는 의미로 0을 리턴해준다.*/
          return 0;
     }
      /*  입력받은 고유번호를 가지고 있는 데이터를 지워라 */
      public int delete(int movieNo) {
    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(movieNo);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.movieDTOs.remove(iIndex);
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /*  입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 삭제한다. */
      public int delete(MovieDTO deleteDto) {

          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(deleteDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.movieDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*삭제한 데이터가 없다는 의미로 0 리턴*/
          return 0;
     }
      /* 입력받은 데이터 내용으로
       * 해당 데이터에 고유번호를 새로 부여하고
                  메모리칩에 추가 입력한다. */
      public int insert(MovieDTO insertDto) {

    	  /*입력받은 데이터가 없다면 0을 리턴해준다. (입력 성공한 거 0개임)*/
          if(insertDto == null) {
              return 0;
          }
          /*입력전에 고유번호를 발급하고 입력 데이터에 넣어준 후 메모리칩에 넣어준다.*/
          this.movieNoIndex = this.movieNoIndex + 1;
          insertDto.setMovieNo(this.movieNoIndex);
          this.movieDTOs.add(insertDto);
          return 1;

      }

}
