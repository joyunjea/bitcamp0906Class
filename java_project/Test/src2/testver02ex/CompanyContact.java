package testver02ex;

public class CompanyContact extends Contact{

	private String companyName;
	private String divName;
	private String job;
	
	
	
	public CompanyContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String companyName, String divName, String job) {
		super(name, phoneNumber, email, address, birthday, group);
		this.companyName = companyName;
		this.divName = divName;
		this.job = job;
	}
	
	public CompanyContact() {
		
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+ "\n회사명= " + companyName + "\n부서: " + divName + "\n직급: " + job;
	}

	@Override
	public void ShowData() {
		System.out.println(this.toString());
	}

	@Override
	public void showList() {
		System.out.println("회사명 : "+this.companyName);
		super.showList();
	}
	
	
	
	
}
