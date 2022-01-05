package lesson;

public class Test {

	public static void main(String[] args) {
		// HeloService
		Chef chef=new Chef("오종현", "남자");
		Chef chef2=new Chef("오종현2", "남자");
		Chef chef3=new Chef("오종현3", "남자");
		Chef chef4=new Chef("오종현4", "남자");
		
		// HelloController
		Restaurant restaurant= new Restaurant();
		restaurant.setChef(chef);
		
		System.out.println(restaurant.getChef().getName());
		
		System.out.println(chef==restaurant.getChef());
		
	}
}
