package dto;

public class MovieRateDTO {
    
    private int movieRateNo;
    private int userNo;
    private int memberGrade;
    private int movieNo;
    private int movieRate;
    private String movieReview;
   
    public MovieRateDTO() {
        
    }
       
    

    public MovieRateDTO(int userNo, int memberGrade, int movieNo, int movieRate, String movieReview) {
        this.userNo = userNo;
        this.memberGrade = memberGrade;
        this.movieNo = movieNo;
        this.movieRate = movieRate;
        this.movieReview = movieReview;
    }



    public MovieRateDTO(MovieRateDTO anotherDTO) {
        this.movieRateNo = anotherDTO.movieRateNo;
        this.userNo      = anotherDTO.userNo;
        this.memberGrade = anotherDTO.memberGrade;
        this.movieNo     = anotherDTO.movieNo;
        this.movieRate   = anotherDTO.movieRate;
        this.movieReview = anotherDTO.movieReview;
    }

    public int getMovieRateNo() {
        return movieRateNo;
    }
    public void setMovieRateNo(int movieRateNo) {
        this.movieRateNo = movieRateNo;
    }
    public int getUserNo() {
        return userNo;
    }
    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
    public int getMovieNo() {
        return movieNo;
    }
    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }
    public int getMovieRate() {
        return movieRate;
    }
    public void setMovieRate(int movieRate) {
        this.movieRate = movieRate;
    }
    public String getMovieReview() {
        return movieReview;
    }
    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }
    
    public int getMemberGrade() {
        return memberGrade;
    }



    public void setMemberGrade(int memberGrade) {
        this.memberGrade = memberGrade;
    }



    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof MovieRateDTO) {
            MovieRateDTO anotherDTO = (MovieRateDTO)obj;
            return this.movieRateNo == anotherDTO.movieRateNo;
        }
        return false;
    }



    @Override
    public String toString() {
        return "MovieRateDTO [movieRateNo=" + movieRateNo + ", userNo=" + userNo + ", memberGrade=" + memberGrade
                + ", movieNo=" + movieNo + ", movieRate=" + movieRate + ", movieReview=" + movieReview + "]";
    }

   
    
    

}
