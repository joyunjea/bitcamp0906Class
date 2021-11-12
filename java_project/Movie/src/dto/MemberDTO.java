package dto;

public class MemberDTO {
    
    public final static int GRADE_NORMAL = 0;
    public final static int GRADE_CRITIC = 1;
    public final static int GRADE_ADMIN  = 2;
    
    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberNick;
    private int memberGrade;
    
    public MemberDTO() {
        // TODO Auto-generated constructor stub
    }
    
    public MemberDTO(String memberId, String memberPw, String memberNick, int memberGrade) {
        this.memberId    = memberId;
        this.memberPw    = memberPw;
        this.memberNick  = memberNick;
        this.memberGrade = memberGrade;
    }
    
    

    public MemberDTO(MemberDTO anotherDTO) {
        
        this.memberNo    = anotherDTO.memberNo;
        this.memberId    = anotherDTO.memberId;
        this.memberPw    = anotherDTO.memberPw;
        this.memberNick  = anotherDTO.memberNick;
        this.memberGrade = anotherDTO.memberGrade;
    }
    
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberNick() {
        return memberNick;
    }
    public void setMemberNick(String memberNick) {
        this.memberNick = memberNick;
    }
    public int getMemberGrade() {
        return memberGrade;
    }
    public void setMemberGrade(int memberGrade) {
        this.memberGrade = memberGrade;
    }
    
    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof MemberDTO) {
            MemberDTO anotherDTO = (MemberDTO)obj;
            return this.memberNo == anotherDTO.memberNo;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNick="
                + memberNick + ", memberGrade=" + memberGrade + "]";
    }
    
    

}
