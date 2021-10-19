package exam;
//문제 3. 다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//1 2 3
//4 5 6
//7 8 9
//이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열
//의 구조를 변경시키는 메서드를 정의해 보자.
//7 8 9
//1 2 3
//4 5 6
//즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행
//으로 이동이 이뤄져야한다. 이번에도 마찬가지로 배열의 가로, 세로길이에 상
//관 없이 동작을 하도록 메서드가 정의되어야 하며, 정의된 메서드의 확인을
//위한 main메서드도 함께 정의하자
public class ArrayTest2 {
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12}
		};
		//출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[j].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		System.out.println();
		}
		/////////////////
		//행의 시프트
		
		//임시배열선언
		int[] temp = arr[arr.length-1];
		
		for(int i =arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		System.out.println("시프트===============");
		// 출력
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						System.out.print(arr[i][j] + "\t");
					}
					System.out.println();
				}

				System.out.println("============================");

		
	}
	
	
}
