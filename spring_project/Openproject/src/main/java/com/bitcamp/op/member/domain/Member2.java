package com.bitcamp.op.member.domain;

public class Member2 {

	private int index;
	private String memberid;
	private String password;
	private String membername;
	private String memberphoto;
	private String date;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberphoto() {
		return memberphoto;
	}

	public void setMemberphoto(String memberphoto) {
		this.memberphoto = memberphoto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Member2 [index=" + index + ", memberid=" + memberid + ", pw=" + password + ", membername=" + membername
				+ ", memberphoto=" + memberphoto + ", date=" + date + "]";
	}
	
	

}