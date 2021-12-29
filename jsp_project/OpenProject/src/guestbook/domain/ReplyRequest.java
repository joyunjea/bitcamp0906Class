package guestbook.domain;

public class ReplyRequest {

	private int memberidx;
	private int guestbookidx;
	private String message;

	public ReplyRequest() {}

	public ReplyRequest(int memberidx, int guestbookidx, String message) {
		super();
		this.memberidx = memberidx;
		this.guestbookidx = guestbookidx;
		this.message = message;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	public int getGuestbookidx() {
		return guestbookidx;
	}

	public void setGuestbookidx(int guestbookidx) {
		this.guestbookidx = guestbookidx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReplyRequest [memberidx=" + memberidx + ", guestbookidx=" + guestbookidx + ", message=" + message + "]";
	}
	
	

}