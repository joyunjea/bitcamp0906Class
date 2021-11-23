package testver06;

public class CustomerContact extends Contact{
    
    
    private String customerName;
    private String product;
    private String job;
    
    public CustomerContact( String name, 
                            String phoneNumber,
                            String email, 
                            String address, 
                            String birthday, 
                            String group,
                            String customerName,
                            String product,
                            String job) {
        super(name, phoneNumber, email, address, birthday, group);
        this.customerName =customerName;
        this.product = product;
        this.job = job;
    }
    
    public CustomerContact() {
        
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\n거래처명: "+this.customerName+"\n거래품목 "+this.product+"\n직급: "+this.job;
    }
    
    @Override
    public void showData() {
        System.out.println(this.toString());
    }

	@Override
	public void showList() {
		System.out.println("거래처 : " + this.customerName);
		super.showList();
	}
    
    

}