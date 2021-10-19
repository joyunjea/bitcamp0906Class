package examcalculator;
	
	public class CalculatorMain {

		public static void main(String[] args) {

			long n1 = 20;
			long n2 = 2;

			Calculator c = new CalculatorImplements();
			
			System.out.println(n1 + "+" + n2 + "=" + c.add(n1, n2));
			System.out.println(n1 + "-" + n2 + "=" + c.substract(n1, n2));
			System.out.println(n1 + "*" + n2 + "=" + c.multiply(n1, n2));
			System.out.println(n1 + "/" + n2 + "=" + c.divide(n1, n2));
		
	}
}
