package exam;

public class ScoreArray {

	public static void main(String[] args) {
		
		// 1.국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 
		//   평균 점수를 출력하는 프로그램을 작성해봅시다.
		
		// 국영수 점수를 각 10개 저장할수 있는 2차원 배열 생성
		int[][] score = new int[10][3];
		
		
		// 과목별 총합을 저장하는 변수
		int totalKorScore = 0;
		int totalEngScore = 0;
		int totalMathScore = 0;
				
		// 랜덤한 숫자를 점수로 저장
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				
				// 랜덤한 숫자 구하기 0~100
				// int num = (int)(Math.random()*101);
				// Math.random() =>       0.0 <= r < 1.0
				// Math.random()*101 =>     0.0 <= r < 101.0  ==> 0.0~100.9999999
				// (int)(Math.random()*101) =>     0 <= r <= 100
				
				int num = (int)(Math.random()*71)+30;
				
				score[i][j] = num;
			}
		}
		
		System.out.println("국어\t영어\t수학");
		System.out.println("---------------------------");
		
		// for-each를 이용한 출력
		for(int[] arr : score) {
			
			// 과목 3개의 총합
			int scoreSum = 0;
			
			for(int n : arr) {
				System.out.print(n+"\t");
				scoreSum += n;
			}
			
			System.out.println("\t"+scoreSum+"\t"+((float)scoreSum/arr.length));
		}
		
		// 과목의 총점을 구하기
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				if(j==0) {
					totalKorScore += score[i][j];
				} else if(j==1) {
					totalEngScore += score[i][j];
				} else {
					totalMathScore += score[i][j];
				}
			}
		}
		
		// 과목 총점 출력
		System.out.println("---------------------------");
		System.out.println(totalKorScore+"\t"+totalEngScore+"\t"+totalMathScore +"\t 과목 총점");
		
		// AVG 구하기
		float avgKor = (float)totalKorScore / score.length;
		float avgEng = (float)totalEngScore / score.length;
		float avgMath = (float)totalMathScore / score.length;
		
		// 과목 평균 출력
		System.out.println(avgKor+"\t"+avgEng+"\t"+avgMath +"\t 과목 평균");
		
		

	}

}