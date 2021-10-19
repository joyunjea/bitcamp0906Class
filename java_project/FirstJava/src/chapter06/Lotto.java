package chapter06;

public class Lotto {
	public static void main(String[] args) {
		
		//1~45까지의 숫자를 저장할 수 있는 배열을 생성
		int[] ball = new int[45];
		
		//각 배열의 요소에 1~45까지의 숫자를 저장
		for(int i =0; i < ball.length; i++) {
			//각 요소에 값을 저장
			ball[i]=i+1;
		}
		
		for(int i =0; i<ball.length; i++) {
			System.out.println(ball[i]);
		}
		System.out.println("숫자섞기==========");
		//임시변수 : 0번지의 값을 저장
		int temp = 0;
		
		for(int i = 0; i < 10000; i++) {
			
		//랜덤한 index -> 1~44		//*45가아닌 44+1을 해줌으로 시작은1~끝이 44+1이 된다.
		int index = (int)(Math.random()*44)+1; //0.0 <= r < 1.0 => 0.999999999-> 0.0<= r*45 < 44.9999999
		
		temp = ball[0];
		ball[0] = ball[index];
		ball[index] = temp;
		}
		//배열의 요소 0~5 출력
		for(int i =0; i<6; i++) 
			System.out.println(ball[i]);
		
	}
}
