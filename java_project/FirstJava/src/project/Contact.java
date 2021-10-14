package project;

public class Contact {
	
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	void PrintData() {
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("이메일 : "+email);
		System.out.println("주소 : "+address);
		System.out.println("생일 : "+birthday);
		System.out.println("그룹 : "+group);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	
	public static void main(String[] args) {
		
		Contact contact = new Contact();
				
		contact.name="손흥민";
		contact.phoneNumber="010-1234-5678";
		contact.email="son@gmail.com";
		contact.address="서울시 강남구";
		contact.birthday="10월14일";
		contact.group="친구";
		
		contact.PrintData();
		
	
		
	}
	
}
