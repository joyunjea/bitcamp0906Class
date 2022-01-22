package main;


public class MemberVO {
	
	private String name;
	private String address;
	private String nickName;
	
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public MemberVO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getNickName() {
		return nickName;
	}
	public MemberVO setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", address=" + address + ", nickName=" + nickName + "]";
	}
	
	
}
