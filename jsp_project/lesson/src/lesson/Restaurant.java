package lesson;

public class Restaurant {
	
	
	String storeName;
	
	Chef chef;
	
	public Restaurant() {
		
	}

	public Restaurant(String storeName, Chef chef) {
	
		this.storeName = storeName;
		this.chef = chef;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
	
	
	
	

}
