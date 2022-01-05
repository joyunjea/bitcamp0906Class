package domain;

public class RegRequest {

		private String uid;	//jsp의 이름과 일치시켜줘야함
		private String pw;
		private String uname;
		
		
		public RegRequest() {
		}
		
		
		
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		@Override
		public String toString() {
			return "RegRequest [uid=" + uid + ", pw=" + pw + ", uname=" + uname + "]";
		}
		
		
	
}
