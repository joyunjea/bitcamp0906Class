package dto;

import java.util.Objects;

public class MovieDTO {

    public final static int GRADE_ALL = 0;
    public final static int GRADE_OVER_12 = 1;
    public final static int GRADE_OVER_15 = 2;
    public final static int GRADE_OVER_18 = 3;

    private int movieNo;
    private String movieName;
    private String movieSummary;
    private int movieGrade;

    public MovieDTO(MovieDTO anotherDTO) {

        this.movieNo      = anotherDTO.movieNo;
        this.movieName    = anotherDTO.movieName;
        this.movieSummary = anotherDTO.movieSummary;
        this.movieGrade   = anotherDTO.movieGrade;
    }
    
    

    public MovieDTO(String movieName, String movieSummary, int movieGrade) {
        this.movieName = movieName;
        this.movieSummary = movieSummary;
        this.movieGrade = movieGrade;
    }



    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public void setMovieSummary(String movieSummary) {
        this.movieSummary = movieSummary;
    }

    public int getMovieGrade() {
        return movieGrade;
    }

    public void setMovieGrade(int movieGrade) {
        this.movieGrade = movieGrade;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof MovieDTO) {
            MovieDTO anotherDTO = (MovieDTO)obj;
            return this.movieNo == anotherDTO.movieNo;
        }

        return false;
    }

    @Override
    public String toString() {
        return "MovieDTO [movieNo=" + movieNo + ", movieName=" + movieName + ", movieSummary=" + movieSummary
                + ", movieGrade=" + movieGrade + "]";
    }

    
}
