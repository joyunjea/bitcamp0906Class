package project;

import java.util.Scanner;

import project.Contact;

public class ContactMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contact contact = new Contact();
		
		
		System.out.println("이름");
		String name = scanner.nextLine();		
		System.out.println("번호");
		String phoneNumber = scanner.nextLine();
		System.out.println("메일");
		String mail = scanner.nextLine();
		System.out.println("주소");
		System.out.print(">");
		String address = scanner.nextLine();
		System.out.println("생일");
		System.out.print(">");
		String birthDay = scanner.nextLine();
		System.out.println("그룹");
		System.out.print(">");
		String group = scanner.nextLine();
		
		contact.setName(name);
		contact.setPhoneNumber(phoneNumber);
		contact.setEmail(mail);
		contact.setAddress(address);
		contact.setBirthday(birthDay);
		contact.setGroup(group);
		
		contact.ShowData();
		
		contact.Update(contact);
		contact.ShowData();
		

	}
}
