package exam;

public class ArrayTest {
public static void main(String[] args) {
		
		// 배열 생성
		int[] arr = {0,100, 240, 180, 60, 150, 90, 30, 200};
		int[] arr2 = {100, 150, 200};

		System.out.println("최대값: " + maxValue(arr));
		System.out.println("최소값: " + miniValue(arr));
		System.out.println("최대값: " + maxValue(arr2));
		System.out.println("최소값: " + miniValue(arr2));
		
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
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		//매개변수로 전달받은 숫자를 각 요소에 더해준다
		for(int i = 0; i< arr.length; i++) {
			//열
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] += add;
			}
			System.out.println("각 요소에 숫자 더하기 ===================");
		}
	}

	// 최소값 반환
	public static int miniValue(int[] arr) {
		// 최소값
		int minVal = arr[0]; // 처음값을 최소값으로 저장
		// 각 요소의 값과 최소값들을 비교 후 새로운 값이 더 작을 때 최소값으로 저장
		// 전달받은 배열의 사이즈만큼 반복하면서 비교
		for(int i=1; i<arr.length; i++) {
			if(arr[i]<minVal) {
				minVal = arr[i];
			}
		}
			
		return minVal;
	} 

	// 최대값 반환
	public static int maxValue(int[] arr) {
		// 최대값
		int maxVal=arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>maxVal) {
				maxVal=arr[i];
			}
		}
		
		return maxVal; 
	} 

}