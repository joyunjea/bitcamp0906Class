package dto;

public class ScreenInformationDTO {

        private int screeningInformationNo;
        private int movieNo;
        private int cinemaNo;
        private String showTime;
        
        
        
        public ScreenInformationDTO() {
        }
        
        
        
        public ScreenInformationDTO(int movieNo, int cinemaNo, String showTime) {
            this.movieNo = movieNo;
            this.cinemaNo = cinemaNo;
            this.showTime = showTime;
        }

        public ScreenInformationDTO(ScreenInformationDTO anotherDTO) {
            this.screeningInformationNo = anotherDTO.screeningInformationNo;
            this.movieNo                = anotherDTO.movieNo;
            this.cinemaNo               = anotherDTO.cinemaNo;
            this.showTime               = anotherDTO.showTime;
        }

        public int getScreeningInformationNo() {
            return screeningInformationNo;
        }
        public void setScreeningInformationNo(int screeningInformationNo) {
            this.screeningInformationNo = screeningInformationNo;
        }
        public int getMovieNo() {
            return movieNo;
        }
        public void setMovieNo(int movieNo) {
            this.movieNo = movieNo;
        }
        public int getCinemaNo() {
            return cinemaNo;
        }
        public void setCinemaNo(int cinemaNo) {
            this.cinemaNo = cinemaNo;
        }
        public String getShowTime() {
            return showTime;
        }
        public void setShowTime(String showTime) {
            this.showTime = showTime;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof ScreenInformationDTO) {
                ScreenInformationDTO anotherDTO = (ScreenInformationDTO)obj;
                return this.screeningInformationNo == anotherDTO.screeningInformationNo;
            }
            return false;
        }



        @Override
        public String toString() {
            return "ScreenInformationDTO [screeningInformationNo=" + screeningInformationNo + ", movieNo=" + movieNo
                    + ", cinemaNo=" + cinemaNo + ", showTime=" + showTime + "]";
        }
        
        
        
}
