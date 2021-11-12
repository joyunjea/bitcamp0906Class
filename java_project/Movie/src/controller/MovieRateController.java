package controller;

import java.util.ArrayList;
import java.util.List;

import dto.CinemaDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.MovieRateDTO;

/*영화 평점관리기계
 기계 역할 : 영화평점정보를 요청한 내용에 맞추어서 복사해서 출력해주는 기계
 * */
public class MovieRateController {

	  /*
		영화평점정보를 저장하고 있는 메모리 칩
		입력하는 순서대로 0,1,2,3 인덱스를 가지고 차례대로 저장한다.
	  */
    private ArrayList<MovieRateDTO> movieRateDTOs;
    /*
	영화평점정보 하나 하나를 고유번호를 생성해서 코드를 부여해준다.(여기서는 숫자를 차례대로 부여해준다.)
    */
    private int movieRateNoIndex;/*ALT+SHIFT+R로 해당 변수를 참조하고 있는 모든 코드의 이름을 한번에 바꿔줄 수 있다.*/

    public MovieRateController() {
    	/*메모리칩 장착*/
        this.movieRateDTOs = new ArrayList<MovieRateDTO>();
        /*데이터 고유번호 생성 숫자 초기화 */
        this.movieRateNoIndex = 0;
        /*영화평점관리기계에 초기임시 데이터를 넣어준다.*/
        tumpDataInput();
    }

    public void tumpDataInput() {
        this.insert(new MovieRateDTO(1, MemberDTO.GRADE_NORMAL, 1, 8, "무서운 이야기였습니다."));
        this.insert(new MovieRateDTO(1, MemberDTO.GRADE_NORMAL, 2, 5, "팽귄귀여워요"));
        this.insert(new MovieRateDTO(1, MemberDTO.GRADE_NORMAL, 3, 10, "오징어 넘 재밌어요"));

        this.insert(new MovieRateDTO(3, MemberDTO.GRADE_CRITIC, 1, 5, "귀신이야기 혁명"));
        this.insert(new MovieRateDTO(3, MemberDTO.GRADE_CRITIC, 2, 7, "아쉬운 스토리"));
        this.insert(new MovieRateDTO(3, MemberDTO.GRADE_CRITIC, 3, 9, "최고의 영화"));
    }
    /*요청 : 메모리칩에 있는 데이터 전체를 내어줘!!!*/
    public List<MovieRateDTO> getMovieRateDTOs() {
    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
        List<MovieRateDTO> movieDTOTemps = new ArrayList<MovieRateDTO>();
        /*가지고 있던 메모리 칩에 내용을 새로운 메모리 칩에 영화평점정보 하나 하나 복사해서 넣어준다.*/
        for(MovieRateDTO tempDto : this.movieRateDTOs) {
        	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
            MovieRateDTO copyDto = new MovieRateDTO(tempDto);
            movieDTOTemps.add(copyDto);
        }

        return movieDTOTemps;

    }
    /*요청 : 메모리칩에 있는 영화평점정보 데이터들 중  입력받은 영화 고유번호랑 꺼낸 데이터에 들어있는 영화고유번호 필드에 숫자가 같은 데이터가 있으면 해당 데이터들을 모아서 줘 */
    public List<MovieRateDTO> getMovieRateDTOsWithMovieNo(int movieNo) {
       	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
        List<MovieRateDTO> movieRateDTOTemps = new ArrayList<MovieRateDTO>();
        /*가지고 있던 메모리 칩에 데이터를 하나 하나 꺼내서 확인한다.*/
        for(MovieRateDTO tempDto : this.movieRateDTOs) {

        	/*입력받은 영화 고유번호랑 꺼낸 데이터에 들어있는 영화고유번호 필드에 숫자가 같은 데이터가 있으면*/
            if (tempDto.getMovieNo() == movieNo){

            	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
                MovieRateDTO copyDto = new MovieRateDTO(tempDto);
                movieRateDTOTemps.add(copyDto);

            }
        }

        /*호출한곳으로 넘겨준다.*/
        return movieRateDTOTemps;

    }

