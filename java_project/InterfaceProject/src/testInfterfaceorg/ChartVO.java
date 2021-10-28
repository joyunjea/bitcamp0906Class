package testInfterfaceorg;

import java.util.Arrays;

public class ChartVO {
	
	private String phone;
	private String email;
	private String address;
	private String[] events;
	private String groups;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String[] getEvents() {
		return events;
	}
	public void setEvents(String[] events) {
		this.events = events;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "ChartVO [phone=" + phone + ", email=" + email + ", address=" + address + ", events="
				+ Arrays.toString(events) + ", groups=" + groups + "]";
	}
	
	

}
