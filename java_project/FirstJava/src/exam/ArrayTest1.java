package exam;
//문제 2. 다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값
//의 크기만큼 전부 증가시킨다.
//public static void addOneDArr(int[] arr, int add)
//{
//for (int i=0, i<arr.length; i++)
//arr[i] +=add;
//}
//Dl 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 저장
//된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
//public static void addOneDArr(int[][] arr, int add) { . . . . . }
//단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 위
//의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다
public class ArrayTest1 {
	public static void main(String[] args) {
		//2차원 배열선언
				int[][] arr3 = {
						{1, 2, 3},
						{4, 5, 6, 7},
						{8, 9, 10, 11, 12, 13}
				};
				System.out.println("2차원 배열 출력");
				addOneDArr(arr3, 10);
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		//2차원 배열의 출력
		//행
		for(int i = 0; i< arr.length; i++) {
			//열
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		//매개변수로 전달받은 숫자를 각 요소에 더해준다
		for(int i = 0; i< arr.length; i++) {
			//열
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
			
		}
		System.out.println("각 요소에 숫자 더하기 ===================");
		//2차원 배열의 출력
				//행
				for(int i = 0; i< arr.length; i++) {
					//열
					for(int j = 0; j < arr[i].length; j++) {
						System.out.print(arr[i][j] + "\t");
					}
					System.out.println();
				}
	}
}