    /*요청 : 메모리칩에 있는 영화평점정보 데이터들 중  입력받은 회원 고유번호랑 꺼낸 데이터에 들어있는 회원고유번호 필드에 숫자가 같은 데이터가 있으면 해당 데이터들을 모아서 줘 */
    public List<MovieRateDTO> getMovieRateDTOsWithUserNo(int userNo) {
    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
    	List<MovieRateDTO> movieRateDtoTemps = new ArrayList<MovieRateDTO>();
    	/*가지고 있던 메모리 칩에 데이터를 하나 하나 꺼내서 확인한다.*/
    	for (MovieRateDTO tempDto : this.movieRateDTOs) {
    		/*입력받은 회원 고유번호랑 꺼낸  데이터에 들어있는 회원고유번호 필드에 숫자가 같은 데이터가 있으면*/
            if (tempDto.getUserNo() == userNo){
            	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
                MovieRateDTO copyDto = new MovieRateDTO(tempDto);
                movieRateDtoTemps.add(copyDto);

            }

        }
    	/*호출한곳으로 넘겨준다.*/
    	return movieRateDtoTemps;
    }

    /*요청 : 메모리칩에 있는 영화평점정보 데이터들 중  입력받은 영화 고유번호랑, 입력받은 회원등급이 꺼낸 데이터에 들어있는 영화고유번호 필드에 숫자랑 회원등급필드의 숫자 둘다 일치하는 데이터가 있으면 해당 데이터들을 모아서 줘 */
    public List<MovieRateDTO> getMovieRateDTOsWithMovieNoAndMemberGrade(int movieNo,int memberGrade) {

    	/*새로운 메모리 칩을 하나 가져온다.(가지고 있는 메모리 칩을 내어주면 데이터가 손상되거나 분실될 수 있기에
    	 * 복사해서 주기 위하여 새로운 메모리 칩을 가져왔다. 복사하기 위하여 장착*/
    	List<MovieRateDTO> movieRateDtoTemps = new ArrayList<MovieRateDTO>();
    	/*가지고 있던 메모리 칩에 데이터를 하나 하나 꺼내서 확인한다.*/
    	for (MovieRateDTO tempDto : this.movieRateDTOs) {

    		/*입력받은 영화 고유번호랑  입력받은 회원 등급 번호 숫자가  꺼낸 데이터에 들어있는 영화고유번호 필드에 숫자랑 회원등급필드의 숫자 둘다 일치한다면 */
            if (
                (tempDto.getMovieNo() == movieNo) &&
                (tempDto.getMemberGrade() == memberGrade)
               ){
            	/*데이터를 새로운 데이터 공간을 만든 후 하나하나 새로운 메모리칩에 넣어준 후 */
                MovieRateDTO copyDto = new MovieRateDTO(tempDto);
                movieRateDtoTemps.add(copyDto);
            }

        }
    	/*호출한곳으로 넘겨준다.*/
    	return movieRateDtoTemps;

    }
    /*요청 : 입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아줘!!*/
      public int findIndex(int movieRateNo) {
        	/* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
        for(int iIndex = 0 ; iIndex < this.movieRateDTOs.size() ; iIndex++ ) {
        	/* 하나하나 끄집어 내서 */
            MovieRateDTO tempDto = this.movieRateDTOs.get(iIndex);
            /* 뽑은 데이터에 들어 있는 고유번호가 확인 요청 들어온 고유번호와 같은지 확인해서 같으면*/
            if(tempDto.getMovieRateNo() == movieRateNo ) {
            	/* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                return iIndex;
            }
        }

        return -1;
      }
      /*요청 : 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾아줘*/
      public int findIndex(MovieRateDTO findDto) {
    	  /* 가지고 있는 메모리 칩 데이터를 차례대로 하나 하나 끄집어 낸다.*/
          for(int iIndex = 0 ; iIndex < this.movieRateDTOs.size() ; iIndex++ ) {
        	  /* 하나하나 끄집어 내서 */
              MovieRateDTO tempDto = this.movieRateDTOs.get(iIndex);
              /* 뽑은 데이터에 들어 있는 고유번호가 찾아달라고 입력받은 데이터 내용안에 있는 고유번호와 같은지 확인해서 같으면*/
              if(tempDto.getMovieRateNo() == findDto.getMovieRateNo()) {
            	  /* 해당하는 데이터가 몇번째 인덱스에 저장되어있는지 알려준다.*/
                  return iIndex;
              }
          }

          return -1;
      }
      /*  입력받은 고유번호를 가지고 있는 데이터를 찾아줘 */
      public MovieRateDTO selectOne(int movieRateNo) {
          /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(movieRateNo);

          if(iIndex != -1) {
              /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
              MovieRateDTO tempDto = this.movieRateDTOs.get(iIndex);
              /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
              MovieRateDTO copyDto = new MovieRateDTO(tempDto);
              /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
              return copyDto;
          }else {
              /*없다면 널을 리턴해준다. */
              return null;
          }

      }
      /*  입력받은 사용자 고유 번호와 영화평점 고유번호를 모두 가지고 있는 데이터를 찾아줘 (유저고유번호를 추가로 넣는 이유는 남의 데이터를 못지우게 하기위함)*/
      public MovieRateDTO selectOne(int userNo,int movieRateNo) {
    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(movieRateNo);

          if(iIndex != -1) {
        	  /*가지고 있는 메모리 칩에서 해당 데이터를 끄집어 낸다.*/
              MovieRateDTO tempDto = this.movieRateDTOs.get(iIndex);
              /*끄집어낸 데이터에 들어있는 유저고유번호랑 입력받은 유저번호가 같은지 확인*/
              if(userNo == tempDto.getUserNo()) {
            	  /*새로운 데이터셋을 만들고 끄집어 낸 데이터 내용을 모두 복사해서 넣어준다. */
                  MovieRateDTO copyDto = new MovieRateDTO(tempDto);
                  /*원본을 그대로 복사한 데이터를 내어준다. (원본 손상 방지) */
                  return copyDto;
              }else {
            	  /*유저고유번호가 입력받은거랑 찾은게 다르다면 널 리턴*/
                  return null;
              }

          }else {
        	  /*일치하는 데이터가 없다면 널 리턴*/
              return null;
          }

      }

      /* 입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 바꾼다. */
      public int update(MovieRateDTO updateDto) {
          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(updateDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
              /* 메모리칩에 해당 인덱스의(iIndex)의 데이터를 입력받은 데이터로 바꿔넣는다. */
              this.movieRateDTOs.set(iIndex, updateDto);
              /* 1개 업데이트 되었다는 의미로 1을 리턴해준다.*/
              return 1;
          }
          /* 업데이트 대상이 없었다는 의미로 0을 리턴해준다.*/
          return 0;
     }
      /*  입력받은 고유번호를 가지고 있는 데이터를 지워라 */
      public int delete(int movieRateNo) {
    	  /*입력받은 고유번호가 메모리칩 몇번째 인덱스에 저장되어있는지 찾아주는 함수로 인덱스를 확인한다.*/
          int iIndex = findIndex(movieRateNo);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.movieRateDTOs.remove(iIndex);
              return 1;
          }
          /*해당 고유번호가 메모리 칩에 존재하지 않는다면 삭제 내역이 없다는 표시로 0을 응답준다.*/
          return 0;
     }

      /*  입력받은 데이터 내용으로 해당 데이터의 고유번호랑
      메모리칩에 동일한  고유번호를 가진 데이터를 삭제한다. */
      public int delete(MovieRateDTO deleteDto) {
          /* 입력받은 데이터 내용안에 있는 고유번호랑 동일한 고유번호를 가진 데이터가 몇번째 인덱스에 있는지 찾는다.*/
          int iIndex = findIndex(deleteDto);
          /*해당 고유번호가 메모리 칩에 존재하고 있는 데이터라고 한다면*/
          if(iIndex != -1) {
        	  /*메모리칩의 해당 인덱스의 데이터를 지워라*/
              this.movieRateDTOs.remove(iIndex);
              /*한건 삭제 되었다는 의미로 1 리턴*/
              return 1;
          }
          /*삭제한 데이터가 없다는 의미로 0 리턴*/
          return 0;
     }
      /* 입력받은 데이터 내용으로
       * 해당 데이터에 고유번호를 새로 부여하고
                  메모리칩에 추가 입력한다. */
      public int insert(MovieRateDTO insertDto) {
    	  /*입력받은 데이터가 없다면 0을 리턴해준다. (입력 성공한 거 0개임)*/
          if(insertDto == null) {
              return 0;
          }
          /*입력전에 고유번호를 발급하고 입력 데이터에 넣어준 후 메모리칩에 넣어준다.*/
          this.movieRateNoIndex = this.movieRateNoIndex + 1;
          insertDto.setMovieRateNo(this.movieRateNoIndex);
          this.movieRateDTOs.add(insertDto);
          return 1;

      }



}
