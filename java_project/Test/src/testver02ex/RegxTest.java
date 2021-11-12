package testver02ex;

public class RegxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "[^0-9]";
		String str = "aaaabdfa11231";
		
		String replaceStr = str.replaceAll(pattern, "");
		System.out.println(replaceStr);
	}

}
