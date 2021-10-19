package exam;

public class Test {
	public static void main(String[] args) {
		int arr[] = {10,30,50,100,200};
		System.out.println(miniValue(arr));
		System.out.println(maxValue(arr));
		
	}
	public static int miniValue(int[] arr) {
		int minVal = arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<minVal) {
				minVal=arr[i];
			}
		}
		return minVal;
	} // 최소값 반환

	public static int maxValue(int[] arr) {
		int maxVal = arr[0];
		for(int i = 0; i <arr.length; i++) {
			if(arr[i]>maxVal) {
				maxVal=arr[i];
			}
		}
		return maxVal;
	} // 최대값 반환
	
}
