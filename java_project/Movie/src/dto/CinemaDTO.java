package dto;

/*종이 판이라 생각*/
public class CinemaDTO {
    
    private int cinemaNo;
    private String cinemaName;
    private String location; 
    private String cinemaPhoneNo;
    
    /*이 종이를 만들어 줄수 있는 방법은 아래 생성자 3가지 방법이 있다고 정의해놓은거다.
     * 1. 빈종이
     * 2. 쪽지로 받은 정보를 가지고 만든 종이
     * 3. 기존에 있던 종이정보를 가지고 배껴서 만든 종이 
    */
    
    /* 빈종이 주세요 */
    public CinemaDTO() {
        
    }
    
    /*
      쪽지에 영화관 이름,위치,전화번호를 주면서 야 이거 입력해서 통에 넣어놔
      당연히 고유번호는 그사람이 뭐를 넣어서 줘야 할지 알리가 없다 cinemaNo를 이 종이를 받은
      관리소에서 알아서 발급해서 넣을 것이다.
    */
    public CinemaDTO(String cinemaName, String location, String cinemaPhoneNo) {
        this.cinemaName = cinemaName;
        this.location = location;
        this.cinemaPhoneNo = cinemaPhoneNo;
    }

    /*
     누군가 나한테 거기 통에 있는 어떤 종이줘 라고 말할 때
     원본을 줄 수 없으니 새로운 종이를 만들고 거기에 
     기존 정보를 하나 하나 배껴서 넣어서 복사 종이를 주려고 한다.
     이때는 배껴적는거니 cinemaNo도 원래 적혀있는 정보를 배껴서 넣어줄 수 있다.
     * */
    public CinemaDTO(CinemaDTO anotherDTO) {
        this.cinemaNo      = anotherDTO.cinemaNo;
        this.cinemaName    = anotherDTO.cinemaName;
        this.location      = anotherDTO.location;
        this.cinemaPhoneNo = anotherDTO.cinemaPhoneNo;
    }
    
    public int getCinemaNo() {
        return cinemaNo;
    }
    public void setCinemaNo(int cinemaNo) {
        this.cinemaNo = cinemaNo;
    }
    public String getCinemaName() {
        return cinemaName;
    }
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getCinemaPhoneNo() {
        return cinemaPhoneNo;
    }
    public void setCinemaPhoneNo(String cinemaPhoneNo) {
        this.cinemaPhoneNo = cinemaPhoneNo;
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj instanceof CinemaDTO) {
            CinemaDTO anotherDto = (CinemaDTO)obj;
            return this.cinemaNo == anotherDto.cinemaNo ; 
            
        }
        return false;
    }

    @Override
    public String toString() {
        return "CinemaDTO [cinemaNo=" + cinemaNo + ", cinemaName=" + cinemaName + ", location=" + location
                + ", cinemaPhoneNo=" + cinemaPhoneNo + "]";
    }
    
    
}
