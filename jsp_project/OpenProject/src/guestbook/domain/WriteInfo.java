package guestbook.domain;

public class WriteInfo {
	private String subject;
	private String content;
	private int memberidx;
	
	
	public WriteInfo(String subject, String content, int memberidx) {
		
		
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
	}


	public String getSubject() {
		return subject;
	}


	public String getContent() {
		return content;
	}


	public int getMemberidx() {
		return memberidx;
	}
	
	
	
	

}
