package chapter01;

import java.util.Calendar;

public class Calcul {
	
	public void check(int birth) {
		int age = 2021-birth -1;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean check = birth%2 == year%2;
	}
	
	
}
