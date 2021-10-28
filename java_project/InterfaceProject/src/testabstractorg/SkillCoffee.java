package testabstractorg;

public abstract class SkillCoffee {
	
	public void makeCoffee() {
		System.out.println("이 가게에 커피 만드는 기술로 만든 커피");
	}
	
	public void buyCoffeeBean() {
		System.out.println("이 가게에서 원두를 사옴");
			
	}
	
	public void sellCoffee() {
		System.out.println("고객에게 커피를 팜");
		
	}
	
	public void calcEat() {
		System.out.println("고객에게 비용을 계산받음");
		
	}
	
	public void storeProcess() {
		//1. 커피알을 사온다.
		buyCoffeeBean() ;
		//2. 커피를 만든다..
		makeCoffee();
		//3. 커피를 만든다..
		makeBread();
		//4. 커피를 팔고 
		sellCoffee();
		//5. 커피를 만든다..
		sellBread();
		//6. 커피를 계산받음
		calcEat();
	}

	protected abstract void sellBread();
	protected abstract void makeBread();
	

}
