package chapter04;

import java.util.Calendar;

public class Member {
	
	//① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
	//- 매개변수로 태어난 해(년도)를 전달받습니다.
	//- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
	//- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다
	public void vaccinCheck(int birthYear) {
		
		//나이연산
		int age = 2021 - birthYear - 1;
		
		boolean checkAge1 = age < 15 || age >= 65;
		boolean checkAge2 = !(age >= 15 && age < 65);
		
		if(checkAge1) {
			System.out.println("무료예방접종이 가능합니다");
		}else {
			System.out.println("무료접종 대상이 아닙니다");
		}
	}
	//② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
	//- 매개변수로 태어난 해(년도)를 전달받습니다.
	//- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
	//- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
	//- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
	public void checkUp(int birthYear) {
		//나이 연산
		int age = 2021 - birthYear - 1;
		//올해 년도 구하기
		int year = Calendar.getInstance().get(Calendar.YEAR);
		//System.out.println(year);
		boolean checkUp = birthYear%2 == year%2;	//검진 대상 여부 확인
		
		if(age>= 20 && checkUp) {
			System.out.println("올해 검진 대상 입니다");
			if(age >= 40) {
				System.out.println("암검진 대상자 입니다");				
			}
		}else {
			System.out.println("올해는 검진 대상이 아닙니다.");
		}

	}
	
	//나이 계산 후 반환 하는 메소드
	int ageCal(int year) {
		return Calendar.getInstance().get(Calendar.YEAR)-year-1;
	}
	
	public static void main(String[] args) {
		Member member = new Member();
		
		member.vaccinCheck(1993);
		member.checkUp(1993);
	}
}
