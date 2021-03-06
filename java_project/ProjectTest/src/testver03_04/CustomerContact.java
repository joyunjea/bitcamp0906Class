package testver03_04;

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
    	// 인터페이스에 원하는 showData 메소드에 목적에 맞게
    	// 메소드를 "완성"시켜야 함
    	// 왜냐하면 이 클래스는 Contact 클래스를 상속하고 있으며, Contact 클래스는 ShowData를 구현하고 있고
    	// 이 CustomerContact 클래스는 추상 클래스가 아닌 "온전한 클래스"이기 때문이다.
    	
    	
        System.out.println(this.toString());
    }

	@Override
	public void showList() {
		System.out.println("거래처 : " + this.customerName);
		super.showList();
	}
    
    

}