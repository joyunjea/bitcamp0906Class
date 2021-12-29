package guestbook.domain;

public class ContentInfo {
	
	
	
	private int idx;
	private String subject;
	private String content;
	private String username;
	private String regdate;
	private int memberidx;

	
	
	public ContentInfo(int idx, String subject, String content, String username, String regdate,
			int memberidx) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.username = username;
		this.regdate = regdate;
		this.memberidx = memberidx;
	}
	
	public int getIdx() {
		return idx;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getUsername() {
		return username;
	}
	public String getRegdate() {
		return regdate;
	}
	public int getMemberidx() {
		return memberidx;
	}
	
	
	

	@Override
	public String toString() {
		return "ContentInfo [idx=" + idx + ", subject=" + subject + ", content=" + content + ", username=" + username
				+ ", regdate=" + regdate + ", memberidx=" + memberidx + "]";
	}

	
	
	
	
}
