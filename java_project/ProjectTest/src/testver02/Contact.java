package testver02;
//이름,전화,메일,주소,생일,그룹
public class Contact {
	//변수 저장
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	//생성자(모든 변수)
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	//생성자(이름,전화,생일만)
	public Contact(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//기본생성자
	public Contact() {
		
	}
	//데이터 출력메소드
		public void ShowMenu() {
			System.out.println("이름 : " + name);
			System.out.println("전화 : " + phoneNumber);
			System.out.println("메일 : " + email);
			System.out.println("주소 : " + address);
			System.out.println("생일 : " + birthday);
			System.out.println("그룹 : " + group);
		}

	//getset
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
	
	@Override
	public String toString() {
		return "Contact [이름=" + name + ", 전화=" + phoneNumber + ", 메일=" + email + ", 주소=" + address
				+ ", 생일=" + birthday + ", 그룹=" + group + "]";
	}
	
	
}
