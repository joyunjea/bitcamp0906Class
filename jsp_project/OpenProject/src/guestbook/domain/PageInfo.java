package guestbook.domain;

public class PageInfo {
	private int idx;
	private String subject;
	private String username;
	private String regdate;
	private String content;
	
	
	
	public PageInfo(int idx, String subject, String username, String regdate, String content) {
		
		this.idx = idx;
		this.subject = subject;
		this.username = username;
		this.regdate = regdate;
		this.content = content;
	}


	public int getIdx() {
		return idx;
	}


	public String getSubject() {
		return subject;
	}


	public String getUsername() {
		return username;
	}


	public String getRegdate() {
		return regdate;
	}


	public String getContent() {
		return content;
	}
	
	
	
	

}
