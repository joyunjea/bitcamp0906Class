package mm.domain;

import java.util.Date;

public class RegRequest {

	// 이메일, 비밀번호, 비밀번호 확인, 이름
	private String email;			//Member클래스에서 id는 내부에서 만들어서 사용자에게 받지않고
	private String password;		// email password name 세개를받고
	private String confirmPassword;	// 패스워드확인 변수를 만들어줌.
	private String name;

	public RegRequest() {
	}

	public RegRequest(String email, String password, String confirmPassword, String name) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 비밀번호 비밀번호 일치여부
	public boolean isPwRePwEquals() {
		return password.equals(confirmPassword);
	}
	
	// RegRequest -> Member
	public Member toMember() {
		return new Member(0, email, password, name, new Date());
	}

}