package exam;

public class Ex06 {
	public static void main(String[] args) {
		
		String str = "ABCDEFGHIJKLMN";
		StringBuffer sb = new StringBuffer(str);
		String reversedStr = sb.reverse().toString();
		System.out.println(reversedStr);
		
		String str1 = "ABCDEFGHIJKLMN";
		char[] arr = str1.toCharArray();
		char[] reversedArr = new char[arr.length];
		for(int i =0; i< arr.length; i++) {
			reversedArr[arr.length-1-i] = arr[i];
		}
		String reversedStr1 = new String(reversedArr);
		System.out.println(reversedStr1);
		
		String str2 = "990929-1010123";
		StringBuilder stringBuilder = new StringBuilder(str2);
		System.out.println(stringBuilder.deleteCharAt(6));
	}
}
