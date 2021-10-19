package exam;

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] arr = {0,100, 240, 180, 60, 150, 90, 30, 200};
		
		//for-each
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("==========================");
		for(int num : arr) {		//참조해서 값을 가져올때만 사용
			System.out.println(num);
		}
	}

}
