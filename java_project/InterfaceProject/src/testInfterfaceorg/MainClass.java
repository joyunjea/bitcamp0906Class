package testInfterfaceorg;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmaClerk amClerk = new AmaClerk();
		SemiProClerk semiProClerk = new SemiProClerk();
		ProClerck proClerck = new ProClerck();
		
		
		
		if(semiProClerk instanceof Clerk) {
			Clerk clerk = (Clerk)semiProClerk;
			clerk.printAll();
		}
		
		
	}

}
